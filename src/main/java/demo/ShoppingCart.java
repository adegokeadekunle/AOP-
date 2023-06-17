package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String status){
        System.out.println("checked out ");
    }
    public int quantity(){
        return 2;
    }
}
