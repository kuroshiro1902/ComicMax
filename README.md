
- API
api fe: Thành
"method", trả về "object" là gì cho server //method[POST, GET, DELETE, UPDATE], object
server:
	- servlet: Sơn
		+ nhận object mà fe trả về
		+ làm công việc với object đó bằng "phương thức" trong DAO
	- DAO: Tùng, Trung
		+ tạo hàm 
	- SQL: Đạt
		+ viết lệnh sql để thực hiện hành động
công việc: 
	-sửa:
	+ servlet
	method: post  -> code trong dopost
	object: {pid, amout}
	+ dao: itemDAO:tạo hàm modifyItemInCart(Item item(id, amount, username)){
		query = "sfsdfsdfdsfs"
		sửa lại amount của item trong bảng Item có username = item.getUsername() và id = item.getAmount()
	+sql: query = "lskjdlksajdklasj"
	}

	
- các hàm trong utils:
	- encrypt, decrypt: Đạt
	- splitString: Trung
- getRelateBook trong BookDAO
- Trigger: Trung
item: sản phẩm trong giỏ hàng
- khi một user "mua" một item:
+ trường đã_mua của item set về 1
+ số lượng quyển sách có id trùng với id item = số lượng hiện tại - số lượng của item
- Phân trang
- Sửa lại hết DAO theo form BookDAO (format lại hết query trong từng hàm)
- Tạo lại database, thêm các ràng buộc FOREIGN KEY, ON DELETE để tự động xóa các hàng liên quan ở bảng khác khi một hàng bị xóa
- Filter kết quả
- Sửa lại chữ ở slider







