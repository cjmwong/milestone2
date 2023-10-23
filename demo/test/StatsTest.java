import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {
    private Pair pair;
    private PropertyAssessment p1;
    private PropertyAssessment p2;
    private PropertyAssessment p3;
    private PropertyAssessment p4;
    private PropertyAssessment p5;
    private Neighborhood n1;
    private Neighborhood n2;
    private Coordinates c1;
    private Coordinates c2;
    private Assessment a1;
    private Assessment a2;
    private Assessment a3;
    private Assessment a4;
    private Assessment a5;
    private ArrayList<PropertyAssessment> testArray = new ArrayList<>();

    @BeforeEach
    void setup() {
        n1 = new Neighborhood("12345", "NEIGHBOR", "HOME");
        n2 = new Neighborhood("54321", "HOOD", "HOUSE");
        c1 = new Coordinates(new BigDecimal(50000), new BigDecimal(-100000));
        c2 = new Coordinates(new BigDecimal(58000), new BigDecimal(150000));
        a1 = new Assessment(new BigDecimal(1000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a2 = new Assessment(new BigDecimal(2000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
        a3 = new Assessment(new BigDecimal(3000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a4 = new Assessment(new BigDecimal(4000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
        a5 = new Assessment(new BigDecimal(5000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
        p1 = new PropertyAssessment("1234", "123", "5432", "STREET", true, n1, c1, a1);
        p2 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a2);
        p3 = new PropertyAssessment("1234", "123", "5432", "STREET", true, n1, c1, a3);
        p4 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a4);
        p5 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a4);
        pair = LoadData.readCSV("Property_Assessment_Data_2023.csv");

        testArray.add(p1);
        testArray.add(p2);
        testArray.add(p3) ;
        testArray.add(p4);
    }
    @Test
    void getMinAndMaxValue() {
        BigDecimal test[];
        test = Stats.getMinAndMaxValue(testArray);
        assertEquals(new BigDecimal(1000), test[0]);
        assertEquals(new BigDecimal(4000), test[1]);
        BigDecimal b[];
        b = Stats.getMinAndMaxValue(pair.getList());
        assertEquals(new BigDecimal(0), b[0]);
        assertEquals(new BigDecimal(1147736500), b[1]);

    }

    @Test
    void mean() {
        BigDecimal test = Stats.mean(testArray);
        assertEquals(new BigDecimal(10000).divide(new BigDecimal(4)), test);
        BigDecimal b = Stats.mean(pair.getList());
        assertEquals(new BigDecimal(476039), b);
    }

    @Test
    void median() {
        BigDecimal test = Stats.median(testArray);
        assertEquals(new BigDecimal(2500), test);
        testArray.add(p5);
        test = Stats.median(testArray);
        assertEquals(new BigDecimal(3000), test);
        BigDecimal b = Stats.median(pair.getList());
        assertEquals(new BigDecimal(337000), b);
    }
}