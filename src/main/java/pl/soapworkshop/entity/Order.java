package pl.soapworkshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long row;
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer productId;
    @NotNull
    private String productName;
    @NotNull
    private Integer productQuantity;
    @NotNull
    private BigDecimal orderTotal;

    private Integer chosenShipmentId;

    public Long getRow() { return row; }

    public void setRow(Long row) { this.row = row; }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getChosenShipmentId() { return chosenShipmentId; }

    public void setChosenShipmentId(Integer chosenShipmentId) { this.chosenShipmentId = chosenShipmentId; }
}
