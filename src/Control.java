import java.util.ArrayList;
import java.util.Scanner;

public class Control {
	
	public static void main(String[] args) {
		ArrayList<String> alName = new ArrayList<String>();
		ArrayList<Integer> alPrice = new ArrayList<Integer>();
			
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print("작업 선택 [m:메뉴관리,o:주문관리,s:실적관리,x:종료] ");
			String ins = s.nextLine();
			
			if(ins.equals("x")||ins.equals("X")) break;
			switch(ins) {
			case "m","M":
				doMenu(alName,alPrice); // 메소드호출, call
				break;
			case "o","O":
				doOrder(alName, alPrice);
				break;
			case "s","S":
				doSales();
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	public static void doMenu(ArrayList<String> aName,
							  ArrayList<Integer> aPrice) { // 메소드선언(정의)
		Scanner s1 = new Scanner(System.in);
		while(true) {
			System.out.print("작업선택 [c:메뉴추가,u:메뉴수정,d:메뉴삭제,r:메뉴보기,x:종료] ");
			String mch=s1.nextLine();
			if(mch.equals("x")||mch.equals("X")) break;
			switch(mch) {
			case "c","C":
				addMenu(aName, aPrice);
				break;
			case "u","U":
				updateMenu(aName,aPrice);
				break;
			case "d","D":
				deleteMenu(aName,aPrice);
				break;
			case "r","R":
				System.out.println("메뉴보기");
			}
		}
	}
	public static void addMenu(ArrayList<String> _Name,
							   ArrayList<Integer> _Price) {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print("메뉴명 ['':종료] ");
			String name=s.nextLine();
			if(name.equals("")) break;
			
			System.out.println("가격 [''/0:종료] ");
			String strPrice=s.nextLine();
			if(strPrice.equals("")) break;
			if(!isNumber(strPrice)) break;
			int price = Integer.parseInt(strPrice);
			if(price==0) break;
			
			_Name.add(name);
			_Price.add(price);
		}
		for(int i=0; i<_Name.size(); i++) {
			System.out.println(_Name.get(i)+", "+_Price.get(i));
		}
	}
	public static void updateMenu(ArrayList<String> _Name,
								  ArrayList<Integer> _Price) {
		// Scanner
		while(true) {
			// 메뉴번호 읽기
			// 메뉴번호가 1보다 작으면 종료
			// 새멤뉴명 읽기
			// 새 값 읽기
		}
	}
	public static void deleteMenu(ArrayList<String> _Name,
			  ArrayList<Integer> _Price) {
		
	}
	public static void doOrder(ArrayList<String> aName,
							   ArrayList<Integer> aPrice) {
		ArrayList<String> alMenu = new ArrayList<String>();
		ArrayList<Integer> alCount = new ArrayList<Integer>();
		ArrayList<Integer> alSum = new ArrayList<Integer>();
		
		Scanner s = new Scanner(System.in);

		for(int i=0; i<aName.size(); i++) {
			System.out.println(aName.get(i)+", "+aPrice.get(i));
		}
		
		while(true) {
			System.out.print("작업선택 [c:주문추가,d:주문삭제,r:주문보기,x:주문종료] ");
			String mch=s.nextLine();
			if(mch.equals("x")||mch.equals("X")) break;
			switch(mch) {
			case "c","C":
				addOrder(_Name,_Price,alMenu,alCount,alSum);
				break;
			case "d","D":
				alMenu.clear(); alCount.clear(); alSum.clear();
				break;
			case "r","R":
				showOrder(alMenu,alCount,alSum);
			}
		}
	}
	public static void doSales() {
		Scanner s1 = new Scanner(System.in);
		while(true) {
			System.out.print("작업선택 [r:매출보기,x:보기종료] ");
			String mch=s1.nextLine();
			if(mch.equals("x")||mch.equals("X")) break;
			else if(mch.equals("r")||mch.equals("R")) { 
				System.out.println("매출보기");
			}
		}
	}
	
	public static boolean isNumber(String str) {
        // 정규식을 사용하여 숫자와 소수점만 있는지 확인
        return str.matches("-?\\d*(\\.\\d+)?");
	}
	
	public static void clearAll(ArrayList<String> alName) {
		alName.clear();
		
		while(alName.size()>0) {
			System.out.println(alName.get(0));
			alName.remove(0);
		}
	}
}
