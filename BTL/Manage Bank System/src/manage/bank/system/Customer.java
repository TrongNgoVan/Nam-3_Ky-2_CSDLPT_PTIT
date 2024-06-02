/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage.bank.system;

import java.sql.Date;

/**
 *
 * @author MEDIAMART PHU SON
 */
public class Customer {
    private String ID;
    private String name;
    private String CCCD;
    private Date Ngaycap;
    private Date Dob;
    private String adress;
    private String Sdt;
    private String ID_Dp;
    private String gender;

    public Customer(String ID, String name, String CCCD, Date Ngaycap, Date Dob, String adress, String Sdt, String ID_Dp, String gender) {
        this.ID = ID;
        this.name = name;
        this.CCCD = CCCD;
        this.Ngaycap = Ngaycap;
        this.Dob = Dob;
        this.adress = adress;
        this.Sdt = Sdt;
        this.ID_Dp = ID_Dp;
        this.gender = gender;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCCCD() {
        return CCCD;
    }

    public Date getNgaycap() {
        return Ngaycap;
    }

    public Date getDob() {
        return Dob;
    }

    public String getAdress() {
        return adress;
    }

    public String getSdt() {
        return Sdt;
    }

    public String getID_Dp() {
        return ID_Dp;
    }

    public String getGender() {
        return gender;
    }
}