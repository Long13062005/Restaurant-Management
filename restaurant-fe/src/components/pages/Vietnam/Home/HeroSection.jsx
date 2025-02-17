import "../../../../assets/css/HeroSectionCss.css"

export function HeroSection(){
    return (
        <section className="hero-section text-white py-32">
            <div className="container mx-auto">
                <h1 className="text-6xl font-bold mb-4">Chào mừng đến với Ryu</h1>
                <p className="text-xl mb-8">Hương vị Nhật Bản đích thực</p>
                <a href="#reservation" className="bg-red-600 text-white px-6 py-3 rounded-lg hover:bg-red-700">Đặt bàn ngay</a>
            </div>
        </section>
    )
}