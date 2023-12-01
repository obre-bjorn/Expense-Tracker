import java.util.Date;

public class ExpenseTracker {
    public CategoryList categories;
    public Summary summary;


    ExpenseTracker(){

        this.categories =  new CategoryList();
        this.summary =  new Summary();

    }


    boolean addExpense(String expenseDescription, double amount, Category category,Date date){

        Expense newExpense = new Expense(expenseDescription, amount,category, date);
        category.addExpense(newExpense);
        summary.updateTotalAmount(amount);

        return true;
    }

    public boolean addCategory(String categoryName){

        Category newCategory = new Category(categoryName);
        categories.addCategory(newCategory);
        // System.out.println(categories.getCategories());

        return true;

    }

    public static void main(String[] args) {

        ExpenseTracker expenseTracker = new ExpenseTracker();

        new Main(expenseTracker);

        

        // System.out.println("New ");
    }
    
}
