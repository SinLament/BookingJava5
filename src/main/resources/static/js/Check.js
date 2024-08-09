console.log("da nhan JS")
document.addEventListener("DOMContentLoaded", function() {

    const loadChiTietDatPhong = async () => {
        try {
            const response = await axios.get('/cart/ChiTietDatPhong/get-all');
            const tableBody = document.getElementById('CheckTableBody');
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
                    <td><button class="btn btn-success" data-id="${item.id}">Checkin</button>
                    <button class="btn btn-info" data-id="${item.id}">Checkout</button></td>
                `;
                tableBody.appendChild(row);
            });
            const Check_inButtons = document.querySelectorAll('.btn-success');
            Check_inButtons.forEach(button => {
                button.addEventListener('click', async function() {
                    const id = button.getAttribute('data-id');
                    if (!id) {
                        alert('ID không hợp lệ');
                        return;
                    }
                    try {
                        const response = await axios.put(`/update-TrangThai/${id}`,"Da_Check_in");
                        if (response.data.status) {
                            alert('Xóa booking thành công');
                            loadChiTietDatPhong();
                        } else {
                            alert('Check-in thất bại');
                        }
                    } catch (error) {

                    }
                });
            });

            const Check_outButtons = document.querySelectorAll('.btn-info');
            Check_outButtons.forEach(button => {
                button.addEventListener('click', async function() {
                    const id = button.getAttribute('data-id');
                    if (!id) {
                        alert('ID không hợp lệ');
                        return;
                    }
                    try {
                        const response = await axios.put(`/update-TrangThai/${id}`,"Da_Check_out");
                        if (response.data.status) {
                            alert('Xóa booking thành công');
                            loadChiTietDatPhong();
                        } else {
                            alert('Check-in thất bại');
                        }
                    } catch (error) {

                    }
                });
            });
        } catch (error) {
            console.error('Có lỗi xảy ra khi lấy dữ liệu:', error);
        }
        loadChiTietDatPhong();
    };
});