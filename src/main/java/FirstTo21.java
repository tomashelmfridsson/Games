import java.util.Random;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int currentNumber = 0;

            //spelpjäser
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String bold = "\u001B[1m";

        System.out.println("""
                Välkommen till spelet! Den som säger 21 vinner.
                Vi singlar slant om vem som börjar du är krona!
                """);
        int playerMove = random.nextInt(2) + 1;
        if (playerMove == 1) {
            System.out.println("Krona du börjar!"+reset);
        } else {
            System.out.println("Klave datorn börjar!"+reset);
        }
        while (true) {
            if (playerMove == 1) {
                System.out.print("Lägg till 1 eller 2: "+reset);
                int move = scanner.nextInt();
                while (move != 1 && move != 2) {
                    System.out.println("Ogiltigt val, försök igen."+reset);
                    System.out.print("Lägg till 1 eller 2: "+reset);
                    move = scanner.nextInt();
                }
                currentNumber += move;
                System.out.println(green +"Du sa: " + move +reset);
                System.out.println(bold+"Ställningen är: " + currentNumber+reset);

                if (currentNumber >= 21) {
                    System.out.println(green +"Grattis! Du vinner!"+reset);
                    break;
                }
            }
            System.out.print(red + "Datorn tänker");
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(".");
            }
            System.out.println(reset);
            int computerMove = random.nextInt(2) + 1;
            currentNumber += computerMove;
            System.out.println(red + "Datorn väljer: " + computerMove + reset);
            System.out.println(bold+"Ställningen är: " + currentNumber+reset);

            if (currentNumber >= 21) {
                System.out.println(red +"Datorn vinner! Bättre lycka nästa gång." + reset);
                break;
            }
            playerMove=1;

        }
        scanner.close();
    }
}