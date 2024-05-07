public class WaitingForMoney implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("You have already selected a snack.");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        vendingMachine.moneyInserted += amount;
        System.out.println("Money inserted: $" + amount);
        if (vendingMachine.moneyInserted >= vendingMachine.snacks.get(vendingMachine.selectedSnack).price) {
            vendingMachine.state = new DispensingSnack();
        }
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please insert money first.");
    }
}