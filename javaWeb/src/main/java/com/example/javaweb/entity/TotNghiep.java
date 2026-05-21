package com.example.javaweb.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TOT_NGHIEP")
public class TotNghiep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SoCMND")
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "MaTruong")
    private Truong truong;

    @ManyToOne
    @JoinColumn(name = "MaNganh")
    private Nganh nganh;

    @Column(name = "HeTN", length = 50)
    private String heTN;

    @Column(name = "NgayTN")
    private LocalDate ngayTN;

    @Column(name = "LoaiTN", length = 50)
    private String loaiTN;

    public TotNghiep() {
    }

    public TotNghiep(Long id, SinhVien sinhVien, Truong truong, Nganh nganh, String heTN, LocalDate ngayTN, String loaiTN) {
        this.id = id;
        this.sinhVien = sinhVien;
        this.truong = truong;
        this.nganh = nganh;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SinhVien getSinhVien() { return sinhVien; }
    public void setSinhVien(SinhVien sinhVien) { this.sinhVien = sinhVien; }

    public Truong getTruong() { return truong; }
    public void setTruong(Truong truong) { this.truong = truong; }

    public Nganh getNganh() { return nganh; }
    public void setNganh(Nganh nganh) { this.nganh = nganh; }

    public String getHeTN() { return heTN; }
    public void setHeTN(String heTN) { this.heTN = heTN; }

    public LocalDate getNgayTN() { return ngayTN; }
    public void setNgayTN(LocalDate ngayTN) { this.ngayTN = ngayTN; }

    public String getLoaiTN() { return loaiTN; }
    public void setLoaiTN(String loaiTN) { this.loaiTN = loaiTN; }
}