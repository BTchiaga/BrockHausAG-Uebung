import java.text.SimpleDateFormat;
import java.util.*;

public class SUPERDUPERMARKT {
    private static final int MIN_KÄSE_QUALITAET = 30;

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Produkt> produckten= new ArrayList<>();
        Date currentDate = new Date();
        Random random = new Random();

        // Beispielprodukte

        for (int i = 0; i < 15; i++) {
            // Calculate future expiration dates
            Date futureKäseDate = new Date(currentDate.getTime() + (i * 48 * 24 * 60 * 60 * 1000L));

            // Generate random prices for Käse and Wein
            double käsePreis= 3.0 + (random.nextDouble() * (10.0 - 3.0)); // Price range: 3.0 to 10.0
            double weinPreis = 8.0 + (random.nextDouble() * (20.0 - 8.0)); // Price range: 8.0 to 20.0
            int käseQualitaet =  10 + random.nextInt(33);
            int weinQualitaet = 20 + random.nextInt(35);


            // Create Käse and Wein instances
            Käse käse = new Käse("Käse " + (i + 1),  käseQualitaet, futureKäseDate, käsePreis);
            Wein wein = new Wein("Wein " + (i + 1), weinQualitaet, weinPreis);
            System.out.println("Herstellung der Produkten:  Wein : "+ wein.bezeichnung +" Qualität "+wein.qualitaet+" \n");
            System.out.println("Herstellung der Produkten:  Käse: "+ käse.bezeichnung+" Qualität "+käse.qualitaet+ " VerfallsDatum: "+dateFormat.format(käse.verfallsDatum)+ "\n");

            // Add Käse and Wein to the list
            produckten.add(wein);
            if (käse.getQualitaet() > MIN_KÄSE_QUALITAET) {
                produckten.add(käse);
            }else {
                System.out.println(käse.bezeichnung+" wird nicht im regal hinzugefügt\n \n");
            }

        }



        // Ausgabe der Startwerte
        System.out.println("Herzlich Willkomen zu SUPERDUPERMARKT");
        System.out.println("Information zu den Produkten vor der Simulation\n");
        System.out.println("++++++++++++Tabular Display+++++++++++++++++++");
        for (Produkt produkt : produckten){
            produkt.printInfoTabular();
        }

        System.out.println("-------------------------------------------------\n");

        System.out.println("-----------100 Tage Simulation -----------------");

        // hier werden 100 Tage simuliert
        for (int i = 0; i < 100 ; i++) {
            System.out.println("\nTag " + i+ ":");


            System.out.println("Information zu den Produkten nach "+ "\nTag " + i+ ":"+ "Simulation");
            System.out.println("++++++++++++Tabular Display+++++++++++++++++++");
            // Aktualisierung der Produkte täglich
            for (Produkt produkt : produckten){
                produkt.updateQuality();
                produkt.printInfoTabular();
            }
            //ensureEntsorgung(produckten);


        }

    }

    /*private static void ensureEntsorgung(List<Produkt> produckten) {Iterator<Produkt> iterator = produckten.iterator();
        while (iterator.hasNext()) {
            Produkt produkt = iterator.next();

            if ((produkt instanceof Käse && produkt.mussEntsorgtWerden())  ) {

                iterator.remove();

                System.out.println(produkt.bezeichnung + " wurde aus dem Regal entfernt -->> niedriger Qualität oder Verfallsdatum erreicht..");


            }
        }

    }*/
}