package entity;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;



public class Field {
    private List<Line> field = new ArrayList<Line>();
    private Integer size;

    public Field(Integer size) {
        this.size = size;
        System.out.println("бин поля создался");
    }

    public Field() {
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

    @Override
    public String toString() {
        return "Field{" +
                "field=" + field +
                ", size=" + size +
                '}';
    }
}
