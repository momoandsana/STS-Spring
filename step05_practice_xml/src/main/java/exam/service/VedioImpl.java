package exam.service;

import org.springframework.stereotype.Service;

@Service("Video")
public class VedioImpl implements Player {

	@Override
	public void start(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public String pause() {
		// TODO Auto-generated method stub
		//System.out.println("Video pause 호출\n");
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
