import java.util.Date;
// * import java.util.Calendar;

public class Transaction {

    private int amount;
    private String category;;
    private Date date;


    public void setAmount(int priceInput){
        this.amount = priceInput;

    }

    public void setCategory(String categoryInput){

        this.category = categoryInput;
    }
    

    public void setDate(int yr, int mon, int day){

        this.date = new Date(yr,mon,day);

    }

    public Date getDate(){
        return this.date;
    }



    public int getAmount(){
        return this.amount;
    }


    public String getCategory(){
        return this.category;


    }


   

}
