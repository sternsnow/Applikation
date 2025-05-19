/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author karlb
 */
public class Validering {
    
  private InfDB idb;
  
  public Validering (InfDB idb) {
      this.idb = idb;
  }
    
public boolean arTextFaltTomt(String falt)
{
    boolean tomt = false;
        if(falt.isEmpty() || falt == null){
        tomt = true;    
        }
    return tomt;
}

    public boolean kontrolleraTecken(String text)
    {
    boolean giltig = true;
        if(text.matches(".*[åäöÅÄÖ].*"))
        {
        giltig = false;    
        }
        
    return giltig;
    }
    
}

