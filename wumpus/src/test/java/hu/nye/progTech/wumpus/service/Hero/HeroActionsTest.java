package hu.nye.progTech.wumpus.service.Hero;


import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

}