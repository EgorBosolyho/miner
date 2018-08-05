package filters;

import entity.Cell;
import logic.CreateField;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMove implements HandlerInterceptor {
    @Resource
    CreateField createField;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        int lineId = Integer.parseInt(httpServletRequest.getParameter("lineId"));
        int cellId = Integer.parseInt(httpServletRequest.getParameter("cellId"));
        Cell cell = createField.getCellById(lineId,cellId);
        boolean checkWin = createField.getField().getCheckWin().equals("");
        return cell.getRightValue().equals("") && !cell.isOpen() && checkWin;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
