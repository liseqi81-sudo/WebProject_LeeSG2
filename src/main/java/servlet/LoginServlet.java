package servlet;

import java.io.IOException;
import member.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MemberDTO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String email = req.getParameter("id");
        String password = req.getParameter("pass");
        
        System.out.println("로그인 시도: 이메일=" + email + ", 비밀번호=" + password);

        MemberDAO dao = new MemberDAO();
        MemberDTO m = dao.login(email, password);

        if(m != null) { // 로그인 성공
        	System.out.println("로그인 성공: " + m.getName());
        	HttpSession session = req.getSession();
            session.setAttribute("loginUser", m);
            resp.sendRedirect("welcome.jsp"); 
            
        } 
        else { // 로그인 실패
            req.setAttribute("errorMsg", "아이디 또는 비밀번호가 잘못되었습니다.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
