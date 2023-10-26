package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.MapVo;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;

public interface MapReaderInterface {

    MapVo readMap() throws MapReaderException;
}
