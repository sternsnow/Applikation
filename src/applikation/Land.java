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
    private String namn;

    public Land (InfDB idb) {
        this.idb = idb;
        this.namn = namn;
        
    }
    
    
   public String getNamn(String land) 
   {
       try{
    String sqlFraga = "SELECT namn from land WHERE namn = '" + land +"'";
    String namn = idb.fetchSingle(sqlFraga);
    
    return namn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
   
    public String getSprak(String land) 
   {
       try{
    String sqlFraga = "SELECT sprak from land WHERE namn = '" + land +"'";
    String sprak = idb.fetchSingle(sqlFraga);
    
    return sprak;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
   
    public String getValuta(String land) 
   {
       try{
    String sqlFraga = "SELECT valuta from land WHERE namn = '" + land +"'";
    String valuta = idb.fetchSingle(sqlFraga);
    
    return valuta;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getTidzon(String land) 
   {
       try{
    String sqlFraga = "SELECT tidszon from land WHERE namn = '" + land +"'";
    String tidzon = idb.fetchSingle(sqlFraga);
    
    return tidzon;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getPolitiskStruktur(String land) 
   {
       try{
    String sqlFraga = "SELECT politisk_struktur from land WHERE namn = '" + land +"'";
    String politiskStruktur = idb.fetchSingle(sqlFraga);
    
    return politiskStruktur;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getEkonomi(String land) 
   {
       try{
    String sqlFraga = "SELECT ekonomi from land WHERE namn = '" + land +"'";
    String ekonomi = idb.fetchSingle(sqlFraga);
    
    return ekonomi;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
   
   
   
   
   
   
   
   
    public void setNamn(String nyttNamn)
    {
        try{
            if(validering.kontrolleraNyttLand(nyttNamn)){
            String sqlFraga = "UPDATE land SET namn ='" + nyttNamn + "' WHERE namn = '" + namn + "'";
            idb.update(sqlFraga);
            this.namn = nyttNamn;
            }
    
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    }
   }
    
    
    
    
    


 




