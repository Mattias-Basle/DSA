package JavaBasics.serialization;

import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            oos.writeObject(one);
            oos.writeObject(two);
            oos.writeObject(three);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) ois.readObject();
            GameCharacter twoRestore = (GameCharacter) ois.readObject();
            GameCharacter threeRestore = (GameCharacter) ois.readObject();
            ois.close();

            System.out.println("One's type: " + oneRestore.getType());
            System.out.println("Two's type: " + twoRestore.getType());
            System.out.println("Three's type: " + threeRestore.getType());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
