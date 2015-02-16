package model;

public class Paste {
	private String title;
	private String time;
	private int id;
	private String password;
	private String text;

	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
