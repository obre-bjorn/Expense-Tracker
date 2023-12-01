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

     public Category  getCategory(String categoryName){
        
        for(Category category : this.Categories){
            if(category.getCategoryName().equalsIgnoreCase(categoryName)){
                return category;
            }
            
        }

        return null;

     }

    public static void main(String[] args) {
        


    }
}