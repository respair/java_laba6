package lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class P04NioReadAll {
  public static void main(String[] args) {
        
    Path file =  Paths.get("hamlet.txt");
    List<String> fileArr;
    try{
        // Read fileinto array here
        fileArr = Files.readAllLines(file);

        System.out.println("\n=== Lord/lord Count ===");
        long wordCount = fileArr.stream()
              .filter(line -> line.contains("Lord") || line.contains("lord"))
              .count();
        
        System.out.println("Word count: " + wordCount);

        System.out.println("\n=== Prison/prison Count ===");
        wordCount = fileArr.stream()
              .filter(line -> line.contains("Prison") || line.contains("prison"))
              .count();
        
        System.out.println("Word count: " + wordCount);            

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  } 
}
