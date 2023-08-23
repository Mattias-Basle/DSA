package JavaBasics.fileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderCustom {

    public FileReaderCustom() {}

    public void letters() {
        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            System.out.print("Enter some letters: ");
            int letters = isr.read();
            while (isr.ready()) {
                System.out.print((char) letters +  " ");
                letters = isr.read();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void readLetters() {
        try (FileReader fr = new FileReader("note.txt")) {
            int letters = fr.read();
            while (fr.ready()) {
                System.out.print((char) letters +  " ");
                letters = fr.read();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void bufferedLines() {
        try (BufferedReader br = new BufferedReader(new FileReader("note.txt"));) {
            while(br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }
}
