package lab2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirWalk {
  public static void main(String[] args) {

      Path dir = Path.of("./src");
      String filter = "*";
    try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir,filter)){// Add try with resources here

        System.out.println("\n=== Dir walk ===");
        // Print directory list here
        for(Path file:stream){
            if(Files.isDirectory(file)) {
                System.out.println(file.getFileName());
            }
        }

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

    try(Stream<Path> files = Files.walk(Paths.get("."))){

        System.out.println("\n=== Dir build ===");
        files
            .filter(path -> path.toString().contains("build"))
            .forEach(line -> System.out.println(line));  

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  } 
}
