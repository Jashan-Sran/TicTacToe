package com.durgaSoftwareUdemy;

import java.util.*;

public class TicTacToeMain {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        gameboard(gameBoard);

        Scanner scr = new Scanner(System.in);


        while (true) {
            System.out.println("Enter the number between (1-9) ");
            int playerPos = scr.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken , Enter the Correct Position .");
                playerPos = scr.nextInt();
            }
            System.out.println(playerPos);
            placePosition(gameBoard, playerPos, "Player");
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int CpuPos = rand.nextInt(10);
            while (playerPositions.contains(CpuPos) || cpuPositions.contains(CpuPos)) {
                CpuPos = rand.nextInt(10);
            }
            placePosition(gameBoard, CpuPos, "CPU");
            gameboard(gameBoard);
            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

        }
    }

    public static void gameboard(char[][] gameBoard) {
        for (char[] draw : gameBoard) {
            System.out.println(draw);
        }
    }

    public static void placePosition(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("Player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("CPU")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;

        }
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List rightCol = Arrays.asList(3, 6, 9);
        List midCol = Arrays.asList(2, 5, 8);
        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(rightCol);
        winning.add(midCol);
        winning.add(diag1);
        winning.add(diag2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations You Win !!! ";
            } else if (cpuPositions.containsAll(l)) {
                return " CPU Win !!";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Draw!!";
            }
        }
        return "";
    }
}

