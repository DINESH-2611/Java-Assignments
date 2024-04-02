package abstractclassandmethods;

import java.util.ArrayList;
import java.util.List;

abstract public class Product {
    private String description;
    private double price;

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescriptions() {
        return description;
    }

    public double getPrices() {
        return price;
    }
    public abstract double getPrice();
    public abstract String getDescription();

    @Override
    public String toString() {
        return "Description='" + description + '\'' +
                ", Price=" + price ;
    }
}
class ElectronicsProducts extends Product{
    public ElectronicsProducts(String description, double price) {
        super(description, price);
    }

    @Override
    public double getPrice() {
        return getPrices();
    }

    @Override
    public String getDescription() {
        return getDescriptions();
    }
}
class ClothingProduct extends Product{
    public ClothingProduct(String description, double price) {
        super(description, price);
    }

    @Override
    public double getPrice() {
        return getPrices();
    }

    @Override
    public String getDescription() {
        return getDescriptions();
    }
}
class BookProduct extends Product{
    public BookProduct(String description, double price) {
        super(description, price);
    }

    @Override
    public double getPrice() {
        return getPrices();
    }

    @Override
    public String getDescription() {
        return getDescriptions();
    }

}
class Shopping {
    private List<Product> productList;

    public Shopping() {
        productList=new ArrayList<>();
    }
    public void addProduct(Product product){
        productList.add(product);
    }
    public double totalPrice(){
        double totalPrice=0;
        for(Product product:productList){
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }
    public void diplayProduct(){
        for (Product product:productList){
            System.out.println(product);
        }
    }
}
class ProductDriver{
    public static void main(String[] args) {
        Product product1=new ElectronicsProducts("Iphone",75000);
        Product product2=new ClothingProduct("Cargo pant",1000);
        Product product3=new BookProduct("Java Complete reference ",500);
        Shopping shopping=new Shopping();
        shopping.addProduct(product1);
        shopping.addProduct(product2);
        shopping.addProduct(product3);
        shopping.diplayProduct();
        System.out.println("Total price-->"+shopping.totalPrice());
    }


}

