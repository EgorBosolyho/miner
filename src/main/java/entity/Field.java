package entity;

import java.util.ArrayList;
import java.util.List;



public class Field {
    private List<Line> field = new ArrayList<Line>();
    private Integer size;
    private String checkWin = "";

    public Field(Integer size) {
        this.size = size;
    }

    public Field() {
    }

    public String getCheckWin() {
        return checkWin;
    }

    public void setCheckWin(String checkWin) {
        this.checkWin = checkWin;
    }

    public List<Line> getField() {
        return field;
    }

    public void setField(List<Line> field) {
        this.field = field;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
