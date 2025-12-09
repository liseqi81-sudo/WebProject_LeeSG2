package servlet;

import java.io.IOException;

import dao.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemberDTO;

@WebServlet("/Register.do")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // JSP input name과 반드시 동일해야 함
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirmPassword");

        // 비밀번호 확인
        if(password == null || confirm == null || !password.equals(confirm)) {
            req.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        // 이름 합치기
        String fullName = firstName + " " + lastName;

        // DTO 생성
        MemberDTO m = new MemberDTO(email, password, fullName);

        // DB 저장
        try {
            MemberDAO dao = new MemberDAO();
            dao.join(m);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "회원가입 도중 오류 발생");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        // 확인용 출력
        System.out.println("회원가입: " + email + " / " + fullName);

        // 로그인 페이지로 이동
        resp.sendRedirect("login.jsp");
    }
}
