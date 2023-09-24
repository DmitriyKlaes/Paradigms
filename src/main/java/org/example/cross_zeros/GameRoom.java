package org.example.cross_zeros;

import java.util.Random;
import java.util.Scanner;

public class GameRoom {
    private static Scanner scn = new Scanner(System.in);
    private static Random rnd = new Random();
    private Player firstPlayer;
    private Player secondPlayer;
    private Field field;

    public GameRoom() {
        initGame();
        this.field = new Field();

    }

    private void initGame() {
        System.out.println("Введите имя первого игрока: ");
        String firstPlayerName = scn.nextLine();
        System.out.println("Введите имя второго игрока: ");
        String secondPlayerName = scn.nextLine();
        this.firstPlayer = new Player(firstPlayerName);
        this.secondPlayer = new Player(secondPlayerName);
    }


    public void startGame() {
        chipIdentification();
        Player player1;
        Player player2;
        if (this.firstPlayer.getChip().equals("X")) {
            player1 = this.firstPlayer;
            player2 = this.secondPlayer;
        } else {
            player1 = this.secondPlayer;
            player2 = this.firstPlayer;
        }
        System.out.println("Для прерывания игры введите *");
        int count = 9;
        while (true) {
            System.out.println("Ходит " + player1.getName() + "-[X]");
            this.field.printField();
            move(player1);
            count--;
            if (winCheck(player1, count)) {
                this.field.printField();
                break;
            }
            System.out.println("Ходит " + player2.getName() + "-[O]");
            this.field.printField();
            move(player2);
            count--;
            if (winCheck(player2, count)) {
                this.field.printField();
                break;
            }
        }
    }

    private void chipIdentification() {
        int crossIs = rnd.nextInt(2);
        if (crossIs == 0) {
            this.firstPlayer.setChip("X");
            this.secondPlayer.setChip("O");
            System.out.println(firstPlayer.getName() + " [X] ходит первый");
        } else {
            this.secondPlayer.setChip("X");
            this.firstPlayer.setChip("O");
            System.out.println(secondPlayer.getName() + " [X] ходит первый");
        }
    }

    private void move(Player player) {
        int[] cellCords = new int[2];
        boolean f = true;
        while(f) {
            String cell = scn.nextLine();
            if (cell.equals("*")) {
                System.out.println("Игра прервана, до встречи!");
                System.exit(1);
            }
            try {
                String cordCell = cell.replaceAll("\\s", "");
                if (cordCell.length() != 2) {
                    throw new Exception("Неверный формат координат ячейки!");
                }
                try {
                    int cord = Integer.parseInt(cordCell);
                    cellCords[0] = cord / 10;
                    cellCords[1] = cord % 10;
                    if(cellCords[0] > 3 || cellCords[1] > 3) {
                        throw new Exception("Поле 3х3. Выберете координаты ячейки в его пределах");
                    }
                    if(this.field.getField()[cellCords[1] - 1][cellCords[0] - 1].equals("•")) {
                        this.field.getField()[cellCords[1] - 1][cellCords[0] - 1] = player.getChip();
                        f = false;
                    } else {
                        throw new Exception("Ячейка занята, выберете другую");
                    }
                } catch (NumberFormatException e) {
                    throw new Exception("Вводить можно только числовые параметры");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                this.field.printField();
            }
        }
    }

    private boolean winCheck(Player player, int count) {
        if (this.field.getField()[0][0].equals(player.getChip()) &&
            this.field.getField()[0][1].equals(player.getChip()) &&
            this.field.getField()[0][2].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (this.field.getField()[1][0].equals(player.getChip()) &&
                   this.field.getField()[1][1].equals(player.getChip()) &&
                   this.field.getField()[1][2].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (this.field.getField()[2][0].equals(player.getChip()) &&
                   this.field.getField()[2][1].equals(player.getChip()) &&
                   this.field.getField()[2][2].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (this.field.getField()[0][0].equals(player.getChip()) &&
                   this.field.getField()[1][0].equals(player.getChip()) &&
                   this.field.getField()[2][0].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (this.field.getField()[0][1].equals(player.getChip()) &&
                   this.field.getField()[1][1].equals(player.getChip()) &&
                   this.field.getField()[2][1].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (this.field.getField()[0][2].equals(player.getChip()) &&
                   this.field.getField()[1][2].equals(player.getChip()) &&
                   this.field.getField()[2][2].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (this.field.getField()[0][0].equals(player.getChip()) &&
                   this.field.getField()[1][1].equals(player.getChip()) &&
                   this.field.getField()[2][2].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (this.field.getField()[2][0].equals(player.getChip()) &&
                   this.field.getField()[1][1].equals(player.getChip()) &&
                   this.field.getField()[0][2].equals(player.getChip())) {
            System.out.println(player.getName() + " ПОБЕДИЛ!");
            return true;
        } else if (count == 0) {
            System.out.println("НИЧЬЯ");
            return true;
        }
        return false;
    }
}
