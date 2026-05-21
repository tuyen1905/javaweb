package com.example.javaweb.controller;

import com.example.javaweb.entity.SinhVien;
import com.example.javaweb.entity.TotNghiep;
import com.example.javaweb.repository.NganhRepository;
import com.example.javaweb.repository.SinhVienRepository;
import com.example.javaweb.repository.TruongRepository;
import com.example.javaweb.service.StudentService;
import jakarta.websocket.server.PathParam;
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
    public String seardForm(@RequestParam(name ="keyword",value = "keyword",required = false)String keyword,Model model){
        List<SinhVien> dsSinhVien;
        if(keyword!=null && !keyword.trim().isEmpty()){
            dsSinhVien=sinhVienRepository.findByHoTenContainingOrSoCMND(keyword,keyword);
            model.addAttribute("keyword",keyword);
        }else{
            dsSinhVien=sinhVienRepository.findAll();
;        }
        model.addAttribute("listSinhVien",dsSinhVien);
        return "seard-form";
    }
}
