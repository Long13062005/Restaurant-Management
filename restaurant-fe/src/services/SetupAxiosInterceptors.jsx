import React, { createContext, useContext, useLayoutEffect, useState } from 'react';
import axios from 'axios';
import UserService from './UserService';

const AuthContext = createContext(undefined);

export const useAuth = () => {
    const authContext = useContext(AuthContext);

    if (!authContext) {
        throw new Error('useAuth must be used within an AuthProvider');
    }

    return authContext;
};

const AuthProvider = ({ children }) => {
    const [token, setToken] = useState(UserService.getAccessToken());

    useLayoutEffect(() => {
        const requestInterceptor = axios.interceptors.request.use(
            req => {
                const token = UserService.getAccessToken();
                if (token) {
                    req.headers['Authorization'] = 'Bearer ' + token;
                }
                return req;
            },
            error => {
                return Promise.reject(error);
            }
        );

        const responseInterceptor = axios.interceptors.response.use(
            response => {
                return response;
            },
            async error => {
                const originalConfig = error.config;

                let accessToken = UserService.getAccessToken();

                if (error.response) {

                    if ((error.response.status === 401 || error.response.status === 403) && !originalConfig._retry) {
                        originalConfig._retry = true;
                        try {
                            const rs = await UserService.refreshToken();
                            const { token } = rs;

                            // Update the access token
                            accessToken = token;
                            UserService.accessToken = token;
                            setToken(token); // Update the token in the state

                            // Update the Authorization header in the original request
                            originalConfig.headers['Authorization'] = 'Bearer ' + token;

                            // Retry the original request with the new token
                            return axios(originalConfig);
                        } catch (_error) {
                            UserService.logout();
                            setToken(null); // Clear the token in the state
                            return Promise.reject(_error);
                        }
                    }
                }

                return Promise.reject(error);
            }
        );

        // Cleanup function to eject the interceptors
        return () => {
            axios.interceptors.request.eject(requestInterceptor);
            axios.interceptors.response.eject(responseInterceptor);
        };
    }, [token]);

    return (
        <AuthContext.Provider value={{ token, setToken }}>
            {children}
        </AuthContext.Provider>
    );
};

export default AuthProvider;