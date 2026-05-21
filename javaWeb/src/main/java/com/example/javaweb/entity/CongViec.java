package com.example.javaweb.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="CONG_VIEC")
public class CongViec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="SoCMND")
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name="MaNganh")
    private Nganh nganh;

    @Column(name="NgayVaoCongty")
    private LocalDate ngayVaoCongTy;

    @Column(name="TenCongViec")
    private String tenCongViec;

    @Column(name = "TenCongTy", length = 100)
    private String tenCongTy;

    @Column(name = "DiaChiCongTy", length = 255)
    private String diaChiCongTy;

    @Column(name = "ThoiGianLamViec")
    private Integer thoiGianLamViec;

    public CongViec(Long id, SinhVien sinhVien, Nganh nganh, LocalDate ngayVaoCongTy, String tenCongViec, String tenCongTy, String diaChiCongTy, Integer thoiGianLamViec) {
        this.id = id;
        this.sinhVien = sinhVien;
        this.nganh = nganh;
        this.ngayVaoCongTy = ngayVaoCongTy;
        this.tenCongViec = tenCongViec;
        this.tenCongTy = tenCongTy;
        this.diaChiCongTy = diaChiCongTy;
        this.thoiGianLamViec = thoiGianLamViec;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public LocalDate getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(LocalDate ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChiCongTy() {
        return diaChiCongTy;
    }

    public void setDiaChiCongTy(String diaChiCongTy) {
        this.diaChiCongTy = diaChiCongTy;
    }

    public Integer getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(Integer thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }
}
