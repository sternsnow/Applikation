/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author juliadyrebrant
 */
public class Land {
    
    private InfDB idb;
    private Validering validering;
    private String lid;

    public Land (InfDB idb, String lid) {
        this.idb = idb;
        this.lid = lid;
        this.validering = new Validering(idb);
        
    }
    
    public ArrayList<String> hamtaAllaNamn()
    {
        try{
        String sqlfraga = "SELECT namn FROM land";
        ArrayList<String> namn = idb.fetchColumn(sqlfraga);
        return namn;
        }
        catch(InfException ex){
        System.out.println(ex.getMessage());    
        } 
        return null;
    }
    
   public String getNamn(String lid) 
   {
       try{
    String sqlFraga = "SELECT namn from land WHERE lid = " + lid;
    String namn = idb.fetchSingle(sqlFraga);
    
    return namn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
   
   public void setNamn(String nyttNamn, String lid)
        {
        if(validering.arTextFaltTomt(nyttNamn) == false)
        {
            try{
            String sqlFraga = "UPDATE land SET namn ='" + nyttNamn + "' WHERE lid = " + lid;
            idb.update(sqlFraga);
            } catch(InfException ex){
        System.out.println(ex.getMessage());    
        }  
        }
        
        }
   
    public boolean kontrolleraLandNamn(String namn) {

    // Tomkontroll
    if (validering.arTextFaltTomt(namn)) {
        System.out.println("Fel: Landsnamnet får inte vara tomt.");
        return false;
    }

    // Längdkontroll
    if (namn.length() < 2 || namn.length() > 100) {
        System.out.println("Fel: Landsnamnet måste vara mellan 2 och 100 tecken.");
        return false;
    }

    // Teckenkontroll – tillåt bara bokstäver, siffror, mellanslag, bindestreck och apostrof
    if (!namn.matches("^[A-Za-zÅÄÖåäö0-9\\s\\-']+$")) {
        System.out.println("Fel: Landsnamnet innehåller ogiltiga specialtecken.");
        return false;
    }

    // Dublettkontroll
    try {
        ArrayList<String> landNamn = hamtaAllaNamn();
        if (landNamn != null && landNamn.contains(namn)) {
            System.out.println("Fel: Angivet namn finns redan i databasen.");
            return false;
            }
        } 
        catch (Exception e) {
        System.out.println("Fel vid hämtning från databas: " + e.getMessage());
        return false;
    }

    // Om allt gick bra
    return true;
}
   
    public String getSprak(String lid) 
   {
       try{
    String sqlFraga = "SELECT sprak from land WHERE lid = " + lid;
    String sprak = idb.fetchSingle(sqlFraga);
    
    return sprak;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setSprak(String nyttSprak, String lid)
    {
        try{
        String sqlFraga = "UPDATE land SET sprak ='" + nyttSprak + "' WHERE lid = " + lid;
        idb.update(sqlFraga);
        } catch(InfException ex){
        System.out.println(ex.getMessage());    
          
        }
        
    }
    
    public boolean kontrolleraSprak(String sprak) {
    if (validering.arTextFaltTomt(sprak)) {
        System.out.println("Fel: Språknamnet får inte vara tomt.");
        return false;
        }

    sprak = sprak.trim();

    if (sprak.length() < 2 || sprak.length() > 50) {
        System.out.println("Fel: Språknamnet måste vara mellan 2 och 50 tecken.");
        return false;
        }

    // Tillåt bokstäver, siffror, mellanslag, bindestreck och apostrof
    if (!sprak.matches("^[A-Za-zÅÄÖåäö0-9\\s\\-']+$")) {
        System.out.println("Fel: Språknamnet innehåller ogiltiga tecken.");
        return false;
        }

    return true;
}
    
   
    public String getValuta(String lid) 
   {
       try{
    String sqlFraga = "SELECT valuta from land WHERE lid = " + lid;
    String valuta = idb.fetchSingle(sqlFraga);
    
    return valuta;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setValuta(String nyValuta, String lid)
    {
        try{
        String sqlFraga = "UPDATE land SET valuta ='" + nyValuta + "' WHERE lid = " + lid;
        idb.update(sqlFraga);
        } catch(InfException ex){
        System.out.println(ex.getMessage());    
          
        }
        
    }    
    public boolean kontrolleraValuta(String valuta) {
    if (validering.arTextFaltTomt(valuta)){
        System.out.println("Fel: Valutavärdet får inte vara tomt.");
        return false;
    }

    // Kontrollera att det är ett positivt tal med exakt 4 decimaler
    if (!valuta.matches("^\\d+\\.\\d{4}$")) {
        System.out.println("Fel: Valutavärdet måste vara ett positivt tal med exakt 4 decimaler (exempel: 10.1234).");
        return false;
    }

    return true;
}
    
    public String getTidzon(String lid) 
   {
       try{
    String sqlFraga = "SELECT tidszon from land WHERE lid = " + lid;
    String tidzon = idb.fetchSingle(sqlFraga);
    
    return tidzon;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setTidzon(String nyTidzon, String lid)
    {
        try{
        String sqlFraga = "UPDATE land SET tidzon ='" + nyTidzon + "' WHERE lid = " + lid;
        idb.update(sqlFraga);
        } catch(InfException ex){
        System.out.println(ex.getMessage());    
          
        }
        
    }    
    
    public boolean kontrolleraTidzon(String tidzon) {
    if (validering.arTextFaltTomt(tidzon)) {
        System.out.println("Fel: Tidzon får inte vara tom.");
        return false;
    }

    tidzon = tidzon.trim();

    if (tidzon.length() < 2 || tidzon.length() > 40) {
        System.out.println("Fel: Tidzon måste vara mellan 2 och 40 tecken.");
        return false;
    }

    // Tillåter A-Z, a-z, 0-9, snedstreck, bindestreck, understreck, plustecken
    if (!tidzon.matches("^[A-Za-z0-9/_\\-\\+]+$")) {
        System.out.println("Fel: Tidzon innehåller ogiltiga tecken.");
        return false;
    }

    return true;
}
    
    public String getPolitiskStruktur(String lid) 
   {
       try{
    String sqlFraga = "SELECT politisk_struktur from land WHERE lid = " + lid;
    String politiskStruktur = idb.fetchSingle(sqlFraga);
    
    return politiskStruktur;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setPolitiskStruktur(String nyPolitiskStruktur, String lid)
    {
        try{
        String sqlFraga = "UPDATE land SET politisk_struktur ='" + nyPolitiskStruktur + "' WHERE lid = " + lid;
        idb.update(sqlFraga);
        } catch(InfException ex){
        System.out.println(ex.getMessage());    
          
        }
        
    }    
    
    public boolean kontrolleraPolitiskStruktur(String struktur) {
    if (validering.arTextFaltTomt(struktur)) {
        System.out.println("Fel: Politisk struktur får inte vara tom.");
        return false;
    }

    struktur = struktur.trim();

    if (struktur.length() < 3 || struktur.length() > 50) {
        System.out.println("Fel: Politisk struktur måste vara mellan 3 och 50 tecken.");
        return false;
    }

    // Tillåt bokstäver, siffror, mellanslag och bindestreck
    if (!struktur.matches("^[A-Za-z0-9 \\-]+$")) {
        System.out.println("Fel: Politisk struktur innehåller ogiltiga tecken.");
        return false;
    }

    return true;
}
    
    public String getEkonomi(String lid) 
   {
       try{
    String sqlFraga = "SELECT ekonomi from land WHERE lid = " + lid;
    String ekonomi = idb.fetchSingle(sqlFraga);
    
    return ekonomi;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    
    public void setEkonomi(String nyEkonomi, String lid)
    {
        try{
        String sqlFraga = "UPDATE land SET ekonomi ='" + nyEkonomi + "' WHERE lid = " + lid;
        idb.update(sqlFraga);
        } catch(InfException ex){
        System.out.println(ex.getMessage());    
          
        }
        
    }    
       
    public boolean kontrolleraEkonomi(String ekonomi) {
    if (validering.arTextFaltTomt(ekonomi)) {
        System.out.println("Fel: Ekonomi får inte vara tom.");
        return false;
    }

    ekonomi = ekonomi.trim();

    if (ekonomi.length() < 3 || ekonomi.length() > 50) {
        System.out.println("Fel: Ekonomi måste vara mellan 3 och 50 tecken.");
        return false;
    }

    // Tillåt bokstäver, siffror, mellanslag och bindestreck
    if (!ekonomi.matches("^[A-Za-z0-9 \\-]+$")) {
        System.out.println("Fel: Ekonomi innehåller ogiltiga tecken.");
        return false;
    }

    return true;
}
      
    
    public boolean kontrolleraLandFinns(String sokland) {
    try {
    boolean giltig = true;
    String sqlfraga = "SELECT lid FROM land WHERE namn ='" + sokland +"'";
    String dbLid = idb. fetchSingle(sqlfraga);
    
        if(validering.arTextFaltTomt(sokland) == false && dbLid == null){
        giltig = false;
        }
        return giltig;

        }
            catch(InfException ex){
            System.out.println(ex.getMessage());    
               return false;
            }
    }
  
       
       
      
       



}
    
    
    
    
    


 




