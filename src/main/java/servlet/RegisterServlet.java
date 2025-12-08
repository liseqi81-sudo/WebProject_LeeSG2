package servlet;

import java.io.IOException;




import dao.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Member;



@WebServlet("/Register.do")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // 폼 데이터 처리
        String firstName = req.getParameter("firstName");
        String lastName  = req.getParameter("lastName");
        String email     = req.getParameter("email");
        String password  = req.getParameter("password");
        String confirm   = req.getParameter("confirmPassword");

        if(!password.equals(confirm)) {
            req.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        
        Member member = new Member(firstName, lastName, email, password);

        try {
            MemberDAO dao = new MemberDAO();
            dao.insertMember(member);
        } 
        catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "회원가입 도중 오류 발생");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        
        // 확인용 출력
        System.out.println("회원가입: " + firstName + " " + lastName + " / " + email);

        resp.sendRedirect("login.jsp");
    }
}
