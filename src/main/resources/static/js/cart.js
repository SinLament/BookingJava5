document.addEventListener("DOMContentLoaded", function() {

    const loadChiTietDatPhong = async () => {
        try {
            const response = await axios.get('/cart/ChiTietDatPhong/get-all');
            const tableBody = document.getElementById('bookingTableBody');
            tableBody.innerHTML = '';

            response.data.data.forEach(item => {
                const today = new Date().toISOString().slice(0, 10);
                const ngayDenValue = item.ngayDen ? item.ngayDen : today;
                const ngayTraValue = item.ngayTra ? item.ngayTra : today;
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.id}</td>
                    <td>${item.maPhong}</td>
                    <td><input type="date" class="form-control" value="${ngayDenValue}"></td> 
                    <td><input type="date" class="form-control" value="${ngayTraValue}"></td>  
                    <td>${item.giaPhong}</td>
                    <td><button class="btn btn-danger btn-del" data-id="${item.id}">X</button></td>
                `;
                tableBody.appendChild(row);
            });
            const deleteButtons = document.querySelectorAll('.btn-del');
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
        updateTotalPrice();
    };
    function updateTotalPrice() {
        let totalPrice = 0;
        const rows = document.querySelectorAll('#bookingTableBody tr');
        rows.forEach(row => {
            const giaPhong = parseFloat(row.querySelector('td:nth-child(5)').textContent);
            totalPrice += giaPhong;
        });

        // Cập nhật phần tử HTML hiển thị tổng tiền
        const totalPriceElement = document.querySelector('.totalprice');
        totalPriceElement.textContent = `Tổng tiền: ${totalPrice.toLocaleString()}.000 VND`;
    }

    loadChiTietDatPhong();

    const btnThanhToan = document.querySelector('.thanh-toan');
    btnThanhToan.addEventListener('click', function() {
        const tbody = document.getElementById('bookingTableBody');
        tbody.innerHTML = '';

    });
});
