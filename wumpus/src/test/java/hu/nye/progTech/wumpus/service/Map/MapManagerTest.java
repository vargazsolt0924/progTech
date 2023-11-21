package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class MapManagerTest {


    private MapManager underTest;

    @Mock
    private MapVO mapVOMock;

    @Mock
    private HeroVO heroVOMock;

    @BeforeEach
    public void setUp() {
        underTest = new MapManager();
    }

    @Test
    void testPrintMapShouldRunSuccessfullyWhenGetValidMapVO() {
        // GIVEN
        char[][] mapData = {
                {'A', ' ', 'W', 'N', 'P'},
                {'P', 'W', 'W', 'U', 'P'},
                {'U', 'W', 'U', 'U', 'U'},
                {'W', 'U', 'U', 'P', 'W'},
                {'U', 'W', 'U', 'U', 'P'}
        };

        heroVOMock = new HeroVO('A', 0, 'W', 0, false, 0 , 'A');
        mapVOMock = new MapVO(5, mapData, heroVOMock);

        // WHEN
        underTest.printMap(mapVOMock);

        // THEN

    }

    @Test
    void testPrintMapShouldRunWhenGetNullMapVO() {
        // GIVEN
        MapVO mapVO = null;

        // WHEN
        underTest.printMap(mapVO);

        // THEN

    }

    @Test
    void testReadMapShouldRunWhenGetEmptyFile() throws FileNotFoundException {
        // Given
        File emptyFile = new File("C:\\Users\\Varga Zsolt\\IdeaProjects\\progTech\\wumpus\\src\\main\\resources\\map\\empty.txt");
        InputStream inputStream = new FileInputStream(emptyFile);

        // When - Then
        assertThrows(NullPointerException.class, () -> {
            underTest.readMap(inputStream);
        });
    }

    @Test
    void testReadMapShouldRunWhenTryingToRunWithNonExistentFile() {
        // Given
        File nonExistentFile = new File("C:\\Users\\Varga Zsolt\\IdeaProjects\\progTech\\wumpus\\src\\main\\resources\\map\\nonExistentFile.txt");

        // When - Then
        assertThrows(FileNotFoundException.class, () -> {
            InputStream inputStream = new FileInputStream(nonExistentFile);
            underTest.readMap(inputStream);
        });
    }

    @Test
    void testPrintMapShouldRunWhenGetInvalidHeroVO() {
        // Given
        HeroVO heroVOMock = new HeroVO('A', -1, 'W', 0, false, 1 , 'A');
        MapVO mapVOMock = new MapVO(5, new char[5][5], heroVOMock);

        // When
        underTest.printMap(mapVOMock.getHeroVO().getMapVO());

        // Then
    }


}