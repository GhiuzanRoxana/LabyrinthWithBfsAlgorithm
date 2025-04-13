import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String filename = "src/file.txt";
        Graph.readMatrixFromFile(filename);

        Node startNode = Graph.findStartNode();
        System.out.println("Nodul de start găsit la: " + startNode);
        BFS.breadthFirstSearch(startNode);

        JFrame frameWithPath = new JFrame("Labirint cu drumuri BFS");
        Window windowWithPath = new Window(true);
        frameWithPath.add(windowWithPath);
        frameWithPath.setSize(720, 740);
        frameWithPath.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWithPath.setLocation(50, 50);
        frameWithPath.setVisible(true);

        JFrame frameNoPath = new JFrame("Labirint fără drumuri BFS");
        Window windowNoPath = new Window(false);
        frameNoPath.add(windowNoPath);
        frameNoPath.setSize(720, 740);
        frameNoPath.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNoPath.setLocation(800, 50);
        frameNoPath.setVisible(true);
    }
}