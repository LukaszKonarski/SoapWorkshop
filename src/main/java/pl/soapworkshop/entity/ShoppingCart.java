package pl.soapworkshop.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope("session")
public class ShoppingCart {

    private List<Product> cartContents = new ArrayList<>();

    @ManyToOne
    private Shipment shipment = new Shipment();

    public List<Product> getCartContents() {
        return cartContents;
    }

    public void setCartContents(List<Product> cartContents) {
        this.cartContents = cartContents;
    }

    public Shipment getShipment() { return shipment; }

    public void setShipment(Shipment shipment) { this.shipment = shipment; }
}
