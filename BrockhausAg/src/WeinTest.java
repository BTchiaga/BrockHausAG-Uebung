import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class WeinTest {

    @Test
    public void shouldUpdateQualityWithinIncrementInterval() {
        Wein wein = new Wein("Merlot", 30, 12.0);
        wein.updateQuality();
        assertEquals(34, wein.getQualitaet());
    }

    @Test
    public void shouldUpdateQualityAtMaxQuality() {
        Wein wein = new Wein("Chardonnay", 50, 15.0);
        wein.updateQuality();
        assertEquals(50, wein.getQualitaet());
    }

    @Test
    public void shouldUpdateQualityExceedingMaxQuality() {
        Wein wein = new Wein("Shiraz", 48, 18.0);
        wein.updateQuality(); // Expect increment by 3 (48/10 + 1)
        assertEquals(50, wein.getQualitaet());
    }
}
