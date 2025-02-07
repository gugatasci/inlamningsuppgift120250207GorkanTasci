package inllamningsuppgift1;

import java.util.Scanner;
//MorseCodeApp: Main-klassen som hanterar in- och utmatning.

public class MorseCodeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj ett alternativ:");
        System.out.println("1: Omvandla engelska till morsekod");
        System.out.println("2: Omvandla morsekod till engelska");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Skriv in text: ");
            String text = scanner.nextLine();
            System.out.println("Morsekod: " + MorseCodeConverter.toMorse(text));
        } else if (choice == 2) {
            System.out.print("Skriv in morsekod: ");
            String morse = scanner.nextLine();
            System.out.println("Engelska: " + MorseCodeConverter.toEnglish(morse));
        } else {
            System.out.println("Ogiltigt val.");
        }

        scanner.close();
    }
}
