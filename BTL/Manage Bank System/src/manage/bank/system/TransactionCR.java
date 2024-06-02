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

public class TransactionCR {
    private String ID_CR;
    private String STK;
    private String LoaiGD;
    private Date Day;
    private String Money;
    private String ID_NV;

    // Constructor with all fields
    public TransactionCR(String ID_CR, String STK, String LoaiGD, Date Day, String Money, String ID_NV) {
        this.ID_CR = ID_CR;
        this.STK = STK;
        this.LoaiGD = LoaiGD;
        this.Day = Day;
        this.Money = Money;
        this.ID_NV = ID_NV;
    }

    // Getters
    public String getID_CR() {
        return ID_CR;
    }

    public String getSTK() {
        return STK;
    }

    public String getLoaiGD() {
        return LoaiGD;
    }

    public Date getDay() {
        return Day;
    }

    public String getMoney() {
        return Money;
    }

    public String getID_NV() {
        return ID_NV;
    }
}
