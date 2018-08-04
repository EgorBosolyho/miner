package entity;

public class Cell {
    private int cellId;
    private int lineId;
    private boolean open = false;
    private String value = "";
    private String rightValue = "";

    public Cell() {
    }

    public Cell(int lineId, int cellId) {
        this.lineId = lineId;
        this.cellId = cellId;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRightValue() {
        return rightValue;
    }

    public void setRightValue(String rightValue) {
        this.rightValue = rightValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
