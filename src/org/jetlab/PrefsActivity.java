/**
 * 
 */
package org.jetlab;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * @author arnaud
 *
 */
public class PrefsActivity  extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
		}
	
	

}
