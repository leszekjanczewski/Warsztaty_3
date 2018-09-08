package pl.coderslab.controller;

import pl.coderslab.database.DbUtil;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SolutionServlet", urlPatterns = "/")
public class SolutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String limit = request.getParameter("limit");
        List<Solution> solutionToDisplay = new ArrayList<>();

        try {
            solutionToDisplay = Solution.loadAll(DbUtil.getConn());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("solutions", solutionToDisplay);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
