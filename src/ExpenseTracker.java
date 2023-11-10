import java.util.Date;


/*  TO DO: 
    
    Remove the deprecated date method and use the Calender Object to get Year



*/


public class ExpenseTracker {

    public static void main(String[] args) {


        // ! Test: TO REMOVE!!!
        // ! Interchange Expense and Transaction classes



        // * Creating Transactions
        Transaction jaba = new Transaction();

        jaba.setAmount(100);
        jaba.setCategory("Anasa");
        jaba.setDate(2020,11,2);
        
        Date leo = jaba.getDate();

        System.out.println(jaba.getAmount() + " " +  jaba.getCategory() + " " + leo.getYear());


        // * Creating Expense (Holder for transactions)

        Expense expenses = new Expense();


        expenses.addTransaction(jaba);

        


        System.out.println(expenses.getTransactions().get(0).getCategory());
    }
    
}
