/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

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
    
    
    
    public Projekt(InfDB idb, String pid){
    this.idb = idb;
    this.pid = pid;
    
        
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

}

