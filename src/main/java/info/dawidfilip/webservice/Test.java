package info.dawidfilip.webservice;

public class Test {
	private String name;
	private String company;
	
	public Test() {
	}
	
	public Test(String name, String company) {
		this.name = name;
		this.company = company;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Test [name=" + name + ", company=" + company + "]";
	}
	
	
}
