package hu.nye.progTech.wumpus.service.map;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;

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
                {'W', 'W', 'W', 'W', 'W'},
                {'W', '_', '_', 'U', 'W'},
                {'W', 'G', '_', 'P', 'W'},
                {'W', '_', '_', 'P', 'W'},
                {'W', 'W', 'W', 'W', 'W'}
        };

        heroVOMock = new HeroVO('A', 0, 'W', 0, false, 0, 'A');
        mapVOMock = new MapVO(5, mapData, heroVOMock);

        // WHEN - THEN
        underTest.printMap(mapVOMock);
    }

    @Test
    void testPrintMapShouldRunWhenGetNullMapVO() {
        // GIVEN
        MapVO mapVO = null;

        // WHEN - Then
        underTest.printMap(mapVO);
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
        HeroVO heroVOMock = new HeroVO('A', -1, 'W', 0, false, 1, 'A');
        MapVO mapVOMock = new MapVO(5, new char[5][5], heroVOMock);

        // When - Then
        underTest.printMap(mapVOMock.getHeroVO().getMapVO());
    }


    @Test
    void testReadMapShouldRunSuccessfullyWithValidFile() {
        // Given
        File validFile = new File("C:\\Users\\Varga Zsolt\\IdeaProjects\\progTech\\wumpus\\src\\main\\resources\\map\\wumpuszinput.txt");

        try {
            InputStream inputStream = new FileInputStream(validFile);

            // When
            MapVO result = underTest.readMap(inputStream);

            // Then
            assertNotNull(result);
        } catch (FileNotFoundException e) {
            fail("Test setup failed: valid map file not found");
        }
    }

    @Test
    void testPrintMapShouldRunSuccessfullyWithLargeMap() {
        // Given
        char[][] largeMapData = new char[100][100];

        HeroVO heroVOMock = new HeroVO('A', 0, 'W', 0, false, 0, 'A');
        MapVO largeMapVO = new MapVO(100, largeMapData, heroVOMock);

        // When - Then
        underTest.printMap(largeMapVO);
    }

    @Test
    void testPrintMapShouldRunSuccessfullyWithNullHeroVO() {
        // Given
        MapVO mapVOWithNullHero = new MapVO(5, new char[5][5], null);

        // When - Then
        underTest.printMap(mapVOWithNullHero);
    }

    @Test
    void testPrintMapShouldRunSuccessfullyWithSpecificElements() {
        // Given
        char[][] specificMapData = {
                {'A', ' ', 'W', 'N', 'P'},
                {'P', 'W', 'W', 'U', 'P'},
                {'U', 'W', 'U', 'U', 'U'},
                {'W', 'U', 'U', '?', 'W'},
                {'!', 'W', '"', 'U', 'P'}
        };

        HeroVO heroVOMock = new HeroVO('A', 0, 'W', 0, false, 0, 'A');
        MapVO specificMapVO = new MapVO(5, specificMapData, heroVOMock);

        // When - Then
        underTest.printMap(specificMapVO);
    }

    @Test
    void testReadMapShouldRunWhenGetNullInputStream() {
        // Given
        InputStream inputStream = null;

        // When - Then
        assertThrows(NullPointerException.class, () -> {
            underTest.readMap(inputStream);
        });
    }

    @Test
    void testPrintMapShouldRunWhenGetMapWithSpecificNumberOfElements() {
        // Given
        char[][] mapData = new char[10][10];
        HeroVO heroVOMock = new HeroVO('A', 0, 'W', 0, false, 0, 'A');
        MapVO mapVOMock = new MapVO(10, mapData, heroVOMock);

        // When - Then
        underTest.printMap(mapVOMock);
    }

}
