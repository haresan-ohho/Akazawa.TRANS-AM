package ne.jp.android;

import java.util.Timer;
import java.util.TimerTask;


import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.Window;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MyAndroidApplActivity extends Activity {
	//TODO �C�ʂ̐ݒ�@���W�̎擾
	private Timer tmr = null;
	Handler mHandler = new Handler();
	MyDrawingView view;
	MyDrawingView testview;
	Timer tmr2 = null;
	newTimertask task =new newTimertask();
	boolean flag;
	
	int countTimer=0;//�����Ă�Ԃ̎���
	int speedV = 0; //���x�̕ϐ�
    int speedVX = 0;//X�̈ړ���
    int speedVY = 0;//Y�̈ړ���
    int countkakudo = 0;//�p�x
    
    final int f_kakudo=10;
    
    int kasokudo = 1;
    
    byte kakudoflag =0;
    boolean m_flag =false;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		view = new MyDrawingView(this, null);
		testview = (MyDrawingView)findViewById(R.id.login_id);//
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
						if(kakudoflag==1){
							countkakudo += f_kakudo;
							if(countkakudo >= 351)
								countkakudo = 0;
						}
						if(kakudoflag==2){
							countkakudo -= f_kakudo;
							if(countkakudo <= -351)
								countkakudo = 0;
						}
						if(m_flag==true)
							view.sets_set(view.getS_width() - speedVX,view.getS_height() - speedVY);
		                speedV = SPEEDfunc(speedV, kasokudo, countTimer);
		                speedVX = SPEEDXfunc(speedV, countkakudo);
		                speedVY = SPEEDYfunc(speedV, countkakudo);
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
						if(flag == true)
							countTimer+=1;
						else
							countTimer=0;
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
				    kakudoflag = 1;
				    Log.d("count", String.valueOf(countkakudo));

					return true;
				case KeyEvent.KEYCODE_DPAD_LEFT: // �\�������L�[
					kakudoflag = 2;
//					countkakudo -= f_kakudo;
//					if(countkakudo <= -351)
//						countkakudo = 0;
					return true;
				case KeyEvent.KEYCODE_DPAD_DOWN: // �\�������L�[
					return true;
				case KeyEvent.KEYCODE_DPAD_UP: // �\�������L�[
					Log.d("move", String.valueOf(view.getS_width()));
					m_flag=true;
					
					return true;
				case KeyEvent.KEYCODE_Z: // �\�������L�[
					return true;
				case KeyEvent.KEYCODE_T: // �\�������L�[
					return true;
				default:
			}
		}
		if (event.getAction() == KeyEvent.ACTION_UP) { // �L�[�������ꂽ��
			switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_DPAD_UP:
					m_flag=false;
					speedV=0;
					return true;
				case KeyEvent.KEYCODE_DPAD_RIGHT: // �\�������L�[
					kakudoflag=0;
					return true;
				case KeyEvent.KEYCODE_DPAD_LEFT: // �\�������L�[
					kakudoflag=0;
					return true;
	    	}
			flag=false;
		}
		return super.dispatchKeyEvent(event);
	}
	private int SPEEDfunc(int V, int a, int t){
		V += a * t;
		if(V >= 100){
			V = 100;
		}
		return V;
	}
	private int SPEEDXfunc(int V, int kakudo){
		int Vx;
		Vx = (int)Math.round((double)V * Math.cos((-(double)kakudo / 180.0) * Math.PI));
		return Vx;
	}
	private int SPEEDYfunc(int V, int kakudo){
		int Vy;
		Vy = (int)Math.round((double)V * Math.sin((-(double)kakudo / 180.0) * Math.PI));
		return Vy;
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
