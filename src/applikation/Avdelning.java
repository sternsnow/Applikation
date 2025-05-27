/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author karlb
 */
public class Avdelning {
    private InfDB idb;
    private String avdid;
    private Validering validering;
    
    
    
    public Avdelning(InfDB idb){
    this.idb = idb;
    this.avdid = avdid;
    this.validering = new Validering(idb);
    
        
    }
    
 public ArrayList<String> hamtaAllaNamn()
    {
        try{
        String sqlfraga = "SELECT namn FROM avdelning";
        ArrayList<String> namn = idb.fetchColumn(sqlfraga);
        return namn;
        }
        catch(InfException ex){
        System.out.println(ex.getMessage());    
        } 
        return null;
    }
 
    public String getNamn(String avdid) 
   {
       try{
    String sqlFraga = "SELECT namn from avdelning WHERE avdid = " + avdid;
    String namn = idb.fetchSingle(sqlFraga);
    
    return namn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    
    
    public String getBeskrivning(String avdid) 
   {
       try{
    String sqlFraga = "SELECT Beskrivning from avdelning WHERE avdid = " + avdid;
    String beskrivning = idb.fetchSingle(sqlFraga);
    
    return beskrivning;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getAdress(String avdid) 
   {
       try{
    String sqlFraga = "SELECT adress from avdelning WHERE avdid = " + avdid;
    String adress = idb.fetchSingle(sqlFraga);
    
    return adress;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getEpost(String avdid) 
   {
       try{
    String sqlFraga = "SELECT epost from avdelning WHERE avdid = " + avdid;
    String epost = idb.fetchSingle(sqlFraga);
    
    return epost;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getTelefon(String avdid) 
   {
       try{
    String sqlFraga = "SELECT telefon from avdelning WHERE avdid = " + avdid;
    String telefon = idb.fetchSingle(sqlFraga);
    
    return telefon;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getStad(String avdid) 
   {
       try{
    String sqlFraga = "SELECT stad from avdelning WHERE avdid = " + avdid;
    String sid = idb.fetchSingle(sqlFraga);
    
    String sqlFragaHamtaNamn = "SELECT namn from stad WHERE sid = " + sid;
    String stadNamn = idb.fetchSingle(sqlFragaHamtaNamn);
    
    return stadNamn;
    
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public boolean kontrolleraNamn(String namn) {
    if (validering.arTextFaltTomt(namn)) {
        System.out.println("Fel: Naamnet får inte vara tomt.");
        return false;
        }

    namn = namn.trim();

    if (namn.length() < 2 || namn.length() > 200) {
        System.out.println("Fel: Språknamnet måste vara mellan 2 och 200 tecken.");
        return false;
        }

    if (!namn.matches("^[a-zA-ZåäöÅÄÖ ]+$")) {
        JOptionPane.showMessageDialog(null, "Namn får endast innehålla bokstäver.");
        return false;
    }

    return true;
}
    
    public boolean kontrolleraBeskrivning(String beskrivning) {
    if (validering.arTextFaltTomt(beskrivning)) {
        System.out.println("Fel: Beskrivningen får inte vara tomt.");
        return false;
        }

    beskrivning = beskrivning.trim();

    if (beskrivning.length() < 2 || beskrivning.length() > 300) {
        System.out.println("Fel: Beskrivningen måste vara mellan 2 och 300 tecken.");
        return false;
        }
    return true;
}
 
    public boolean kontrolleraAdress(String adress) {
    if (validering.arTextFaltTomt(adress)) {
        System.out.println("Fel: Adressen får inte vara tomt.");
        return false;
        }

    adress = adress.trim();

    if (adress.length() < 2 || adress.length() > 100) {
        System.out.println("Fel: Beskrivningen måste vara mellan 2 och 100 tecken.");
        return false;
        }
    
    if(!adress.matches(".*[a-zA-ZåäöÅÄÖ].*") || !adress.matches(".*\\d.*")){
        return false;
    }
    return true;
    }
    
      public boolean kontrolleraEpost(String epost) {
    if (validering.arTextFaltTomt(epost)) {
        System.out.println("Fel: Epost får inte vara tomt.");
        return false;
        }

    epost = epost.trim();

    if(!epost.endsWith("@ngo.org"))
       {
       return false;  
       }
        return true;  
        
      }
      
       public boolean kontrolleraTelefon(String telefon) {
    if (validering.arTextFaltTomt(telefon)) {
        System.out.println("Fel: Telefonnummer kan inte vara tomt.");
        return false;
        }

    telefon = telefon.trim();

    if (!telefon.matches("^\\d{9}$")) {
    System.out.println("Fel: Telefonnummer måste bestå av exakt 9 siffror.");
    return false;
    }
    return true;
    }
       
       
       public String getChef(String avdid) 
   {
       try{
    String sqlFraga = "SELECT chef from avdelning WHERE avdid = " + avdid;
    String aid = idb.fetchSingle(sqlFraga);
    
    String sqlFragaHamtaNamn = "SELECT CONCAT(fornamn, ' ', efternamn) from anstalld WHERE aid = " + aid;
    String dbNamn = idb.fetchSingle(sqlFragaHamtaNamn);
    
    return dbNamn;
    
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
}
