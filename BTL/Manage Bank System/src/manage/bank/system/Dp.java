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
public class Dp {
    private String ID_dp;
    private String adress;
    private String name;
    private String hotline;
    private String ID_HQ;

    // Constructor
    public Dp(String ID_dp, String adress, String name, String hotline, String ID_HQ) {
        this.ID_dp = ID_dp;
        this.adress = adress;
        this.name = name;
        this.hotline = hotline;
        this.ID_HQ = ID_HQ;
    }

    // Getters and Setters
    public String getID_dp() {
        return ID_dp;
    }

  

    public String getAdress() {
        return adress;
    }


    public String getName() {
        return name;
    }


    public String getHotline() {
        return hotline;
    }

 
    public String getID_HQ() {
        return ID_HQ;
    }

  
}

