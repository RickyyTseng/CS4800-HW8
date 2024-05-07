public class SnackSelection implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        Snack selectedSnack = vendingMachine.snacks.get(snackName);
        if (selectedSnack != null && selectedSnack.quantity > 0) {
            vendingMachine.selectedSnack = snackName;
            System.out.println(snackName + " selected.");
            vendingMachine.state = new WaitingForMoney();
        } else {
            System.out.println(snackName + " out of stock.");
            vendingMachine.state = new SnackSelection();
        }
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Please select a snack first.");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please select a snack first.");
    }
}
