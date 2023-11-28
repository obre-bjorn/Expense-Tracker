public class Category {
    
    private String name;
    private double total;
    
    
    Category(String name){
        this.name = name;
        this.total = 0;
    }


    void addExpense(double amount){
        this.total += amount;

    }

    String getCategoryName(){
        return this.name;
    }


    double getTotal(){
        return this.total;
    }


}
