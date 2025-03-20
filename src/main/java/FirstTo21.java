import java.util.Random;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int currentNumber = 0;

        System.out.println("Witness me! Ibrahim was here!!");

        System.out.println("Välkommen till spelet! Den som säger 21 vinner.");
        System.out.println("Du börjar!");
            //spelpjäser
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String bold = "\u001B[1m";

        boolean taunt10 = false;
        boolean taunt18 = false;

        System.out.println("""
                Välkommen till spelet! Den som säger 21 vinner.
                Vi singlar slant om vem som börjar, du är krona!
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

                if (currentNumber >= 10 && currentNumber < 13 && !taunt10) {
                    String taunt = (red + "Datorn: Haha, detta är bara uppvärmning!" + reset);
                    for (int i = 0; i < taunt.length(); i++) {
                        System.out.print(taunt.charAt(i));
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                    taunt10 = true;
                }

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

            if (currentNumber >= 19 && currentNumber < 21 && !taunt18) {
                System.out.println();
                System.out.println(red + "Datorn: Det är omöjligt för dig att vinna nu!" + reset);
                taunt18 = true;
            }
            System.out.println(reset);
            if (currentNumber<19) {
                int computerMove = random.nextInt(2) + 1;
                currentNumber += computerMove;
                System.out.println(red + "Datorn väljer: " + computerMove + reset);
                System.out.println(bold + "Ställningen är: " + currentNumber + reset);
            }else {
                currentNumber = currentNumber + 2;
                System.out.println(red + "Datorn väljer: 2" + reset);
                System.out.println(bold + "Ställningen är: " + currentNumber + reset);
            }


            if (currentNumber >= 21) {
                System.out.println("Datorn vann!! Bättre lycka nästa gång");
                break;
            }
            playerMove=1;

        }
        scanner.close();
    }
}
