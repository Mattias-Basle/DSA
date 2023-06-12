package designPatterns.ProxyPattern.virtualProxy;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

public class ImageProxyTestDrive {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("Album Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable<String, String> albums = new Hashtable<>();

    public static void main(String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {
        albums.put("Buddha Bar", "https://tse3.mm.bing.net/th?id=OIP.DRemBmexsKvuPZoss9uTiwHaHa&pid=Api");
        albums.put("Ima", "https://tse1.mm.bing.net/th?id=OIP.UcCqtE0V-RmIxq1VKXdAbgHaHX&pid=Api");
        albums.put("Karma","https://tse2.mm.bing.net/th?id=OIP.vtJYTiMvc1AuJJBrw3RzOQHaHa&pid=Api");
        albums.put("MCMXC a.D.","https://tse4.mm.bing.net/th?id=OIP.W6-92dqcrjsdbgfuqLtULQHaHc&pid=Api");

        URL initialURL = new URL((String) albums.get("Ima"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite Albums");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for (Enumeration e = albums.keys(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(event -> {
                imageComponent.setIcon(
                        new ImageProxy(getAlbumUrl(event.getActionCommand()))
                );
                frame.repaint();
            });
        }

        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
    }

    URL getAlbumUrl(String name) {
        try {
            return new URL((String) albums.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
