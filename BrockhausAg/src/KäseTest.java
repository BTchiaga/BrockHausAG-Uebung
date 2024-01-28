import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class KäseTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void shouldUpdateQualityQualityAboveMinimumQualität() {
        Date verfallsDatum = new Date();
        Käse käse = new Käse("Gouda", 40, verfallsDatum, 5.0);

        käse.updateQuality();

        assertEquals(39, käse.getQualitaet());
    }

    @Test
    public void shouldUpdateQualityQualityAtMinimumualität() {
        Date verfallsDatum = new Date();
        Käse käse = new Käse("Gouda", 30, verfallsDatum, 5.0);

        käse.updateQuality();

        assertEquals("Gouda soll weg.....", outContent.toString().trim());
    }

    @Test
    public void shouldUpdateQualityQualityBelowMinimumQualität() {
        Date verfallsDatum = new Date();
        Käse käse = new Käse("Gouda", 20, verfallsDatum, 5.0);

        käse.updateQuality();

        assertEquals("Gouda soll weg.....", outContent.toString().trim());
    }

    @Test
    public void shouldRemoveProductWithQualityBelowMinimumQualität() {
        Date verfallsDatum = new Date();
        Käse käse = new Käse("Gouda", 20, verfallsDatum, 5.0);

        assertTrue(käse.mussEntsorgtWerden());
    }

    @Test
    public void shouldremoveProductWithinExpirationRange() {
        Date verfallsDatum = new Date();
        Käse käse = new Käse("Gouda", 40, verfallsDatum, 5.0);

        assertFalse(käse.mussEntsorgtWerden());
    }
}
