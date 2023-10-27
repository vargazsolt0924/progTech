package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class BufferedMapReaderTest {

    private BufferedMapReader underTest;

    @Mock
    private BufferedReader bufferedReaderMock;

    @BeforeEach
    public void setUp(){
        underTest = new BufferedMapReader(bufferedReaderMock);
    }

    @Test
    void testReadMapShouldReturnRowsReadFromBufferedReader() throws IOException, MapReaderException {
        // GIVEN
        given(bufferedReaderMock.readLine()).willReturn("4 A 2 N", "PWWU", "UUWP", "WUUP", "UWWP");
        // WHEN
        MapVO result = underTest.readMap();
        // THEN
        assertNotNull(result);
    }



    @Test
    void testReadMapWhenEncountersIOExceptionsWillThrowCustomException() throws IOException {
        // GIVEN
        doThrow(IOException.class).when(bufferedReaderMock).readLine();

        // WHEN - THEN
        MapReaderException exception = assertThrows(MapReaderException.class, () -> {
            underTest.readMap();
        });
        assertEquals("Sikertelen térkép beolvasás", exception.getMessage());
    }

}