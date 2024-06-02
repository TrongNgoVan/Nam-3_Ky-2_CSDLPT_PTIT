/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manage.bank.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db{
     public  Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://ALEXANDER_T\\CSPTN1:1433;databaseName=QLNH;user=sa;password=123;;encrypt=false";
//         đoạn này nên thêm encrypt = false đề phòng sqlserver nó bảo mật 
// servername + portname + dbname + user + pass 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }   
 
   
   
    public  Connection getConnection1()throws Exception {
        String url = "jdbc:sqlserver://ACERNITRO5EAGLE\\CSPTN1:1433;databaseName=QLNH_TSDN;user=sa;password=123;;encrypt=false";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }   
    public  Connection getConnection2()throws Exception {
        String url = "jdbc:sqlserver://DESKTOP-HBDN5FQ\\BTN_CSDLPT:1433;databaseName=QLNH_TSCT;user=sa;password=123;;encrypt=false";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }   
    public  Connection getConnection3()throws Exception {
        String url = "jdbc:sqlserver://DELL\\CSPTN1:1433;databaseName=QLNH_TSHCM;user=sa;password=123;;encrypt=false"; 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }   
    
     public static void main(String[] args){
        try{
            System.out.println(new Db().getConnection1());
        }catch(Exception e){
            System.out.println("khong ket noi duoc ");
    }
     }
    
}