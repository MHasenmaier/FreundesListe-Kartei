public class Adressen
{
    private String strasse;
    private String stadt;
    private int plz;

    public Adressen(int plz, String stadt, String strasse)
    {
        setPlz(plz);
        setStadt(stadt);
        setStrasse(strasse);
    }


    public String getStrasse()
    {
        return strasse;
    }

    public void setStrasse(String strasse)
    {
        this.strasse = strasse;
    }

    public String getStadt()
    {
        return stadt;
    }

    public void setStadt(String stadt)
    {
        this.stadt = stadt;
    }

    public int getPlz()
    {
        return plz;
    }

    public void setPlz(int plz)
    {
        this.plz = plz;
    }
}