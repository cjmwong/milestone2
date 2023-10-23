import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class LoadDataTest {
    private String[] propertyInfo;
    private PropertyAssessment p1;
    @BeforeEach
    void setup() {
        propertyInfo = new String[] {"1194893", "", "8349", "156 AVENUE NW", "N", "2050", "BELLE RIVE", "tastawiyiniwak Ward",
                "297000", "53.6162664", "-113.4714644", "POINT (-113.47146440816364 53.61626639817324)"
                , "100", "", "", "RESIDENTIAL", "", ""};
        Neighborhood n1 = new Neighborhood( "2050", "BELLE RIVE", "tastawiyiniwak Ward");
        Coordinates c1 = new Coordinates(new BigDecimal(53.6162664).setScale(7, RoundingMode.HALF_UP), new BigDecimal(-113.4714644).setScale(7, RoundingMode.HALF_UP));
        Assessment a1 = new Assessment(new BigDecimal(297000), "100", "", "", "RESIDENTIAL", "", "");
        p1 = new PropertyAssessment("1194893", "", "8349", "156 AVENUE NW", false, n1, c1, a1);
    }
    @Test
    void readFile() {
        assertEquals(422062, LoadData.readCSV("Property_Assessment_Data_2023.csv").getList().size());
        assertEquals(422062, LoadData.readCSV("Property_Assessment_Data_2023.csv").getMap().size());
    }
    @Test
    void buildProperty() {
        assertEquals(p1, LoadData.buildProperty(propertyInfo));
    }
}