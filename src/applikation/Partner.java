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
    
    private Validering validering;

    public Partner(InfDB idb) {
        this.idb = idb;
        this.validering = validering;
    }
    
    public ArrayList<String> hamtaAllaNamn() {
        try {
            String sqlfraga = "SELECT namn FROM partner";
            ArrayList<String> namn = idb.fetchColumn(sqlfraga);
            return namn;

        } catch(InfException ex){
            System.out.println(ex.getMessage());    
        } 
        return null;
    }
    
    public String getPid(String namn) {
        try {
            String sqlFraga = "SELECT pid from partner WHERE namn = '" + namn + "'";
            String hamtatNamn = idb.fetchSingle(sqlFraga);
            return hamtatNamn;

        } catch(InfException ex) {
            System.out.println(ex.getMessage());    
        }  
        return null;
    }
    
    public String getNamn(String pid) {
        try {
            String sqlFraga = "SELECT namn from partner WHERE pid = " + pid;
            String namn = idb.fetchSingle(sqlFraga);
            return namn;

        } catch(InfException ex) {
            System.out.println(ex.getMessage());    
        }  
        return null;
    }
    
    //Validering för namn
    public boolean kontrolleraNamn(String namn) {
        //Tomkontroll
        if (validering.arTextFaltTomt(namn)) {
            System.out.println("Fel: Namn får ej vara tomt.");
            return false;
        }
        
        //Längdkontroll
        if (namn.length() < 2 || namn.length() > 100) {
            System.out.println("Fel: Namnet måste vara mellan 2 till 100 tecken.");
            return false;
        }
        

        //Teckenkontroll
        if (!namn.matches ("^[A-Za-zÅÄÖåäö0-9\\s\\-']+$")) {
            System.out.println("Fel: Namnet innehåller ogiltiga tecken.");
            return false;
        }
        
        //Dublettkontroll
        try {
            String sql = "SELECT pid FROM partner WHERE namn = '" + namn + "'";
            String finns = idb.fetchSingle(sql);
            if (finns != null) {
                System.out.println("Fel: Namnet finns redan i databasen.");
                return false;
            }
        } catch (InfException e) {
            System.out.println("Databasfel vid namnvalidering: " + e.getMessage());
            return false;
        }

        return true;
    }
    
    public String getKontaktPerson(String pid) {
        try {
            String sqlFraga = "SELECT kontaktperson from partner WHERE pid = " + pid;
            String kontaktperson = idb.fetchSingle(sqlFraga);
    
            return kontaktperson;
 
        } catch (InfException ex) {
            System.out.println(ex.getMessage()); 
        }    
        return null; 
    }

    //Validering av kontaktperson
    public boolean kontrolleraKontaktperson(String kontaktperson) {
        //Tomkontroll
        if (validering.arTextFaltTomt(kontaktperson)) {
            System.out.println("Fel: Kontaktperson får inte vara tom.");
            return false;
        }

        //Längdkontroll
         if (kontaktperson.length() < 2 || kontaktperson.length() > 100) {
            System.out.println("Fel: Kontaktperson måste vara mellan 2 och 100 tecken.");
            return false;
        }

        //Teckenkontroll
         if (!kontaktperson.matches("^[A-Za-zÅÄÖåäö\\s\\-']+$")) {
            System.out.println("Fel: Kontaktperson innehåller ogiltiga tecken.");
            return false;
        }

        return true;
    }

    public String getKontaktEpost(String pid) {
       try {
            String sqlFraga = "SELECT kontaktepost from partner WHERE pid = " + pid;
            String kontaktepost = idb.fetchSingle(sqlFraga);
    
            return kontaktepost;
        } catch (InfException ex) {
            System.out.println(ex.getMessage());    
        }

        return null;
    }

    //Validering av epost
    public boolean kontrolleraEpost(String epost) {
        //Tom-och teckenkontroll
        if (!validering.isValidEpost(epost)) {
            System.out.println("Fel: Ogiltig e-postadress.");
            return false;
        }

        //Dublettkontroll
        try {
            String sql = "SELECT pid FROM partner WHERE kontaktepost = '" + epost + "'";
            String finns = idb.fetchSingle(sql);
            if (finns != null) {
                System.out.println("Fel: E-postadressen finns redan i databasen.");
                return false;
            }

        } catch (InfException e) {
            System.out.println("Databasfel vid epostvalidering: " + e.getMessage());
            return false;
        }

        return true;
    }

    public String getTelefon(String pid) {
        try {
            String sqlFraga = "SELECT telefon from partner WHERE pid = " + pid;
            String telefon = idb.fetchSingle(sqlFraga);
            return telefon;

        } catch (InfException ex) {
            System.out.println(ex.getMessage());    
        }

        return null;
    }

    //Validering av telefonnummer
    public boolean kontrolleraTelefon(String telefon) {
        if (!validering.isValidTelefon(telefon)) {
            System.out.println("Fel: Telefonnummer är ogiltigt (måste vara exakt 10 siffror).");
            return false;
        }
    
        //Dublettkontroll
        try {
        String sql = "SELECT pid FROM partner WHERE telefon = '" + telefon + "'";
        String finns = idb.fetchSingle(sql);
        if (finns != null) {
            System.out.println("Fel: Telefonnummer finns redan i databasen.");
            return false;
        }
    } catch (InfException e) {
        System.out.println("Databasfel vid telefonvalidering: " + e.getMessage());
        return false;
        }

    return true;
    }
    
    public String getAdress(String pid) {
        try {
            String sqlFraga = "SELECT adress from partner WHERE pid = " + pid;
            String adress = idb.fetchSingle(sqlFraga);
            return adress;

        } catch (InfException ex){
            System.out.println(ex.getMessage());    
        }  

        return null;
    }

    //Validering av adress
    public boolean kontrolleraAdress(String adress) {
        //Tomkontroll
        if (validering.arTextFaltTomt(adress)) {
            System.out.println("Fel: Adress får inte vara tom.");
            return false;
        }

        //Längdkontroll
        if (adress.length() < 5 || adress.length() > 150) {
            System.out.println("Fel: Adress måste vara mellan 5 och 150 tecken.");
            return false;
        }

        //Teckenkontroll
            if (!adress.matches("^[A-Za-zÅÄÖåäö0-9\\s\\-,.]+$")) {
            System.out.println("Fel: Adress innehåller ogiltiga tecken.");
            return false;
        }

        return true;
    }


    public String getBranch(String pid) {
        try {
            String sqlFraga = "SELECT branch from partner WHERE pid = " + pid;
            String branch = idb.fetchSingle(sqlFraga);
    
        return branch;

        } catch (InfException ex) {
            System.out.println(ex.getMessage());    
        } 

        return null;
    }

    //Validering av bransch
    public boolean kontrolleraBranch(String branch) {
        //Tomkontroll
        if (validering.arTextFaltTomt(branch)) {
            System.out.println("Fel: Bransch får inte vara tom.");
            return false;
        }

        //Längdkontroll
        if (branch.length() < 2 || branch.length() > 100) {
            System.out.println("Fel: Bransch måste vara mellan 2 och 100 tecken.");
            return false;
        }

        //Teckenkontroll
        if (!branch.matches("^[A-Za-zÅÄÖåäö0-9\\s\\-]+$")) {
            System.out.println("Fel: Bransch innehåller ogiltiga tecken.");
            return false;
        }

        return true;
    }
    
    public String getStad(String pid) {
        try {
            String sqlFraga = "SELECT stad from partner WHERE pid = " + pid;
            String sid = idb.fetchSingle(sqlFraga);
    
            String sqlFragaHamtaNamn = "SELECT namn from stad WHERE sid = " + sid;
            String stadNamn = idb.fetchSingle(sqlFragaHamtaNamn);
    
            return stadNamn;
        } catch (InfException ex){
            System.out.println(ex.getMessage());    
        }  
        return null;
    }
    
    
    public String getStadNamn(String stad) {
        try {
            String sqlFragaHamtaNamn = "SELECT namn from stad WHERE sid = " + stad;
            String stadNamn = idb.fetchSingle(sqlFragaHamtaNamn);
    
             return stadNamn;
             
        } catch(InfException ex) {
            System.out.println(ex.getMessage());
        }  
        return null;
    }
    

    //Validering av stad
    public boolean kontrolleraStad(String stad) {
        //Tomkontroll
        if (validering.arTextFaltTomt(stad)) {
            System.out.println("Fel: Stad får inte vara tom.");
            return false;
        }

        //Längdkontroll
        if (stad.length() < 2 || stad.length() > 100) {
            System.out.println("Fel: Stad måste vara mellan 2 och 100 tecken.");
            return false;
        }

        //Teckenkontroll
        if (!stad.matches("^[A-Za-zÅÄÖåäö\\s\\-]+$")) {
            System.out.println("Fel: Stad innehåller ogiltiga tecken.");
            return false;
        }

        //Kontroll om staden finns i databasen
        try {
            String sql = "SELECT sid FROM stad WHERE namn = '" + stad + "'";
            String finns = idb.fetchSingle(sql);
            if (finns == null) {
                System.out.println("Fel: Staden finns inte i databasen.");
                return false;
            }
        } catch (InfException e) {
            System.out.println("Databasfel vid stadvalidering: " + e.getMessage());
            return false;
        }

        return true;
    }  
}
