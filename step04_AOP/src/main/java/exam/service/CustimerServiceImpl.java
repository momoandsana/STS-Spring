package exam.service;

public class CustimerServiceImpl implements CustomerService {

	@Override
	public int select() {
		// TODO Auto-generated method stub
		System.out.println("CustomerServiceImpl public int select() ");
		return 100;
	}

	@Override
	public String selectById(String id) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServiceImpl selectById(String id) ");
		if(id==null)throw new RuntimeException("id는 반드시 입력해주세요");
		
		
		return "hello";
	}

	@Override
	public void update(String id, String name) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServiceImpl update(String id, String name)");
	}

}
