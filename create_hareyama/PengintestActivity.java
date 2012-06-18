package akazawa.f.seiei;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PengintestActivity extends Activity{
    /** Called when the activity is first created. */
	
	// 部品宣言
    private Bitmap bfbmp;
    private Bitmap afbmp;
    private ImageView penginImgView;
    private Resources rs;   // リソース宣言
    private Button rButton;
    private Button lButton;
    private int bfwidth;   // 加工前のbitmapの幅
    private int bfheight;   // 加工前のbitmapの高さ
    private int rad = 0;
    private int radplus = 10;   // プラス管理
    private int radminus = -10;   // マイナス管理
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pentest);
       
        // 部品照合
        penginImgView = (ImageView) findViewById(R.id.penginImageView);
        rButton = (Button)findViewById(R.id.rbutton);
        lButton = (Button)findViewById(R.id.lbutton);

        // 他クラスから引っ張ってきます
        // Bitmap更新時のメモリー解放
        final memoryrecycle mrecycle = new memoryrecycle();
        
        // ラジアン加算
        rButton.setOnTouchListener(new View.OnTouchListener(){

			public boolean onTouch(View vv, MotionEvent me) {
				// TODO 自動生成されたメソッド・スタブ
				if(me.getAction() == MotionEvent.ACTION_DOWN){
					mrecycle.bmpmemoryRecycle(bfbmp);
					Matrix matrix = new Matrix();
					rs = getResources();
					bfbmp = BitmapFactory.decodeResource(rs, R.drawable.pengin);
					rad += radplus;
					matrix.postRotate(rad);
					bfwidth = bfbmp.getWidth();
					bfheight = bfbmp.getHeight();
					mrecycle.bmpmemoryRecycle(afbmp);
					afbmp = Bitmap.createBitmap(bfbmp, 0, 0, bfwidth, bfheight, matrix, true);
					penginImgView.setImageBitmap(afbmp);
				}
				else if(me.getAction() == MotionEvent.ACTION_UP){
				}
			    return false;
			}

        });
        
        // ラジアン減算
        lButton.setOnTouchListener(new View.OnTouchListener(){

			public boolean onTouch(View vv, MotionEvent me) {
				// TODO 自動生成されたメソッド・スタブ
				if(me.getAction() == MotionEvent.ACTION_DOWN){
					mrecycle.bmpmemoryRecycle(bfbmp);
			        Matrix matrix = new Matrix();
			        rs = getResources();
			        bfbmp = BitmapFactory.decodeResource(rs, R.drawable.pengin);
			        rad += radminus;
					matrix.postRotate(rad);
			        bfwidth = bfbmp.getWidth();
			        bfheight = bfbmp.getHeight();
					mrecycle.bmpmemoryRecycle(afbmp);
			        afbmp = Bitmap.createBitmap(bfbmp, 0, 0, bfwidth, bfheight, matrix, true);
			        penginImgView.setImageBitmap(afbmp);
				}
				else if(me.getAction() == MotionEvent.ACTION_UP){
				}
				return false;
			}
        });
        
    }
}

// 失敗作共
//bfbmp = BitmapFactory.decodeFile("drawable/pengin.gif");
//bfbmp = BitmapFactory.decodeResource(rs, R.id.penginImageView);
//decodeResource(penginImgView.getResources(), penginImgView.getId());
// ペンギンの大きさは 80,80である
//int penrad = ();
//penginImgView.setScaleType(ScaleType.MATRIX);
//matrix.postTranslate((penW/2), (penH/2));//最終的に動かしたい地点へ移動
//matrix.postRotate(penrad);
//matrix.postTranslate(penW, penH);//最終的に動かしたい地点へ移動
//penginImgView.setImageMatrix(matrix);
