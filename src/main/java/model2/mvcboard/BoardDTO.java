package model2.mvcboard;

import java.sql.Date;

public class BoardDTO {
    private String num;       // 글번호 (PK)
    private String id;        // 작성자
    private String title;     // 글제목
    private String content;   // 글내용
    private Date postdate;    // 작성일
    private int visitcount;   // 조회수

    // 게터/세터
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostdate() {
        return postdate;
    }
    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public int getVisitcount() {
        return visitcount;
    }
    public void setVisitcount(int visitcount) {
        this.visitcount = visitcount;
    }
}
