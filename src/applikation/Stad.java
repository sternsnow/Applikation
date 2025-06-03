/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author karlb
 */
public class Stad {
    
    private InfDB idb;
    private Validering validering;
    
    public Stad(InfDB idb) {
        this.idb = idb;
        this.validering = new Validering (idb);
    }
    
    
    public String getSid(String namn) {
        try {
            String sqlFraga = "SELECT sid from stad WHERE namn = '" + namn + "'";
            String sid = idb.fetchSingle(sqlFraga);
            return sid;

        } catch(InfException ex) {
            System.out.println(ex.getMessage());    
        }  
        return null;
    }
}
