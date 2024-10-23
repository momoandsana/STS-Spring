package exam.service;

import org.springframework.stereotype.Service;

@Service("target")
public class MemberServiceImpl implements MemberService {

	@Override
	public void memberInsert(String name) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl memberInsert(String name) 핵심기능입니다");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void memberUpdate() {
		// TODO Auto-generated method stub
System.out.println("MemberServiceImpl memberUpdate() 핵심기능입니다");
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int memberDelete(int no) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl memberDelete(int no) 핵심기능입니다");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 100;
	}

	@Override
	public String select(String keyField, String keyword) {
		// TODO Auto-generated method stub
		
		System.out.println("MemberServiceImpl select(String keyField, String keyword) 핵심기능입니다");
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "좋다!";
	}

}


















