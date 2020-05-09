package com.sonyjop.games;

import com.sonyjop.games.util.Sudoku;

public class Application {
    private int size;

    
    public static void main(String[] args) {
        Application app = new Application();
        app.setSize(9);
        Sudoku su = new Sudoku(app.getSize());

        su.intialize();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}