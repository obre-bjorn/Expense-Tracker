import java.util.Date;

public class Transaction {

    private int amount;
    private String category;;
    private Date month;


    public void setAmount(int priceInput){
        this.amount = priceInput;

    }

    public void setCategory(String categoryInput){

        this.category = categoryInput;
    }

    public int getAmount(){
        return this.amount;
    }


    public String getCategory(){
        return this.category;


    }


   

}
