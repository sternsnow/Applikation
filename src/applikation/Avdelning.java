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
 * @author karlb
 */
public class Avdelning {
    private InfDB idb;
    private String avdid;
    
    
    
    public Avdelning(InfDB idb, String avdid){
    this.idb = idb;
    this.avdid = avdid;
    
        
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
}
