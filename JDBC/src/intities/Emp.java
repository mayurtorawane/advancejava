package intities;

public class Emp implements Comparable<Emp>{

	private int empno;
	private String ename;
	private String job;
	private double sal;
	private int deptno;
	
	
	public Emp() {
		super();
		
	}


	public Emp(int empno, String ename, String job, double sal, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.deptno = deptno;
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptno=" + deptno
				+ "]";
	}


	@Override
	public int compareTo(Emp o) {
		
	 if(this.sal>o.sal)
		 return 1;
	 else if(this.sal<o.sal)
		 return -1;
	 else
	     return this.empno-o.empno;
	 
	}
	
	
}
