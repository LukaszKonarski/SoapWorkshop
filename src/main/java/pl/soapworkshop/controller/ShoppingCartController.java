package pl.soapworkshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.soapworkshop.entity.*;
import pl.soapworkshop.repository.CategoryRepository;
import pl.soapworkshop.repository.OrderRepository;
import pl.soapworkshop.repository.ProductRepository;
import pl.soapworkshop.repository.ShipmentRepository;
import pl.soapworkshop.service.ShoppingCartService;

import java.util.List;

@Controller
@Scope("request")
public class ShoppingCartController {

    private ShoppingCart shoppingCart;
    private ShoppingCartService shoppingCartService;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private OrderRepository orderRepository;
    private ShipmentRepository shipmentRepository;

    @Autowired
    public ShoppingCartController(ShoppingCart shoppingCart, ProductRepository productRepository, CategoryRepository categoryRepository,
                                  ShoppingCartService shoppingCartService, OrderRepository orderRepository, ShipmentRepository shipmentRepository) {
        this.shoppingCart = shoppingCart;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.shoppingCartService = shoppingCartService;
        this.orderRepository = orderRepository;
        this.shipmentRepository = shipmentRepository;
    }

//    //Navbar resources
    @ModelAttribute
    public void addCategories(Model model) {
        model.addAttribute("categories", this.categoryRepository.findAllByIdGreaterThan(1));
    }

    @RequestMapping(value = "/store/productDetails/{id}", method = RequestMethod.POST)
    public String addProductToCart(@PathVariable Integer id, @ModelAttribute Product product) {
        shoppingCartService.addToCart(product);
      return "/index";
    }

    @RequestMapping(value = "/store/shoppingCart", method = RequestMethod.GET)
    public String showCart(@ModelAttribute Shipment shipment, Model model){
        shoppingCartService.useShipment(1);
        model.addAttribute("cart", shoppingCartService.getCart());
        model.addAttribute("shipments", shipmentRepository.findAll());
        model.addAttribute("cartTotal", shoppingCartService.getCartTotal());
        return "store/shoppingCart";
    }

    @RequestMapping(value = "/store/shoppingCart", method = RequestMethod.POST)
    public String showCartWithShipment(@RequestParam int id,  @ModelAttribute Shipment shipment, Model model){
        shoppingCartService.useShipment(id);
        model.addAttribute("cart", shoppingCartService.getCart());
        model.addAttribute("shipments", shipmentRepository.findAll());
        model.addAttribute("cartTotal", shoppingCartService.getCartTotal());
        return "store/shoppingCart";
    }


    @RequestMapping(value = "/store/editShoppingCart", method = RequestMethod.POST)
    public String editCart(@RequestParam int editedQuantity, @ModelAttribute Product product, @ModelAttribute Shipment shipment, Model model){
        shoppingCartService.editCart(product, editedQuantity);
        model.addAttribute("cart", shoppingCartService.getCart());
        model.addAttribute("shipments", shipmentRepository.findAll());
        model.addAttribute("cartTotal", shoppingCartService.getCartTotal());
        return "store/shoppingCart";
    }

    @RequestMapping(value = "/store/deleteItemFromCart/{id}", method = RequestMethod.GET)
    public String deleteProductFromCart(@PathVariable Integer id, Model model){
        shoppingCartService.deleteProductFromCart(id);
        model.addAttribute("cart", shoppingCartService.getCart());
        model.addAttribute("shipments", shipmentRepository.findAll());
        model.addAttribute("cartTotal", shoppingCartService.getCartTotal());
        return "store/shoppingCart";
    }

    @RequestMapping(value = "/store/orderCheckout", method = RequestMethod.POST)
    public String orderCheckout(Model model, @ModelAttribute Address address){
        shoppingCartService.orderCheckout(shoppingCartService.getCart(), shoppingCart.getShipment());
        Integer orderId = shoppingCartService.getLastOrderId();
        model.addAttribute("orderId", orderId);
        shoppingCartService.addOrderAddress(address, orderId );
        return "store/orderConfirmation";
    }

}
