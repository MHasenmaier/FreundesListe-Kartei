import java.util.ArrayList;

public class Freund
{
    private static int idCounter = 1;
    ArrayList<Adressen> adressList = new ArrayList<>();
    private int freundID;
    private String vorname;
    private String nachname;
    private String geb;


    //Konstruktor
    public Freund(String vorname, String nachname, String geb)
    {
        setVorname(vorname);
        setNachname(nachname);
        setGeb(geb);
        freundID = idCounter++;
    }


    /**
     * Einem Freund eine Adresse hinzufuegen
     *
     * @param plz,     die Postleitzahl
     * @param stadt,   der Wohnort(Stadt)
     * @param strasse, der Wohnort(Strasse / Hausnummer)
     */
    public void addAdresse(int plz, String stadt, String strasse)
    {
        if (adressList.add(new Adressen(plz, stadt, strasse))) {
            System.out.println("Neue Adresse fuer ID: " + this.freundID + " angelegt.");
        } else {
            System.out.println("### FEHLER :: adressList.add() konnte kein neues Element hinzugefuegt werden!");
        }

    }

    /**
     * Loescht einen Adresseintrag
     *
     * @param adressIndex: Index der Adresse, die geloescht werden soll
     */
    public void deleteAdresse(int adressIndex)
    {
        if (!adressList.isEmpty() && adressIndex >= 0 && adressList.remove(adressList.get(adressIndex))) {
            System.out.println("Adresse mit der ID: " + adressIndex + " erfolreich entfernt");
        } else {
            System.out.println(" ### FEHLER :: adressList.remove() konnte die Adresse mit der ID : " + adressIndex + " nicht entfernen.");
        }
    }

    /**
     * Gibt alle Adressen eines Freundes aus
     */
    public void printAdressen()
    {
        System.out.println("Adressen von " + this.getVorname() + " " + this.getNachname() + " werden ausgegeben:");
        if (!adressList.isEmpty()) {
            for (Adressen adr : adressList) {
                System.out.println(" :: AdressIndex: " + adressList.indexOf(adr) + " ::  PLZ: " + adr.getPlz() + " ::  Stadt: " + adr.getStadt() + " ::  Strasse: " + adr.getStrasse());
            }
            System.out.println();
        } else {
            System.out.println(" ### FEHLER :: adressList von " + this.getVorname() + " " + this.getNachname() + " ist leer.");
        }
    }

    /**
     * Supportmethode, welche dem Loeschen von Adressen dient
     *
     * @param adressIndex Index der Adresse, nach welcher gesucht werden soll
     * @return gibt das gesuchte Objekt zurueck oder null, wenn Objekt nicht gefunden oder Index kleiner 0
     */
    private Adressen sucheAdresse(int adressIndex)
    {
        if (adressList.isEmpty() || adressIndex < 0 || adressIndex >= adressList.size()) {
            System.out.println(" +++ FEHLER! sucheAdresse(" + adressIndex + ") hat einen ungueltigen Parameter bekommen");
            return null;
        }
        return adressList.get(adressIndex);
    }


    //Getter & Setter
    public int getFreundID()
    {
        return freundID;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public String getNachname()
    {
        return nachname;
    }

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public String getGeb()
    {
        return geb;
    }

    public void setGeb(String geb)
    {
        this.geb = geb;
    }
}