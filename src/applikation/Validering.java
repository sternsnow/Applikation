/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Validering {
    
    private InfDB idb;
    
    public Validering(InfDB idb) {
        this.idb = idb;
    }
    
    public boolean arTextFaltTomt(String falt) {
        if (falt == null || falt.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean kontrolleraTecken(String text) {
        if (text == null) {
            return false;
        }
        return !text.matches(".*[åäöÅÄÖ].*");
    }
    
    public boolean kontrolleraDatum(String datum) {
        if (datum == null || !datum.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return false;
        }

        try {
            LocalDate.parse(datum, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public boolean kontrolleraSlutDatum(String pid, String slutDatum) {
        try {
            Projekt projekt = new Projekt(idb, pid);
            String startDatum = projekt.getStartDatum(pid);

            if (startDatum == null) {
                return false;
            }

            if (slutDatum == null || !slutDatum.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                return false;
            }

            LocalDate start = LocalDate.parse(startDatum, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate slut = LocalDate.parse(slutDatum, DateTimeFormatter.ISO_LOCAL_DATE);

            return slut.isAfter(start) || slut.isEqual(start);

        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean kontrolleraProjektnamn(String namn) {
        if (namn == null) {
            return false;
        }
        if (namn.length() < 3 || namn.length() > 50) {
            return false;
        }
        return namn.matches("^[A-Za-zÅÄÖåäö0-9\\s\\-]+$");
    }
    
    public boolean kontrolleraProjektnamnUnikt(String projektnamn, String pid) {
        try {
            String sqlFraga = "SELECT projektnamn FROM projekt WHERE projektnamn = '" + projektnamn + "' AND pid != " + pid;
            String dbResultat = idb.fetchSingle(sqlFraga);

            return dbResultat == null;
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean kontrolleraProjektBeskrivning(String beskrivning) {
        if (beskrivning == null) {
            return false;
        }
        if (beskrivning.length() < 10 || beskrivning.length() > 250) {
            return false;
        }
        return beskrivning.matches("^[A-Za-zÅÄÖåäö0-9.,\\-\\s]+$");
    }
    
    public static boolean kontrolleraProjektKostnad(String kostnadString) {
        if (kostnadString == null || kostnadString.trim().isEmpty()) {
            return false;
        }

        try {
            double kostnad = Double.parseDouble(kostnadString);
            return kostnad >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean kontrolleraProjektStatus(String status) {
        if (status == null) {
            return false;
        }
        return status.equals("Planerat") || status.equals("Pågående") || status.equals("Avslutat");
    }
    
    public static boolean kontrolleraProjektPrioritet(String prioritet) {
        if (prioritet == null) {
            return false;
        }
        return prioritet.equals("Låg") || prioritet.equals("Medel") || prioritet.equals("Hög");
    }
    
    public boolean kontrolleraLandFinns(String landNamn) {
    if (arTextFaltTomt(landNamn)) {
        return false;  // Fältet är tomt, returnera false direkt
    }

    try {
        String sqlfraga = "SELECT lid FROM land WHERE namn = '" + landNamn + "'";
        String dbLid = idb.fetchSingle(sqlfraga);

        if (dbLid != null) {
            return true;  // Landet finns i databasen

        }

             } catch (InfException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    return false;
    }

    public boolean kontrolleraProjektchef(String fullstandigtNamn) {
        try {
            // 1. Hämta alla aid från handlaggare
            String sqlHämtaAid = "SELECT aid FROM handlaggare";
            ArrayList<String> handlaggarIds = idb.fetchColumn(sqlHämtaAid);

        if (handlaggarIds == null || handlaggarIds.isEmpty()) {
            return false;
        }

        // 2. Gå igenom varje aid och hämta namn från anstalld
        for (String aid : handlaggarIds) {
            String sqlHämtaNamn = "SELECT CONCAT(fornamn, ' ', efternamn) FROM anstalld WHERE aid = " + aid;
            String namn = idb.fetchSingle(sqlHämtaNamn);

            if (namn != null && namn.equals(fullstandigtNamn)) {
                return true;
            }
        }

        // 3. Ingen match hittad
        return false;

        } catch (InfException e) {
            System.out.println("Fel vid kontroll: " + e.getMessage());
            return false;
        }
    }

    

    public boolean kontrolleraOmProjektPartnerFinns(String projektPid, String partnerPid) {
        try {
            String sql = "SELECT * FROM projekt_partner WHERE pid = '" + projektPid + "' AND partner_pid = '" + partnerPid + "'";
            String resultat = idb.fetchSingle(sql);

            if (resultat != null) {
            // Vi hittade en rad i databasen
            return true;
            }   else {
                // Ingen rad hittades
                return false;
}
        } catch (InfException e) {
            System.out.println("Fel vid kontroll av projekt-partner-koppling: " + e.getMessage());
            return false;
        }
    }
    
    public boolean isValidEpost(String epost) {
        if (epost == null) return false;
        return epost.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean isValidLosenord(String losenord) {
        if (losenord == null) return false;
        return losenord.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public boolean isValidTelefon(String telefon) {
        if (telefon == null) return false;
        // Exempel: svenska telefonnummer, 10 siffror
        return telefon.matches("^\\d{10}$");
    }
  
    public boolean kontrolleraStadFinns(String stadNamn) {
    if (arTextFaltTomt(stadNamn)) {
        return false;  // Fältet är tomt, returnera false direkt
    }

    try {
        String sqlfraga = "SELECT sid FROM stad WHERE namn = '" + stadNamn + "'";
        String dbLid = idb.fetchSingle(sqlfraga);

        if (dbLid != null) {
            return true;  // Staden finns i databasen

        }

             } catch (InfException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    return false;
    }

}