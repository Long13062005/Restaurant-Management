import React from 'react'
import {Outlet} from 'react-router-dom'
import {NavBar} from "../pages/Vietnam/Home/NavBar.jsx";
import {Footer} from "../pages/Vietnam/Home/Footer.jsx";

const AuthLayout = () => {
    const loginBackground = "https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/authPage%2FLogin.png?alt=media&token=f1852a60-cd24-48a2-b0cd-c31f4841f2b9";
    return (
        <>
            <NavBar/>
            <div className='flex min-h-screen w-full'>
            <div className="hidden lg:flex items-center justify-center bg-black w-1/2 px-12" style={{
                backgroundImage: `url(${loginBackground})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center'
            }}>
                <div className='max-w-md space-y-12  text-white'><h1
                    className='text-6xl font-extrabold tracking-tight hover:text-red-200'>
                    WELCOME TO RYU JAPANESE RESTAURANT
                </h1>
                </div>
            </div>
            <div className='flex flex-1 items-center justify-center bg-background px4 py-12 sm:px-6 lg:px-8'>
                <Outlet/>
            </div>
        </div>
            <Footer/>
        </>)
}

export default AuthLayout