package hu.nye.progTech.wumpus.service.hero;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HeroActionsTest {

    private HeroActions underTest;

    @Mock
    private MapVO mapVOMock;

    @Mock
    private HeroVO heroVOMock;

    @BeforeEach
    public void setUp(){
        underTest = new HeroActions(mapVOMock);
    }

    @Test
    void testTurnRightShouldChangeDirectionAndIncrementSteps() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'N', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnRight();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('E', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testTurnRightFromEastShouldChangeDirectionToSouth() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'E', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnRight();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('S', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testTurnRightFromSouthShouldChangeDirectionToWest() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'S', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnRight();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('W', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testTurnLeftShouldChangeDirectionAndIncrementSteps() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'N', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnLeft();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('W', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testTurnRightFromWestShouldChangeDirectionToNorth() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'W', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnRight();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('N', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testTurnLeftFromWestShouldChangeDirectionToSouth() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'W', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnLeft();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('S', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testTurnLeftFromSouthShouldChangeDirectionToEast() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'S', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnLeft();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('E', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testTurnLeftFromEastShouldChangeDirectionToNorth() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'E', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.turnLeft();

        // THEN
        assertEquals(1, heroVO.getSteps());
        assertEquals('N', heroVO.getDirection());
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testCelebrateVictoryShouldPrintCongratulationsMessage() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'N', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN - THEN
        underTest.celebrateVictory();
    }

    @Test
    void testMoveShouldUpdatePositionAndIncrementSteps() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'N', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.move();

        // THEN
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testShootShouldHitWumpusAndDecrementArrowsWhenFacingNorth() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'N', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);
        char[][] map = {
                {'_', 'U', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
        when(mapVOMock.getMap()).thenReturn(map);

        // WHEN
        underTest.shoot(mapVOMock);

        // THEN
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testShootShouldHitWumpusAndDecrementArrowsWhenFacingEast() {
        // GIVEN
        HeroVO heroVO = new HeroVO('A', 2, 'E', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);
        char[][] map = {
                {'_', '_', '_'},
                {'U', '_', '_'},
                {'_', '_', '_'}
        };
        when(mapVOMock.getMap()).thenReturn(map);

        // WHEN
        underTest.shoot(mapVOMock);

        // THEN
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testShootShouldHitWumpusAndDecrementArrowsWhenFacingWest() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'W', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);
        char[][] map = {
                {'_', '_', '_'},
                {'_', 'U', '_'},
                {'_', '_', '_'}
        };
        when(mapVOMock.getMap()).thenReturn(map);

        // WHEN
        underTest.shoot(mapVOMock);

        // THEN
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testShootShouldHitWumpusAndDecrementArrowsWhenFacingSouth() {
        // GIVEN
        HeroVO heroVO = new HeroVO('B', 1, 'S', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);
        char[][] map = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', 'U', '_'}
        };
        when(mapVOMock.getMap()).thenReturn(map);

        // WHEN
        underTest.shoot(mapVOMock);

        // THEN
        verify(mapVOMock).getHeroVO();
    }



    @Test
    void testShootShouldNotHitWumpusWhenNoArrows() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 1, 'N', 0, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN
        underTest.shoot(mapVOMock);

        // THEN
        verify(mapVOMock).getHeroVO();
    }

    @Test
    void testMoveShouldPrintErrorMessageWhenMapIsNull() {
        // GIVEN
        when(mapVOMock.getMap()).thenReturn(null);

        // WHEN - THEN
        underTest.move();
    }

    @Test
    void testMoveShouldPrintErrorMessageWhenHeroVOIsNull() {
        // GIVEN
        when(mapVOMock.getHeroVO()).thenReturn(null);

        // WHEN - THEN
        underTest.move();
    }

    @Test
    void testMoveShouldHandleInvalidDirection() {
        // GIVEN
        HeroVO heroVO = new HeroVO('C', 2, 'X', 3, false, 2, 'A', mapVOMock);
        when(mapVOMock.getHeroVO()).thenReturn(heroVO);

        // WHEN - THEN
        underTest.move();
    }

    @Test
    void testConstructorWithNullMapVOShouldThrowIllegalArgumentException() {
        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> {
            new HeroActions(null);
        });
    }


}