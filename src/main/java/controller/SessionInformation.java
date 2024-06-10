package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */

//Common coupling
public class SessionInformation {
    private static SessionInformation instance;
    private User mainUser;
    private Cart cartInstance;
    private LocalDateTime expiredTime;

    private SessionInformation() {

    }

    public static SessionInformation getInstance() {
        if (instance == null) {
            instance = new SessionInformation();
        }
        return instance;
    }

    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    public Cart getCartInstance() {
        return cartInstance;
    }

    public static void setCartInstance(Cart cartInstance) {
        this.cartInstance = cartInstance;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }

}