package com.example.javaweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Nganh")
public class Nganh {
    @Id
    @Column(name="MaNganh",length = 100)
    private String maNganh;


    @Column(name="TenNganh",length = 255)
    private String tenNganh;

    @Column(name="LoaiNganh",length = 255)
    private String loaiNganh;

    public Nganh(){

    }
    public Nganh(String maNganh,String tenNganh,String loaiNganh){
        this.maNganh=maNganh;
        this.tenNganh=tenNganh;
        this.loaiNganh=loaiNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getLoaiNganh() {
        return loaiNganh;
    }

    public void setLoaiNganh(String loaiNganh) {
        this.loaiNganh = loaiNganh;
    }
}
