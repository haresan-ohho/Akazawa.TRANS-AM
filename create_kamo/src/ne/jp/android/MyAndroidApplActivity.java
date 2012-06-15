package ne.jp.android;

import java.util.Timer;
import java.util.TimerTask;


import android.view.KeyEvent;
import android.view.Window;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MyAndroidApplActivity extends Activity {

	private Timer tmr = null;
	Handler mHandler = new Handler();
	MyDrawingView view;
	Timer tmr2 = null;
	newTimertask task =new newTimertask();
	boolean flag;
	int hoge=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		view = new MyDrawingView(this);
		setContentView(view);

		// �^�C�}�[���N�����A��ʂ��ĕ`�悳����
		tmr = new Timer(true);
		tmr.schedule(new TimerTask() {
			@Override
			public void run() {
				// mHandler��ʂ���UI Thread�֏������L���[�C���O
				mHandler.post(new Runnable() {
					public void run() {
						view.invalidate();
						if (view.getS_width() < -480)
							view.setS_width(0);
						if (view.getS_width() > 480)
							view.setS_width(0);
					}
				});
			}
		}, 0, 100);
		tmr2 = new Timer(true);
		tmr2.schedule(	new TimerTask() {
			@Override
			public void run() {
				// mHandler��ʂ���UI Thread�֏������L���[�C���O
				mHandler.post(new Runnable() {
					public void run() {
						if(flag=true)
							hoge+=1;
						else
							hoge=0;
					}
				});
			}
		}, 0, 100);
	}

	// �L�[���������Ƃ���ʂ̍��W��ς���
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {// �L�[�������ꂽ��
		//	hoge=task.getPush_time();
			flag=true;
				switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_DPAD_RIGHT: // �\�������L�[
					view.setS_width(view.getS_width() - 20);
					break;
				case KeyEvent.KEYCODE_DPAD_LEFT: // �\�������L�[
					view.setS_width(view.getS_width() + 20);
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN: // �\�������L�[
					view.setS_height(view.getS_height() - 20);
					break;
				case KeyEvent.KEYCODE_DPAD_UP: // �\�������L�[
					view.setS_height(view.getS_height() + 20);
					break;
				case KeyEvent.KEYCODE_Z: // �\�������L�[
					view.setS_height(view.getS_height() + 20);
					view.setS_width(view.getS_width() - 20 );
					break;
				case KeyEvent.KEYCODE_T: // �\�������L�[
					view.setS_height(view.getS_height() + 20);
					break;
				default:
			}
		}
		if (event.getAction() == KeyEvent.ACTION_UP) { // �L�[�������ꂽ��
			tmr2=null;
			flag=false;
		}
		return super.dispatchKeyEvent(event);
	}
	public void keisan(){
		
	}

	public MyDrawingView getView() {
		return view;
	}

}

// �����N���X�i�J�X�^���r���[�j
class newTimertask extends TimerTask{
	private Handler mHandler = new Handler();
	private int push_time=0;
	@Override
	public void run() {
		// mHandler��ʂ���UI Thread�֏������L���[�C���O
		mHandler.post(new Runnable() {
			public void run() {
				push_time+=1;
			}
		});
	}
	//TODO View���������Ȃ���ˁ@�ړ��ʂ�����Ԃ�������
	public int getPush_time() {
		return push_time;
	}
	
}
