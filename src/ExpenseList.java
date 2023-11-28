import java.util.List;
import java.util.ArrayList;

public class ExpenseList {

    private List<Expense> transactions = new ArrayList<>() ; 
    
    
    public void addTransaction(Expense transaction){

        this.transactions.add(transaction); 
    
    }

    public List<Expense> getAllTransactions(){

        return this.transactions;
        
    }

    public List<Expense> getTransactionByCategory(String categoryName){


        List<Expense> allExpenses  = this.getAllTransactions();
        List<Expense> categoryTransactions;


        
        for(int expenseIndex = 0 ; expenseIndex < allExpenses.size(); expenseIndex++ ){


            if (allExpenses.get())

        }



        return categoryTransactions;
    }


    
}
