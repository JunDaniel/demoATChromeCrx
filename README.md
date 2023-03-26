# Công cụ phát triển
1. Tool InteliJ IDE
2. Thư viện Selenium / Thư viện Junit
3. Ngôn ngữ Java
4. Cấu trúc Project dạng Maven, dùng POM quản lý thư viện của dự án
5. ChromeDriver và trình duyệt Chrome 111.0.5563.111 (bản 64 bit) 

# Demo Automation Test với Extension Google Translate của trình duyệt Chrome
1. Load file crx của extension Google Translate
2. Thao tác AT với extension Google Translate

*Video demo: https://www.youtube.com/watch?v=vl6uY1VCOaI

Kịch bản kiểm thử với 1 Test case có các bước sau
1. Step 1: Cài Extension Google Translate vào trình duyệt Chrome
2. Step 2: Mở đường dẫn chrome-extension://aapbdbdomjkkjkaonfhkkikfgjllcleb/popup.html 
3. Step 3: Thực hiện điền text: tương lai vào ô textbox trên giao diện của Extension Google Translate
4. Step 4: Click nút Translate trên giao diện của Extension Google Translate
5. Step 5: Thực hiện verify kết quả dịch gồm: text nguồn = tương lai / kết quả dịch mong muốn text = future

Công việc cần Kiểm thử: 
Test chức năng dịch ngôn ngữ Tiếng Việt sang ngôn ngữ Tiếng Anh của công cụ Extension Google Translate trên trình duyệt Chrome
