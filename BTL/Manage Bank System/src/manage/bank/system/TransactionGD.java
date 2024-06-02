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

public class TransactionGD {
    private String ID_HD;
    private String STK1;
    private String STK2;
    private String Money;
    private Date Day;
    private String ID_NV;

    // Constructor with all fields
    public TransactionGD(String ID_HD, String STK1, String STK2, String Money, Date Day, String ID_NV) {
        this.ID_HD = ID_HD;
        this.STK1 = STK1;
        this.STK2 = STK2;
        this.Money = Money;
        this.Day = Day;
        this.ID_NV = ID_NV;
    }

    // Getters
    public String getID_HD() {
        return ID_HD;
    }

    public String getSTK1() {
        return STK1;
    }

    public String getSTK2() {
        return STK2;
    }

    public String getMoney() {
        return Money;
    }

    public Date getDay() {
        return Day;
    }

    public String getID_Nv() {
        return ID_NV;
    }
}

