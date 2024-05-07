public class DispensingSnack implements StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("Snack dispensing in progress. Please wait.");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Snack dispensing in progress. Please wait.");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        Snack snack = vendingMachine.snacks.get(vendingMachine.selectedSnack);
        if (snack.quantity > 0 && vendingMachine.moneyInserted >= snack.price) {
            snack.quantity--;
            vendingMachine.moneyInserted -= snack.price;
            System.out.println("Dispensing " + snack.name);
        } else {
            System.out.println("Insufficient quantity or money. Please try again.");
        }
        vendingMachine.state = new SnackSelection();
    }
}
