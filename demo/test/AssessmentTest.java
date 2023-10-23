import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AssessmentTest {
    private Assessment a1;
    private  Assessment a2;
    private  Assessment a3;
    private  Assessment a4;
    @BeforeEach
    void setUp(){
        a1 = new Assessment(new BigDecimal(1000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a2 = new Assessment(new BigDecimal(2000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
        a3 = new Assessment(new BigDecimal(1000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a4 = new Assessment(new BigDecimal(2000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
    }

    @Test
    void getValue() {
        BigDecimal value1 = a1.getValue();
        assertEquals(new BigDecimal(1000), value1);
        BigDecimal value2 = a2.getValue();
        assertEquals(new BigDecimal(2000), value2);
    }

    @Test
    void setValue() {
        a1.setValue(new BigDecimal(5000));
        assertEquals(new BigDecimal(5000), a1.getValue());
        a2.setValue(new BigDecimal(6000));
        assertEquals(new BigDecimal(6000), a2.getValue());
    }

    @Test
    void getClassPercent1() {
        String p1 = a1.getClassPercent1();
        assertEquals("35", p1);
        String p2 = a2.getClassPercent1();
        assertEquals("30", p2);
    }

    @Test
    void setClassPercent1() {
        a1.setClassPercent1("60");
        assertEquals("60", a1.getClassPercent1());
        a2.setClassPercent1("70");
        assertEquals("70", a2.getClassPercent1());
    }

    @Test
    void getClassPercent2() {
        String p1 = a1.getClassPercent2();
        assertEquals("35", p1);
        String p2 = a2.getClassPercent2();
        assertEquals("30", p2);
    }

    @Test
    void setClassPercent2() {
        a1.setClassPercent2("70");
        assertEquals("70", a1.getClassPercent2());
        a2.setClassPercent2("80");
        assertEquals("80", a2.getClassPercent2());
    }

    @Test
    void getClassPercent3() {
        String p1 = a1.getClassPercent3();
        assertEquals("30", p1);
        String p2 = a2.getClassPercent3();
        assertEquals("40", p2);
    }

    @Test
    void setClassPercent3() {
        a1.setClassPercent3("10");
        assertEquals("10", a1.getClassPercent3());
        a2.setClassPercent3("15");
        assertEquals("15", a2.getClassPercent3());
    }

    @Test
    void getClass1() {
        String p1 = a1.getClass1();
        assertEquals("RESIDENTIAL", p1);
        String p2 = a2.getClass1();
        assertEquals("RESIDENTIAL", p2);
    }

    @Test
    void setClass1() {
        a1.setClass1("COMMERCIAL");
        assertEquals("COMMERCIAL", a1.getClass1());
        a2.setClass1("FARMLAND");
        assertEquals("FARMLAND", a2.getClass1());
    }

    @Test
    void getClass2() {
        String p1 = a1.getClass2();
        assertEquals("COMMERCIAL", p1);
        String p2 = a2.getClass2();
        assertEquals("RESIDENTIAL", p2);
    }

    @Test
    void setClass2() {
        a1.setClass2("RESIDENTIAL");
        assertEquals("RESIDENTIAL", a1.getClass2());
        a2.setClass2("FARMLAND");
        assertEquals("FARMLAND", a2.getClass2());
    }

    @Test
    void getClass3() {
        String p1 = a1.getClass3();
        assertEquals("RESIDENTIAL", p1);
        String p2 = a2.getClass3();
        assertEquals("COMMERCIAL", p2);
    }

    @Test
    void setClass3() {
        a1.setClass3("FARMLAND");
        assertEquals("FARMLAND", a1.getClass3());
        a2.setClass3("RESIDENTIAL");
        assertEquals("RESIDENTIAL", a2.getClass3());
    }

    @Test
    void testToString() {
        String p1 = a1.toString();
        assertEquals("Assessment{" +
                "value=" + a1.getValue() +
                ", classPercent1='" + a1.getClassPercent1() + '\'' +
                ", classPercent2='" + a1.getClassPercent2() + '\'' +
                ", classPercent3='" + a1.getClassPercent3() + '\'' +
                ", class1='" + a1.getClass1() + '\'' +
                ", class2='" + a1.getClass2() + '\'' +
                ", class3='" + a1.getClass3() + '\'' +
                '}', p1);
        String p2 = a2.toString();
        assertEquals("Assessment{" +
                "value=" + a2.getValue() +
                ", classPercent1='" + a2.getClassPercent1() + '\'' +
                ", classPercent2='" + a2.getClassPercent2() + '\'' +
                ", classPercent3='" + a2.getClassPercent3() + '\'' +
                ", class1='" + a2.getClass1() + '\'' +
                ", class2='" + a2.getClass2() + '\'' +
                ", class3='" + a2.getClass3() + '\'' +
                '}', p2);
    }

    @Test
    void testEquals() {
        boolean t1 = a1.equals(a2);
        boolean t2 = a1.equals(a3);
        boolean t3 = a2.equals(a3);
        boolean t4 = a2. equals(a4);
        assertFalse(t1);
        assertTrue(t2);
        assertFalse(t3);
        assertTrue(t4);
    }

    @Test
    void testHashCode() {
        int h1 = a1.hashCode();
        int h2 = a2.hashCode();
        int h3 = a3.hashCode();
        int h4 = a4.hashCode();
        assertEquals(h1, h3);
        assertEquals(h2, h4);
    }
}