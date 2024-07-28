const getAdminKhuyenMai = async () => {
    let khuyenMaiContainer = $('#khuyenmai');
    await axios.get('/api/khuyenmai-api/getAllKhuyenMai')
        .then(response => {
            khuyenMaiContainer.html('');
            response.data.data.forEach(khuyenmai => {
                let html = `
                <tr>
                    <td>${khuyenmai.maKhuyenMai}</td>
                    <td>${khuyenmai.tenKhuyenMai}</td>
                    <td>${khuyenmai.moTa}</td>
                    <td>${khuyenmai.ngayBatDau}</td>
                    <td>${khuyenmai.ngayKetThuc}</td>
                    <td>${khuyenmai.mucGiam}</td>
                    <td>
                      <a style="background-color: #28d5a7; border:none;" class="edit-btn theme-btn theme-btn-small btn-edit" data-makhuyenmai="${khuyenmai.maKhuyenMai}"><i class="bi bi-pencil-square"></i></a> 
                      <a style="background-color: #e1306c; border:none;" class="theme-btn theme-btn-small delete-btn" data-khuyenmaiid="${khuyenmai.maKhuyenMai}"><i class="bi bi-x-lg"></i></a>
                    </td>
                </tr>
                `;
                khuyenMaiContainer.append(html);
            });
        })
        .catch(error => {
            alert(error);
        });
}

// Gọi hàm getAdminKhuyenMai khi trang được tải
document.addEventListener('DOMContentLoaded', getAdminKhuyenMai);

// Đăng ký sự kiện xóa khuyến mãi một lần khi trang được tải
$(document).on('click', '.delete-btn', async function () {
    let khuyenMaiId = $(this).data('khuyenmaiid');
    if (confirm('Bạn có chắc chắn muốn xóa khuyến mãi này?')) {
        await axios.delete(`/api/khuyenmai-api/delete-khuyen-mai?maKhuyenMai=${khuyenMaiId}`)
            .then(response => {
                alert(response.data.message);
                getAdminKhuyenMai(); // Cập nhật lại bảng sau khi xóa thành công
            })
            .catch(error => {
                console.log(error);
                alert('Xóa khuyến mãi thất bại');
            });
    }
});

// Đăng ký sự kiện chỉnh sửa khuyến mãi
$(document).on('click', '.btn-edit', function () {
    const maKhuyenMai = $(this).data('makhuyenmai');
    axios.get(`/api/khuyenmai-api/get-khuyenMai-by-maKM?maKM=${maKhuyenMai}`)
        .then(response => {
            let khuyenMai = response.data.data;
            $(`#maKM`).val(khuyenMai.maKhuyenMai);
            $(`#tenKM`).val(khuyenMai.tenKhuyenMai);
            $(`#moTa`).val(khuyenMai.moTa);
            $(`#ngayBatDau`).val(khuyenMai.ngayBatDau);
            $(`#ngayKetThuc`).val(khuyenMai.ngayKetThuc);
            $(`#mucGiam`).val(khuyenMai.mucGiam);
            $('#addKhuyenMaiBtn').hide();
            $('#updateKhuyenMaiBtn').show();
        })
        .catch(error => {
            console.log(error);
            alert('Không thể lấy thông tin khuyến mãi');
        });
});

// Thêm khuyến mãi
$('#addKhuyenMaiBtn').click(async function () {
    let khuyenMai = {
        tenKhuyenMai: $('#tenKM').val(),
        moTa: $('#moTa').val(),
        ngayBatDau: $('#ngayBatDau').val(),
        ngayKetThuc: $('#ngayKetThuc').val(),
        mucGiam: $('#mucGiam').val()
    };

    await axios.post('/api/khuyenmai-api/saveKhuyenMai', khuyenMai)
        .then(response => {
            alert('Thêm khuyến mãi thành công');
            $('#khuyenMaiForm')[0].reset();
            getAdminKhuyenMai(); // Cập nhật lại bảng sau khi thêm thành công
        })
        .catch(error => {
            console.log(error);
            alert('Thêm khuyến mãi thất bại');
        });
});

// Cập nhật khuyến mãi
$('#updateKhuyenMaiBtn').click(async function () {
    let khuyenMai = {
        maKhuyenMai: $('#maKM').val(),
        tenKhuyenMai: $('#tenKM').val(),
        moTa: $('#moTa').val(),
        ngayBatDau: $('#ngayBatDau').val(),
        ngayKetThuc: $('#ngayKetThuc').val(),
        mucGiam: $('#mucGiam').val()
    };

    await axios.put('/api/khuyenmai-api/updateKhuyenMai', khuyenMai)
        .then(response => {
            alert('Cập nhật khuyến mãi thành công');
            $('#khuyenMaiForm')[0].reset();
            $('#addKhuyenMaiBtn').show();
            $('#updateKhuyenMaiBtn').hide();
            getAdminKhuyenMai(); // Cập nhật lại bảng sau khi cập nhật thành công
        })
        .catch(error => {
            console.log(error);
            alert('Cập nhật khuyến mãi thất bại');
        });
});
