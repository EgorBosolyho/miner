package controllers;

import entity.Cell;
import entity.Field;
import logic.CreateField;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/field")
public class ControllerField {
    @Resource
    private CreateField createField;

    @ResponseBody
    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Field getField(){
        createField.create();
        return createField.getField();

    }

    @ResponseBody
    @RequestMapping(value = "/move", produces = MediaType.APPLICATION_JSON_VALUE)
    public Field userMove(@RequestParam("lineId") Integer lineId, @RequestParam("cellId") Integer cellId, HttpSession session){
        createField.userMove(lineId, cellId);
        Cell cell = createField.getCellById(lineId, cellId);
        if(cell.getValue().equals("b")){
            session.setAttribute("checkWin", "Вы проиграли!!!");
            //доделать вывод победил/проиграл!!!!!!!!!!!!!!
        } else {
            session.setAttribute("checkWin", createField.checkWin());
        }
        return createField.getField();

    }

    @ResponseBody
    @RequestMapping(value = "/right", produces = MediaType.APPLICATION_JSON_VALUE)
    public Field userRightClick(@RequestParam("lineId") Integer lineId, @RequestParam("cellId") Integer cellId, HttpSession session){
        createField.userRight(lineId, cellId);
        session.setAttribute("checkWin", createField.checkWin());
        return createField.getField();
    }

}
