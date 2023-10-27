package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapWriterTest {

    private MapWriter underTest;

    @BeforeEach
    public void setUp() {
        underTest = new MapWriter();
    }


    @Test
    void testMaPrinterShouldThrowExceptionWhenGivenNullMapVO() {
        // GIVEN
        MapVO mapVO = null;

        // WHEN - THEN (using an assertion to check for the expected exception)
        assertThrows(NullPointerException.class, () -> underTest.mapPrinter(mapVO));
    }

    @Test
    void testMapPrinterShouldRunSuccessfully() {
        // GIVEN
        char[][] mapData = {
                {'W', 'P', 'E'},
                {'E', 'B', 'E'},
                {'E', 'E', 'G'}
        };
        HeroVO heroVO = new HeroVO();
        MapVO mapVO = new MapVO(3, mapData, heroVO);
    }

    @Test
    void testPrintMapAndHeroDetailsShouldRunSuccessfully() {
        // GIVEN
        char[][] mapData = {
                {'W', 'P', 'E'},
                {'E', 'B', 'E'},
                {'E', 'E', 'G'}
        };
        HeroVO heroVO = new HeroVO();
        heroVO.setArrows(5);
        heroVO.setDirection('N');
        MapVO mapVO = new MapVO(3, mapData, heroVO);
    }

}