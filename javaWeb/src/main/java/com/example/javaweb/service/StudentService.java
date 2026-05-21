package com.example.javaweb.service;

import com.example.javaweb.entity.TotNghiep;
import com.example.javaweb.repository.TotNghiepRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
@Service
public class StudentService {
   private final TotNghiepRepository totNghiepRepository;

   public StudentService(TotNghiepRepository totNghiepRepository){
       this.totNghiepRepository=totNghiepRepository;
   }
   public Map<String,String> validateAndSave(TotNghiep totNghiep){
       Map<String,String> errors=new HashMap<>();

       if(totNghiep.getSinhVien()==null||totNghiep.getSinhVien().getSoCMND().trim().isEmpty()){
           errors.put("errors","So CMND khong duoc de trong!");
       }
       if(totNghiep.getNgayTN()==null){
           errors.put("errorNgay", "Ngày tốt nghiệp không được để trống!");
       } else if (totNghiep.getNgayTN().isAfter(LocalDate.now())) {
           errors.put("errorNgay", "Ngày tốt nghiệp không được vượt quá ngày hiện tại!");
       }
       if(errors.isEmpty()){
           totNghiepRepository.save(totNghiep);
       }
       return errors;
   }
}
