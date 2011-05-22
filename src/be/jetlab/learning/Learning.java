package be.jetlab.learning;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import winterwell.jtwitter.Twitter;


public class Learning extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	
	private static final String TAG = "StatusActivity";
	EditText editText;
	Button updateButton;
	Twitter twitter;
	
	
	
	@Override
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);

        
        editText = (EditText) findViewById(R.id.editText);
        updateButton = (Button) findViewById(R.id.buttonUpdate);
        
        updateButton.setOnClickListener(this);
        
        twitter = new Twitter("nauw", "tttttt");
        twitter.setAPIRootUrl("http://yamba.marakana.com/api");
        Toast.makeText(getApplicationContext(), R.string.hello,10).show();
    }
    
	public void onClick(View v){
		
		try {
			twitter.setStatus(editText.getText().toString());
			 Log.d(TAG,"onClicked");
			 Toast.makeText(getApplicationContext(), R.string.statusSuccess,10).show();
			 editText.getText().clear();
		}catch (Exception e){
			Toast.makeText(getApplicationContext(), e.getMessage(),10).show();
		}
		 
		
	
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