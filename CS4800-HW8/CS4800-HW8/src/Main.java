import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Snack[] snacks = {
                new Snack("Coke", 1.25, 5),
                new Snack("Pepsi", 1.25, 3),
                new Snack("Cheetos", 1.5, 1),
                new Snack("Doritos", 1, 0),
                new Snack("KitKat", .75, 4),
                new Snack("Snickers", .5, 2)
        };

        VendingMachine vendingMachine = new VendingMachine(snacks);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Available snacks:");
            for (Snack snack : snacks) {
                System.out.println(snack.name + " - Price: $" + snack.price + " - Quantity: " + snack.quantity);
            }

            System.out.print("Please select a snack: ");
            String selectedSnack = scanner.nextLine();
            vendingMachine.selectSnack(selectedSnack);

            if (vendingMachine.state instanceof SnackSelection) {
                continue;
            }

            try {
                System.out.print("Please insert money: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();  // Consume newline
                vendingMachine.insertMoney(amount);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.nextLine();  // Consume newline
                continue;
            }

            vendingMachine.dispenseSnack();

            System.out.println("Updated inventory:");
            for (Snack snack : snacks) {
                System.out.println(snack.name + " - Quantity: " + snack.quantity);
            }

            System.out.print("Do you want to continue (yes/no)? ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}