package com.example.javaweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Truong")
public class Truong {

    @Id
    @Column(name="MaTruong",length = 20)
    private String maTruong;

    @Column(name = "TenTruong",length = 100)
    private String tenTruong;

    @Column(name ="DiaChi",length = 255)
    private String diaChi;

    @Column(name="SoDT",length = 10)
    private String soDT;

    public Truong(){

    }
    public Truong(String maTruong,String tenTruong,String diaChi,String soDT){
        this.maTruong=maTruong;
        this.tenTruong=tenTruong;
        this.diaChi=diaChi;
        this.soDT=soDT;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}
