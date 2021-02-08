package com.java_shoppingTest;

import java.util.Scanner;
import java.util.ArrayList;

public class Testpage {
	public static void main(String[] args) {
		ArrayList<UserDB> userData = new ArrayList<UserDB>(); 
		ArrayList<Category> categoryData = new ArrayList<Category>();
		Scanner scan = new Scanner(System.in);
		userData.add(new UserDB("123", "123", "123"));
		int playTest = 0;
		int test = 1;
		while(playTest < 2) {
			test = 1;
			while(test == 1) {
				System.out.println("sign up test");
				String id = scan.nextLine();
				boolean dupChk = true;
				for(UserDB check : userData) {
					String chkId = check.getUserId();
					if(chkId.equals(id)) {
						System.out.println("duplicate.");
						dupChk = false;
						break;
					}
				}
				if(dupChk) {
					System.out.println("name: ");
					String name = scan.nextLine();
					System.out.println("password: ");
					String pw = scan.nextLine();
					userData.add(new UserDB(name, id, pw));
					for(int i=0; i < userData.size(); i++) {
						System.out.println(userData.get(i));
					}
					
					test++;
				}
			}
			while(test == 2) {
				System.out.println("ID: ");
				String inputId = scan.nextLine();
				for(UserDB index : userData) {
					if(index.getUserId().equals(inputId)) {
						System.out.println("PW: ");
						String inputPw = scan.nextLine();
						boolean passLogin = index.checkPassword(inputPw);
						if(passLogin) {
							System.out.println("Success");
							test++;
						} else {
							System.out.println("incorrect password.");
						}
					}
				}
				
				if(test == 2) { System.out.println("login fail."); }
			}
			
			while(test == 3) {
				System.out.println("Make Category class");
				boolean dupChk = true;
				String catName = scan.nextLine();
				for(Category check : categoryData) {
					String chkcat = check.getCategory();
					if(catName == chkcat) {
						System.out.println("duplicate.");
						dupChk = false;
						break;
					}
				}
				if(dupChk) {
					categoryData.add(new Category(catName));
					System.out.println("Category Name: ");
					
					for(Category index : categoryData) {
						System.out.println(index.getCategory());
					}
				}
				
				test++;
			}
			playTest++;
		}
		scan.close();
	}
}