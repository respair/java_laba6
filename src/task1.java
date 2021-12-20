import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task1 {
    private String name;

    public task1(String args){
       // System.arraycopy(args, 0, this.path, 0, args.length - 1);
        this.name = args;
    }

    public String search(String str){
        try(BufferedReader reader = new BufferedReader(new FileReader(this.name))) {
            int count = 0;
           // BufferedReader reader = new BufferedReader(new FileReader(this.name));
            String line;
            while((line = reader.readLine()) != null) {
                if((line.contains(str))) {
                    count++;
                 //   System.out.println("Number of String " + count);
                 //   System.out.println(line);
                    reader.close();
                    return line;
                }
            }
        }catch (IOException ex){
            System.out.println(ex);
        }
        return "";
    }

    public int count(String str){
        try(BufferedReader reader = new BufferedReader(new FileReader(this.name))){
            int count = (int) reader.lines()
                    .filter(line -> line.equals(search(str)))
                    .count();
            reader.close();
            return count;
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        return 100;
    }
/*
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
       // System.out.println("Input name of file: ");
       // String name = in.nextLine();
        String name = args[0];
        task1 task = new task1(name);
        System.out.println("Input for search: ");
        String str = in.nextLine();
        System.out.println("string: " + task.search(str));
        System.out.println("count: " + task.count(str));

    }*/
}
