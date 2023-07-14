package view;

import grid.Grid;
import grid.GridRect;
import sense.Mouse;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainCanvas extends JPanel {
    public Grid grid =  new Grid();
    public boolean paused = true;
    private Mouse m;
    private Thread repaintThread = new Thread(new Runnable() {
        @Override
        public void run() {
            int fps = 60;
            //Lower = Faster
            int tickSpeed = 10;
            int del = 0;
            while(true) {
                del++;
                try {
                    Thread.sleep(1000 / fps);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(del==tickSpeed) {
                    del = 0;
                    tick();
                }
                revalidate();
                repaint();
            }
        }
    });

    public MainCanvas(Mouse m)
    {
        this.m = m;
        repaintThread.start();
    }

    public void tick()
    {
        System.out.println("paused - " + paused);
        ArrayList<GridRect> toChange = new ArrayList<>();
        if(!paused)
        {
            Grid grid2 = new Grid();
            grid2.grid = grid.grid.clone();
            for(int i = 0; i < 50;i++) {
                for (int j = 0; j < 40; j++) {
                    GridRect c = grid.getCell(i, j);
                    if (c.active) {
                        int count = 0;
                        for (int i1 = i - 1; i1 < i + 2; i1++) {
                            for (int j1 = j - 1; j1 < j + 2; j1++) {
                                try {
                                    GridRect rect = grid.getCell(i1, j1);
                                    if (rect.active) count++;
                                } catch (Exception ignored) {
                                }
                            }
                        }
                        count--;
                        if (count < 2) {
                            toChange.add(grid2.getCell(i, j));
                        }

                    }
                }

            }

            for(int i = 0; i < 50;i++) {
                for (int j = 0; j < 40; j++) {
                    GridRect c = grid.getCell(i, j);
                    if (c.active) {
                        int count = 0;
                        for (int i1 = i - 1; i1 < i + 2; i1++) {
                            for (int j1 = j - 1; j1 < j + 2; j1++) {
                                try {
                                    GridRect rect = grid.getCell(i1, j1);
                                    if (rect.active) count++;
                                } catch (Exception ignored) {
                                }
                            }
                        }
                        count--;
                        if (count > 3) {
                            toChange.add(grid2.getCell(i, j));
                        }

                    }
                }
            }
            for(int i = 0; i < 50;i++) {
                for (int j = 0; j < 40; j++) {
                    GridRect c = grid.getCell(i, j);
                    if (!c.active) {
                        int count = 0;
                        for (int i1 = i - 1; i1 < i + 2; i1++) {
                            for (int j1 = j - 1; j1 < j + 2; j1++) {
                                try {
                                    GridRect rect = grid.getCell(i1, j1);
                                    if (rect.active) count++;
                                } catch (Exception ignored) {
                                }
                            }
                        }
                        if (count ==3) {
                            toChange.add(grid2.getCell(i, j));
                        }
                    }
                }
            }
            for(GridRect gr : toChange)
            {
                gr.active = !gr.active;
            }
            grid = grid2;
        }
    }

    public void click()
    {
        grid.getCell(m.x/20,m.y/20).active=!grid.getCell(m.x/20,m.y/20).active;
    }


    public void paint(Graphics g2)
    {
        Graphics2D g = (Graphics2D) g2;
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        grid.render(g);
        g.setColor(Color.red);
        //g.fill(grid.getCell(m.x/20,m.y/20));
    }
}
