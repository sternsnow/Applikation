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
  
   }
    
    
    
    
    


 




