import "./App.css";
import './assets/css/Header.css';
import './assets/css/VintageFontsCss.css';
import './assets/css/ErrorMessage.css';
import 'react-toastify/dist/ReactToastify.css';
import {Route, Routes} from "react-router-dom";
import {Home} from "./components/pages/Vietnam/Home.jsx";
import AuthLayout from "./components/auth/AuthLayout.jsx";
import {Login} from "./components/auth/Login.jsx";
import { ToastContainer } from 'react-toastify';
import {Register} from "./components/auth/Register.jsx";


function App() {
  return (
    <>
        <Routes>

            <Route exact path="/" element={<Home />} />

            <Route
                path=""
                element={
                    // <CheckAuth isAuthenticated={isAuthenticated} user={user}>
                        <AuthLayout />
                    // </CheckAuth>
                    }
            >
                <Route path="login" element={<Login />} />
                <Route path="register" element={<Register />} />
                {/*<Route path="register" element={<Register />} />*/}
            </Route>

        </Routes>
        <ToastContainer />

    </>
  );
}

export default App;