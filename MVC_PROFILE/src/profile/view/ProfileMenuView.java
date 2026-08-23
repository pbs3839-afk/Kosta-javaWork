package profile.view;

import java.util.Scanner;

import profile.controller.ProfileController;
import profile.dto.Profile;

public class ProfileMenuView {
	private Scanner sc = new Scanner(System.in);
	private ProfileController controller = new ProfileController();

	public void printMenu() {
		while (true) {
			System.out.println("다음 사항에 맞게 입력하여 주십시오");
			System.out.println("몸무게 입력은 1 번");
			System.out.println("몸무게 검색은 2번");
			System.out.println("몸무게 변경은 3번");
			System.out.println("비밀번호 변경은 4번");
			System.out.println("프로그램 종료는 5번");
			System.out.println("을 입력후 Enter을 눌러 주십시오");
			System.out.println("메뉴 선택 : ");
			
			String menu = sc.nextLine();
			switch (menu) {
			case"1" :
				insert();
				break;
			case"2" :
				search();
				break;
			case"3" :
				updateWeight();
				break;
			case"4" :
				updatePassword();
				break;
			case"5" :
				System.out.println("프로그램을 종료합니다.");
			default:
				System.out.println("메뉴를 다시 선택해주세요");
			}
		}
	}

	private void insert() {
		System.out.println("이름을 입력하여 주십시오.");
		System.out.println("이름 :");
		String name  = sc.nextLine();
		
		System.out.println("몸무게를 입력하여 주십시오");
		System.out.println("몸무게 :");
		int weight = Integer.parseInt(sc.nextLine());
		
		System.out.println("비밀번호를 입력하여 주십시오");
		System.out.println("비밀번호 :");
		int password = Integer.parseInt(sc.nextLine());
		
		int result = controller.insert(name, weight, password);
		if (result == -1) {
			System.out.println("이미 존재하는 이름입니다. 다시 입력해주세요");
		}else {
			System.out.println(name + ".txt 파일에 저장되었습니다.0");
		}
	}

	private void search() {
		System.out.println("검색할 이름을 입력하여 주십시오");
		System.out.println("이름 :");
		String name = sc.nextLine();
		
		int Count = 0;
		while (Count < 3 ) {
			System.out.println("비밀번호를 입력하여 주십시오");
			System.out.println("비밀번호 :");
			int password = Integer.parseInt(sc.nextLine());
			
			Profile result = controller.search(name, password);
			if (result != null) {
				System.out.println(name + "님의 몸무게는" + result.getWeight() + "Kg입니다.");
				return;
			}
			System.out.println("비밀번호 오류입니다.");
			Count++;
		}
		System.out.println("비밀번호 오류 횟수를 초과했습니다.");
	}

	private void updateWeight() {
		System.out.println("이름을 입력하여 주십시오.");
		System.out.println("이름 :");
		String name = sc.nextLine();
		
		int Count = 0;
		while (Count < 3 ) {
			System.out.println("비밀번호를 입력하여 주십시오");
			System.out.println("비밀번호 :");
			int password = Integer.parseInt(sc.nextLine());
			
			Profile result = controller.search(name, password);
			if (result != null) {
				System.out.println("현재" + name + "님의 몸무게는" + result.getWeight() + "kg 입니다." );
				System.out.println("변경할 몸무게를 입력하여 주십시오.");
				System.out.println("변경할 몸무게");
				int newWeinght = Integer.parseInt(sc.nextLine());
				
				controller.updateWeight(result, newWeinght);
				System.out.println("몸무게가 " + newWeinght + "kg으로 변경되었습니다.");
				return;
			}	
			 	System.out.println("비밀번호 오류입니다.");
			 	Count++;
		}
		System.out.println("비밀번호 오류 횟수를 초과했습니다.");
	}

	private void updatePassword() {
		System.out.println("이름을 입력하여 주십시오.");
		System.out.println("이름 :");
		String name = sc.nextLine();
		
		int Count = 0;
		while (Count < 3 ) {
			System.out.println("비밀번호를 입력하여 주십시오");
			System.out.println("비밀번호 :");
			int Password = Integer.parseInt(sc.nextLine());
			
			Profile result = controller.search(name, Password);
			if (result != null) {
				System.out.println("현재" + name + "님의 비밀번호는" + result.getPassword() );
				System.out.println("변경할 비밀번호를 입력하여 주십시오.");
				System.out.println("변경할 비밀번호 : ");
				int newPassword = Integer.parseInt(sc.nextLine());
				
				controller.updatePassword(result, newPassword);
				System.out.println("비밀번호가 변경되었습니다.");
				return;
			}	
			 	System.out.println("비밀번호 오류입니다.");
			 	Count++;
		}
		System.out.println("비밀번호 오류 횟수를 초과했습니다.");
	
	}
}