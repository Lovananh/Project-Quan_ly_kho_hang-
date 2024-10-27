/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Database;

import java.sql.*;
import javax.swing.*;
public class Lap01_Finall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connect dbConnect = new Connect();
    try {
        Connection conn = dbConnect.connectSQL();
        if (conn != null) {
            System.out.println("Kết nối thành công!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
}
