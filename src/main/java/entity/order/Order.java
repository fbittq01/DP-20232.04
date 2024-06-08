package entity.order;

import controller.SessionInformation;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.shipping.DeliveryInfo;
import entity.shippingutils.shippingfee.CalculatingFee;
import entity.shippingutils.shippingfee.CalculatingFeeA;
import views.screen.ViewsConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import entity.shippingutils.shippingfee;

public class Order {

    private int shippingFees;
    private int subtotal;
    private int tax;
    private List orderMediaList;
    protected DeliveryInfo deliveryInfo;
    private CalculatingFee calculatingFee;

    public Order() {
        this.shippingFees = 0;
        this.subtotal = 0;
        this.tax = 0;
    }

    public Order(Cart cart) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Object object : SessionInformation.cartInstance.getListMedia()) {
            CartItem cartItem = (CartItem) object;
            OrderItem orderItem = new OrderItem(cartItem.getMedia(),
                    cartItem.getQuantity(),
                    cartItem.getPrice());
            orderItems.add(orderItem);
        }
        this.orderMediaList = Collections.unmodifiableList(orderItems);
        this.subtotal = cart.calSubtotal();
        this.tax = (int) (ViewsConfig.PERCENT_VAT/100) * subtotal;
    }

    public List getListOrderMedia() {
        return this.orderMediaList;
    }

    public int getShippingFees() {
        if (deliveryInfo == null) return 0;
        return this.shippingFees;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        this.calculatingFee = new CalculatingFeeA(deliveryInfo.getAddress(), deliveryInfo.getProvince());
        this.shippingFees = calculatingFee.calculateShippingFee();
    }

    public void setCalculatingFee(CalculatingFee calculatingFee) {
        this.calculatingFee = calculatingFee;
    }

    public List getOrderMediaList() {
        return orderMediaList;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getTax() {
        return tax;
    }

    public int getTotal() {
        return this.subtotal + this.tax + this.shippingFees;
    }
}