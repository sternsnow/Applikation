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
    
    public boolean kontrolleraSlutDatum(String pid, String slutDatum) {
    try {
        Projekt projekt = new Projekt(idb, pid);
        String startDatum = projekt.getStartDatum(pid);
        
        if (startDatum == null) {
            // Kan inte hitta startdatum, validera som false
            return false;
        }
        
        // Kontrollera format på slutdatum
        if (!slutDatum.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return false;
        }

	// Omvandlar datumsträngarna till LocalDate-objekt för att kunna jämföra dem som riktiga datum.
        LocalDate start = LocalDate.parse(startDatum, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate slut = LocalDate.parse(slutDatum, DateTimeFormatter.ISO_LOCAL_DATE);

        // Kontrollerar så att slutdatumet inte är innan startdatumet
        if (slut.isAfter(start) || slut.isEqual(start)) {
            return true;
        } else {
            return false;
        }

    } catch (Exception e) {
        // Hantera fel, t.ex. SQL-fel eller parsing-fel
        return false;
    }
}
    
    
    public static boolean kontrolleraProjektnamn(String namn) {
        if (namn == null){
            return false;
        }
        if (namn.length() < 3 || namn.length() > 50){
            return false;
        }
        if (!namn.matches("^[A-Za-zÅÄÖåäö0-9\\s\\-]+$")){
            return false;
        }
        return true;
    }
    
    public boolean kontrolleraProjektnamnUnikt(String projektnamn, String pid) {
    try {
        String sqlFraga = "SELECT projektnamn FROM projekt WHERE projektnamn = '" + projektnamn + "' AND pid != " + pid;
        String dbResultat = idb.fetchSingle(sqlFraga);

        return dbResultat == null;  // true om namnet är unikt
    } catch (InfException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
}

    public static boolean kontrolleraProjektBeskrivning(String beskrivning) {
        if(beskrivning == null){
            return false;
        }
    
            if(beskrivning.length() < 10 || beskrivning.length() > 250){
            return false;
            }

                // Tillåt endast bokstäver, siffror, mellanslag och några vanliga skiljetecken
                if(!beskrivning.matches("^[A-Za-zÅÄÖåäö0-9.,\\-\\s]+$")){
                return false;
                }

    return true;
    }
    
    public static boolean kontrolleraProjektKostnad(String kostnadString) {
    if (kostnadString == null || kostnadString.trim().isEmpty()) {
        return false;
    }

    try {
        //Konverterar kostnaden som lagts in till double.
        double kostnad = Double.parseDouble(kostnadString);
        if (kostnad < 0) {
            return false; // Negativ kostnad är inte tillåtet
        }

        return true; // Allt är okej
        } 
            catch (NumberFormatException e) {
            return false; // Ogiltigt tal, t.ex. bokstäver eller symboler
            }
    }
    
    
    public static boolean kontrolleraProjektStatus(String status) {
    if (status == null) {
        return false;
    }
    if(!(status.equals("Planerat") || status.equals("Pågående") || status.equals("Avslutat"))) {
        return false;
    }
    return true;
    }
    
    public static boolean kontrollleraProjektPrioritet(String prioritet) {
    if (prioritet == null) {
        return false;
    }
    if(!(prioritet.equals("Låg") || prioritet.equals("Medel") || prioritet.equals("Hög"))) {
        return false;
    }
    return true;
}
    
    public boolean kontrolleraLandFinns(String lid) {
    if (arTextFaltTomt(lid)) {
        return false;  // Fältet är tomt, returnera false direkt
    }

    try {
        String sqlfraga = "SELECT lid FROM land WHERE lid = " + lid;
        String dbLid = idb.fetchSingle(sqlfraga);

        if (dbLid == null) {
            return false;  // Landet finns inte i databasen
        }
        return true;  // Landet finns
    } catch (InfException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
}
    
    

    
    
}

