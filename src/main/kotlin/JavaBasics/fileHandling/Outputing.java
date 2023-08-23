package JavaBasics.fileHandling;

import java.io.*;
import java.util.Scanner;

public class Outputing {

    public Outputing() {}

    public void createFile() {
        try {
            File fo = new File("new-file.txt");
            fo.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void writingInFile() {
        try {
            FileWriter fw = new FileWriter("new-file.txt");
            fw.write("Writing in your created file");
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void readingFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("new-file.txt"));) {
            while(br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void deleteFile() {
        try {
            File file = new File("new-file.txt");
            if (file.delete()) {
                System.out.println("File " + file.getName() + " deleted");
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            return;
        }

    }
}
