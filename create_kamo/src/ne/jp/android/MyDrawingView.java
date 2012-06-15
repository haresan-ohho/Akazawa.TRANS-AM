package ne.jp.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class MyDrawingView extends SurfaceView implements SurfaceHolder.Callback {
	Bitmap img;
	private int img_h;
	private int img_w;
	private int width = 800;
	private int s_width = 0;
	private int s_height = 0;
	private int height = 480;

	public MyDrawingView(Context context) {
		super(context);
		setBackgroundColor(Color.WHITE);
		Resources r = context.getResources();
		img = BitmapFactory.decodeResource(r, R.drawable.mu);
		img_h = img.getHeight();
		img_w = img.getWidth();
	}

	// ②描画のためのコールバックメソッド
	@Override
	public boolean onTouchEvent(MotionEvent m) {
		invalidate();
		return super.onTouchEvent(m);

	}

	@Override
	protected void onDraw(Canvas canvas) {

		// ③ペイント（Paint）を生成
		Paint paint = new Paint();
		paint.setStrokeWidth(50);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setColor(Color.WHITE);

		// ④Canvasに描画
		// canvas.drawBitmap(img,0,0,null);
		// new Rect(開始x,開始y,終了x,終了y)
		// ２枚目画像
		if (s_width < 0) {
			canvas.drawBitmap(img, new Rect(0, img_h / 10 * 4, img_w,
					img_h / 10 * 4 + 480), new Rect(s_width + 480, s_height,
					s_width + 960, s_height + 800), null);
		}
		else if (s_width > 0) {
			canvas.drawBitmap(img, new Rect(0, img_h / 10 * 4, img_w,
					img_h / 10 * 4 + 480), new Rect(s_width - 480, s_height,
					s_width, s_height + 800), null);
		}
		// 1枚目画像
		canvas.drawBitmap(img, new Rect(0, img_h / 10 * 4, img_w,
				img_h / 10 * 4 + 480), new Rect(s_width, s_height, s_width + 480,
				s_height + 800), null);

	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO 自動生成されたメソッド・スタブ
		// img = img.createScaledBitmap(img, width, height, true);
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setS_width(int s_width) {
		this.s_width = s_width;
	}

	public int getS_width() {
		return s_width;
	}
	public int getS_height() {
		return s_height;
	}
	
	public void setS_height(int s_height) {
		this.s_height = s_height;
	}

}
