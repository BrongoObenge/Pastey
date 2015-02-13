package user;

public class User {

	private String uid = null;
	private String username = null;
	private String lastOnline = null;
	private int groupId = -1;
	
	public User(String uid, String username, String lastOnline, int groupId){
		this.uid = uid;
		this.username = username;
		this.lastOnline = lastOnline;
		this.groupId = groupId;
	}
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastOnline() {
		return lastOnline;
	}

	public void setLastOnline(String lastOnline) {
		this.lastOnline = lastOnline;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
