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
    
    public ArrayList<String> hamtaAllaPartners(String pid)
    {
        try{
        String sqlfraga = "SELECT partner.namn " +
                          "FROM partner " +
                          "JOIN projekt_partner ON partner.pid = projekt_partner.partner_pid " +
                          "WHERE projekt_partner.pid = " + pid;

        ArrayList<String> partners = idb.fetchColumn(sqlfraga);
        return partners;
        }
        catch(InfException ex){
        System.out.println(ex.getMessage());    
        } 
        return null;
    }
    
    public ArrayList<String> hamtaAllaHandlaggare(String pid)
    {
        try {
        String sqlfraga = "SELECT CONCAT(fornamn, ' ', efternamn) AS fullstandigtnamn " +
                      "FROM anstalld " +
                      "JOIN handlaggare ON anstalld.aid = handlaggare.aid " +
                      "JOIN ans_proj ON handlaggare.aid = ans_proj.aid " +
                      "WHERE ans_proj.pid = " + pid;

        ArrayList<String> handlaggare = idb.fetchColumn(sqlfraga);
        return handlaggare;
            } 
                catch (InfException ex) {
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
    
    
    public String getStatus(String pid) 
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
    
    
    public String getPrioritet(String pid) 
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
    
    public String getProjektchef(String pid) 
   {
       try{
    String sqlFraga = "SELECT projektchef from projekt WHERE pid = " + pid;
    String dbProjektchef = idb.fetchSingle(sqlFraga);
    
    String sqlFragaHamtaNamn = "SELECT CONCAT(fornamn, ' ', efternamn) from anstalld WHERE aid = " + dbProjektchef;
    String dbNamn = idb.fetchSingle(sqlFragaHamtaNamn);
    
    return dbNamn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setProjektchef(String fullstandigtNamn, String pid) {
    try {
        // 1. Hämta aid för personen med det fullständiga namnet
        String sqlHämtaAid = 
            "SELECT aid FROM anstalld " +
            "WHERE CONCAT(fornamn, ' ', efternamn) = '" + fullstandigtNamn + "'";
        
        String aid = idb.fetchSingle(sqlHämtaAid);

        if (aid == null) {
            System.out.println("Ingen anställd hittades med namnet: " + fullstandigtNamn);
            return;
        }

        // 2. Uppdatera projektchef i projekt-tabellen
        String sqlUppdatera = 
            "UPDATE projekt SET projektchef = " + aid + " WHERE pid = " + pid;

        idb.update(sqlUppdatera);
        System.out.println("Projektchef uppdaterad till: " + fullstandigtNamn);

    } catch (InfException e) {
        System.out.println("Fel vid uppdatering: " + e.getMessage());
    }
}
    
    public String getLand(String pid) 
   {
       try{
    String sqlFraga = "SELECT land from projekt WHERE pid = " + pid;
    String dbLand = idb.fetchSingle(sqlFraga);
    
    String sqlFragaHamtaLandNamn = "SELECT namn from land WHERE lid = " + dbLand;
    String dbLandNamn = idb.fetchSingle(sqlFragaHamtaLandNamn);
    
    
    return dbLandNamn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }

    
    public void setLand(String landNamn, String pid) {
    try {
        // 1. Hämta lid från land där namn = landNamn
        String sqlHämtaLid = "SELECT lid FROM land WHERE namn = '" + landNamn + "'";
        String lid = idb.fetchSingle(sqlHämtaLid);

        if (lid == null) {
            System.out.println("Landet '" + landNamn + "' hittades inte i databasen.");
            return;
        }

        // 2. Uppdatera projektets land med det hämtade lid
        String sqlUppdatera = "UPDATE projekt SET land = " + lid + " WHERE pid = " + pid;
        idb.update(sqlUppdatera);

        System.out.println("Projektets land uppdaterades till: " + landNamn);

    } catch (InfException ex) {
        System.out.println("Fel vid uppdatering av land: " + ex.getMessage());
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
            String insertSql = "INSERT INTO projekt_partner (pid, partner_pid) VALUES (" + projektPid + ", '" + partnerPid + "')";
            idb.insert(insertSql);
            System.out.println("Koppling mellan projekt och partner har lagts till.");
        
         } catch (InfException e) {
        System.out.println("Fel vid inläggning av koppling: " + e.getMessage());
    }
}
    
    public void TaBortPartnerIProjekt(String projektPid, String partnerNamn) {
    try {
        
        // Hämta partnerns PID utifrån namnet
        Partner partner = new Partner(idb);
        String partnerPid = partner.getPid(partnerNamn);
        if (partnerPid == null) {
            System.out.println("Partnern finns inte i databasen.");
            return;
        }
            String deleteSql = "DELETE FROM projekt_partner WHERE pid = " + projektPid + " AND partner_pid = " + partnerPid;
            idb.delete(deleteSql);
            System.out.println("Kopplingen mellan projekt och partner har tagits bort.");
        
         } catch (InfException e) {
        System.out.println("Fel vid inläggning av koppling: " + e.getMessage());
    }
    }
    
    public void TaBortHandlaggareIProjekt(String projektPid, String handlaggareNamn) {
    try {
        
        // Hämta partnerns PID utifrån namnet
        Anstalld anstalld = new Anstalld(idb);
        String sqlFraga = "SELECT aid FROM anstalld WHERE CONCAT(fornamn, ' ', efternamn) ='" + handlaggareNamn + "'";
        String handlaggareAid = idb.fetchSingle(sqlFraga);       
                
        if (handlaggareAid == null) {
            System.out.println("Handläggaren finns inte i databasen.");
            return;
        }
            String deleteSql = "DELETE FROM ans_proj WHERE pid = " + projektPid + " AND aid = " + handlaggareAid;
            idb.delete(deleteSql);
            System.out.println("Kopplingen mellan handläggaren och projektet har tagits bort.");
        
         } catch (InfException e) {
        System.out.println("Fel vid inläggning av koppling: " + e.getMessage());
    }
    }
    
    public void laggTillHandlaggareIProjekt(String projektPid, String handlaggareNamn) {
    try {
        // Hämta AID från namn
        String sqlFraga = "SELECT aid FROM anstalld WHERE CONCAT(fornamn, ' ', efternamn) = '" + handlaggareNamn + "'";
        String handlaggareAid = idb.fetchSingle(sqlFraga);

        if (handlaggareAid == null) {
            System.out.println("Handläggaren finns inte i databasen.");
            return;
        }

        // Kontrollera om kopplingen redan finns
        String kontrollFraga = "SELECT aid FROM ans_proj WHERE pid = " + projektPid + " AND aid = " + handlaggareAid;
        String befintlig = idb.fetchSingle(kontrollFraga);

        if (befintlig != null) {
            System.out.println("Kopplingen finns redan i databasen.");
            return;
        }

        // Lägg till kopplingen
        String insertSql = "INSERT INTO ans_proj (pid, aid) VALUES (" + projektPid + ", " + handlaggareAid + ")";
        idb.insert(insertSql);
        System.out.println("Kopplingen mellan handläggaren och projektet har lagts till.");

    } catch (InfException e) {
        System.out.println("Fel vid tillägg av koppling: " + e.getMessage());
    }
}
}

