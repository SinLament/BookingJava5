const getAdminKhachHang = async () => {
  let productContainer = $('#adminkhachhang');
    let index = 0
  await axios.get('/admin-khachhang/getAllkhachHang')
  .then(response => {
    productContainer.html('');
    response.data.data.forEach(khachhang => {

      let html = `
                <tr>
                    <td>${khachhang.maKhachHang}</td>
                    <td>${khachhang.username}</td>
                    <td>${khachhang.fullname}</td>
                    <td>${khachhang.gender ? "Nam" : "Nữ"}</td>
                    <td>${khachhang.birthday}</td>
                    <td>${khachhang.address}</td>
                    <td>${khachhang.email}</td>
                    <td>${khachhang.sdt}</td>
                    <td>
                      <a style="background-color: #28d5a7;border:none;" class="edit-btn theme-btn theme-btn-small btn-edit btn-edit-KhachHang" data-username="${khachhang.username}"><i class="bi bi-pencil-square"></i></a> 
                      <a style="background-color: #e1306c;border:none;" class="theme-btn theme-btn-small delete-btn delete-btn-khachHang" data-khachhangid="${khachhang.maKhachHang}"><i class="bi bi-x-lg"></i></a>
                     </td>
                  </tr>
                `;
      productContainer.append(html);
    });
  })
  .catch(error => {
    alert(error);
  });
  productContainer.on('click', '.delete-btn-khachHang', async function () {
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
document.addEventListener('DOMContentLoaded', getAdminKhachHang);
$(document).on('click', '.btn-edit-KhachHang', function (){
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
        $(`#ps`).val(khachHang.password);
      })
})

async function saveKhachHang() {
    const username =$('#username').val();
    const fullname =$('#fullname').val();
    const birthday = new Date($('#birthday').val()).toISOString().slice(0, 10);
    const address =$('#address').val();
    const email =$('#email').val();
    const sdt =$('#sdt').val();
    const ps =$('#ps').val();
    const genderSelect = document.getElementById('gender');
    const genderValue = genderSelect.value;
    const gender = genderValue === 'true';

    const khachHang = {
        username: username,
        fullname: fullname,
        gender: gender,
        birthday: birthday,
        address: address,
        email: email,
        sdt: sdt,
        password:ps
    };
    console.log("Dữ liệu khách hàng gửi đi:", khachHang);
    try {
        const response = await axios.post('/api-khachhang/save-khachHang', khachHang);
        if (response.data.status) {
            alert('Lưu khách hàng thành công');
            reset();
            getAdminKhachHang();
        } else {
            alert('Lưu khách hàng thất bại: ' + response.data.message);
        }
    } catch (error) {
        console.error('Lỗi khi lưu khách hàng:', error);
        alert('Có lỗi xảy ra khi lưu khách hàng');
    }
}




async function updateKhachHang() {

    const maKH = $('#maKH').val();
    const username =$('#username').val();
    const fullname =$('#fullname').val();
    const birthday = new Date($('#birthday').val()).toISOString().slice(0, 10);
    const address =$('#address').val();
    const email =$('#email').val();
    const sdt =$('#sdt').val();
    const ps =$('#ps').val();
    const genderSelect = document.getElementById('gender');
    const genderValue = genderSelect.value;
    const gender = genderValue === 'true';

    const khachHang = {
        username: username,
        fullname: fullname,
        gender: gender,
        birthday: birthday,
        address: address,
        email: email,
        sdt: sdt,
        password:ps
    };
    console.log("Dữ liệu khách hàng gửi đi:", khachHang);
    console.log(maKH);
    try {
        const response = await axios.put(`/api-khachhang/update-khachhang/${maKH}`, khachHang);
        if (response.data.status) {
            alert('Cập nhật khách hàng thành công');
            getAdminKhachHang();
        } else {
            alert('Cập nhật khách hàng thất bại: ' + response.data.message);
        }
    } catch (error) {
        console.error('Lỗi khi cập nhật khách hàng:', error);
        alert('Có lỗi xảy ra khi cập nhật khách hàng');
    }
}
// Khách sạn
const getAdminKhachSan = async () => {
    let productContainer = $('#adminKhachSan');
    let index = 0
    await axios.get('/api/khachsan-api/getAllKhachSan')
        .then(response => {
            productContainer.html('');
            response.data.data.forEach(khachSan => {

                let html = `
                <tr>
                    <td>${khachSan.maKhachSan}</td>
                    <td>${khachSan.tenKhachSan}</td>
                    <td>${khachSan.diaChi}</td>
                    <td>${khachSan.thanhPho}</td>
                    <td>${khachSan.moTa}</td>
                    <td>${khachSan.xepHang}</td> 
                    <td>
                      <a style="background-color: #28d5a7;border:none;" class="edit-btn theme-btn theme-btn-small btn-edit btn-edit-khachSan" data-username="${khachSan.maKhachSan}"><i class="bi bi-pencil-square"></i></a> 
                      <a style="background-color: #e1306c;border:none;" class="theme-btn theme-btn-small delete-btn delete-btn-khachSan" data-khachhangid="${khachSan.maKhachSan}"><i class="bi bi-x-lg"></i></a>
                     </td>
                  </tr>
                `;
                productContainer.append(html);
            });
        })
        .catch(error => {
            alert(error);
        });
    productContainer.on('click', '.delete-btn-khachSan', async function () {
        let khachSanId = $(this).data('khachhangid');
        if (confirm('Bạn có chắc chắn muốn xóa khách sạn này?')) {
            await axios.delete(`/api/khachsan-api/delete-khachSan-by-maks?maKS=${khachSanId}`)
                .then(response => {
                    alert(response.data.message);
                    getAdminKhachSan();
                })
                .catch(error => {
                    console.log(error);
                    alert('Xóa khách sạn thất bại');
                });
        }
    });
}
document.addEventListener('DOMContentLoaded', getAdminKhachSan);
$(document).on('click', '.btn-edit-khachSan', function (){
    const username = $(this).data('username');
    axios.get(`/api/khachsan-api/find-khach-san-by-ma-khach-san?maKhachSan=${username}`)
        .then(response =>{
            let khachSan = response.data.data;
            $(`#maKS`).val(khachSan.maKhachSan);
            $(`#tenKhachSan`).val(khachSan.tenKhachSan);
            $(`#moTa`).val(khachSan.moTa);
            $(`#xepHang`).val(khachSan.xepHang);
            $(`#hinh`).val(khachSan.hinh);
            $(`#diaChi`).val(khachSan.diaChi);
            $(`#thanhPho`).val(khachSan.thanhPho);
        })
})

async function saveKhachSan() {
    const maKS =$('#maKS').val();
    const tenKhachSan =$('#tenKhachSan').val();
    const moTa =$('#moTa').val();
    const xepHang =$('#xepHang').val();
    const hinh =$('#hinh').val();
    const diaChi =$('#diaChi').val();
    const thanhPho =$('#thanhPho').val();

    const khachSan = {
        maKhachSan: maKS,
        tenKhachSan: tenKhachSan,
        diaChi: diaChi,
        thanhPho: thanhPho,
        moTa: moTa,
        xepHang: xepHang,
        hinh: hinh,
    };
    console.log("Dữ liệu khách hàng gửi đi:", khachSan);
    try {
        const response = await axios.post('/api/khachsan-api/saveKhachSan', khachSan);
        if (response.data.status) {
            alert('Lưu khách Sạn thành công');
            reset();
            getAdminKhachSan();
        } else {
            alert('Lưu khách Sạn thất bại: ' + response.data.message);
        }
    } catch (error) {
        console.error('Lỗi khi lưu khách Sạn:', error);
        alert('Có lỗi xảy ra khi lưu khách Sạn');
    }
}




async function updateKhachSan() {

    const maKS =$('#maKS').val();
    const tenKhachSan =$('#tenKhachSan').val();
    const moTa =$('#moTa').val();
    const xepHang =$('#xepHang').val();
    const hinh =$('#hinh').val();
    const diaChi =$('#diaChi').val();
    const thanhPho =$('#thanhPho').val();

    const khachSan = {
        maKhachSan: maKS,
        tenKhachSan: tenKhachSan,
        diaChi: diaChi,
        thanhPho: thanhPho,
        moTa: moTa,
        xepHang: xepHang,
        hinh: hinh,
    };
    console.log("Dữ liệu khách hàng gửi đi:", khachSan);

    try {
        const response = await axios.put(`/api/khachsan-api/update-khachSan/${maKS}`, khachSan);
        if (response.data.status) {
            alert('Cập nhật khách sạn thành công');
            getAdminKhachSan();
        } else {
            alert('Cập nhật khách sạn thất bại: ' + response.data.message);
        }
    } catch (error) {
        console.error('Lỗi khi cập nhật khách sạn:', error);
        alert('Có lỗi xảy ra khi cập nhật khách sạn');
    }
}

function reset() {
    $('form')[0].reset();
}
