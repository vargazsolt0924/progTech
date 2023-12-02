package hu.nye.progTech.wumpus.service.map;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;

public class MapWriter {

    public static void mapPrinter(MapVO mapVO) {

        char[][] mapData = mapVO.getMap();

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

    public static void printMapAndHeroDetails(MapVO map) {
        if (map == null) {
            System.out.println("map is null");
            return;
        }
        MapWriter.mapPrinter(map);
        HeroVO heroVO = map.getHeroVO();
        if (heroVO == null) {
            System.out.println("hero is null");
            return;
        }
        System.out.println("Ennyi nyillal rendelkezik jelenleg a hős: " + map.getHeroVO().getArrows());
        System.out.println("Ebbe az irányba áll a hős: " + map.getHeroVO().getDirection());
    }

}


