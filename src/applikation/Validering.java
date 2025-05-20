/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    
    public boolean kontrolleraDatum(String datum) {
    // Kollar om strängen som läggs in följer rätt format: yyyy-MM-dd
    if (!datum.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
        return false;
    }

    try {
        // Ser till att det är ett korrekt datum.
        LocalDate.parse(datum, DateTimeFormatter.ISO_LOCAL_DATE);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}
}

