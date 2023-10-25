package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.MapVo;


public class MapWriter {

    public void mapPrinter(MapVo mapData) {
        int rowCount = 1;

        System.out.print("  ");

        for (char c = 'A'; c < 'A' + mapData.getNumberOfColumns(); c++) {
            System.out.print(" " + c);
        }
        System.out.println();

        String[][] map = mapData.getMap();
        for (String[] row : map) {
            System.out.print(rowCount + " ");
            rowCount++;
            for (String cell : row) {
                String[] elements = cell.split(""); // A pályaelemeket szétválasztjuk itt
                for (String element : elements) {
                    System.out.print(" " + element);
                }
            }
            System.out.println();
        }
    }

}


