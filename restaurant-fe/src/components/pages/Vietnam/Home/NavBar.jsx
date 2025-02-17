import React, {useState} from 'react';
import {Link} from "react-router-dom";

export function NavBar() {
    const [dropdownOpen, setDropdownOpen] = useState(false);

    const toggleDropdown = () => {
        setDropdownOpen(!dropdownOpen);
    };

    return <header className="bg-red-800">
        <div className="mx-auto max-w-screen-xl px-4 sm:px-6 lg:px-8">
            <div className="flex h-16 items-center justify-between">
                <div className="flex-1 md:flex md:items-center md:gap-12">
                    <Link className="block text-white" to={"/"}>
                        <span className="sr-only ">Home</span>
                        <h1>Ryu</h1>
                    </Link>
                </div>

                <div className="md:flex md:items-center md:gap-12">
                    <nav aria-label="Global" className="hidden md:block">
                        <ul className="flex items-center gap-6 text-sm">
                            <li>
                                <a className="text-white transition hover:text-red-300/75"  href={"#menu"}> Thực đơn </a>
                            </li>

                            <li>
                                <a className="text-white transition hover:text-red-300/75" href="#reservation"> Đặt bàn </a>
                            </li>

                            <li>
                                <a className="text-white transition hover:text-red-300/75" href="#"> Tuyển dụng </a>
                            </li>
                        </ul>
                    </nav>

                    <div className="flex items-center gap-4">
                        <div className="sm:flex sm:gap-4">
                            <Link
                                className="rounded-md bg-red-900 transition hover:bg-red-700 px-5 py-2.5 text-sm  font-medium text-white shadow-sm"
                             to={"/login"}>
                                Đăng nhập
                            </Link>

                            <div className="hidden sm:flex">
                                <Link
                                    className="rounded-md bg-gray-100 hover:bg-gray-200 px-5 py-2.5 text-sm font-medium text-red-900 hover:text-black"
                                 to={"/register"}>
                                    Đăng ký
                                </Link>
                            </div>
                        </div>

                        <div className="block md:hidden">
                            <button
                                className="rounded-sm bg-gray-100 p-2 text-gray-600 transition hover:text-gray-600/75"
                            >
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="size-5"
                                    fill="none"
                                    viewBox="0 0 24 24"
                                    stroke="currentColor"
                                    strokeWidth="2"
                                >
                                    <path strokeLinecap="round" strokeLinejoin="round" d="M4 6h16M4 12h16M4 18h16" />
                                </svg>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
;
}