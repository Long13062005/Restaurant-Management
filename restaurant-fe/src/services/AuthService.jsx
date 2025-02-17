import axios from 'axios';

const API_URL = 'http://localhost:1010/auth/';

axios.defaults.withCredentials = true;

const register = (username,email,password) => {
  return axios.post(API_URL + 'signup', {
    username,
    email,
    password,
  });
};

const login = (username,password) => {
  return axios
    .post(API_URL + 'login', {
      username,
      password,
    })
    .then((response) => {
      if (response.data.username) {
        localStorage.setItem('user', JSON.stringify(response.data));
      }

      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem('user');
  return axios.post(API_URL + 'logout').then((response) => {
    return response.data;
  });
};

export const getCurrentUser = () => {
  const userStr = localStorage.getItem("user");
  if (userStr) return JSON.parse(userStr);

  return null;
};

const AuthService = {
  register,
  login,
  logout,
  getCurrentUser,
};

export default AuthService;