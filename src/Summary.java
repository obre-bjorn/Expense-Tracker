 public class Summary {
    double totalAmountSpent;

    public Summary() {
        this.totalAmountSpent = 0;
    }

    public void updateTotalAmount(double amount) {
        this.totalAmountSpent += amount;
    }
}


