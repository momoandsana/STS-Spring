package exam.service;

import org.springframework.stereotype.Service;

@Service("target2")
public class BoardService {
	public void insert(String name) {
		System.out.println("BoardService insert() call");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
