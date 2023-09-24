package org.example.cross_zeros;

public class Field {
    private String[][] field = {{"•", "•", "•"},
                                {"•", "•", "•"},
                                {"•", "•", "•"}};

    public String[][] getField() {
        return field;
    }

    public void printField() {
        for (int i = 0; i <=3; i++) {
            if (i == 0) {
                System.out.print("*|");
            } else {
                System.out.print(i + "|");
            }
        }
        System.out.println();
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length + 1; j++) {
                if (j == 0) {
                    System.out.print(i + 1);
                } else {
                    System.out.print(this.field[i][j-1]);
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
