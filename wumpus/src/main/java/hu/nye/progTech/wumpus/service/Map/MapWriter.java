package hu.nye.progTech.wumpus.service.Map;


import hu.nye.progTech.wumpus.model.MapVO;

public class MapWriter {

    public void mapPrinter(MapVO mapVo) {
        char[][] mapData = mapVo.getMap();
        int rowCount = 1;

        System.out.print("  ");

        for (char c = 'A'; c < 'A' + mapData[0].length; c++) {
            System.out.print(" " + c);
        }
        System.out.println();

        for (char[] row : mapData) {
            System.out.print(rowCount + " ");
            rowCount++;
            for (char cell : row) {
                System.out.print(" " + cell);
            }
            System.out.println();
        }
    }

}


