package be.jetlab.learning;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;

public class Learning3 extends Activity implements OnClickListener, TextWatcher {
	/** Called when the activity is first created. */

	private static final String TAG = "StatusActivity";
	EditText editText;
	Button updateButton;
	Twitter twitter;
	TextView textCount;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);

		editText = (EditText) findViewById(R.id.editText);
		updateButton = (Button) findViewById(R.id.buttonUpdate);

		updateButton.setOnClickListener(this);

		twitter = new Twitter("nauw", "tttttt");
		twitter.setAPIRootUrl("http://yamba.marakana.com/api");
		Toast.makeText(getApplicationContext(), R.string.hello, 10).show();
		
		textCount = (TextView) findViewById(R.id.textCount);
		textCount.setText(Integer.toString(140));
		textCount.setTextColor(Color.GREEN);
		editText.addTextChangedListener(this);
	}

	// Async post Twitter
	class PostToTwitter extends AsyncTask<String, Integer, String> {
		protected String doInBackground(String... statuses) {
			try {
				Twitter.Status status = twitter.updateStatus(statuses[0]);
				return status.text;
			} catch (TwitterException e) {
				Log.e(TAG, e.toString());
				e.printStackTrace();
				return "Failled to post ";
			}
		}

		// Called when there's a status to be updated
		@Override
		protected void onProgressUpdate(Integer... values) { //
			super.onProgressUpdate(values);
			// Not used in this case
			//Toast.makeText(Learning3.this, R.string.loading, Toast.LENGTH_LONG).show();
		}

		// Called once the background activity has completed
		@Override
		protected void onPostExecute(String result) { //
			Toast.makeText(Learning3.this, result, Toast.LENGTH_LONG).show();
			editText.setText("");
		}

	}

	// Called when button is clicked
	public void onClick(View v) {
		String status = editText.getText().toString();
		new PostToTwitter().execute(status); //
		Log.d(TAG, "onClicked");
	}

	
	public void afterTextChanged(Editable statusText){
		int count = 140 - statusText.length();
		textCount.setText(Integer.toString(count));
		textCount.setTextColor(Color.GREEN);
		
		if(count < 10 )
			textCount.setTextColor(Color.YELLOW);
		if(count < 0)
			textCount.setTextColor(Color.RED);
	}
	
	public void beforeTextChanged(CharSequence s, int start, int count, int after){
		
	}
	
	public void onTextChanged(CharSequence s, int start, int before, int count){
		
	}
	
	public void closeHandler(View view) {
		finish();
	}

	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(), R.string.bye, 10).show();
	}

	public void switchLayout() {
		setContentView(R.layout.main);
	}

}
