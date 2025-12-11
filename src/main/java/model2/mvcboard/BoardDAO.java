package model2.mvcboard;

import common.DBConnPool;
import java.util.*;
import java.sql.*;

public class BoardDAO extends DBConnPool {

    public BoardDAO() {
        super(); // DB 연결
    }

    // 게시물 목록 조회
    public List<BoardDTO> selectList(Map<String, Object> map) {
        List<BoardDTO> list = new ArrayList<>();
        String query = "SELECT * FROM board "; // DB 테이블 이름 맞춰주세요

        if (map.get("searchWord") != null && !map.get("searchWord").toString().isEmpty()) {
            query += " WHERE " + map.get("searchField") + " LIKE ?";
        }
        query += " ORDER BY num DESC";

        try {
            if (map.get("searchWord") != null && !map.get("searchWord").toString().isEmpty()) {
                psmt = con.prepareStatement(query);
                psmt.setString(1, "%" + map.get("searchWord") + "%");
            } else {
                psmt = con.prepareStatement(query);
            }

            rs = psmt.executeQuery();
            while (rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNum(rs.getString("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setId(rs.getString("id"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setVisitcount(rs.getInt("visitcount"));
                list.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 게시물 총 개수 (검색 포함)
    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String query = "SELECT COUNT(*) FROM board";

        if (map.get("searchWord") != null && !map.get("searchWord").toString().isEmpty()) {
            query += " WHERE " + map.get("searchField") + " LIKE ?";
        }

        try {
            if (map.get("searchWord") != null && !map.get("searchWord").toString().isEmpty()) {
                psmt = con.prepareStatement(query);
                psmt.setString(1, "%" + map.get("searchWord") + "%");
            } else {
                psmt = con.prepareStatement(query);
            }
            rs = psmt.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return totalCount;
    }
    
 // 게시물 쓰기
    public int insertWrite(BoardDTO dto) {
        int result = 0;
        String query = "INSERT INTO board(num, title, content, id, postdate, visitcount) "
                     + "VALUES(seq_board_num.NEXTVAL, ?, ?, ?, SYSDATE, 0)";

        try {
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getId());
            result = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
