package com.example.javaweb.repository;

import com.example.javaweb.entity.TotNghiep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, Long> {
}