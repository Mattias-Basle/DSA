package JavaBasics.fileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWriterCustom {

    public FileWriterCustom() {}

    public void consoleWriter() {
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write("Hello World");
            osw.write(97);
            osw.write(10);
            osw.write('A');
            osw.write('\n');
            char[] arr = "Mattias".toCharArray();
            osw.write(arr);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void consoleWriter(String s) {
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void fileWriter() {
        try (FileWriter fw = new FileWriter("note.txt")) {
            fw.write("overwriting the current file");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void fileAppend() {
        try (FileWriter fw = new FileWriter("note.txt", true)) {
            fw.append("\nthis should be appended");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void buffered() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))) {
            bw.write("Hail File Handling");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }
}
