package member;

import java.sql.*;

import member.MemberDTO;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
	
    public MemberDAO() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속 URL
            String user = "webproject_db"; // 계정명
            String pass = "1234";          // 비밀번호

            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 회원가입
    public int join(MemberDTO m) {
        int result = 0;
        String sql = "insert into member(id, pass, name) values (?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPass());
            pstmt.setString(3, m.getName());
            result = pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 로그인
    public MemberDTO login(String id, String pass) {
        MemberDTO m = null;
        String sql = "select * from member where id=? and pass=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                m = new MemberDTO();
                m.setId(rs.getString("id"));
                m.setPass(rs.getString("pass"));
                m.setName(rs.getString("name"));
                m.setRegidate(rs.getDate("regidate"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return m;
    }
}
