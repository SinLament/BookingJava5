document.addEventListener('DOMContentLoaded', function() {
  const tabs = document.querySelectorAll('.nav-tabs li');
  const panes = document.querySelectorAll('.tab-pane');

  tabs.forEach(tab => {
    tab.addEventListener('click', switchTab);
  });

  function switchTab(e) {
    const target = e.target.closest('li');
    if (!target) return;
    tabs.forEach(tab => tab.classList.remove('active'));
    panes.forEach(pane => pane.classList.remove('active'));
    target.classList.add('active');
    const tabId = target.querySelector('a').getAttribute('href');
    document.querySelector(tabId).classList.add('active');
  }

  // Tăng giảm số lượng phòng
  let roomValue = 1;
  $(document).on('click','#phong .qtyInc',function(e) {
    roomValue++;
    $('#phong input').val(roomValue);
    e.stopPropagation();
  });

  $(document).on('click','#phong .qtyDec',function(e) {
    roomValue--;
    if (roomValue < 1) {
      alert("Số phòng tối thiểu là 1");
    } else {

      $('#phong input').val(roomValue);
    }
    e.stopPropagation();
  });

  // Tăng giảm số lượng người lớn
  let adultValue = 0;
  $(document).on('click','#nguoiLon .qtyInc',function(e) {
    adultValue++;
    $('#nguoiLon input').val(adultValue);
    const dropdown = document.querySelector('.dropdown-toggle.dropdown-btn');
    const adultSpan = dropdown.querySelector('.nguoiLonVal');

    adultSpan.textContent = `${adultValue} Người lớn`;
    e.stopPropagation();
  });

  $(document).on('click','#nguoiLon .qtyDec',function(e) {
    adultValue--;
    if (adultValue < 1) {
      alert("Số người lớn tối thiểu là 1");
    } else {

      $('#nguoiLon input').val(adultValue);
      const dropdown = document.querySelector('.dropdown-toggle.dropdown-btn');
      const adultSpan = dropdown.querySelector('.nguoiLonVal');

      adultSpan.textContent = `${adultValue} Người lớn`;
    }
    e.stopPropagation();
  });

  // Tăng giảm số lượng trẻ em
  let childValue = 0;
  $('#treEm .qtyInc').click(function(e) {
    childValue++;
    $('#treEm input').val(childValue);
    const dropdown = document.querySelector('.dropdown-toggle.dropdown-btn');
    const childSpan = dropdown.querySelector('.treEmVal');
    childSpan.textContent = `${adultValue} Trẻ Em`;
    e.stopPropagation();
  });

  $('#treEm .qtyDec').click(function(e) {
    childValue--;
    if (childValue < 0) {
      alert("Số trẻ em tối thiểu là 0");
      childValue = 0;
    } else {
      $('#treEm input').val(childValue);
      const dropdown = document.querySelector('.dropdown-toggle.dropdown-btn');
      const childSpan = dropdown.querySelector('.treEmVal');

      childSpan.textContent = `${adultValue} Trẻ Em`;
    }
    e.stopPropagation();
  });

});
