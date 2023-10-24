package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.service.exception.MapReaderException;

import java.util.List;

public interface MapReaderInterface {

    List<String> readMap() throws MapReaderException;
}
