package akazawa.f.seiei;

import android.graphics.Bitmap;

// 様々なメモリー解放を司ります
// 特に画像描写はその都度解放しないと処理落ちします

public class memoryrecycle {
	public Bitmap bmpmemoryRecycle(Bitmap bmp){
		if(bmp != null){
			bmp.recycle();
			bmp = null;
		}
		return bmp;
	}
	
}
