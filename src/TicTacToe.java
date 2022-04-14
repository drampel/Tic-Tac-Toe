public class TicTacToe {
    public static void main(String[] args) {
        System.out.print("Enter the name of the first player: ");
        PlayerData.firstPlayerName = PlayerData.sc.nextLine();
        System.out.print("Enter the name of the second player: ");
        PlayerData.secondPlayerName = PlayerData.sc.nextLine();
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);
        boolean gameStart = true;
        while (gameStart) {
            while (true) {
                playerMove(gameBoard, PlayerData.firstPlayerName);
                if (isGameOver(gameBoard)) {
                    break;
                }
                playerMove(gameBoard, PlayerData.secondPlayerName);
                if (isGameOver(gameBoard)) {
                    break;
                }
            }
            System.out.println("'" + PlayerData.firstPlayerName + "' player points: " + PlayerData.firstPlayerPoints);
            System.out.println("'" + PlayerData.secondPlayerName + "' player points: " + PlayerData.secondPlayerPoints);
            System.out.print("Do you want to play again? y/n: ");
            boolean incorrectInput = true;
            while (incorrectInput) {
                String result = PlayerData.sc.nextLine();
                switch (result.strip()) {
                    case "Y", "y" -> {
                        System.out.println("\n\"Let's play!\"");
                        resetBoard(gameBoard);
                        printGameBoard(gameBoard);
                        incorrectInput = false;
                    }
                    case "N", "n" -> {
                        System.out.print("\n\"Game over!\"");
                        incorrectInput = false;
                        gameStart = false;
                    }
                    default -> System.out.print("Enter either \"y\" or \"n\": ");
                }
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] board : gameBoard) {
            for (char b : board) {
                System.out.print(b);
            }
            System.out.println();
        }
    }

    public static void updateBoard(int position, String player, char[][] gameBoard) {
        char symbol = ' ';
        if (player.equalsIgnoreCase(PlayerData.firstPlayerName)) {
            symbol = 'X';
        } else if (player.equalsIgnoreCase(PlayerData.secondPlayerName)) {
            symbol = '0';
        }
        switch (position) {
            case 1 -> {
                gameBoard[0][0] = symbol;
                printGameBoard(gameBoard);
            }
            case 2 -> {
                gameBoard[0][2] = symbol;
                printGameBoard(gameBoard);
            }
            case 3 -> {
                gameBoard[0][4] = symbol;
                printGameBoard(gameBoard);
            }
            case 4 -> {
                gameBoard[2][0] = symbol;
                printGameBoard(gameBoard);
            }
            case 5 -> {
                gameBoard[2][2] = symbol;
                printGameBoard(gameBoard);
            }
            case 6 -> {
                gameBoard[2][4] = symbol;
                printGameBoard(gameBoard);
            }
            case 7 -> {
                gameBoard[4][0] = symbol;
                printGameBoard(gameBoard);
            }
            case 8 -> {
                gameBoard[4][2] = symbol;
                printGameBoard(gameBoard);
            }
            case 9 -> {
                gameBoard[4][4] = symbol;
                printGameBoard(gameBoard);
            }
        }
    }

    public static void playerMove(char[][] gameBoard, String player) {
        System.out.print("\nPlayer '" + player + "' enter a number from 1 to 9: ");
        int move = Integer.parseInt(PlayerData.sc.nextLine());
        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            System.out.print("Wrong move! Try again: ");
            move = Integer.parseInt(PlayerData.sc.nextLine());
            result = isValidMove(move, gameBoard);
        }
        updateBoard(move, player, gameBoard);
        System.out.println("'" + player + "' has chosen position: " + move);
    }

    public static boolean isValidMove(int move, char[][] gameBoard) {
        return switch (move) {
            case 1 -> gameBoard[0][0] == ' ';
            case 2 -> gameBoard[0][2] == ' ';
            case 3 -> gameBoard[0][4] == ' ';
            case 4 -> gameBoard[2][0] == ' ';
            case 5 -> gameBoard[2][2] == ' ';
            case 6 -> gameBoard[2][4] == ' ';
            case 7 -> gameBoard[4][0] == ' ';
            case 8 -> gameBoard[4][2] == ' ';
            case 9 -> gameBoard[4][4] == ' ';
            default -> false;
        };
    }

    public static boolean isGameOver(char[][] gameBoard) {
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[0][0] == '0' && gameBoard[0][2] == '0' && gameBoard[0][4] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[2][0] == '0' && gameBoard[2][2] == '0' && gameBoard[2][4] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }
        if (gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[4][0] == '0' && gameBoard[4][2] == '0' && gameBoard[4][4] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }

        if (gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[0][0] == '0' && gameBoard[2][0] == '0' && gameBoard[4][0] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }
        if (gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[0][2] == '0' && gameBoard[2][2] == '0' && gameBoard[4][2] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }
        if (gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[0][4] == '0' && gameBoard[2][4] == '0' && gameBoard[4][4] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }

        if (gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[0][0] == '0' && gameBoard[2][2] == '0' && gameBoard[4][4] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }
        if (gameBoard[4][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("'" + PlayerData.firstPlayerName + "' win!!!\n");
            ++PlayerData.firstPlayerPoints;
            return true;
        }
        if (gameBoard[4][0] == '0' && gameBoard[2][2] == '0' && gameBoard[0][4] == '0') {
            System.out.println("'" + PlayerData.secondPlayerName + "' win!!!\n");
            ++PlayerData.secondPlayerPoints;
            return true;
        }

        if (gameBoard[0][0] != ' ' && gameBoard[0][2] != ' ' && gameBoard[0][4] != ' ' && gameBoard[2][0] != ' ' &&
                gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ' && gameBoard[4][0] != ' ' && gameBoard[4][2] != ' '
                && gameBoard[4][4] != ' ') {
            System.out.println("\"The result is a draw!!!\"\n");
            return true;
        }
        return false;
    }

    public static void resetBoard(char[][] gameBoard) {
        gameBoard[0][0] = ' ';
        gameBoard[0][2] = ' ';
        gameBoard[0][4] = ' ';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
        gameBoard[4][0] = ' ';
        gameBoard[4][2] = ' ';
        gameBoard[4][4] = ' ';
    }
}