package hu.nye.progTech.wumpus.service.Map;

import java.util.List;

public class MapWriter {

    public void mapPrinter(List<String> mapData) {
        int rowCount = 1;

        System.out.print("  ");

        for (char c = 'A'; c < 'A' + mapData.get(0).length(); c++) {
            System.out.print(" " + c);
        }
        System.out.println();

        for (String line : mapData) {
            System.out.print(rowCount + " ");
            rowCount++;
            for (char c : line.toCharArray()) {
                System.out.print(" " + c);
            }
            System.out.println();
        }
    }

}

