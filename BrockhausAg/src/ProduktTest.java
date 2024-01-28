import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProduktTest {


   /* @Test
    public void shouldPrintInfoTabularFürKäse() {
        Date verfallsDatum = new Date();
        Produkt käse = new Käse("Gouda", 90, verfallsDatum, 5.0);


        String expectedOutput = "+--------------+-------------------------+---------+----------+-----------------+-----------+\n" +
                "| Produkttyp   | Produkt                 | Preis   | Qualität | Verfallsdatum   | Entsorgung |\n" +
                "+--------------+-------------------------+---------+----------+-----------------+-----------+\n" +
                "| Käse         | Gouda                   | 5.00    | 90       | yyyy-MM-dd      | Nein      |\n" +
                "+--------------+-------------------------+---------+----------+-----------------+-----------+\n";

        // Tatsächliche Ausgabe
        String actualOutput = getOutputString(käse);


        assertEquals(expectedOutput, actualOutput);
    }*/

    @Test
    public void shouldMussEntsorgtWerdenFürKäse() {
        Date verfallsDatum = new Date();
        Produkt käse = new Käse("Gouda", 20, verfallsDatum, 5.0);

        assertTrue(käse.mussEntsorgtWerden());
    }

    private String getOutputString(Produkt produkt) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        produkt.printInfoTabular();
        return outContent.toString();
    }
}

