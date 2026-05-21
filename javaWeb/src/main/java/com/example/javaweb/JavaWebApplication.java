package com.example.javaweb;

import com.example.javaweb.entity.Nganh;
import com.example.javaweb.entity.SinhVien;
import com.example.javaweb.entity.Truong;
import com.example.javaweb.repository.NganhRepository;
import com.example.javaweb.repository.SinhVienRepository;
import com.example.javaweb.repository.TruongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebApplication.class, args);
    }

    // Khối lệnh này sẽ tự động chạy ngay sau khi Spring Boot khởi động thành công
    @Bean
    public CommandLineRunner initData(TruongRepository truongRepo,
                                      NganhRepository nganhRepo,
                                      SinhVienRepository sinhVienRepo) {
        return args -> {
            // 1. Thêm dữ liệu mẫu vào bảng TRUONG (Nếu chưa có)
            if (truongRepo.count() == 0) {
                truongRepo.save(new Truong("T01", "Đại học Bách Khoa", "Đà Nẵng", "0236123456"));
                truongRepo.save(new Truong("T02", "Đại học Sư Phạm Kỹ Thuật", "Đà Nẵng", "0236654321"));
                truongRepo.save(new Truong("T03", "Đại học CNTT & TT Việt - Hàn", "Đà Nẵng", "0236999999"));
            }

            // 2. Thêm dữ liệu mẫu vào bảng NGANH (Nếu chưa có)
            if (nganhRepo.count() == 0) {
                nganhRepo.save(new Nganh("N01", "Công nghệ thông tin", "Kỹ thuật"));
                nganhRepo.save(new Nganh("N02", "Quản trị kinh doanh", "Kinh tế"));
                nganhRepo.save(new Nganh("N03", "Công nghệ kỹ thuật ô tô", "Kỹ thuật"));
            }

            // 3. Thêm dữ liệu mẫu vào bảng SINHVIEN (Để lát nữa test nhập CMND)
            if (sinhVienRepo.count() == 0) {
                sinhVienRepo.save(new SinhVien("123456789", "Nguyễn Văn A", "vana@gmail.com", "0905111222", "Đà Nẵng"));
                sinhVienRepo.save(new SinhVien("987654321", "Trần Thị B", "thib@gmail.com", "0905333444", "Quảng Nam"));
            }

            System.out.println(">> ĐÃ NẠP DỮ LIỆU MẪU THÀNH CÔNG VÀO DATABASE! <<");
        };
    }
}