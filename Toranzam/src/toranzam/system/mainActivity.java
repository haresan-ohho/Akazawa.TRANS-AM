package toranzam.system;


import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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
	  private Button		button1;
	  private Button		button2;
	  private Button		button3;
	  private Button		button4;
	  private Button		button5;
	  private Button		button6;
	  private Button		button7;
	  
    
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
      
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        
        mGestureDetector = new GestureDetector(this, mOnGestureListener);
        
        findViews();
        setAnimations();       
        
        button1		= (Button) findViewById(R.id.button1);
        button2		= (Button) findViewById(R.id.button2);
        button3		= (Button) findViewById(R.id.button3);
        button4		= (Button) findViewById(R.id.button4);
        button5		= (Button) findViewById(R.id.button5);
        button6		= (Button) findViewById(R.id.button6);
        button7		= (Button) findViewById(R.id.button7);
        
        
        button1.setOnClickListener(new backOnClick());
        button2.setOnClickListener(new backOnClick());
        button3.setOnClickListener(new backOnClick());
        button4.setOnClickListener(new backOnClick());
        button5.setOnClickListener(new backOnClick());
        button6.setOnClickListener(new backOnClick());
        button7.setOnClickListener(new backOnClick());
        
    }
        
        
    	@Override
    	public boolean dispatchTouchEvent(MotionEvent event) {
    		return mGestureDetector.onTouchEvent(event)
            || super.dispatchTouchEvent(event);
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

class backOnClick implements OnClickListener {
	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		finish(); //テスト用
		Intent intent = new Intent(mainActivity.this, Title.class);
		startActivity(intent);
	}
	
}
    

}