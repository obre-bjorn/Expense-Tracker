import java.util.ArrayList;
import java.util.List;

public class CategoryList {


   private List <Category> Categories = new ArrayList<>();
    

    CategoryList(){
        
        this.addCategory(new Category("General"));
        this.addCategory(new Category("Entertainment"));
        this.addCategory(new Category("Travel"));
        this.addCategory(new Category("Medical"));


    }

    List<Category> getCategories(){
        return this.Categories;
    } 

    void addCategory(Category category){
        this.Categories.add(category);
    }


    public static void main(String[] args) {
        
        CategoryList Categories  = new CategoryList(); 
        System.out.println(Categories.getCategories());


    }
}