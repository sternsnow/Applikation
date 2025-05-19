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
public class Anstalld {

    private InfDB idb;
    private String ePost;
    private String aid;
    private Validering validering;
    
    
    
   

    public Anstalld(InfDB idb, String ePost, String aid){
        this.idb = idb;
        this.ePost = ePost;
        this.aid = aid;
        this.validering = new Validering(idb);   
    }
    
    public ArrayList<String> hamtaAllaNamn() {
    ArrayList<String> namnLista = new ArrayList<>();

    try {
        String sqlfraga = "SELECT fornamn, efternamn FROM anstalld";
        ArrayList<HashMap<String, String>> namn = idb.fetchRows(sqlfraga);

        for (HashMap<String, String> rad : namn) {
            String fornamn = rad.get("fornamn");
            String efternamn = rad.get("efternamn");
            String fullstandigtNamn = fornamn + " " + efternamn;
            namnLista.add(fullstandigtNamn);
            }
        }
    catch (InfException ex) {
        System.out.println(ex.getMessage());
    }

    return namnLista;
}
    
   public String getFornamn(String aid)
    {
        try{
            String sqlFraga = "SELECT fornamn from anstalld WHERE aid = " + aid;
            String fornamn = idb.fetchSingle(sqlFraga);
            return fornamn;
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
                    return null;
    }
    
    
    
    public void setFornamn(String nyttFornamn, String aid)
    {
        try{
            String sqlFraga = "UPDATE anstalld SET fornamn ='" + nyttFornamn + "' WHERE aid = " + aid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
           }
    
    public boolean kontrolleraFornamn(String fornamn)
    {
    boolean giltig = false;  
    if(validering.arTextFaltTomt(fornamn) == false && fornamn.length() > 2 && fornamn.length() < 25){    
    giltig = true;
    }
    
    return giltig;
    }  
    
    public String getEfternamn(String aid)
    {
        try{
            String sqlFraga = "SELECT efternamn from anstalld WHERE aid = " + aid;
            String fornamn = idb.fetchSingle(sqlFraga);
            return fornamn;
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
                    return null;
    }
    
    
    
    public void setEfternamn(String nyttEfternamn, String aid)
    {
        try{
            String sqlFraga = "UPDATE anstalld SET efternamn ='" + nyttEfternamn + "' WHERE aid = " + aid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
           }
    
    public boolean kontrolleraEfternamn(String efternamn)
    {
    boolean giltig = false;  
    if(validering.arTextFaltTomt(efternamn) == false && efternamn.length() > 2 && efternamn.length() < 50){    
    giltig = true;
    }
    
    return giltig;
    }  
    
    public String getEpost()
    {
        
       return ePost;
    
    }
    
    
    
    public void setEpost(String nyEpost, String aid)
    {
        try{
            String sqlFraga = "UPDATE anstalld SET epost ='" + nyEpost + "' WHERE aid = " + aid;
            idb.update(sqlFraga);
            this.ePost = nyEpost;
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
           }
    
    public boolean kontrolleraEpost(String epost)
    {
    boolean giltig = false;  
    if(validering.arTextFaltTomt(epost) == false && validering.kontrolleraTecken(epost) && epost.endsWith("@example.com")){    
    giltig = true;
    }
    
    return giltig;
    }  
        
    
    
    public String getLosenord(String aid){
    try{
    String sqlFraga = "SELECT losenord from anstalld WHERE aid = " + aid;
    String losenord = idb.fetchSingle(sqlFraga);
    
    return losenord;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setLosenord(String nyttLosenord, String aid)
    {
        try{
            
            String sqlFraga = "UPDATE anstalld SET losenord ='" + nyttLosenord + "' WHERE aid = " + aid;
            idb.update(sqlFraga);
            
    
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
    }
    
    public boolean kontrolleraLosenord(String losenord)
    {
    boolean giltig = false;  
    if(validering.arTextFaltTomt(losenord) == false && losenord.length() >= 5 && losenord.length() <= 50){    
    giltig = true;
    }
    return giltig;
    }  
    
    
    public String getTelefon(String aid)
    {
     try{
    String sqlFraga = "SELECT telefon from anstalld WHERE aid = " + aid;
    String telefon = idb.fetchSingle(sqlFraga);
    
    return telefon;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }   
    
    public void setTelefon(String nyTelefon, String aid)
    {
        try{
            String sqlFraga = "UPDATE anstalld SET telefon ='" + nyTelefon + "' WHERE aid = " + aid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
    }
    
    public boolean kontrolleraTelefon(String telefon)
    {
    boolean giltig = false;
    String forstaBindestreck = telefon.substring(3, 4);
    String andraBindestreck = telefon.substring(7, 8);
    
    if(validering.arTextFaltTomt(telefon) == false && telefon.length() == 12 &&
       forstaBindestreck.equals("-") && andraBindestreck.equals("-")){    
    giltig = true;
    }
    return giltig;
    }  
    
    
    
    
    public String getAdress(String aid)
    {
     try{
    String sqlFraga = "SELECT adress from anstalld WHERE aid = " + aid;
    String adress = idb.fetchSingle(sqlFraga);
    
    return adress;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }   
      
    public void setAdress(String nyAdress, String aid)
    {
        try{
            String sqlFraga = "UPDATE anstalld set adress ='" + nyAdress + "' WHERE aid = " + aid;
            idb.update(sqlFraga);
            }
                catch(InfException ex){
                System.out.println(ex.getMessage());    
                }  
    }
    
    public boolean kontrolleraAdress(String adress)
    {
    boolean giltig = false;
    
    if(validering.arTextFaltTomt(adress) == false && adress.length() >= 10 && adress.length() <= 50){    
    giltig = true;
    }
    return giltig;
    }  
  
       
    }
        
        
    
    

