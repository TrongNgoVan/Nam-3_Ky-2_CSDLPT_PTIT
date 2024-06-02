package manage.bank.system;

import java.sql.Date;

public class Staff {
    private String ID;
    private String name;
    private String Gioitinh;
    private String SDT;
    private Date Dob;
    private String CCCD;
    private String Chucvu;
    private String ID_Dp;

    public Staff(String ID, String name, String Gioitinh, String SDT, Date Dob, String CCCD, String Chucvu, String ID_Dp) {
        this.ID = ID;
        this.name = name;
        this.Gioitinh = Gioitinh;
        this.SDT = SDT;
        this.Dob = Dob;
        this.CCCD = CCCD;
        this.Chucvu = Chucvu;
        this.ID_Dp = ID_Dp;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public String getSDT() {
        return SDT;
    }

    public Date getDob() {
        return Dob;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public String getID_Dp() {
        return ID_Dp;
    }
}
