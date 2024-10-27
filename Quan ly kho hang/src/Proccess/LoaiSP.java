/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import java.sql.*;
import Database.Connect;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.sql.PreparedStatement;

public class LoaiSP {

    private String maloai;
    private String tenloai;

     public String getMaloai() {
        return maloai;
    }

    public String getTenloai() {
        return this.tenloai;
    }
    
    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

   
    public Connect cn = new Connect();

    //truy van tat car du liieu trong table LoaiSP
    public List<LoaiSP> getLoaiSP() throws SQLException {
        String sql = "SELECT*FROM LoaiSp";
        List<LoaiSP> list = new ArrayList<>();
      try (Connection conn = cn.connectSQL()) {
          
          Statement st = conn.createStatement(); 
          ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                LoaiSP loaisp = new LoaiSP();
                loaisp.setMaloai(rs.getString("Maloai"));
                loaisp.setTenloai(rs.getString("Tenloai"));
                list.add(loaisp);
            }
        }
        return list;
    }
    // truy vấn vào các dòng  trong table theo maloai

    public LoaiSP getLoaiSP(String ml) throws SQLException {
        String sql = "SELECT*FROM LoaiSp where Maloai= ?";
        LoaiSP loaisp = null;
     
        try (Connection conn = cn.connectSQL()) {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, ml);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    loaisp = new LoaiSP();
                    loaisp.setMaloai(rs.getString("Ma loai"));
                    loaisp.setTenloai(rs.getString("Ten loai"));
                }
            }
        }
        return loaisp;
    }

//    thêm 1 dòng mới vào table 
    public boolean InsertData(LoaiSP obj) throws SQLException {
        String sql = "INSERT INTO LoaiSp (Maloai, Tenloai) VALUES (?, ?)";

        try (Connection conn = cn.connectSQL()) {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, obj.getMaloai());
            stm.setString(2, obj.getTenloai());
            int rowsInserted = stm.executeUpdate();
            return rowsInserted > 0;  // Trả về true nếu chèn thành công
        }
    }

    //điều chỉnh 1 dòng 
    public boolean EditData(LoaiSP obj) throws SQLException {
        String sql = "Update LoaiSp set Tenloai =? where Maloai=?";

        try (Connection conn = cn.connectSQL()) {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, obj.getTenloai());
            stm.setString(2, obj.getMaloai());
            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    
    //xoa 1 dong du lieu khoi table
    public boolean DeleteData(String ml) throws SQLException {
        String sql = "DELETE FROM LoaiSP WHERE Maloai = ?";

        try (Connection conn = cn.connectSQL()) {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, ml);
            int rowsDeleted = stm.executeUpdate();
            return rowsDeleted > 0;  // Trả về true nếu xóa thành công
        }
    }

}
