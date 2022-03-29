import java.util.ArrayList;

public class Kartei
{
    ArrayList<Freund> freundesListe = new ArrayList<>();

    /**
     * Methode zum Hinzufuegen von Freunden
     *
     * @param vorname  Vorname des neuen Freundes
     * @param nachname Nachname des neuen Freundes
     * @param geb      Geburtstag des neuen Freundes
     * @return ID (int) des neuen Eintrags (.getFreundID())
     */
    public int addNeuerFreund(String vorname, String nachname, String geb)
    {
        if (freundesListe.add(new Freund(vorname, nachname, geb))) {
            System.out.println("Neuer Eintrag :: Freund-ID: " + freundesListe.get(freundesListe.size() - 1).getFreundID() + " :: Vorname: " + freundesListe.get(freundesListe.size() - 1).getVorname() + " :: Nachname: " + freundesListe.get(freundesListe.size() - 1).getNachname() + " :: Geburtsdatum: " + freundesListe.get(freundesListe.size() - 1).getGeb());
            return freundesListe.get(freundesListe.size() - 1).getFreundID();
        } else {
            System.out.println(" +++ FEHLER! addNeuerFreund() konnte keinen neuen Eintrag machen :: Vorname: " + vorname + " :: Nachname: " + nachname + " :: Geburtsdatum: " + geb);
            return -1;
        }

    }

    /**
     * Methode zum aendern von Freunden
     *
     * @param id       ID des Eintrags, der geaendert werden soll
     * @param vorname  neuer Vorname des Freundes
     * @param nachname neuer Nachname des Freundes
     * @param geb      neuer Geburtstag des Freundes
     */
    public void changeFreunde(int id, String vorname, String nachname, String geb)
    {
        freundesListe.get(id).setVorname(vorname);
        freundesListe.get(id).setNachname(nachname);
        freundesListe.get(id).setGeb(geb);
    }

    /**
     * Methode zum Loeschen von Freunden
     *
     * @param id ID des Eintrags, der geloescht werden soll, verwendet sucheFreunde(int)
     */
    public void deleteFreunde(int id)
    {
        if (freundesListe.remove(sucheFreunde(id))) {
            System.out.println("Freund ID :: " + id + " :: wurde gefunden und geloescht.");
        } else {
            System.out.println(" +++ FEHLER! deleteFreunde(int id = " + id + ") war nicht erfolgreich");
        }
    }

    /**
     * Methode zum Loeschen von Freunden
     *
     * @param input Vorname oder Nachname des Eintrages, der zu loeschen ist, verwendet sucheFreunde(String)
     */
    public void deleteFreunde(String input)
    {
        if (freundesListe.remove(sucheFreunde(input))) {
            System.out.println("Freund String_input :: '" + input + "' :: wurde gefunden und geloescht.");
        } else {
            System.out.println(" +++ FEHLER! deleteFreunde(String input = " + input + ") war nicht erfolgreich");
        }
    }

    /**
     * Methode zum Suchen von Eintraegen
     *
     * @param id ID des Eintrages, der zu loeschen ist, muss > 0 und ≤ Arraylist.size() sein
     * @return Freundobjekt, das gesucht wurde, NULL, wenn Fehler auftritt
     */
    public Freund sucheFreunde(int id)
    {
        if (id > 0 && !freundesListe.isEmpty()) {
            return sucheFreundOBJ(id);
        }

        System.out.println(" +++ FEHLER! sucheFreunde(id: " + id + ") nicht existent - drohende NullPointerExcept.");
        return null;
    }

    /**
     * Methode zum Suchen von Eintraegen
     *
     * @param input Vorname oder Nachname, nach welchem gesucht werden soll
     * @return Freund-Objekt, das gesucht wurde, NULL, wenn Fehler auftritt - es wird nur der erste Treffer zurueckgegeben!
     */
    public Freund sucheFreunde(String input)
    {
        if (input.isEmpty() && freundesListe.isEmpty()) {
            System.out.println(" +++ FEHLER! sucheFreunde -> leerer String als Parameter :: input: " + input + " :: oder leere 'freundesListe'");
            return null;
        }

        for (Freund fr : freundesListe) {
            if (input.equals(fr.getVorname()) || input.equals(fr.getNachname())) {
                return sucheFreundOBJ(fr.getFreundID());
            }
        }//for-freundesListe
        System.out.println(" +++ FEHLER! sucheFreunde -> :: input: " + input + " :: for-Schleife (Freund fr : freundesListe) uebersprungen");
        return null;
    }

    /**
     * Suchfunktion, wird von sucheFreunde(String) und sucheFreunde(int) angesteuert
     *
     * @param id des Eintrags, welcher vorher von sucheFreunde ermittelt wurde
     * @return Freundobjekt, das gesucht wurde, NULL, wenn Fehler auftritt
     */
    private Freund sucheFreundOBJ(int id)
    {
        for (Freund fr : freundesListe) {
            if (id == fr.getFreundID()) return fr;
        }
        return null;
    }

    /**
     * System.Out.println mit der Anzahl der Eintraege in der Arrayliste "freundesListe"
     */
    public void printAnzahlFreunde()
    {
        System.out.println("In der Datenbank befinden sich: " + freundesListe.size() + " Eintraege");
    }
}