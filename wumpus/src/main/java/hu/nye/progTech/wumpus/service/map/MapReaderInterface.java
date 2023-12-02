package hu.nye.progTech.wumpus.service.map;

import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;

public interface MapReaderInterface {

    MapVO readMap() throws MapReaderException;
}
