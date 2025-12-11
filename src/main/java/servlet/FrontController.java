package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model2.mvcboard.BoardDAO;
import model2.mvcboard.BoardDTO;

@WebServlet("*.do")  // 모든 .do 요청을 이 서블릿에서 처리
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 요청 URI 확인
        String uri = req.getRequestURI();
        String context = req.getContextPath();
        String command = uri.substring(context.length());

        // 요청 처리
        if (command.equals("/freeboard/list.do")) {
            listFunc(req);
        } else if (command.equals("/freeboard/write.do")) {
            writeFunc(req);
        }

        // JSP로 포워드
        String viewPage = (String) req.getAttribute("viewPage");
        if (viewPage != null) {
            RequestDispatcher rd = req.getRequestDispatcher(viewPage);
            rd.forward(req, resp);
        }
    }

    // 자유게시판 목록 처리
    private void listFunc(HttpServletRequest req) {
        BoardDAO dao = new BoardDAO();
        List<BoardDTO> list = dao.selectList(null);  // DB에서 목록 조회
        req.setAttribute("list", list);
        req.setAttribute("viewPage", "/freeboardlist.jsp");  // 표시할 JSP
    }

    // 자유게시판 글쓰기 처리 (폼 제출)
    private void writeFunc(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String id = req.getParameter("id");

            BoardDTO dto = new BoardDTO();
            dto.setTitle(title);
            dto.setContent(content);
            dto.setId(id);

            BoardDAO dao = new BoardDAO();
            dao.insertWrite(dto);

            // 작성 후 목록 페이지로 이동
            req.setAttribute("viewPage", "/freeboard/list.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
