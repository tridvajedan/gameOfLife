package sense;

import grid.Grid;
import view.MainCanvas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Keyboard implements KeyListener {
    MainCanvas mc;
    ScheduledExecutorService sc = new ScheduledThreadPoolExecutor(1);
    boolean pressed = false;
    Runnable r = new Runnable() {
        @Override
        public void run() {
            pressed = false;
        }
    };
    public Keyboard(MainCanvas mc)
    {
        this.mc = mc;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && !pressed)
        {
            pressed = true;
            mc.paused = !mc.paused;
            sc.schedule(r,100, TimeUnit.MILLISECONDS);
        }
        else if(e.getKeyCode() == KeyEvent.VK_R && !pressed)
        {
            pressed = true;
            mc.grid = new Grid();
            sc.schedule(r,100, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
