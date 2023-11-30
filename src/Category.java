import java.util.List;

public class Category extends Transaction {
    

    List<Expense> expenseList;

    String name;
    double categoryTotal;
    
    
    Category(String name){
        
        super(name, 0);
        this.categoryTotal = 0;
    }


    void addExpense(double amount){
        this.categoryTotal += amount;

    }

    String getCategoryName(){
        return this.name;
    }


    double getTotal(){
        return this.categoryTotal;
    }


}
