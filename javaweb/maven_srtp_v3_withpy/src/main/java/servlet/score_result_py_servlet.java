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
        String str = getpy.getPythonDemo("/Users/cuijiajun/Desktop/SRTP/python/ml_crispra_v4/ml_crispra_14features_model.py","-0.18708664, 1.73239376, 1.54802069,  0.7466342,   1.37401474,  0.33645973, 2.11035398,  1.8803562,   0.72672721 , 2.28216878 , 0.56584782,  1.82112032  ,0.88874096 , 0.72263392");
        request.setAttribute("strtest", str.toString().replaceAll("\\[|\\]", ""));
        request.getRequestDispatcher("/jsp/score_result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
