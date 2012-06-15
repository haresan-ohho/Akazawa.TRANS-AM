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

		// タイマーを起動し、画面を再描画させる
		tmr = new Timer(true);
		tmr.schedule(new TimerTask() {
			@Override
			public void run() {
				// mHandlerを通じてUI Threadへ処理をキューイング
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
				// mHandlerを通じてUI Threadへ処理をキューイング
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

	// キーを押したとき画面の座標を変える
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {// キーが押された時
		//	hoge=task.getPush_time();
			flag=true;
				switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_DPAD_RIGHT: // 十字中央キー
					view.setS_width(view.getS_width() - 20);
					break;
				case KeyEvent.KEYCODE_DPAD_LEFT: // 十字中央キー
					view.setS_width(view.getS_width() + 20);
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN: // 十字中央キー
					view.setS_height(view.getS_height() - 20);
					break;
				case KeyEvent.KEYCODE_DPAD_UP: // 十字中央キー
					view.setS_height(view.getS_height() + 20);
					break;
				case KeyEvent.KEYCODE_Z: // 十字中央キー
					view.setS_height(view.getS_height() + 20);
					view.setS_width(view.getS_width() - 20 );
					break;
				case KeyEvent.KEYCODE_T: // 十字中央キー
					view.setS_height(view.getS_height() + 20);
					break;
				default:
			}
		}
		if (event.getAction() == KeyEvent.ACTION_UP) { // キーが離された時
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

// 内部クラス（カスタムビュー）
class newTimertask extends TimerTask{
	private Handler mHandler = new Handler();
	private int push_time=0;
	@Override
	public void run() {
		// mHandlerを通じてUI Threadへ処理をキューイング
		mHandler.post(new Runnable() {
			public void run() {
				push_time+=1;
			}
		});
	}
	//TODO Viewを解決しなきゃね　移動量だけを返したいな
	public int getPush_time() {
		return push_time;
	}
	
}
