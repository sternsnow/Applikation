/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

/**
 *
 * @author karlb
 */
public class Validering {
    
    
    
public boolean arTextFaltTomt(String falt)
{
    boolean tomt = false;
        if(falt.isEmpty() || falt == null){
        tomt = true;    
        }
    return tomt;
}

public boolean kontrolleraLosenord(String losenord){
  boolean giltigt = false;
  
    if(arTextFaltTomt(losenord) == false && losenord.length() <= 11 && losenord.length() >= 5){
    giltigt = true;    
    }
    return giltigt;
}

public boolean kontrolleraEpost(String epost)
{
    boolean giltig = false;
        if(arTextFaltTomt(epost) == false && epost.contains("@") && epost.indexOf("@") > 0 && epost.length() > 5)
        {
        giltig = true;    
        }
            if(epost.contains(" ")){
            giltig = false;    
            }
        
    return giltig;
}

}
