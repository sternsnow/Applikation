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
    
   
    
    public String getEpost()
    {
        return ePost;
    }
    
    
    public void setEpost(String nyEpost)
    {
        try{
            if(validering.kontrolleraEpost(nyEpost)){
            String sqlFraga = "UPDATE anstalld SET epost ='" + nyEpost + "' WHERE epost = '" + ePost + "'";
            idb.update(sqlFraga);
            this.ePost = nyEpost;
            }
    
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    }
    
    
    public String getLosenord(){
    try{
    String sqlFraga = "SELECT losenord from anstalld WHERE epost = '" + ePost +"'";
    String losenord = idb.fetchSingle(sqlFraga);
    
    return losenord;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }
    
    public void setLosenord(String nyttLosenord)
    {
        try{
            if(validering.kontrolleraLosenord(nyttLosenord)){
            String sqlFraga = "UPDATE anstalld SET losenord ='" + nyttLosenord + "' WHERE epost = '" + ePost + "'";
            idb.update(sqlFraga);
            }
    
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    }
    
    public String getTelefon()
    {
     try{
    String sqlFraga = "SELECT telefon from anstalld WHERE epost = '" + ePost +"'";
    String telefon = idb.fetchSingle(sqlFraga);
    
    return telefon;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }   
    
    public String getAdress()
    {
     try{
    String sqlFraga = "SELECT adress from anstalld WHERE epost = '" + ePost +"'";
    String adress = idb.fetchSingle(sqlFraga);
    
    return adress;
    }
    catch(InfException ex){
    System.out.println(ex.getMessage());    
    }  
    return null;
    }   
            
       
    }
        
        
    
    

