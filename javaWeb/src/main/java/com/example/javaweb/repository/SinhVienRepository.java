package com.example.javaweb.repository;

import com.example.javaweb.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,String> {
    List<SinhVien> findByHoTenContainingOrSoCMND(String hoTen, String soCMND);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tot_nghiep WHERE SoCMND = :soCMND", nativeQuery = true)
    void deleteTotNghiepBySoCMND(@Param("soCMND") String soCMND);
}
