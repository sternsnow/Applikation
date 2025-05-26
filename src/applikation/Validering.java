/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applikation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    
    public boolean kontrolleraLandFinns(String lid) {
        if (arTextFaltTomt(lid)) {
            return false;
        }

        try {
            String sqlfraga = "SELECT lid FROM land WHERE lid = " + lid;
            String dbLid = idb.fetchSingle(sqlfraga);

            return dbLid != null;
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean kontrolleraOmProjektPartnerFinns(String projektPid, String partnerPid) {
        try {
            String sql = "SELECT * FROM projekt_partner WHERE pid = '" + projektPid + "' AND partner_pid = '" + partnerPid + "'";
            String resultat = idb.fetchSingle(sql);

            return resultat != null;
        } catch (InfException e) {
            System.out.println("Fel vid kontroll av projekt-partner-koppling: " + e.getMessage());
            return true;
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

}