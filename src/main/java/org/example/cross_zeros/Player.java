package org.example.cross_zeros;

public class Player{

    private String name;
    private String chip;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }
}
