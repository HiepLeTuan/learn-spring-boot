
## Spring Boot Annotations 

#### Core Spring Framework Annotations

[@Required](): nó được áp dụng cho phương thức setter method. Nó chỉ ra rằng Bean được chú thích phải điền vào thời điểm cấu hình, nếu không thì nó sẽ ném ra ngoại lên 'BeanInitilizationException'

[@Autowired](): nó được sử dụng để tiêm(inject) đối tượng vào các phương thức 'setter', 'instance variable' và 'constructor'. @Autowired, bộ chứa lò xo sẽ tự động kết nối bean bằng cách khớp loại dữ liệu.

[@Configuration](): Nó là một chú thích cấp bậc.Lớp được chú thích '@Configuration' sử dụng làm nguồn định nghĩa 'Bean'

[@ComponentScan](): là annotation khai báo ở cấp độ class, giống như cái tên của nó, annotation @ComponentScan dùng để scan toàn bộ bean trong ứng dụng, mặc định nó sẽ scan tất cả bean trong package ở vị trí đặt class chưa hàm main, ngoài ra chúng ta cũng có thể tùy chỉnh package cần scan. thường thì annotation @ComponentScan sẽ đi chung vớ @ComponentScan.

Các param trong `@ComponentScan`:
- `basePackages`: dùng để chỉ ra những package cần scan, bạn có thể truyền vào một hoặc nhiều package name
- `basePackageClasses`: chỉ ra những class cần scan
- `excludeFilters`: dùng để filter loại trừ những bean or package không cần scan
- `includeFilters`: Dùng dể filter những bean or package cần scan.
- `lazyInit`: dùng để lazy load bean, default = false
- `resourcePattern`: chỉ ra các pattern file để Spring có thể scan, default pattern "**/*.class"

[@Bean](): nó là một annotation cho method. Nó là sự thay thể của thẻ XML <bean>. Nó cho biết method tạo ra một bean được Spring Container quản lý.

## Các mẫu Spring Boot Annotations:

[@Component]() :  là một annotation của class. Nó dùng để đánh dấu class Java là một bean. Một class Java được đánh dấu @Component được tìm thấy trong classpath. Spring Framework chọn nó và cấu hình trong ngữ cảnh ứng dụng như một Spring Bean.

[@Controller](): là một annotation ở class. Là một chuyên môn hóa của @Component. Nó đánh dấu class là một class để xử lý request web. Nó thường được sử dụng để phục vụ các request từ UI. Mặc định thì nó trả về một chuỗi cho biết route nào cần redirect. Nó chủ yếu được sử dụng với annotation @RequestMapping.

[@Service]() : nố thường được sử dụng ở class. Nó cho biết Spring biết rằng class này chứa business login.

[@Repository](): nó thường được dụng ở class. Repository là một DAOs (Data Access Object) cái mà sẽ truy cập trực tiếp vào database. Repository thực hiện tất cả các hoạt động liên quan đến database.


## Spring Boot Annotations:

[@EnableAutoConfiguration]() : Nó tự động cấu hình bean có trong classpath và cấu hình nó để chạy các phương thức. Việc sử dụng chú thích này bị giảm trong bản phát hành Spring Boot 1.2.0 vì các nhà phát triển đã cung cấp một giải pháp thay thế cho chú thích, tức là `@SpringBootApplication.`

[@SpringBootApplication]() : Nó là sự kết hợp của 3 chú thích: `@EnableAutoConfiguration`, `@ComponentScan`, `@Configuration.`


## Spring MVC and REST Annotations:

[@RequestMapping]() :  nó được sử dụng để map các request. Nó có nhiều phần tử tùy chọn như `consumes`, `header`, `method`, `name`, `params`, `path`, `produces`, và `value`. Chúng tôi sử dụng nó với lớp cũng như phương thức

[@GetMapping]() : nó map HTTP GET request trên method cụ thể. Nó dùng để tạo một điểm cuối trong web service, và nó được sử dụng thay cho `@RequestMapping(method = RequestMethod.GET)`.

[@PostMapping](): sử dụng khi gửi data tới server để tạo ra tài nguyên mới. Thay cho `@RequestMapping(method = RequestMethod.POST)`.

[@PutMapping](): sử dụng để thay đổi thông tin của một tài nguyên đã tồn tại trong hệ thống bằng cách sử dụng nội dung trong body của request. Nó được sử dụng thay vì sử dụng: `@RequestMapping (method = RequestMethod.PUT)`.

