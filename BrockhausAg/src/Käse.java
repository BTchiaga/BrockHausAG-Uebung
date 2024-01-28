import java.util.Date;

public class Käse extends Produkt {
    private static final int MIN_QUALITY = 30;
    private static final int MIN_TAG_ZUM_VERSFALSDATUM = 50;
    private static final int MAX_TAG_ZUM_VERFALSSDATUM = 100;
    public Käse(String bezeichnung, int qualität, Date verfallsDatum, double grundPreis) {
        super(bezeichnung, qualität,verfallsDatum,grundPreis);
    }
    @Override
    public void updateQuality() {

        if (qualitaet > MIN_QUALITY && !mussEntsorgtWerden()) {
            System.out.println("Updating......."+bezeichnung);
            qualitaet--; // Käse verliert täglich einen Qualitätspunkt

        } else {

            System.out.println(bezeichnung + " soll weg.....");

        }
        preis = preisBerechnung(); // Aktualisieren des Preises basierend auf der Qualität
    }
    @Override
    public boolean mussEntsorgtWerden() {
        Date heute = new Date();
        long diffInMillies = verfallsDatum.getTime() - heute.getTime();
        long diffInTage = diffInMillies / (1000 * 60 * 60 * 24);

        return (qualitaet < MIN_QUALITY || (diffInTage >= MIN_TAG_ZUM_VERSFALSDATUM && diffInTage <= MAX_TAG_ZUM_VERFALSSDATUM));
    }







}
