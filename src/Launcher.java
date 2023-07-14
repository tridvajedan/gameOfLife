import sense.Keyboard;
import sense.Mouse;
import view.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Conways Game of Life v0.1");
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(996,800));
        frame.pack();
        Mouse m = new Mouse();
        frame.getContentPane().addMouseListener(m);frame.getContentPane().addMouseMotionListener(m);
        MainCanvas canvas = new MainCanvas(m);
        Keyboard k = new Keyboard(canvas);
        frame.addKeyListener(k);
        m.mc=canvas;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
