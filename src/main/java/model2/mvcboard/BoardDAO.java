package model2.mvcboard;

import common.DBConnPool;
import java.util.*;
import java.sql.*;

public class BoardDAO extends DBConnPool {

    public BoardDAO() {
        super(); // DB 연결
    }

    // 게시물 목록 조회 (간단 버전)
    public List<BoardDTO> selectList() {
        List<BoardDTO> list = new ArrayList<>();
        String query = "SELECT * FROM board ORDER BY num DESC";
        try {
            psmt = con.prepareStatement(query);
            rs = psmt.executeQuery();
            while(rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setVisitcount(rs.getInt("visitcount"));
                list.add(dto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 게시물 쓰기 (간단)
    public int insertWrite(BoardDTO dto) {
        int result = 0;
        String query = "INSERT INTO board(num, title, content, id, postdate, visitcount) VALUES(seq_board_num.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
        try {
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getId());
            result = psmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insertBoard(BoardDTO dto) {
        return insertWrite(dto); // 그냥 insertWrite 호출
    }

}
