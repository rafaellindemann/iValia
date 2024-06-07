import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TelaHome t = new TelaHome();
        t.setContentPane(t.painelPrincipal);
        t.setTitle("iValia");
        t.setSize(800, 600);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}