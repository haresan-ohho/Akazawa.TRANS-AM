package trans_am.system.akazawa.f.seiei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class result extends Activity {
	
	// リザルト画面用の部品宣言 TODO
	private Button retryButton;
	private Button gameoverButton;
	private Button scoreButton;
	
	// スコアー用部品宣言 TODO
	//private TextView highest_jump_Text;				// 最大高度.text
	//private TextView longest_jump_Text;				// 最大飛距離.text
	//private TextView biggest_splash_Text;			// 最大水飛沫.text
	//private TextView longest_tailslide_Text;		// 最大滑走距離.text
	//private TextView highest_speed_Text;			// 最大速度.text
	//private TextView longest_combo_Text;			// 最大曲芸維持時間.text
	//private TextView final_score_Text;				// 最終得点.Text

	private TextView highest_jump_TextValue;		// 最大高度.value
	private TextView longest_jump_TextValue;		// 最大飛距離.value
	private TextView biggest_splash_TextValue;		// 最大水飛沫.value
	private TextView longest_tailslide_TextValue;	// 最大滑走距離.value
	private TextView highest_speed_TextValue;		// 最大速度.value
	private TextView longest_combo_TextValue;		// 最大曲芸維持時間.value
	private TextView final_score_TextValue;			// 最終得点.value
	
	// で、でた～～ｗｗ　受け取ったスコア情報格納変数宣言奴ｗｗ TODO w
	private String highest_jump_String;		// 最大高度数値
	private String longest_jump_String;		// 最大飛距離数値
	private String biggest_splash_String;		// 最大水飛沫数値
	private String longest_tailslide_String;	// 最大滑走距離数値
	private String highest_speed_String;		// 最大速度数値
	private String longest_combo_String;		// 最大曲芸維持時間数値
	private String final_score_String;		// 最終得点数値
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        
        // リザルト画面用の部品照合 TODO
        retryButton		= (Button) findViewById(R.id.retry_Button);
        gameoverButton	= (Button) findViewById(R.id.gameover_Button);
        scoreButton		= (Button) findViewById(R.id.score_Button);
        
        // スコアー用部品宣言 TODO
    	//highest_jump_Text		= (TextView) findViewById(R.id.highest_jump);
    	//longest_jump_Text		= (TextView) findViewById(R.id.longest_jump);
    	//biggest_splash_Text		= (TextView) findViewById(R.id.biggest_splash);
    	//longest_tailslide_Text	= (TextView) findViewById(R.id.longest_tailslide);
    	//highest_speed_Text		= (TextView) findViewById(R.id.highest_speed);
    	//longest_combo_Text		= (TextView) findViewById(R.id.longest_combo);
    	//final_score_Text		= (TextView) findViewById(R.id.final_score);

    	highest_jump_TextValue		= (TextView) findViewById(R.id.highest_jump_value);
    	longest_jump_TextValue		= (TextView) findViewById(R.id.longest_jump_value);
    	biggest_splash_TextValue	= (TextView) findViewById(R.id.biggest_splash_value);
    	longest_tailslide_TextValue	= (TextView) findViewById(R.id.longest_tailslide_value);
    	highest_speed_TextValue		= (TextView) findViewById(R.id.highest_speed_value);
    	longest_combo_TextValue		= (TextView) findViewById(R.id.longest_combo_value);
    	final_score_TextValue		= (TextView) findViewById(R.id.final_score_value);
        
        // ボタン処理宣言 TODO
        retryButton.setOnClickListener(new RetryOnClick());
        gameoverButton.setOnClickListener(new GameOverOnClick());
        scoreButton.setOnClickListener(new ScoreOnClick());
        
        // 受け取った値をぶっちこんでください＾＾； TODO
        Intent intent = getIntent();
    	highest_jump_String			= String.valueOf(intent.getIntExtra("highest_jump", 0));
    	longest_jump_String			= String.valueOf(intent.getIntExtra("longest_jump", 0));
    	biggest_splash_String		= String.valueOf(intent.getIntExtra("biggest_splash", 0));
    	longest_tailslide_String	= String.valueOf(intent.getIntExtra("longest_tailslide", 0));
    	highest_speed_String		= String.valueOf(intent.getIntExtra("highest_speed", 0));
    	longest_combo_String		= String.valueOf(intent.getIntExtra("longest_combo", 0));
        final_score_String			= String.valueOf(intent.getIntExtra("final_score", 0));

    	highest_jump_TextValue.setText(highest_jump_String);
    	longest_jump_TextValue.setText(longest_jump_String);
    	biggest_splash_TextValue.setText(biggest_splash_String);
    	longest_tailslide_TextValue.setText(longest_tailslide_String);
    	highest_speed_TextValue.setText(highest_speed_String);
    	longest_combo_TextValue.setText(longest_combo_String);
    	final_score_TextValue.setText(final_score_String);
        
        
    }
    
    // リトライボタンの処理
    class RetryOnClick implements OnClickListener {
    	public void onClick(View view){
			finish(); //テスト用
    		
    		// ゲーム画面への遷移処理 TODO
    		Intent intent = new Intent(/*TODO */); // テスト用
    		//Intent intent = new Intent(Play.this, TODO);
			startActivity(intent);
    	}
    }
    
    // ゲイむオーバーボタンの処理
    class GameOverOnClick implements OnClickListener {
    	public void onClick(View view){
			finish(); // テスト用
    		
    		// ハウトゥ画面への遷移処理 TODO
    		Intent intent = new Intent(/*TODO */); // テスト用
    		//Intent intent = new Intent(Title.this, TODO);
			startActivity(intent);
    	}
    }

    // スコアーボタンの処理
    class ScoreOnClick implements OnClickListener {
    	public void onClick(View view){
			finish(); // テスト用
    		
    		// スコアー画面への遷移処理 TODO
    		Intent intent = new Intent(/*TODO */); // テスト用
    		//Intent intent = new Intent(Score.this, TODO);
			startActivity(intent);
    	}
    }
}