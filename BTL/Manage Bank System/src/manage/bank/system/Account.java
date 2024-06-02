/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage.bank.system;

/**
 *
 * @author MEDIAMART PHU SON
 */
import java.sql.Date;

public class Account {
    private String STK;
    private String name;
    private String CCCD;
    private String Sodu;
    private Date Create_date;
    private String ID_Dp;
    private String ID_Customer;

    public Account(String STK, String name, String CCCD, String Sodu, Date Create_date, String ID_Dp, String ID_Customer) {
        this.STK = STK;
        this.name = name;
        this.CCCD = CCCD;
        this.Sodu = Sodu;
        this.Create_date = Create_date;
        this.ID_Dp = ID_Dp;
        this.ID_Customer = ID_Customer;
    }

    public String getSTK() {
        return STK;
    }

    public String getName() {
        return name;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getSodu() {
        return Sodu;
    }

    public Date getCreate_date() {
        return Create_date;
    }

    public String getID_Dp() {
        return ID_Dp;
    }

    public String getID_Customer() {
        return ID_Customer;
    }
}