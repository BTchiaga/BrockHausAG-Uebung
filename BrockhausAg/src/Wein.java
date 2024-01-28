import java.util.Date;

public class Wein extends Produkt{
    private static final int MAX_QUALITY = 50;
    private static final int QUALITY_INCREMENT_INTERVAL = 10;

    public Wein(String bezeichnung, int qualität, double preis) {
        super(bezeichnung, qualität, preis);


    }
    @Override
    public void updateQuality() {
        if (qualitaet< MAX_QUALITY) {
            int incrementCount = (qualitaet / QUALITY_INCREMENT_INTERVAL) + 1;
            // Wein gewinnt alle 10 Tage +1 Qualität hinzu, bis Qualität 50 erreicht ist
            qualitaet += incrementCount;
            if (qualitaet > MAX_QUALITY) {
                qualitaet = MAX_QUALITY;
            }
        }

    }
}
