package com.example.javaweb.controller;

import com.example.javaweb.entity.SinhVien;
import com.example.javaweb.entity.TotNghiep;
import com.example.javaweb.repository.NganhRepository;
import com.example.javaweb.repository.SinhVienRepository;
import com.example.javaweb.repository.TruongRepository;
import com.example.javaweb.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sinh-vien")
public class StudentController {
    private final TruongRepository truongRepository;
    private final NganhRepository nganhRepository;
    private final StudentService studentService;
    private final SinhVienRepository sinhVienRepository;

    public StudentController(TruongRepository truongRepository,
                             NganhRepository nganhRepository,
                             StudentService studentService,SinhVienRepository sinhVienRepository) {
        this.truongRepository = truongRepository;
        this.nganhRepository = nganhRepository;
        this.studentService = studentService;
        this.sinhVienRepository=sinhVienRepository;
    }
    @GetMapping("/them-tot-nghiep")
    public String showForm(Model model){
        model.addAttribute("totNghiepData",new TotNghiep());

        model.addAttribute("listTruong",truongRepository.findAll());
        model.addAttribute("listNganh",nganhRepository.findAll());;

        return "add-form";
    }

    @PostMapping("/luu-tot-nghiep")
    public String SaveForm(@ModelAttribute("totNghiepData") TotNghiep totNghiep,Model model){
        Map<String,String> errors=studentService.validateAndSave(totNghiep);
        if(!errors.isEmpty()){
            model.addAttribute((errors));
            model.addAttribute("listTruong",truongRepository.findAll());
            model.addAttribute("listNganh",nganhRepository.findAll());

            return "add-form";
        }
        return "redirect:/sinh-vien/them-tot-nghiep?success=true";
    }
    @GetMapping("/tim-sinh-vien")
    public String searchForm(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<SinhVien> dsSinhVien;

        if (keyword != null && !keyword.trim().isEmpty()) {
            dsSinhVien = sinhVienRepository.findByHoTenContainingOrSoCMND(keyword, keyword);
            model.addAttribute("keyword", keyword);
        } else {
            dsSinhVien = sinhVienRepository.findAll();
        }

        model.addAttribute("listSinhVien", dsSinhVien);
        return "search-form";
    }
    @GetMapping("/sua-sinh-vien/{soCMND}")
    public String showEditForm(@PathVariable("soCMND") String soCMND,Model model){
        SinhVien sv=sinhVienRepository.findById(soCMND).orElse(null);
        if(sv==null){
            return "redirect:/sinh-vien/tim-sinh-vien";
        }
        model.addAttribute("sinhVien",sv);
        return "edit";
    }
    @PostMapping("/cap-nhat")
    public String updateSinhVien(@ModelAttribute("sinhVien") SinhVien sinhVien){
        sinhVienRepository.save(sinhVien);
        return "redirect:/sinh-vien/tim-sinh-vien";
    }
    @GetMapping("/xoa-sinh-vien/{soCMND}")
    public String deleteSinhVien(@PathVariable("soCMND") String soCMND,Model model){
        try{
            sinhVienRepository.deleteTotNghiepBySoCMND(soCMND);
            sinhVienRepository.deleteById(soCMND);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/sinh-vien/tim-sinh-vien";
    }
}
