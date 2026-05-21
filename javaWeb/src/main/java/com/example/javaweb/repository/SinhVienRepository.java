package com.example.javaweb.repository;

import com.example.javaweb.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,String> {
    List<SinhVien> findByHoTenContainingOrSoCMND(String hoTen, String soCMND);
}
