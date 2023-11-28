import java.util.Calendar;
import java.util.Date;
// import java.util.Calendar;

public class Expense {

    private int amount;
    private Category category;;
    private Date date;


    Expense(int amount, Category category, Date expenseDate ){

        this.amount = amount;
        this.category = category;
        this.date = expenseDate;

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



    public int getAmount(){
        return this.amount;
    }


    public Category getCategory(){
        return this.category;
    }


   

}
