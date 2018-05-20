/**
 * 
 */
package be.jetlab.learning;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * @author ACR
 * Adding some more comment to test branch git
 */
public class PostTwitter extends AsyncTask<String, Integer, String>{
	

	private static final String TAG = "PostTwitter";
	Twitter twitter;
	Context context;
	String success;
	
	public void initVariables(Twitter tweet, Context context){
		
		this.twitter = tweet;
		this.context = context;
		
	}
	
	protected String doInBackground(String... statuses){
		
		try{
			@SuppressWarnings("unused")
			Twitter.Status status = twitter.updateStatus(statuses[0]);
			success = "Message sent";
			
		}catch (TwitterException e){
			Log.e(TAG, e.toString());
			e.printStackTrace();
			success = "Faild to post";			
		}
		return success;
	}

	// Called when there's a status to be updated
	@Override
	protected void onProgressUpdate(Integer... values) { //
		super.onProgressUpdate(values);
		// Not used in this case
	}

	// Called once the background activity has completed
	@Override
	protected void onPostExecute(String result) { //
		Toast.makeText(this.context, result, Toast.LENGTH_LONG).show();
		Log.d(TAG, result);
		}
		
}
