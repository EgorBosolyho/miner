package entity;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Cell> line = new ArrayList<Cell>();

    public Line() {
    }

    public List<Cell> getLine() {
        return line;
    }

    public void setLine(List<Cell> line) {
        this.line = line;
    }
}
