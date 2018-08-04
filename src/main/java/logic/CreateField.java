package logic;

import entity.Cell;
import entity.Field;
import entity.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.*;

public class CreateField {

    private Field field ;
    public void setField(Field field) {
        this.field = field;
    }
    public Field getField() {
        return field;
    }

    private List<Cell> listCell;

    public CreateField() {
    }

    public void create(){
        field.setField(new ArrayList<>());
        listCell = new ArrayList<Cell>();
         for(int i = 0; i<field.getSize(); i++){
             Line line = new Line();
             for(int j = 0; j<field.getSize(); j++){
                Cell cell = new Cell(i,j);
                listCell.add(cell);
                line.getLine().add(cell);
             }
             field.getField().add(line);
         }
         addMine();
         addValue();
    }

    private void addMine(){
        int numberMine = (int) (listCell.size()*0.2);
        for(int i = 0; i<numberMine; i++){
            Cell cell = listCell.get(randomCell());
            cell.setValue("b");
        }
    }

    private int randomCell() {
        Random random = new Random();
        while (true){
            int randomCell = random.nextInt(listCell.size());
            if (listCell.get(randomCell).getValue().equals("")) {
                return randomCell;
            }
        }
    }

    private void addValue(){
        for (Cell cell : listCell) {
            if (cell.getValue().equals("")) {
                int mineArround = mineArround(cell);
                cell.setValue(Integer.toString(mineArround));
            }
        }
    }

    private int mineArround(Cell cell){
        int count = 0;
        int lineId = cell.getLineId();
        int cellId = cell.getCellId();
        for (Cell cellFromList : listCell) {
            if (listId(lineId).contains(cellFromList.getLineId()) && listId(cellId).contains(cellFromList.getCellId())) {
                if (cellFromList.getValue().equals("b")) {
                    count++;
                }
            }
        }
        return count;
    }

    private List<Integer> listId(int id){
        List<Integer> list = new ArrayList<Integer>();
        list.add(id-1);
        list.add(id);
        list.add(id+1);
        return list;
    }

    public Cell getCellById(int lineId, int cellId){
        Cell cell = new Cell();
        for (Cell aListCell : listCell) {
            cell = aListCell;
            if (cell.getLineId() == lineId && cell.getCellId() == cellId) {
                break;
            }
        }
        return cell;
    }

    public void userMove(int lineId, int cellId){
        getCellById(lineId,cellId).setOpen(true);
    }

    public void userRight(int lineId, int cellId){
        Cell cell = getCellById(lineId,cellId);
        if(cell.getRightValue().equals("")){
            cell.setRightValue("!");
        } else {
            cell.setRightValue("");
        }
    }

    public String checkWin(){
        int count = listCell.size();
        for (Cell aListCell: listCell){
            if(aListCell.isOpen()){
                count--;
            }
            if(!aListCell.getRightValue().equals("") && aListCell.getRightValue().equals("b")){
                count--;
            }
        }
        return count==0 ? "You win!!!" : "";
    }

}
