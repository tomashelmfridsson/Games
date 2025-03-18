import java.util.Random;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int currentNumber = 0;

        System.out.println("""
                Välkommen till spelet! Den som säger 21 vinner.
                Vi singlar slant om vem som börjar du är krona!
                """);
        int playerMove = random.nextInt(2) + 1;
        if (playerMove == 1) {
            System.out.println("Krona du börjar!");
        } else {
            System.out.println("klave datorn börjar!");
        }
        while (true) {
            if (playerMove == 1) {
                System.out.print("Lägg till 1 eller 2: ");
                int move = scanner.nextInt();
                while (move != 1 && move != 2) {
                    System.out.println("Ogiltigt val, försök igen.");
                    System.out.print("Lägg till 1 eller 2: ");
                    move = scanner.nextInt();
                }
                currentNumber += move;
                System.out.println("Du sa: " + currentNumber);

                if (currentNumber >= 21) {
                    System.out.println("Grattis! Du vinner!");
                    break;
                }
            }

            int computerMove = random.nextInt(2) + 1;
            currentNumber += computerMove;
            System.out.println("Datorn väljer: " + computerMove);
            System.out.println("Ställningen är: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println("Datorn vinner! Bättre lycka nästa gång.");
                break;
            }
        }
        scanner.close();
    }
}