/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import oru.inf.InfDB;


/**
 *
 * @author karlb
 */
public class Anstalld {

    private InfDB idb;

    private String aid;
    private String ePost;
    private String losenord;
    private String telefon;
    private String adress;
    private String behorighet;
    private String forNamn;
    private String efterNamn;
    
   

    public Anstalld(InfDB idb){
        this.idb = idb;
        
        
        
    }
    
    
    
    public String getEpost()
    {
        return ePost;
    }
    
    public void setEpost(String nyEpost)
    {
        this.ePost = nyEpost;
    }
    
    public String getLosenord()
    {
        return losenord;
    }
    
    public void setLosenord(String nyttLosenord)
    {
        this.losenord = nyttLosenord;
    }
    
    public String getTelefon()
    {
        return telefon;
    }
    
    public void setTelefon(String nyTelefon)
    {
        this.telefon = nyTelefon;
    }
        


 //testt    
}
