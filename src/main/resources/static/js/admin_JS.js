const getAdminKhachHang = async () => {
  let productContainer = $('#adminkhachhang');
    let index = 0
  await axios.get('/admin-khachhang/getAllkhachHang')
  .then(response => {
    productContainer.html('');
    response.data.data.forEach(khachhang => {

      let html = `
                <tr>
                    <td>${index+=1}</td>
                    <td>${khachhang.username}</td>
                    <td>${khachhang.fullname}</td>
                    <td>${khachhang.gender ? "Nam" : "Nữ"}</td>
                    <td>${khachhang.birthday}</td>
                    <td>${khachhang.address}</td>
                    <td>${khachhang.email}</td>
                    <td>${khachhang.sdt}</td>
                    <td>
                      <a style="background-color: #28d5a7;border:none;" class="edit-btn theme-btn theme-btn-small btn-edit" data-username="${khachhang.username}"><i class="bi bi-pencil-square"></i></a> 
                      <a style="background-color: #e1306c;border:none;" class="theme-btn theme-btn-small delete-btn" data-khachhangid="${khachhang.maKhachHang}"><i class="bi bi-x-lg"></i></a>
                     </td>
                  </tr>
                `;
      productContainer.append(html);
    });
  })
  .catch(error => {
    alert(error);
  });
  productContainer.on('click', '.delete-btn', async function () {
    let khachHangId = $(this).data('khachhangid');
    if (confirm('Bạn có chắc chắn muốn xóa khách hàng này?')) {
      await axios.delete(`/api-khachhang/delete-khachHang-by-makh?maKH=${khachHangId}`)
      .then(response => {

        alert(response.data.message);
        getAdminKhachHang(); // Cập nhật lại bảng sau khi xóa thành công
      })
      .catch(error => {
          console.log(error);
        alert('Xóa khách hàng thất bại');
      });
    }
  });
}
// Gọi hàm getAllProduct khi trang được tải
document.addEventListener('DOMContentLoaded', getAdminKhachHang);
$(document).on('click', '.btn-edit', function (){
  const username = $(this).data('username');
  axios.get(`/api-khachhang/get-khachHang-by-username?username=${username}`)
      .then(response =>{
        let khachHang = response.data.data;
        $(`#maKH`).val(khachHang.maKhachHang);
        $(`#username`).val(khachHang.username);
        $(`#fullname`).val(khachHang.fullname);
        $(`#gender`).val(khachHang.gender.toString());
        $(`#birthday`).val(khachHang.birthday);
        $(`#address`).val(khachHang.address);
        $(`#email`).val(khachHang.email);
        $(`#sdt`).val(khachHang.sdt);
      })
})

//edit user
