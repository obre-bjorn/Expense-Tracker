import java.util.Calendar;
import java.util.Date;
// import java.util.Calendar;

public class Expense extends Transaction {

    
    private Category category;;
    private Date date;


    Expense(String description,double amount, Category category, Date expenseDate ){
        super(description, amount);
        this.category = category;
        this.date = expenseDate;
        // this.category.addExpense(amount);
    }

    // ^ Setters for Expense Object.

    // public void setAmount(int priceInput){
    //     this.amount = priceInput;

    // }

    // public void setCategory(Category categoryInput){

    //     this.category = categoryInput;
    // }
    

    // public void setDate(int yr, int mon, int day){

    //     this.date = new Date(yr,mon,day);

    // }

    public Date getDate(){
        return this.date;
    }

    public double getAmount(){
        return super.amount;
    }


    public String getName(){
        return  super.description;
    }


    public Category getCategory(){
        return this.category;
    }


   public static void main(String[] args) {
    
        Category food = new Category("Food");
        Category rent = new Category("Rent");

        Expense lunch = new Expense( "Bought Chapo and Beans", 120, food, new Date());
        Expense bnb = new Expense("Paid house rent", 11000, rent, new Date());

        System.out.println(lunch.getName() + " which was Ksh." + lunch.getAmount() );
        System.out.println(bnb.getName() + " which was Ksh." + bnb.getAmount() );

   }


}
