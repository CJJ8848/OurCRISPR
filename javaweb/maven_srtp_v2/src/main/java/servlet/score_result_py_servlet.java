package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.getpy;
import javax.servlet.annotation.WebServlet;
@WebServlet("/score_result_py_servlet")
public class score_result_py_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getpy getpy = new getpy();
        String str = getpy.getPythonDemo("/Users/cuijiajun/Desktop/BMI3/python_scripts/test.py","first","second");
        request.setAttribute("strtest", str.toString().replaceAll("\\[|\\]", ""));
        request.getRequestDispatcher("/jsp/score_result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
