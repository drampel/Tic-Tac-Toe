import java.util.Scanner;

public class PlayerData {
    public static String firstPlayerName = "";
    public static String secondPlayerName = "";
    public static int firstPlayerPoints = 0;
    public static int secondPlayerPoints = 0;
    public static Scanner sc;

    public PlayerData() {
    }

    static {
        sc = new Scanner(System.in);
    }
}