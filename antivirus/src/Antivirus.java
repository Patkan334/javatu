import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Antivirus {
private static final int BUFFER_SIZE = 1024;
    
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the path of the file or directory you want to scan: ");
    String path = scanner.nextLine();

    Path file = Paths.get(path);
    if (!Files.exists(file)) {
        System.out.println("The file or directory you entered does not exist.");
        return;
    }

    scan(file);
}

public static void scan(Path file) {
    if (Files.isDirectory(file)) {
        // If it's a directory, scan all the files in the directory
        try {
            Files.list(file).forEach(Antivirus::scan);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        // If it's a file, check if it's infected
        if (isInfected(file)) {
            System.out.println(file.toString() + " is infected.");
        } else {
            System.out.println(file.toString() + " is safe.");
        }
    }
}

public static boolean isInfected(Path file) {
    try {
        byte[] buffer = new byte[BUFFER_SIZE];
        Files.newInputStream(file).read(buffer, 0, BUFFER_SIZE);
        String signature = new String(buffer);
        return signature.startsWith("EICAR") || signature.startsWith("X5O!P");
    } catch (IOException e) {
        e.printStackTrace();
        return false;
        }
    }
}
