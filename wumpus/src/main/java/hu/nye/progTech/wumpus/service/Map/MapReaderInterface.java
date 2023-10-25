package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.MapVo;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;

import java.util.List;

public interface MapReaderInterface {

    MapVo readMap() throws MapReaderException;
}
