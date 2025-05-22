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
public class Partner {
    private InfDB idb;
    private String pid;


    
    public Partner(InfDB idb)
    {
    this.idb = idb;
    this.pid = pid;
    }
    
    public ArrayList<String> hamtaAllaNamn()
    {
        try{
        String sqlfraga = "SELECT namn FROM partner";
        ArrayList<String> namn = idb.fetchColumn(sqlfraga);
        return namn;
        }
        catch(InfException ex){
        System.out.println(ex.getMessage());    
        } 
        return null;
    }
    
    public String getPid(String namn) 
   {
       try{
    String sqlFraga = "SELECT pid from partner WHERE namn = '" + namn + "'";
    String hamtatNamn = idb.fetchSingle(sqlFraga);
    
    return hamtatNamn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getNamn(String pid) 
   {
       try{
    String sqlFraga = "SELECT namn from partner WHERE pid = " + pid;
    String namn = idb.fetchSingle(sqlFraga);
    
    return namn;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getKontaktPerson(String pid) 
   {
       try{
    String sqlFraga = "SELECT kontaktperson from partner WHERE pid = " + pid;
    String kontaktperson = idb.fetchSingle(sqlFraga);
    
    return kontaktperson;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getKontaktEpost(String pid) 
   {
       try{
    String sqlFraga = "SELECT kontaktepost from partner WHERE pid = " + pid;
    String kontaktepost = idb.fetchSingle(sqlFraga);
    
    return kontaktepost;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getTelefon(String pid) 
   {
       try{
    String sqlFraga = "SELECT telefon from partner WHERE pid = " + pid;
    String telefon = idb.fetchSingle(sqlFraga);
    
    return telefon;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getAdress(String pid) 
   {
       try{
    String sqlFraga = "SELECT adress from partner WHERE pid = " + pid;
    String adress = idb.fetchSingle(sqlFraga);
    
    return adress;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getBranch(String pid) 
   {
       try{
    String sqlFraga = "SELECT branch from partner WHERE pid = " + pid;
    String branch = idb.fetchSingle(sqlFraga);
    
    return branch;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public String getStad(String pid) 
   {
       try{
    String sqlFraga = "SELECT stad from partner WHERE pid = " + pid;
    String stad = idb.fetchSingle(sqlFraga);
    
    return stad;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    
}
