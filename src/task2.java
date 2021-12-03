import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class task2 {
    public static void main(String args[]) {
        String arg = "task2.txt";
        Item item1 = new Item(1, "apple", 20);
        Item item2 = new Item(10, "water", 100);
        Item item3 = new Item(23, "pen", 87);
        Item item4 = new Item(178, "shirt", 1600);

        ArrayList<Item> arr = new ArrayList<Item>(4);
        arr.add(item1);
        arr.add(item2);
        arr.add(item3);
        arr.add(item4);

        ShoppingCart sc = new ShoppingCart(112,arr);

        System.out.println("before: " + sc + "\n");

        try(FileOutputStream fos = new FileOutputStream(arg);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("date.txt"));){
            out.writeObject(sc);
            out2.writeObject(LocalDateTime.now());
            System.out.println("1 step: ok ");
        } catch (IOException e) {
            System.out.println("1 step: fail. " + e + "\n");
        }

        try(FileInputStream fis = new FileInputStream(arg);
            ObjectInputStream in = new ObjectInputStream(fis);
            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("date.txt"))){
            ShoppingCart scNew = (ShoppingCart)in.readObject();
            LocalDateTime date = (LocalDateTime)in2.readObject();
            System.out.println("2 step: ok " + "\n");
            System.out.println("after: " + scNew);
            System.out.println("date: " + date);
        } catch (FileNotFoundException e) {
            System.out.println("2 step: fail. " + e + "\n");
        } catch (IOException e) {
            System.out.println("2 step: fail. " + e + "\n");
        } catch (ClassNotFoundException e) {
            System.out.println("1 step: fail. " + e + "\n");
        }


    }


}
