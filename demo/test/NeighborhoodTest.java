import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class NeighborhoodTest {
    private Neighborhood n1;
    private Neighborhood n2;
    private Neighborhood n3;
    private Neighborhood n4;
    @BeforeEach
    void setup(){
        n1 = new Neighborhood("12345", "NEIGHBOR", "HOME");
        n2 = new Neighborhood("54321", "HOOD", "HOUSE");
        n3 = new Neighborhood("12345", "NEIGHBOR", "HOME");
        n4 = new Neighborhood("54321", "HOOD", "HOUSE");

    }
    @Test
    void getNeighborhoodID() {
        assertEquals("12345", n1.getNeighborhoodID());
        assertEquals("54321", n2.getNeighborhoodID());
    }

    @Test
    void setNeighborhoodID() {
        n1.setNeighborhoodID("67890");
        n2.setNeighborhoodID("09876");
        assertEquals("67890", n1.getNeighborhoodID());
        assertEquals("09876", n2.getNeighborhoodID());
    }

    @Test
    void getNeighborhood() {
        assertEquals("NEIGHBOR", n1.getNeighborhood());
        assertEquals("HOOD", n2.getNeighborhood());
    }

    @Test
    void setNeighborhood() {
        n1.setNeighborhood("HOOD");
        n2.setNeighborhood("NEIGHBOR");
        assertEquals("HOOD", n1.getNeighborhood());
        assertEquals("NEIGHBOR", n2.getNeighborhood());
    }

    @Test
    void getWard() {
        assertEquals("HOME", n1.getWard());
        assertEquals("HOUSE", n2.getWard());
    }

    @Test
    void setWard() {
        n1.setWard("HOUSE");
        n2.setWard("HOME");
        assertEquals("HOUSE", n1.getWard());
        assertEquals("HOME", n2.getWard());
    }

    @Test
    void testToString() {
        assertEquals("Neighborhood{" +
                "neighborhoodID=" + n1.getNeighborhoodID() +
                ", neighborhood='" + n1.getNeighborhood() + '\'' +
                ", ward='" + n1.getWard() + '\'' +
                '}', n1.toString());
        assertEquals("Neighborhood{" +
                "neighborhoodID=" + n2.getNeighborhoodID() +
                ", neighborhood='" + n2.getNeighborhood() + '\'' +
                ", ward='" + n2.getWard() + '\'' +
                '}', n2.toString());
    }

    @Test
    void testEquals() {
        boolean t1 = n1.equals(n2);
        boolean t2 = n1.equals(n3);
        boolean t3 = n2.equals(n3);
        boolean t4 = n2. equals(n4);
        assertFalse(t1);
        assertTrue(t2);
        assertFalse(t3);
        assertTrue(t4);
    }

    @Test
    void testHashCode() {
        int h1 = n1.hashCode();
        int h2 = n2.hashCode();
        int h3 = n3.hashCode();
        int h4 = n4.hashCode();
        assertEquals(h1, h3);
        assertEquals(h2, h4);
    }
}