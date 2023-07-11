package entities;

public class Comments {
      private int cid;
      private String cname;
      private int tid;
      private String uid;
      
      
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comments(int cid, String cname, int tid, String uid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.tid = tid;
		this.uid = uid;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}
      
	
      
}
