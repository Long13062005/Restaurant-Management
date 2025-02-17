import { ErrorMessage, Field, Form, Formik } from "formik";
import {useEffect, useState} from "react";
import * as Yup from "yup";
import {Link, useNavigate} from "react-router-dom";
import AuthService from "../../services/AuthService.jsx";
import {toast} from "react-toastify";

const validationSchema = Yup.object().shape({
    username: Yup.string().required("This field is required!"),
    password: Yup.string().required("This field is required!"),
});

let count = 3;


export function Login() {
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');
    const [sessionTimeout, setSessionTimeout] = useState(60000);
    const { navigate } = useNavigate();

    useEffect(() => {
        document.title = "Login";
        const maxAttemptsExceeded = sessionStorage.getItem('maxAttemptsExceeded');
        if (maxAttemptsExceeded) {
            setError('You have exceeded the maximum number of attempts, please wait for 1 minute.');
            setTimeout(() => {
                sessionStorage.removeItem('maxAttemptsExceeded');
                count = 3; // Reset the counter
                setError(''); // Clear the error message
            }, [sessionTimeout]);
        } else {
            setError('');
        }
    }, [sessionTimeout]);
    const handleSubmit = async (values) => {
        setLoading(true);
        if (sessionStorage.getItem('maxAttemptsExceeded')) {
            setError('You have exceeded the maximum number of attempts, please wait for 1 minute ');
            setLoading(false);
            return;
        }
        if (count === 0) {
            setError('You have exceeded the maximum number of attempts, please wait for 1 minute ');
            setLoading(false);
            sessionStorage.setItem('maxAttemptsExceeded', 'true');
            // Set a timer to clear the session after 1 hour (3600000 milliseconds)

            setTimeout(() => {
                sessionStorage.removeItem('maxAttemptsExceeded');
                count = 3;
                setError(''); // Clear the error message
            }, sessionTimeout);

            return;
            }
        try {
            const userData = await AuthService.login(values.username, values.password);
            if (userData.data.token) {
                if(userData.data.role.name === 'CUSTOMER'){
                    navigate('/');
                } else {
                    navigate('/user/profile');
                }
                toast("Login successfully", {
                    position: "top-right",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: 'dark',
                    style: {
                        backgroundColor: '#000000', color: 'rgba(237,167,0,0.98)', fontWeight: 'bold', fontSize: '16px'
                    }
                });

            } else {
                count--;
                setError('Invalid username or password , ' + count + ' attempts left');
            }
        } catch (error) {
            console.log(error);
            setError(error.message);
        } finally {
            setTimeout(() => {
                setLoading(false);
            }, 3000);
        }
    };

    return (
        <div className="w-full px-4 py-12 sm:px-6 sm:py-16 lg:w-1/2 lg:px-8 lg:py-24">
            <div className="mx-auto max-w-lg text-center">
                <h1 className="text-2xl font-bold sm:text-3xl text-red-800">Đăng nhập</h1>
            </div>
            <Formik
                initialValues={{ username: "", password: "" }}
                onSubmit={handleSubmit}
                validationSchema={validationSchema}
            >
                {({ values }) => (
                    <Form className="mx-auto mt-8 mb-0 max-w-md space-y-8">
                        <div>
                            <label className="sr-only">Username</label>
                            <div className="relative">
                                <Field
                                    type="text"
                                    className="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-xs"
                                    placeholder="Username"
                                    name="username"
                                />
                                <ErrorMessage name="username" component="div" className="error-message" />
                            </div>
                        </div>

                        <div>
                            <label htmlFor="password" className="sr-only">Password</label>
                            <div className="relative">
                                <Field
                                    type="password"
                                    className="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-xs"
                                    placeholder="Password"
                                    name="password"
                                />
                                <ErrorMessage name="password" component="div" className="error-message" />
                                <span className="absolute inset-y-0 end-0 grid place-content-center px-4">
                                    <svg
                                        xmlns="http://www.w3.org/2000/svg"
                                        className="size-4 text-gray-400"
                                        fill="none"
                                        viewBox="0 0 24 24"
                                        stroke="currentColor"
                                    >
                                        <path
                                            strokeLinecap="round"
                                            strokeLinejoin="round"
                                            strokeWidth="2"
                                            d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
                                        />
                                        <path
                                            strokeLinecap="round"
                                            strokeLinejoin="round"
                                            strokeWidth="2"
                                            d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"
                                        />
                                    </svg>
                                </span>
                            </div>
                        </div>

                            <div className="relative">
                                <span className=" inset-y-0 end-0 grid place-content-center px-4 m-2">
                                    {error && <div className="error-message">{error}</div>}
                                </span>
                            </div>

                        <div className="flex items-center justify-between">
                            <p className="text-sm text-gray-500">
                                Chưa có tài khoản ?
                                <Link className="underline" to={"/register"}>Đăng ký</Link>
                            </p>
                            <button
                                type="submit"
                                className="inline-block rounded-lg bg-white hover:bg-red-800 px-10 py-3 text-sm font-medium text-red-800 hover:text-white"
                                style={{ transition: "all .3s ease", border: "3px solid #e5e7eb" }}
                            >
                                {loading ? 'Loading...' : 'Đăng nhập'}
                            </button>
                        </div>
                    </Form>
                )}
            </Formik>
        </div>
    );
}