//tat ca khach san
const getAllProduct = async () => {
  const response = await axios.get('/api/khachsan-api/getAllKhachSan');
  const productList = response.data.data;

  let carouselHtml = '';
  productList.forEach(khachsan => {
    carouselHtml += `
      <div class="card-item " style="width: 300px;height: 480px;">
        <div class="card-img">
          <a href="#" class="d-block">
            <img class="mt-2" src="/img/${khachsan.hinh}" style="width: 300px" alt="hotel-img">
          </a>
          <div class="add-to-wishlist icon-element" data-bs-toggle="tooltip"
               data-placement="top" aria-label="Bookmark"
               data-bs-original-title="Bookmark">
           <i class="bi bi-heart"></i>
          </div>
        </div>
        <div class="card-body">
          <h3 class="card-title">
            <a href="#">${khachsan.tenKhachSan}</a>
          </h3>
          <p class="card-meta">${khachsan.diaChi}</p>
          <div class="card-rating">
            <span class="badge text-white">${khachsan.xepHang}/5</span>
            <span class="review__text">Trung bình</span>
            <span class="rating__text">(30 Đánh giá)</span>
          </div>
          <div class="card-price d-flex align-items-center justify-content-between">
            <p>
              <span class="price__from">Từ</span>
              <span class="price__num">$88.00</span>
              <span class="price__text">Mỗi đêm</span>
            </p>
            <a href="/detail" class="btn-text">Xem chi tiết<i class="la la-angle-right"></i></a>
          </div>
        </div>
      </div>
    `;
  });

  const carouselElement = document.querySelector('.owl-carousel');
  carouselElement.innerHTML = carouselHtml;

  $(carouselElement).owlCarousel({
    loop: true,
    margin: 10,
    nav: false,
    responsive: {
      0: {
        items: 1
      },
      600: {
        items: 3
      },
      1000: {
        items: 4
      }
    }
  });
};
// Gọi hàm getAllProduct khi trang được tải
document.addEventListener('DOMContentLoaded', getAllProduct);




const getTop6 = async () => {
  let productContainer = $('#getTop5');
  await axios.get('/api/khachsan-api/findTop6ByXepHang')
  .then(response => {
    productContainer.html('');
    response.data.data.forEach(listtop6 => {
      let html = `
  <div class="col-lg-4">
                <div class="card-item destination-card">
          <div class="card-img">
            <img src="/img/${listtop6.hinh}" alt="Samsung S24 Ultra"> <span class="badge">${listtop6.thanhPho}</span>
          </div>
          <div class="card-body">
            <h3 class="card-title">
              <a href="/detail">${listtop6.tenKhachSan}</a>
            </h3>
            <div class="card-rating d-flex align-items-center">
								<span class="ratings d-flex align-items-center me-1"> <i
                    class="la la-star"></i> <i class="la la-star"></i> <i
                    class="la la-star"></i> <i class="la la-star-o"></i> <i
                    class="la la-star-o"></i>
								</span> <span class="rating__text">(70694 Reviews)</span>
            </div>
            <div
                class="card-price d-flex align-items-center justify-content-between">
              <p class="tour__text">50 Tours</p>
              <p>
                <span class="price__from">Price</span> <span class="price__num">$58.00</span>
              </p>
            </div>
          </div>
        </div>
        </div>
                `;
      productContainer.append(html);
    });
  })
  .catch(error => {
    alert(error);
  });
}
// Gọi hàm getAllProduct khi trang được tải
document.addEventListener('DOMContentLoaded', getTop6);