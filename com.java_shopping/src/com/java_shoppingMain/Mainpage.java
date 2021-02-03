package com.java_shoppingMain;

import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainpage {
    public static void main(String[] args) {
        HashMap<String, String> userInfo = new HashMap<String, String>(); //유저 DB
        ArrayList<String> catagoryList = new ArrayList<String>(); // 상품 DB


        Scanner scanner = new Scanner(System.in);
        //테스트용
        catagoryList.add("육류");
        userInfo.put("admin", "master123");

        boolean checkManager = false; //관리자 로그인 확인
        boolean loginNow = false; //현재 로그인 상태
        String whoIsLogin = null; //현재 로그인 한 사람
        int page = 1; //현재 페이지


        System.out.println(userInfo.get("admin"));

        while(page != 0) { //초기화면구성
            //미로그인단
            System.out.println("Wellcome to Shopping mall"); //인사말
            if(!loginNow) {
                System.out.println("\nSelect menu");
                System.out.println("1. login \n2. sign in \n3. sign out \n0. exit.\n");
                try {
                    int input = scanner.nextInt();
                    if(input == 1) {
                        System.out.println("Write Your ID: "); //아이디
                        String userID = scanner.next();
                        if(!userInfo.containsKey(userID)) {
                            System.out.println("Member ID not found.");
                            continue;
                        }

                        System.out.println("Wirte Your Password: "); //비밀번호 
                        String userPassword = scanner.next();


                        if(userInfo.get(userID).equals(userPassword)) {
                            System.out.println("Succesful Sign in.\n");
                            whoIsLogin = userID;
                            if(userID.equals("admin")) {
                                checkManager = true;
                            }
                            loginNow = true;
                            continue;
                        } else {
                            System.out.println("Login fail");
                            continue;
                        }

                    }
                    if(input == 2) { //회원가입단
                        int signin = 1;
                        while(signin == 1){
                            String signInID = null, signInPW = null;
                            System.out.println("please writedown your information.");
                            System.out.println("If you want to go back, enter \"exit\".");
                            for(int check = 1; check < 2; check++) {
                                System.out.print("\n YourID : ");
                                signInID = scanner.next();  //id 체크. 더 나은 방법을 찾아야 함. 공백시 에러, 공백 제거(trim) 기능 추가요
                                if(signInID.equals("exit")) { 
                                	System.out.println("cencle \n\n");
                                    break;
                                }
                                if(userInfo.containsKey(signInID)) {
                                    System.out.println("This ID is already.");
                                    check--;
                                    continue;
                                }
                                if(signInID != null) {
	                                System.out.print("\nYour PassWord(not less than 4 but not more than 12 digits) : ");
	                                signInPW = scanner.next();
	                                if(signInPW.length() < 4 || signInPW.length() > 12) {
	                                    System.out.println("not less than 4 but not more than 12 digits");
	                                    check--;
	                                    continue;
	                                }
                                } // 비밀번호단 끝
                            } //회원가입 종료 
                            if(signInID != null && signInPW != null) { //아이디, 비밀번호가 모두 적용됨
                                userInfo.put(signInID, signInPW);
                                System.out.println("Wellcome. " + signInID);
                            }
                            signin++;
                        } //회원가입 반복 종료
                    }//회원가입 종료
                    if(input == 3) { //회원탈퇴단
                    	System.out.println("Please write down your ID to withdraw from the membership.");
                        String signOutID = scanner.next();
                        System.out.println("Searching...");
                        if(!userInfo.containsKey(signOutID)) {
                        	System.out.println("Don't Find ID!!");
                        	continue;
                        } else if(signOutID.equals("admin")) {
                        	System.out.println("error");
                        	continue;
                        } else {
                        	System.out.println("\nplease write your password.");
                        	String signOutPW = scanner.next();
                        	if(userInfo.get(signOutID).equals(signOutPW)) {
                        		System.out.println("remove Success");
                        		userInfo.remove(signOutID);
                        		continue;
                        	} else {
                        		System.out.println("not macthed.");
                        		continue;
                        	}
                        }


                    }
                    if(input < 0 || input > 3) {
                        System.out.println("please write to 1 or 2 or 3 or 0");
                    }                
                    if(input == 0) { //반복 종료
                        scanner.close();
                        break;
                    }

            } catch(InputMismatchException e) {
                System.out.println("please write number"); //인풋에러
                scanner.next();
            }


            }//미로그인단 끝

            if(loginNow) { //로그인단
                System.out.println("Hello, "+whoIsLogin+"\n");
                boolean loginWhile = true;
                if(checkManager) { //매니저 여부
                    System.out.println("**** admin page ****");
                    System.out.println("Select menu");
                    System.out.println("1. logout \n2. show shopping category \n3. add to category \n4. show item list \n5. add to item \n0. exit \n");
                } else {
                    System.out.println("Select menu");
                    System.out.println("1.logout \n2. show shoping category \n0. exit.\n");
                }
                try{
                    while(loginWhile) { // 로그인 후 반복문
                    	int selectLogin = 1;
                    	while(selectLogin == 1) {
	                        int input = scanner.nextInt();
	                        if(input == 1) { //로그아웃
	                            System.out.println("logout...");
	                            loginNow = false;
	                            loginWhile = false;
	                            break;
	                        }            
	                        if(input == 2) { //카테고리
	                            System.out.println("select for category.\n");
	                            if(catagoryList.size() == 0) {
	                                System.out.println("Oops, We don't have any item. Sorry!");
	                                continue;
	                            }
	                            for(int index = 0; index < catagoryList.size(); index++) {
	                                System.out.println((index+1) +". "+ catagoryList.get(index));
	                            }
	                            continue;
	                        }
	                        if(input == 3) {
	                            if(!checkManager) {
	                                continue;
	                            }
	                            System.out.println("admin only page.");
	                        }
	                        if(input == 4) {
	                            if(!checkManager) {
	                                continue;
	                            }
	                            System.out.println("admin only page.");
	                        }
	                        if(input == 5) {
	                        	for(String key : userInfo.keySet()) {
	                        		System.out.println(key +" "+ userInfo.get(key));              		
	                        	}
	                        	continue;
	                        }

	                        if(input == 0) { //프로그램 종료 (현재 작동 안함!!)
	                        	System.out.println("Good Bye.");
	                            System.exit(page);
	                            break;
	                        }
                    	}
                    } //로그인 반복문 종료

                } catch(InputMismatchException e) {
                    System.out.println("please write number.");
                    scanner = new Scanner(System.in);
                }
            }
        }//메인 반복문 종료
        System.out.println("Good Bye.");
        scanner.close();
    }//main 함수 종료
} 