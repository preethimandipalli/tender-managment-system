package model;

public class Tender {
	private String title;
	private String description;
	//int bidprice = 100000;
	private int baseprice;
	public User winner = null;
	
	public Tender(String title, String description, int baseprice) {
		super();
		this.title = title;
		this.description = description;
		this.baseprice = baseprice;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(int baseprice) {
		this.baseprice = baseprice;
	}
	/*public void declarewinner(int p, User u) {
		if(p <= bidprice && p >= baseprice ) {
			winner = u;
			bidprice=p;
		}
	}*/
	
	
	
	
	
	
	

}
