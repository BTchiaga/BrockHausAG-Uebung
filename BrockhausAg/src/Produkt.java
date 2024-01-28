import java.text.SimpleDateFormat;
import java.util.Date;

class Produkt {
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getQualitaet() {
        return qualitaet;
    }

    public void setQualitaet(int qualitaet) {
        this.qualitaet = qualitaet;
    }

    public Date getVerfallsDatum() {
        return verfallsDatum;
    }

    public void setVerfallsDatum(Date verfallsDatum) {
        this.verfallsDatum = verfallsDatum;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public double getGrundpreis() {
        return grundpreis;
    }

    protected String bezeichnung;
    protected int qualitaet;
    protected Date verfallsDatum;
    protected double preis;
    protected final double grundpreis;


    public Produkt(String bezeichnung, int qualitaet, Date verfallsDatum, double grundpreis) {
        this.bezeichnung = bezeichnung;
        this.qualitaet = qualitaet;
        this.verfallsDatum = verfallsDatum;
        this.preis = preisBerechnung();
        this.grundpreis = grundpreis;

    }

    public Produkt(String bezeichnung, int qualität, double grundPreis) {
        this.bezeichnung=bezeichnung;
        this.qualitaet=qualität;
        this.preis=preisBerechnung();
        this.grundpreis = grundPreis;

    }


    public void updateQuality() {

    }
   protected double preisBerechnung() {
        // Qualität bestimmt  Tagespreis
        return grundpreis + (0.10 * qualitaet);
    }
    public double getPreis() {
        return preisBerechnung();
    }
    public boolean mussEntsorgtWerden() {
        // Überprüfe, ob das Produkt entsorgt werden muss
        return false;
    }
    // ANSI escape codes für farbe
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public void printInfoTabular() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("+--------------+-------------------------+---------+----------+-----------------+-----------+");
        System.out.println("| " + ANSI_CYAN + "Produkttyp" + ANSI_RESET + "   | " + ANSI_CYAN + "Produkt" + ANSI_RESET + "                 | " + ANSI_CYAN + "Preis" + ANSI_RESET + "   | " + ANSI_CYAN + "Qualität" + ANSI_RESET + " | " + ANSI_CYAN + "Verfallsdatum" + ANSI_RESET + "   |"+ ANSI_CYAN + "Entsorgung" + ANSI_RESET + " |");
        System.out.println("+--------------+-------------------------+---------+----------+-----------------+-----------+");
        String entsorgtInfo = "";
        if (this instanceof Wein) {
            entsorgtInfo= "Nein";
            System.out.printf("| %-12s | %-23s | %-7.2f | %-8d | %s             |     %s  |\n", getClass().getSimpleName(), bezeichnung, preis, qualitaet, "N/A",entsorgtInfo);
        } else if (this instanceof Käse) {
            entsorgtInfo= (this.mussEntsorgtWerden() || this.qualitaet < 30 ? "nein" : "ja") ;
            System.out.printf("| %-12s | %-23s | %-7.2f | %-8d | %s      |    %s   |\n", getClass().getSimpleName(), bezeichnung, preis, qualitaet, dateFormat.format(verfallsDatum),entsorgtInfo);
        }
        System.out.println("+--------------+-------------------------+---------+----------+-----------------+-----------+");
    }



    public void printInfoNormal() {

        System.out.println("Produkttyp: " + getClass().getSimpleName() + ", Produkt: " + bezeichnung + ", Preis: " + preis + ", Qualität: " +qualitaet + "Verfallsdatum: " + verfallsDatum);
    }
}

