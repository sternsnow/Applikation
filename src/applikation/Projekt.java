/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author karlb
 */
public class Projekt {
    private InfDB idb;
    private String pid;
    private Validering validering;
    
    
    
    public Projekt(InfDB idb, String pid){
    this.idb = idb;
    this.pid = pid;
    this.validering = new Validering(idb);
    
        
    }
    
    public ArrayList<String> hamtaAllaNamn()
    {
        try{
        String sqlfraga = "SELECT projektnamn FROM projekt";
        ArrayList<String> namn = idb.fetchColumn(sqlfraga);
        return namn;
        }
        catch(InfException ex){
        System.out.println(ex.getMessage());    
        } 
        return null;
    }
    
    public ArrayList<String> hamtaAllaNamnProjektchef(String inloggadAnvandareAid)
    {
        try{
        String sqlfraga = "SELECT projektnamn FROM projekt WHERE projektchef = " + inloggadAnvandareAid;
        ArrayList<String> namn = idb.fetchColumn(sqlfraga);
        return namn;
        }
        catch(InfException ex){
        System.out.println(ex.getMessage());    
        } 
        return null;
    }
    public String getProjektNamn(String pid) 
   {
       try{
    String sqlFraga = "SELECT projektnamn from projekt WHERE pid = " + pid;
    String namn = idb.fetchSingle(sqlFraga);
    
    return namn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setProjektNamn(String nyttNamn, String pid)
    {
        try{
            String sqlFraga = "UPDATE projekt SET projektnamn ='" + nyttNamn + "' WHERE pid = " + pid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
           }
    
    public String getBeskrivning(String pid) 
   {
       try{
    String sqlFraga = "SELECT Beskrivning from projekt WHERE pid = " + pid;
    String beskrivning = idb.fetchSingle(sqlFraga);
    
    return beskrivning;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setBeskrivning(String nyBeskrivning, String pid)
    {
        try{
            String sqlFraga = "UPDATE projekt SET beskrivning ='" + nyBeskrivning + "' WHERE pid = " + pid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
           }
    
    public String getStartDatum(String pid) 
   {
       try{
    String sqlFraga = "SELECT startdatum from projekt WHERE pid = " + pid;
    String startDatum = idb.fetchSingle(sqlFraga);
    
    return startDatum;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setStartDatum(String nyttStartDatum, String pid)
    {
        try{
            String sqlFraga = "UPDATE projekt SET startdatum ='" + nyttStartDatum + "' WHERE pid = " + pid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
           }
    
    
    
    public String getSlutDatum(String pid) 
   {
       try{
    String sqlFraga = "SELECT slutdatum from projekt WHERE pid = " + pid;
    String SlutDatum = idb.fetchSingle(sqlFraga);
    
    return SlutDatum;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setSlutDatum(String nyttSlutDatum, String pid)
    {
        try{
            String sqlFraga = "UPDATE projekt SET slutdatum ='" + nyttSlutDatum + "' WHERE pid = " + pid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
           }
    
    
    
    public String getKostnad(String pid) 
   {
       try{
    String sqlFraga = "SELECT kostnad from projekt WHERE pid = " + pid;
    String kostnad = idb.fetchSingle(sqlFraga);
    
    return kostnad;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setKostnad(String nyKostnad, String pid) {
    try {
        double kostnad = Double.parseDouble(nyKostnad); // Konverterar till tal
        String sqlFraga = "UPDATE projekt SET kostnad = " + kostnad + " WHERE pid = " + pid;
        idb.update(sqlFraga);
    } catch (NumberFormatException e) {
        System.out.println("Felaktigt kostnadsvärde: " + nyKostnad);
    } catch (InfException ex) {
        System.out.println("Databasfel: " + ex.getMessage());
    }
}
    
    
    public String getStatus(String status) 
   {
       try{
    String sqlFraga = "SELECT status from projekt WHERE pid = " + pid;
    String dbStatus = idb.fetchSingle(sqlFraga);
    
    return dbStatus;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setStatus(String nyStatus, String pid)
    {
        try{
            String sqlFraga = "UPDATE projekt SET status ='" + nyStatus + "' WHERE pid = " + pid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
    }
    
    
    public String getPrioritet(String prioritet) 
   {
       try{
    String sqlFraga = "SELECT prioritet from projekt WHERE pid = " + pid;
    String dbPrioritet = idb.fetchSingle(sqlFraga);
    
    return dbPrioritet;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setPrioritet(String nyPrioritet, String pid)
    {
        try{
            String sqlFraga = "UPDATE projekt SET prioritet ='" + nyPrioritet + "' WHERE pid = " + pid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
    }
    
    public String getProjektchef(String chef) 
   {
       try{
    String sqlFraga = "SELECT projektchef from projekt WHERE pid = " + pid;
    String dbProjektchef = idb.fetchSingle(sqlFraga);
    
    return dbProjektchef;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getLand(String land) 
   {
       try{
    String sqlFraga = "SELECT land from projekt WHERE pid = " + pid;
    String dbLand = idb.fetchSingle(sqlFraga);
    
    return dbLand;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }

    
    public void setLand(String nyttLand, String pid)
    {
        try{
            String sqlFraga = "UPDATE projekt SET land ='" + nyttLand + "' WHERE pid = " + pid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
    }
    
    public void laggTillPartnerIProjekt(String projektPid, String partnerNamn) {
    try {
        
        // Hämta partnerns PID utifrån namnet
        Partner partner = new Partner(idb);
        String partnerPid = partner.getPid(partnerNamn);
        if (partnerPid == null) {
            System.out.println("Partnern finns inte i databasen.");
            return;
        }
            // Lägg till kopplingen
            String insertSql = "INSERT INTO projekt_partner (pid, partner_pid) VALUES ('" + projektPid + "', '" + partnerPid + "')";
            idb.insert(insertSql);
            System.out.println("Koppling mellan projekt och partner har lagts till.");
        
         } catch (InfException e) {
        System.out.println("Fel vid inläggning av koppling: " + e.getMessage());
    }
}
}

