package hu.nye.progTech.wumpus.model;

public class MapVo {
    class MazeBoard {
        private int size;               // Pálya mérete (NxN)
        private char[][] board;         // A pálya elemeit tároló karaktertömb
        private HeroVo hero;            // A játékos hőse

        public MazeBoard(int size) {
            this.size = size;
            board = new char[size][size];
        }

        public void placeElement(int row, int col, char element) {
            board[row][col] = element;
        }

        public char getElement(int row, int col) {
            return board[row][col];
        }

        public int getSize() {
            return size;
        }

        public HeroVo getHero() {
            return hero;
        }

        public void setHero(HeroVo hero) {
            this.hero = hero;
        }

        public boolean isGameOver() {
            // Ellenőrizd a játék végét (pl. a hős meghalt vagy összes aranyat megszerezte)
            // Implementáld a játék végét ellenőrző logikát
            return false; // Módosítsd a megfelelő feltételre
        }


        // További metódusok a játékmenet irányításához

    }
}
