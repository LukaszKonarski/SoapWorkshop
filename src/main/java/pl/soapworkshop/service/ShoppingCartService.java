package pl.soapworkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.soapworkshop.entity.*;
import pl.soapworkshop.repository.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.ListIterator;

@Service
@Scope("request")
public class ShoppingCartService {

    private ShoppingCart shoppingCart;
    private OrderRepository orderRepository;
    private ShipmentRepository shipmentRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ShoppingCartService(ShoppingCart shoppingCart, OrderRepository orderRepository, ShipmentRepository shipmentRepository,
                               AddressRepository addressRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.shoppingCart = shoppingCart;
        this.orderRepository = orderRepository;
        this.shipmentRepository = shipmentRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getCart() {
        return shoppingCart.getCartContents();
    }

    public void addToCart(Product product) {
        List<Product> cart = shoppingCart.getCartContents();
        int additionalQuantity = product.getQuantity();
        int currentProductIndex = findProductInCartAndReturnIndex(product, cart);

        if (currentProductIndex >= 0) {
            Product combinedProduct = combineQuantieties(currentProductIndex, product, cart);
            updateSubTotal(combinedProduct);
            cart.set(currentProductIndex, combinedProduct);
        } else if (currentProductIndex < 0) {
            updateSubTotal(product);
            cart.add(product);
        }
    }

    public void editCart(Product editedProduct, int updatedQuantity) {
        List<Product> cart = shoppingCart.getCartContents();
        int currentProductIndex = findProductInCartAndReturnIndex(editedProduct, cart);
        Product updatedProduct = updateQuantity(currentProductIndex, updatedQuantity, cart);
        updateSubTotal(updatedProduct);
        cart.set(currentProductIndex, updatedProduct);

    }


    public void deleteProductFromCart(Integer deletedProductID) {
        List<Product> cart = shoppingCart.getCartContents();
        ListIterator carterator = cart.listIterator();

        while (carterator.hasNext()) {
            Product currentProduct = (Product) carterator.next();
            Integer currentProductId = currentProduct.getId();
            if (currentProductId.compareTo(deletedProductID) == 0) {
                carterator.remove();
            }
        }

    }

    public void orderCheckout(List<Product> orderedProducts, Shipment usedShipment) {
        Order lastOrder = orderRepository.findFirstByOrderByOrderIdDesc();
        Integer orderId = 1 + lastOrder.getOrderId();
        for (Product op : orderedProducts) {
            Order currentOrder = new Order();
            currentOrder.setOrderId(orderId);
            currentOrder.setProductId(op.getId());
            currentOrder.setProductName(op.getName());
            currentOrder.setProductQuantity(op.getQuantity());
            currentOrder.setOrderTotal(getCartTotal());
            currentOrder.setChosenShipmentId(usedShipment.getId());
            orderRepository.save(currentOrder);
        }
    }

    public Integer getLastOrderId() {
        Order lastOrder = orderRepository.findFirstByOrderByOrderIdDesc();
        return lastOrder.getOrderId();
    }

    public void addOrderAddress(Address address, Integer orderId) {
        address.setOrderId(orderId);
        addressRepository.save(address);
    }

    public void useShipment(int chosenShipmentId) {
        Shipment usedShipment = shipmentRepository.findOne(chosenShipmentId);
        shoppingCart.setShipment(usedShipment);
    }

    public int findProductInCartAndReturnIndex(Product product, List<Product> cart) {
        Integer addedProductId = product.getId();
        for (Product p : cart) {
            Integer currentProductId = p.getId();
            if (currentProductId.compareTo(addedProductId) == 0) {
                return cart.indexOf(p);
            }
        }
        return -1;
    }

    public Product combineQuantieties(int currentProductIndex, Product addedProduct, List<Product> cart) {
        Product currentProduct = cart.get(currentProductIndex);
        currentProduct.setQuantity(currentProduct.getQuantity() + addedProduct.getQuantity());
        return currentProduct;
    }

    public Product updateQuantity(int currentProductIndex, int updatedQuantity, List<Product> cart) {
        Product currentProduct = cart.get(currentProductIndex);
        currentProduct.setQuantity(updatedQuantity);
        return currentProduct;
    }

    public void updateSubTotal(Product product) {
        BigDecimal quantity = BigDecimal.valueOf(product.getQuantity());
        BigDecimal subtotal = quantity.multiply(product.getPrice());
        product.setSubtotal(subtotal);
    }

    public BigDecimal getCartTotal() {
        List<Product> cart = shoppingCart.getCartContents();
        BigDecimal cartTotal = new BigDecimal("0.00");
        ListIterator literator = cart.listIterator();
        while (literator.hasNext()) {
            Product currentProduct = (Product) literator.next();
            cartTotal = cartTotal.add(currentProduct.getSubtotal());
        }
        BigDecimal shipmentCost = (shoppingCart.getShipment()).getCost();
        cartTotal = cartTotal.add(shipmentCost);
        return cartTotal;
    }


}
