import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0;
        int choice1 = 1;
        int choice2 = 2;

        System.out.println("Välkommen till spelet! Den som säger 21 vinner.");
        System.out.println("Du börjar!");


        while (true) {
            int playerMove = 0;
            while (playerMove != choice1 && playerMove != choice2) {
                System.out.print("Säg " + choice1 + " eller " + choice2 + ": ");
                playerMove = scanner.nextInt();
                if (playerMove != choice1 && playerMove != choice2) {
                    System.out.println("Ogiltigt val, försök igen.");
                }
            }

            currentNumber += playerMove;
            System.out.println("Du sa: " + currentNumber);
            choice1 += 2;
            choice2 += 2;

            if (currentNumber >= 21) {
                System.out.println("Grattis! Du vinner!");
                break;
            }

            int computerMove = ((currentNumber+1) % 3) == 0 ? 1 : 2;
            currentNumber += computerMove;
            System.out.println("Datorn säger: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println("Datorn vinner! Bättre lycka nästa gång.");
                break;
            }
        }
        scanner.close();
    }
}
