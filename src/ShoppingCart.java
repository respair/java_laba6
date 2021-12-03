import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cartID;
    private ArrayList<Item> items;
    private int itemCount;
    private transient double cartTotal;


    public ShoppingCart(int id,ArrayList<Item> items){
        this.cartID = id;
        this.items = items;
        this.itemCount = items.size();
        setCartTotal();
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        ois.defaultReadObject();
        setCartTotal();
    }

    private void setCartTotal(){
        Random t = new Random();
        Double total = t.nextDouble();
        if(cartTotal == 0){
            cartTotal = 200;
        }
        if(cartTotal < 100){
            total *= cartTotal*100;
        }
        else{
            total = cartTotal*total;
        }

        this.cartTotal = total;
    }

    @Override
    public String toString(){
        return "CartId: " + cartID + "\n" + " items: " + items + "\n" + " count: " + itemCount +
                "\n" + " cartTotal: " + cartTotal;
    }



}
