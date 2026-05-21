package com.example.javaweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SinhVien")
public class SinhVien {
    @Id
    @Column(name="SoCMND",length = 20)
    private String soCMND;

    @Column(name="HoTen")
    private String hoTen;

    @Column(name="Email")
    private String email;

    @Column(name="SoST",length = 10)
    private String soDT;

    @Column(name="DiaChi")
    private String diaChi;

    public SinhVien(){}
    public SinhVien(String soCMND,String hoTen,String email,String soDT,String diaChi){
        this.soCMND=soCMND;
        this.hoTen=hoTen;
        this.email=email;
        this.soDT=soDT;
        this.diaChi=diaChi;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}
