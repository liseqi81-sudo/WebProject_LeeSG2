package member;

import java.util.Date;

public class MemberDTO {
    private String id;
    private String pass;
    private String name;
    private Date regidate;

    public MemberDTO() {}

    public MemberDTO(String id, String pass, String name) {
        this.id = id;
        this.pass  = pass;
        this.name = name;
        
    }

    // getter/setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getRegidate() { return regidate; }
    public void setRegidate(Date regidate) { this.regidate = regidate; }
}
