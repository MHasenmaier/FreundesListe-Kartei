public class Main
{
    public static void main(String[] args)
    {
        Kartei kartei = new Kartei();

        int freundA;
        int freundB;
        int freundC;
        int idDelete = 3;
        int idSearch = 2;
        int idChange = 2;


        //Freunde anlegen
        freundA = kartei.addNeuerFreund("Klaus", "Herbst", "10. Jan. 1948");
        kartei.sucheFreunde(freundA).addAdresse(40210, "Duesseldorf", "Alles-Klar-Allee 42");
        kartei.sucheFreunde(freundA).addAdresse(10115, "Berlin", "Walter-Wolf-Strasse 30b");
        kartei.sucheFreunde(freundA).addAdresse(57072, "Siegen", "Im kleinen Wald 9");
        kartei.sucheFreunde(freundA).addAdresse(85579, "Neubiberg", "Hauptstrasse 11a");

        freundB = kartei.addNeuerFreund("Maria", "Ungenug", "20.07.1956");
        kartei.sucheFreunde(freundB).addAdresse(2237, "Leipzig", "Beamtenlaufbahn 6");
        kartei.sucheFreunde(freundB).addAdresse(7373, "Ostfildern", "Universitaetsstrasse 54");

        freundC = kartei.addNeuerFreund("Eberhardt", "Olufsen", "01. Maerz 2000");
        kartei.sucheFreunde(freundC).addAdresse(12410, "Kiel", "Bremsweg 27");


        printAlleFreunde(kartei);

        //Suche nach Schlagwort / bzw Eintrag
        System.out.println("Suche nach Schlagwort / Eintrag >> 'Herbst' << ::");
        System.out.println("        Suche :: ID: " + kartei.sucheFreunde("Herbst").getFreundID() + " " + "::  Name: " + kartei.sucheFreunde("Herbst").getVorname() + " " + kartei.sucheFreunde("Herbst").getNachname() + " " + "::  Geburtstag: " + kartei.sucheFreunde("Herbst").getGeb());
        System.out.print("\n");

        //Suche nach ID
        System.out.println("Suche nach ID >> " + idSearch + " << ::");
        System.out.println("        Suche :: ID: " + kartei.sucheFreunde(idSearch).getFreundID() + " " + "::  Name: " + kartei.sucheFreunde(idSearch).getVorname() + " " + kartei.sucheFreunde(idSearch).getNachname() + " " + "::  Geburtstag: " + kartei.sucheFreunde(idSearch).getGeb());
        System.out.print("\n");

        //Eintrag veraendern
        System.out.println("aendern eines Eintrags, ID >> " + idChange + " << ::");
        kartei.changeFreunde(idChange, "Ursula", "Schmidt", "19. April 1966");

        System.out.println("Erneute Suche nach ID >> " + idChange + " << um aenderung zu verifizieren ::");
        System.out.println("        Suche :: ID: " + kartei.sucheFreunde(idChange).getFreundID() + " " + "::  Name: " + kartei.sucheFreunde(idChange).getVorname() + " " + kartei.sucheFreunde(idChange).getNachname() + " " + "::  Geburtstag: " + kartei.sucheFreunde(idChange).getGeb());
        System.out.print("\n");

        //Ausgabe der Anzahl aller Freunde in der Datenbank
        System.out.println("Ausgabe der Anzahl aller Freunde in der Kartei ::");
        kartei.printAnzahlFreunde();

        //Eintrag loeschen
        System.out.println("Loeschen eines Eintrags, ID >> " + idDelete + " << ::");
        kartei.deleteFreunde(idDelete);

        System.out.println("Erneute Suche nach ID >> " + idDelete + "  << um Loeschen zu verifizieren ::");
        if (kartei.sucheFreunde(idDelete) == null)     //faengt NullPointerException ab
        {
            System.out.println("        Suche :: ID: " + idDelete + " erfolglos -> NullPointerException abgefangen.");
        } else {
            System.out.println("        Suche :: ID: " + kartei.sucheFreunde(idDelete).getFreundID());
        }
        System.out.print("\n");

        //Ausgabe der Anzahl aller Freunde in der Datenbank - Kontrolle, ob geloescht wurde
        System.out.println("Erneute Ausgabe der Anzahl aller Freunde in der Kartei, um Loeschen zu verifizieren ::");
        kartei.printAnzahlFreunde();

        printAlleFreunde(kartei);
    }


    /**
     * Supportfunktion um main-Methode zu entlassten - gibt alle Eintraege auf der Konsole aus
     *
     * @param kartei aktuelle Kartei, aus welcher die Eintraege auf der Konsole ausgegeben werden sollen
     */
    public static void printAlleFreunde(Kartei kartei)
    {
        System.out.println("\n");
        if (!kartei.freundesListe.isEmpty())
        {
            for (Freund fr : kartei.freundesListe) {

                System.out.println(":: ID " + fr.getFreundID() + " -  Name " + fr.getVorname() + " " + fr.getNachname() + ", geboren am: " + fr.getGeb());
                if (!fr.adressList.isEmpty()) {

                    System.out.println(":: Mit den Adressen:");
                    for (Adressen adr : fr.adressList) {

                        System.out.println(":: PLZ " + adr.getPlz() + " :: Stadt " + adr.getStadt() + " :: Strasse " + adr.getStrasse());
                    }//for-adressList
                    System.out.println();
                }//if-adressList.empty
            }//for-freundesListe
        }
    }
}