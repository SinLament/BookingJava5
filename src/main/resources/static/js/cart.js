document.addEventListener("DOMContentLoaded", function() {

    const loadChiTietDatPhong = async () => {
        try {
            const response = await axios.get('/cart/ChiTietDatPhong/get-all');
            const tableBody = document.getElementById('bookingTableBody');
            tableBody.innerHTML = ''; // Clear the table body before appending rows

            response.data.data.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.id}</td>
                    <td>${item.maPhong}</td>
                    <td>${item.ngayDen}</td>
                    <td>${item.ngayTra}</td>
                    <td>${item.giaPhong}</td>
                    <td><button class="btn btn-danger" data-id="${item.id}">X</button></td>
                `;
                tableBody.appendChild(row);
            });

            // Khởi tạo sự kiện xóa cho các nút xóa
            const deleteButtons = document.querySelectorAll('.btn-danger');
            deleteButtons.forEach(button => {
                button.addEventListener('click', async function() {
                    const id = button.getAttribute('data-id');
                    if (!id) {
                        alert('ID không hợp lệ');
                        return;
                    }
                    try {
                        const response = await axios.delete(`/cart/ChiTietDatPhong/delete/${id}`);
                        if (response.data.status) {
                            alert('Xóa booking thành công');
                            loadChiTietDatPhong(); // Tải lại danh sách sau khi xóa
                        } else {
                            alert('Xóa booking thất bại');
                        }
                    } catch (error) {
                        console.error('Có lỗi xảy ra khi xóa:', error);
                        alert('Có lỗi xảy ra khi xóa booking');
                    }
                });
            });
        } catch (error) {
            console.error('Có lỗi xảy ra khi lấy dữ liệu:', error);
        }
    };

    // Gọi hàm loadChiTietDatPhong khi DOMContentLoaded
    loadChiTietDatPhong();

    // Thêm sự kiện cho các nút "Đặt Ngay"
    const addToCartButtons = document.querySelectorAll('.get-item-cart');
    addToCartButtons.forEach(button => {
        button.addEventListener('click', async function () {
            const maKhachHang = button.getAttribute('data-ma-khach-hang');
            const maKhuyenMai = button.getAttribute('data-ma-khuyen-mai');
            const tongTien = button.getAttribute('data-tong-tien');
            const trangThai = button.getAttribute('data-trang-thai') === 'true';

            if (maKhachHang && maKhuyenMai && tongTien && typeof trangThai === 'boolean') {
                try {
                    const datPhong = {
                        maKhachHang: parseInt(maKhachHang, 10),
                        maKhuyenMai: parseInt(maKhuyenMai, 10),
                        tongTien: parseFloat(tongTien),
                        TrangThai: trangThai
                    };

                    const responseDatPhong = await axios.post('/cart/DatPhong/create', datPhong);
                    const maDatPhong = responseDatPhong.data.data.id;

                    const chiTietDatPhong = {
                        maDatPhong: maDatPhong,
                        maPhong: button.getAttribute('data-ma-phong'),
                        ngayDen: button.getAttribute('data-ngay-den'),
                        ngayTra: button.getAttribute('data-ngay-tra'),
                        giaPhong: parseFloat(button.getAttribute('data-gia-phong'))
                    };

                    const responseChiTietDatPhong = await axios.post('/cart/ChiTietDatPhong/create', chiTietDatPhong);

                    if (responseChiTietDatPhong.data.status) {
                        alert('Thêm vào giỏ hàng thành công');
                        loadChiTietDatPhong();
                    } else {
                        alert('Thêm vào giỏ hàng thất bại');
                    }
                } catch (error) {
                    console.error('Có lỗi xảy ra khi thực hiện yêu cầu:', error);
                    alert('Có lỗi xảy ra khi thêm đơn đặt phòng hoặc chi tiết đặt phòng');
                }
            } else {
                alert('Dữ liệu không hợp lệ');
            }
        });
    });

    // Thêm sự kiện cho nút thanh toán
    const btnThanhToan = document.querySelector('.thanh-toan');
    btnThanhToan.addEventListener('click', function() {
        const tbody = document.getElementById('bookingTableBody');
        tbody.innerHTML = ''; // Clear the table body
    });
});
