package toranzam.system;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import android.os.Bundle;

public class mainActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	ViewFlipper viewFlipper;
	  
	  Animation inFromRightAnimation;
	  Animation inFromLeftAnimation;
	  Animation outToRightAnimation;
	  Animation outToLeftAnimation;
	
    private GestureDetector mGestureDetector;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        
        mGestureDetector = new GestureDetector(this, mOnGestureListener);

        findViews();
        setAnimations();
        
    }    
    
    public boolean onTouchEvent(MotionEvent event){
    	return mGestureDetector.onTouchEvent(event);
    }
   
    protected void findViews(){
        viewFlipper = (ViewFlipper)findViewById(R.id.flipper);
      }
      

      
      protected void setAnimations(){    
        inFromRightAnimation = 
          AnimationUtils.loadAnimation(this, R.anim.right_in);
        inFromLeftAnimation = 
          AnimationUtils.loadAnimation(this, R.anim.left_in);
        outToRightAnimation = 
          AnimationUtils.loadAnimation(this, R.anim.right_out);
        outToLeftAnimation = 
          AnimationUtils.loadAnimation(this, R.anim.left_out);
      }
    
    
    
    private final SimpleOnGestureListener mOnGestureListener = new SimpleOnGestureListener(){
    
    public boolean onFling(MotionEvent e1 // TouchDown時のイベント
            ,MotionEvent e2   // TouchDown後、指の移動毎に発生するイベント
            ,float velocityX  // X方向の移動距離
            ,float velocityY)  // Y方向の移動距離
    {
        // 絶対値の取得
        float dx = Math.abs(velocityX);
            float dy = Math.abs(velocityY);
            // 指の移動方向(縦横)および距離の判定
            if (dx > dy && dx > 200) {
                // 指の移動方向(左右)の判定
                    if (e1.getX() < e2.getX()) {
                    	viewFlipper.setInAnimation(inFromLeftAnimation);
                        viewFlipper.setOutAnimation(outToRightAnimation);
                        viewFlipper.showPrevious();
                    } else {
                    	viewFlipper.setInAnimation(inFromRightAnimation);
                        viewFlipper.setOutAnimation(outToLeftAnimation);
                        viewFlipper.showNext();
                    }
                    return true;
            }
        return false;
    }
    };


	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
    
}