package model2.mvcboard;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/freeboard_list.do")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BoardDAO dao = new BoardDAO();
        List<BoardDTO> list = dao.selectList(); // DB에서 글 목록 조회

        req.setAttribute("list", list); // JSP에 전달
        RequestDispatcher rd = req.getRequestDispatcher("/freeboard.jsp");
        rd.forward(req, resp);
    }
}
