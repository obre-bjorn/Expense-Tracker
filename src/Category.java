import java.util.ArrayList;
import java.util.List;

public class Category extends Transaction {
    

    List<Expense> expenseList = new ArrayList<>();

    String name;
    double categoryTotal;
    
    
    Category(String name){
        
        super(name, 0);
        this.categoryTotal = 0;
    }


    void addExpense(Expense expense){
        this.categoryTotal += expense.getAmount();
        this.expenseList.add(expense);

    }

    String getCategoryName(){
        return super.description;
    }


    double getTotal(){
        return this.categoryTotal;
    }


}
