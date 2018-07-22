package pl.soapworkshop.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope("session")
public class ShoppingCart {

    private List<Product> cartContents = new ArrayList<>();

    public List<Product> getCartContents() {
        return cartContents;
    }

    public void setCartContents(List<Product> cartContents) {
        this.cartContents = cartContents;
    }

}