[@DeleteMapping](): sử dụng để xóa một resource chỉ định. Nó được sử dụng thay vì sử dụng: @RequestMapping (method = RequestMethod.DELETE).


## TỔNG HỢP TÀI LIỆU LẬP TRÌNH

[@PatchMapping](): Sử dụng để áp dụng sửa đổi 1 phần cho resource. Nó được sử dụng thay vì sử dụng: `@RequestMapping (method = RequestMethod.PATCH)`

[@RequestBody](): Nó được sử dụng để liên kết yêu cầu HTTP với một đối tượng trong một tham số phương thức. Bên trong nó sử dụng `HTTP MessageConverters` để chuyển đổi phần thân của yêu cầu. Khi chúng tôi chú thích một tham số phương thức với `@RequestBody`, Spring sẽ liên kết phần body yêu cầu HTTP đến với tham số đó.

[@RequestHeader](): Nó được sử dụng để lấy thông tin chi tiết về tiêu đề yêu cầu HTTP. Chúng tôi sử dụng chú thích này như một tham số phương thức. Các phần tử tùy chọn của chú thích là `name`, `required`, `value`, `defaultValue`. Đối với mỗi chi tiết trong tiêu đề, chúng ta nên chỉ định các chú thích riêng biệt. Chúng ta có thể sử dụng nó nhiều lần trong một phương pháp.

[@RestController]():  là một composed annotation được kết từ annotation @Controller và @ResponseBody, khi đặt một annotation @RestController trên một class controller thì mọi method controller trong class đó sẽ được thừa hưởng annotation `@ResponseBody` và response data trong controller này sẽ được trả về dưới dạng `message`.

 
## HTTP Status Code

- [200 OK]() : Mã này chỉ ra rằng yêu cầu thành công và nội dung phản hồi được trả lại cho máy khách khi thích hợp.
- [201 OK]() : Mã này chỉ ra rằng yêu cầu thành công và tài nguyên mới được tạo.
- [400 Bad Request]() : Mã này cho biết rằng máy chủ không thể xử lý yêu cầu do cú pháp không đúng định dạng trong yêu cầu. Khách hàng có thể thử lại sau khi sửa yêu cầu.
- [401 Unauthorized]() :  Mã này chỉ ra rằng xác thực là bắt buộc đối với tài nguyên. Khách hàng có thể thử lại với xác thực phù hợp.
- [403 Forbidden]() : Mã này chỉ ra rằng máy chủ đang từ chối trả lời yêu cầu ngay cả khi yêu cầu hợp lệ. Lý do sẽ được liệt kê trong nội dung cơ thể nếu yêu cầu không phải là phương thức HEAD.
- [404 Not Found]() : Mã này chỉ ra rằng tài nguyên được yêu cầu không được tìm thấy tại vị trí được chỉ định trong yêu cầu.
- [500 Internal Server Error]() : Mã này biểu thị thông báo lỗi chung và cho biết đã xảy ra lỗi không mong muốn trên máy chủ và yêu cầu không thể thực hiện được.


## @PatchMapping, @DeleteMapping, @GetMapping, @PutMapping ...

@DeleteMapping có các phần tử tùy chọn sau, các Anotation khác cũng dùng các phần tử tùy chọn này.

1. [`consumes`](): Được sử dụng để chỉ định các định dạng phương thức này có thể xử lý. Nếu yêu cầu DELETE có định dạng không nằm trong danh sách được chỉ định ở consumes, thì phương thức sẽ không được gọi.
2. [`headers`](): Cho phép bạn chỉ định các header của yêu cầu HTTP mà phải tồn tại để phương thức DELETE được gọi.
3. [`name`](): Được sử dụng để đặt tên cho phương thức, điều này có thể hữu ích trong việc tạo các bản đồ ánh xạ URL tùy chỉnh.
4. [`path`](): Chỉ định một đường dẫn URI mà phải khớp với yêu cầu DELETE để phương thức xử lý.
5. [`produces`](): Được sử dụng để chỉ định các định dạng phản hồi mà phương thức này có thể tạo ra. Nếu yêu cầu DELETE không thể chấp nhận một định dạng nằm trong danh sách produces, thì phương thức sẽ không được gọi.
6. [`value`](): Định nghĩa một hoặc nhiều đường dẫn URI mà phương thức này sẽ xử lý.


