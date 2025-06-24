package feedback_package;

public class feedback {

	private int id;  
	private String cname,ename,fdate,fcomment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEname() {
		return ename;
	}
	
	// DATA HIDING
    // External classes can't directly manipulate the ename field
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public String getFcomment() {
		return fcomment;
	}
	public void setFcomment(String fcomment) {
		this.fcomment = fcomment;
	}

	
}
