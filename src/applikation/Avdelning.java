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
public class Avdelning {
    private InfDB idb;
    
    
    
    public Avdelning(InfDB idb){
    this.idb = idb; 
        
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
    public String getNamn(String avdelning) 
   {
       try{
    String sqlFraga = "SELECT namn from avdelning WHERE namn = '" + avdelning +"'";
    String namn = idb.fetchSingle(sqlFraga);
    
    return namn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getBeskrivning(String Aid) 
   {
       try{
    String sqlFraga = "SELECT Beskrivning from avdelning WHERE aid = '" + Aid +"'";
    String Beskrivning = idb.fetchSingle(sqlFraga);
    
    return Beskrivning;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
}
