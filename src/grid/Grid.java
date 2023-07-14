package grid;


import java.awt.*;

public class Grid {
    public GridRect[][] grid = new GridRect[40][50];

    public Grid() {
        init();
    }

    public void init()
    {
        for(int i =0;i < grid.length;i++)
        {
            for(int j = 0; j < grid[0].length;j++)
            {
                grid[i][j] = new GridRect(j*20,i*20,20,20);
            }
        }
    }

    public void render(Graphics2D g)
    {
        g.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        for(int i =0;i < grid.length;i++)
        {
            g.setColor(new Color(209, 207, 200));
            for(int j = 0; j < grid[0].length;j++)
            {
                if(getCell(j, i).active)
                {
                    GridRect t = getCell(j,i);
                    g.fill(t);
                    g.setColor(new Color(43, 44, 48));
                    g.fillRect(t.x+2,t.y+2,t.width-4,t.height-4);
                    g.setColor(new Color(209, 207, 200));
                }
                else
                {
                    g.draw(getCell(j,i));
                }
            }
        }
    }

    public GridRect getCell(int x,int y)
    {
        return grid[y][x];
    }
}
