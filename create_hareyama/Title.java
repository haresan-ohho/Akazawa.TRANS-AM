package trans_am.system.akazawa.f.seiei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Title extends Activity {
	
	// タイトル画面用の部品宣言 TODO
	private TextView	titleName;
	private Button		startButton;
	private Button		howtoButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        
        // タイトル画面用の部品照合 TODO
        titleName		= (TextView) findViewById(R.id.title_text);
        startButton		= (Button) findViewById(R.id.start_button);
        howtoButton		= (Button) findViewById(R.id.howto_button);
        
        // ボタン処理宣言 TODO
        startButton.setOnClickListener(new StartOnClick());
        howtoButton.setOnClickListener(new HowtoOnClick());
    }
    
    // スタートボタンの処理
    class StartOnClick implements OnClickListener {
    	public void onClick(View view){
			finish(); //テスト用
    		
    		// ゲーム画面への遷移処理 TODO
    		Intent intent = new Intent(/*TODO */); // テスト用
    		//Intent intent = new Intent(Title.this, TODO);
			startActivity(intent);
    	}
    }
    
    // ハウトゥボタンの処理
    class HowtoOnClick implements OnClickListener {
    	public void onClick(View view){
			finish(); // テスト用
    		
    		// ハウトゥ画面への遷移処理 TODO
    		Intent intent = new Intent(/*TODO */); // テスト用
    		//Intent intent = new Intent(Title.this, TODO);
			startActivity(intent);
    	}
    }
}