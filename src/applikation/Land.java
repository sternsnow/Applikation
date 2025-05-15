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
    
    private String namn;
    private String lid;
    private String sprak;
    private double valuta;
    private String tidzon; 
    private String politisk_struktur;
    private String ekonomi;
    private InfDB idb;

public Land () {
    
    try {
        
    String sqlFraga = "SELECT * FROM land";
        ArrayList<HashMap<String, String>> land = idb.fetchRows(sqlFraga);
        
        }
        catch (InfException ex){
        System.out.println(ex.getMessage());    
        }
    
    
    } 
}

 




