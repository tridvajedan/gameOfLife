package grid;

import java.awt.*;

public class GridRect extends Rectangle {
    public boolean active = false;

    public GridRect(int i, int i1, int i2, int i3) {
        x=i;y=i1;width=i2;height=i3;
    }

    @Override
    public String toString() {
        return "GridRect{" +
                "x=" + x/width +
                ", y=" + y/height +
                '}';
    }
}
