import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    Map<String, Snack> snacks;
    double moneyInserted;
    String selectedSnack;
    StateOfVendingMachine state;

    VendingMachine(Snack[] snacks) {
        this.snacks = new HashMap<>();
        for (Snack snack : snacks) {
            this.snacks.put(snack.name, snack);
        }
        this.moneyInserted = 0;
        this.state = new SnackSelection();
    }

    void selectSnack(String snackName) {
        state.selectSnack(this, snackName);
    }

    void insertMoney(double amount) {
        state.insertMoney(this, amount);
    }

    void dispenseSnack() {
        state.dispenseSnack(this);
    }
}