package controllers;


import entity.Field;
import logic.CreateField;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/field")
public class ControllerField {
    @Resource
    CreateField createField;

    @ResponseBody
    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Field getField(){
        createField.create();
        return createField.getField();

    }

    @ResponseBody
    @RequestMapping(value = "/move", produces = MediaType.APPLICATION_JSON_VALUE)
    public Field userMove(@RequestParam("lineId") Integer lineId, @RequestParam("cellId") Integer cellId){
        createField.userMove(lineId, cellId);
        return createField.getField();

    }

    @ResponseBody
    @RequestMapping(value = "/right", produces = MediaType.APPLICATION_JSON_VALUE)
    public Field userRightClick(@RequestParam("lineId") Integer lineId, @RequestParam("cellId") Integer cellId){
        createField.userRight(lineId, cellId);
        return createField.getField();
    }

}
