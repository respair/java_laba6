import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    //    args[0]="example.txt";
        String name = "example.txt";
        task1 task = new task1(name);
        System.out.println("Input for search: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println("string: " + task.search(str));
        System.out.println("count: " + task.count(str));


    }
}
