package com.java_shoppingTest;

class UserDB {
	private String userName;
	private String userId;
	private String userPw;
	
	public UserDB(String userName,  String userId, String userPw) {
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("changed : "+this.userName+"->"+userName);
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	} //id는 변경 불가 
	
	public String getUserPw() {
		return userPw;
	}
	
	public void setUserPw(String userPw) {
		System.out.println("changed : "+this.userPw+"->"+userPw);
		this.userPw = userPw;
	}
	
	public boolean checkPassword(String userPw) {
		boolean ox;
		if(this.userPw.equals(userPw)) {
			ox = true;
		} else {
			ox = false;
		}	
		return ox;
	}
	
	
	@Override
	public String toString() {
		String str = "name: "+ userName +" id: "+ userId +" pw: "+ userPw;
		return str;
	}
	
} //UserDB class end