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
public class CardType {
    private String ID_CardType;
    private String name;

    // Constructors
  

    public CardType(String ID_CardType, String name) {
        this.ID_CardType = ID_CardType;
        this.name = name;
    }

    // Getters and Setters
    public String getID_CardType() {
        return ID_CardType;
    }

   

    public String getName() {
        return name;
    }

 
   
}
