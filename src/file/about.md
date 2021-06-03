## Graph Path Finder
Phần mềm ***Graph Path Finder*** ///v0.9.9/// được phát triển bởi 6 sinh viên của Đại học Bách khoa Hà Nội. Chúng tôi gồm có:
- ///Trần Công Hoàng - IT1 K64///
- ///Vũ Lê Nhật Minh - IT2 K64///
- ///Lê Trường Nguyên - IT1 K64///
- ///Phạm Hữu Khánh Duy - IT1 K64///
- ///Lê Thanh Tùng - IT1 K64///
- ///Trần Quang Đại - IT1 K64///

***Graph Path Finder*** ra đời với mục đích hỗ trợ việc học tập và nghiên cứu bài toán tìm đường đi giữa các đỉnh trong đồ thị. Với chức năng đầy đủ, giao diện thân thiện, trực quan cùng các bước thao tác đơn giản, chúng tôi hi vọng ***Graph Path Finder*** có thể hỗ trợ tối đa cho người dùng trong việc tìm hiểu bài toán này.

Đây là dự án mã nguồn mở dưới sự cấp phép của ***MIT License***, nên việc đóng góp và phát triển sản phẩm đều rất khuyến khích dưới các yêu cầu và quy định của giấy phép để đem trải nghiệm sản phẩm tốt hơn.

Mọi đóng góp và thắc mắc xin liên hệ:
- ///Email: hoang.tc194060@sis.hust.edu.vn///
- ///Điện thoại: 0846303882///

## Ngôn ngữ
Phần mềm được lập trình bằng ngôn ngữ ***///Java///***, xây dựng giao diện với ***///JavaFX///***, ngôn ngữ ***///XML///*** và ***///CSS///***. Một số tính năng khác có yêu cầu các thư viện từ ***[GluonHQ](https://gluonhq.com/)*** và ***[JFoenix](http://www.jfoenix.com/)*** để mang trải nghiệm người dùng tốt hơn. Vì vậy việc cài đặt các thư viện này là cần thiết để phần mềm có thể chạy đúng tính năng của nó.

Chức năng chính của phần mềm được phát triển bằng ***///Intellij///***, ***///Eclipse///*** và giao diện được xây dựng bằng ***///Scene Builder///***.

## Cài đặt
Dưới đây là các bước cài đặt cơ bản của ***Graph Path Finder***:

### Cài đặt IDE (Eclipse/Intellij)
Tải về và cài đặt theo hướng dẫn tại trang chủ của ***Eclipse*** hoặc ***Intellij***. Có thể phải trả thêm chi phí để sử dụng dịch vụ.

### Cài đặt JavaFX và thiết lập trong IDE
- Tải và cài đặt ***JavaFX*** tại ***GluonHQ***.
- Thêm ***///Environment Variables///***:
    - ***Windows***: ```set PATH_TO_FX="path\to\javafx-sdk-15.0.1\lib"```
    - ***MacOS/Linux***: ```export PATH_TO_FX=path/to/javafx-sdk-15.0.1/lib```

      Để JavaFX tự động chạy khi khởi động Linux, hãy thêm câu lệnh trên vào ```~/.bashrc```.
    - Thêm vào ***configuration***:

      Mở IDE (Eclipse/Inntellij), vào ***Run***, chọn ***Edit Configuration***, chọn ***Add VM variables*** và thêm:

      ```--module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml```
### Cài đặt Scene Builder
- Tải và cài đặt tại ***GluonHQ***
- Tích hợp Scene Builder vào IDE:
    - ***Intellij***: Chọn ***File/Preferences***, chọn ***Languages and Frameworks | JavaFX***. Thêm đường dẫn đến ***Scene Builder*** và chọn ***Apply***.
    - ***Eclipse***: Chọn ***Windows/References***, chọn ***JavaFX***. Thêm đường dẫn đến ***Scene Builder*** và chọn ***Apply***.
### Gluon Charm
- Tải ***com.gluonhq.charm-glisten***
- Thêm vào project:
    - ***Eclipse***: https://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse
    - ***Intellij***: https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
### Nhúng Mark Down
Để xử lý được file ```.md```, GPF sử dụng ```javafx.graphics``` và ```javafx.web```. Thêm dòng dưới đây vào ***///configurations///***:
```
--add-modules=javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.web --add-reads javafx.graphics=ALL-UNNAMED --add-opens javafx.controls/com.sun.javafx.charts=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.iio=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.iio.common=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.css=ALL-UNNAMED --add-opens javafx.base/com.sun.javafx.runtime=ALL-UNNAMED
```
Trong quá trình cài đặt, nếu phát sinh lỗi, hãy copy toàn bộ lỗi và report a bug tại phần ***///Issues///***. Hãy cung cấp đủ thông tin để người khác có thể đọc được.

## Tính năng chính
### Tìm đường đi ngắn nhất giữa hai đỉnh trong đồ thị
Với chế độ duyệt ***///Find All Paths///***, bạn có thể tìm đường đi ngắn nhất giữa hai đỉnh trong đồ thị có hướng, không có trọng số.
### Tìm đường đi ngắn nhất từ một đỉnh đến tất cả các đỉnh còn lại
Với chế độ duyệt ***///Depth First Search///*** - tìm kiếm theo chiều sâu và ***///Breadth First Search///*** - tìm kiếm theo chiều rộng, bạn có thể tìm đường đi ngắn nhất từ một đỉnh đến tất cả các đỉnh còn lại trong đồ thị có hướng, không có trọng số bằng hai thuật toán cùng tên tương ứng.
### Lưu đồ thị dưới dạng file PNG hoặc GPH
Bạn có thể lưu đồ thị dưới dạng file ```*.png``` hoặc ```*.gph``` để có thể tiện cho việc nghiên cứu bài toán tìm đường đi trong đồ thị.
## Về dự án
Đây là một dự án mã nguồn mở cấp phép dưới ***///MIT License///***, với mục đích giáo dục. Mọi hành vi thương mại hóa, close-source đều bị nghiêm cấms.