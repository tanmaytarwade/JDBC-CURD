package jdbc.bean;

public class article {
	private int id;
	private String name;
	private String category;
	private String datecreated;
	private String creatorName;
	public article(int id, String name, String category, String datecreated, String creatorName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.datecreated = datecreated;
		this.creatorName = creatorName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", category=" + category + ", datecreated=" + datecreated
				+ ", creatorName=" + creatorName + "]";
	}
	
	
	

}
