export function ReservationSection() {
    return (
        <section id="reservation" className="py-16 bg-gray-100">
            <div className="container mx-auto">
                <h2 className="text-4xl font-bold text-center mb-8">Đặt bàn</h2>
                <form className="max-w-lg mx-auto bg-white p-8 rounded-lg shadow-lg">
                    <div className="mb-4">
                        <label htmlFor="name" className="block text-gray-700 mb-2">Họ và tên</label>
                        <input type="text" id="name" className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-red-600" required/>
                    </div>
                    <div className="mb-4">
                        <label htmlFor="phone" className="block text-gray-700 mb-2">Số điện thoại</label>
                        <input type="tel" id="phone" className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-red-600" required/>
                    </div>
                    <div className="mb-4">
                        <label htmlFor="date" className="block text-gray-700 mb-2">Ngày đặt</label>
                        <input type="date" id="date" className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-red-600" required/>
                    </div>
                    <div className="mb-4">
                        <label htmlFor="time" className="block text-gray-700 mb-2">Giờ đặt</label>
                        <input type="time" id="time" className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-red-600" required/>
                    </div>
                    <button type="submit" className="w-full bg-red-600 text-white px-4 py-2 rounded-lg hover:bg-red-700">Đặt bàn</button>
                </form>
            </div>
        </section>
        )
}