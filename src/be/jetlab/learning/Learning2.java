package be.jetlab.learning;


import winterwell.jtwitter.Twitter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Learning2 extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	
	private static final String TAG = "StatusActivity";
	EditText editText;
	Button updateButton;
	Twitter twitter;
	Vibrator vibe;
	
	
	@SuppressWarnings("deprecation")
	@Override
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);

        

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);



        
        editText = (EditText) findViewById(R.id.editText);
        updateButton = (Button) findViewById(R.id.buttonUpdate);
        
        updateButton.setOnClickListener(this);
        
        	
        	
        twitter = new Twitter("nauw", "tttttt");
        twitter.setAPIRootUrl("http://yamba.marakana.com/api");
        Toast.makeText(getApplicationContext(), R.string.hello,10).show();
    }
    
	public void onClick(View v){	
		String status = editText.getText().toString();
		
		vibe.vibrate(30);
		
		PostTwitter AsyncPost = new PostTwitter();
		AsyncPost.initVariables(twitter, this);	
		AsyncPost.execute(status);
		Log.d(TAG, "onClicked");
		
	}
    
    public void closeHandler(View view){    	
    	finish();
    }
    
    public void onDestroy(){
    	super.onDestroy();
    	Toast.makeText(getApplicationContext(), R.string.bye,10).show();
    }
    
    
    public void switchLayout(){
    	setContentView(R.layout.main);
    }
    
}