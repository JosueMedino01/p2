package class_25_02_10;

import java.util.ArrayList;

public class ShoppingCart {
    private int customerID;
    private ArrayList<Product> productList;

    public ShoppingCart() {}

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
       int index = this.productList.indexOf(product);
       if(index != -1) {
        this.productList.remove(index);  
       }
    }

    public String getContents() {
        if (productList.isEmpty()) {
            return "O carrinho está vazio.";
        }

        String items = new String();

        for (int i = 0; i < this.getItemCount(); i++) {
            items += this.productList.get(i).getName() + "\n";
        }

        return items;
    }

    public int getCustomerID() {
        return this.customerID;
    }
    public int getItemCount() {
        return this.productList.size();
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : this.productList) {
            total += product.getPrice();
        }
        return total;
    }
}
