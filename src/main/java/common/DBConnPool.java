package common;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class DBConnPool {
    public Connection con;
    public PreparedStatement psmt;
    public ResultSet rs;

    public DBConnPool() {
        try {
            Context initCtx = new InitialContext();
            Context ctx = (Context)initCtx.lookup("java:comp/env");
        DataSource source = (DataSource)ctx.lookup("dbcp_webproject");
        con = source.getConnection();
        System.out.println("DB 연결 성공!");
    } catch (Exception e) {
        System.out.println("DB 연결 실패!");
        e.printStackTrace();
    }
}

public void close() {
    try {
        if (rs != null) rs.close();
        if (psmt != null) psmt.close();
        if (con != null) con.close();
        System.out.println("DB 자원 반납 완료");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	}

