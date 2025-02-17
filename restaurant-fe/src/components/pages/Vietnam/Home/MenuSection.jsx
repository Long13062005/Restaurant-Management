import React from 'react';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

export function MenuSection() {
    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
    };

    return (
        <section id="menu" className="py-16 bg-white">
            <div className="container mx-auto">
                <h2 className="text-4xl font-bold text-center mb-8">Thực đơn</h2>
                <Slider {...settings}>
                    <div className="menu-item bg-gray-100 p-6 rounded-lg shadow-lg text-center">
                        <div className="flex space-x-4">
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2Fsushi.PNG?alt=media&token=8268422c-ec29-4604-8311-60110b250b70" alt="Sushi" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2FsushiAvocado.PNG?alt=media&token=5082793a-466c-4d4e-8916-ca411f47a67c" alt="Sushi" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2FsushiFish.PNG?alt=media&token=634c8b19-6f96-4b9f-9dac-be5d5bb8aefb" alt="Sushi" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2FsushiOmeltte.PNG?alt=media&token=ca7ddb3b-5715-475b-a285-15f24d6c7925" alt="Sushi" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                        </div>
                        <h3 className="text-2xl font-bold mb-2">Sushi</h3>
                        <p className="text-gray-700 mb-4">Sushi tươi ngon, đa dạng loại.</p>
                        <p className="text-red-600 font-bold">150.000 VNĐ</p>
                    </div>
                    <div className="menu-item bg-gray-100 p-6 rounded-lg shadow-lg text-center">
                        <div className="flex space-x-4">
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2Framen1.PNG?alt=media&token=b8379ab1-0e72-401d-95ff-f3716c8ac3e1" alt="Ramen" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2Framen2.PNG?alt=media&token=4be45dab-a76a-43d1-aada-2452e67e7538" alt="Ramen" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2Framen3.PNG?alt=media&token=1d142785-03b1-4ca9-bad9-64c9e3c3d148" alt="Tempura" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2Framen4.PNG?alt=media&token=1a7b625b-c006-4c15-ad50-22eae36116d2" alt="Tempura" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />

                        </div>
                        <h3 className="text-2xl font-bold mb-2">Ramen</h3>
                        <p className="text-gray-700 mb-4">Ramen nóng hổi, đậm đà hương vị.</p>
                        <p className="text-red-600 font-bold">120.000 VNĐ</p>
                    </div>
                    <div className="menu-item bg-gray-100 p-6 rounded-lg shadow-lg text-center">
                        <div className="flex space-x-4">
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2FTempura1.PNG?alt=media&token=97bcea6e-547e-4f55-97bc-d27699ebc76d" alt="Tempura" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2FTempura2.PNG?alt=media&token=3355096a-10cf-48ca-8e9b-c9013767b027" alt="Tempura" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2Ftempura3.PNG?alt=media&token=66bf3a4e-8ee4-49b8-8e86-233a38aaa7ea" alt="Ramen" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />
                            <img src="https://firebasestorage.googleapis.com/v0/b/ryukingdom-48b31.appspot.com/o/restaurant%2Ftempura4.PNG?alt=media&token=01342181-62b9-43fc-89b0-ccd7cb9bc905" alt="Ramen" className="rounded-lg mb-4 w-1/4 h-48 object-cover" />

                        </div>
                        <h3 className="text-2xl font-bold mb-2">Tempura</h3>
                        <p className="text-gray-700 mb-4">Tempura giòn rụm, hấp dẫn.</p>
                        <p className="text-red-600 font-bold">100.000 VNĐ</p>
                    </div>
                </Slider>
            </div>
        </section>
    );
}