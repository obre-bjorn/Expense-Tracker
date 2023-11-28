import java.util.Date;

/*  TO DO: 
    
    Remove the deprecated date method and use the Calender Object to get Year

*/


public class ExpenseTracker {

    public static void main(String[] args) {


        // ! Tests: TO REMOVE!!!
        // ! Interchange Expense and Transaction classes


        CategoryList categoryListInstance  = new CategoryList();


        Category general = categoryListInstance.getCategories().get(0);


        // * Creating Transactions
        Expense jaba = new Expense(100,general,new Date(2020,11,2));

       
        
        Date leo = jaba.getDate();

        System.out.println(jaba.getAmount() + " " +  jaba.getCategory().getCategoryName() + " " + leo.getYear());


        // * Creating Expense (Holder for transactions)

        ExpenseList expenses = new ExpenseList();


        expenses.addTransaction(jaba);

        


        // System.out.println(expenses.getTransactions().get(0).getCategory());
    }
    
}
