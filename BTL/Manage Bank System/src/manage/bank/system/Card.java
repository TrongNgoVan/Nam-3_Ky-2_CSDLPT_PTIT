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


public class Card {
    private String ID_Card;
    private String TenChuthe;
    private Date DateExpired;
    private String Name_CardType;
    private String ID_CardType;
    private String ID_ac;

    // Constructors
    public Card() {}

    public Card(String  ID_Card, String TenChuthe, Date DateExpired, String Name_CardType, String ID_CardType, String ID_ac) {
        this.ID_Card = ID_Card;
        this.TenChuthe = TenChuthe;
        this. DateExpired = DateExpired ;
        this.Name_CardType = Name_CardType;
        this.ID_CardType = ID_CardType;
        this.ID_ac = ID_ac;
    }

   
    // Getters and Setters
    public String getID_Card() {
        return ID_Card;
    }

   

    public String getTenChuthe() {
        return TenChuthe;
    }

    

    public Date getDateExpired() {
        return DateExpired;
    }

    

    public String getName_CardType() {
        return Name_CardType;
    }

  

    public String getID_CardType() {
        return ID_CardType;
    }

 

    public String getID_ac() {
        return ID_ac;
    }

   

   
}

