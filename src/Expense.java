import java.util.List;
import java.util.ArrayList;

public class Expense {

    private List<Transaction> transactions = new ArrayList<>() ; 
    
    
    public void addTransaction(Transaction transaction){

        this.transactions.add(transaction); 
    
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }
    
}
