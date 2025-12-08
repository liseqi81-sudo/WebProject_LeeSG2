package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Member;

public class MemberDAO {

    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private String jdbcID  = "your_db_id";
    private String jdbcPW  = "your_db_password";

    public void insertMember(Member member) throws Exception {
        String sql = "INSERT INTO members(firstName, lastName, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcID, jdbcPW);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getFirstName());
            pstmt.setString(2, member.getLastName());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getPassword());

            pstmt.executeUpdate();
        }
    }
}
