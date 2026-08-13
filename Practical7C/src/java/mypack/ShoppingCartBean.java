package mypack;

import java.util.ArrayList;
import javax.ejb.Stateful;

@Stateful
public class ShoppingCartBean {

    private ArrayList<String> cart = new ArrayList<String>();

    public void addItem(String item) {

        cart.add(item);

    }

    public ArrayList<String> getItems() {

        return cart;

    }

    public int getTotalItems() {

        return cart.size();

    }

    public void clearCart() {

        cart.clear();

    }

}