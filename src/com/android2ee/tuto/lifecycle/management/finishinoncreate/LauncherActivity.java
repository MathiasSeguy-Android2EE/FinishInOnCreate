/**<ul>
 * <li>FinishInOnCreate</li>
 * <li>com.android2ee.tuto.lifecycle.management.finishinoncreate</li>
 * <li>19 avr. 2013</li>
 * 
 * <li>======================================================</li>
 *
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 *
 /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br> 
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 *  Belongs to <strong>Mathias Seguy</strong></br>
 ****************************************************************************************************************</br>
 * This code is free for any usage except training and can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * 
 * *****************************************************************************************************************</br>
 *  Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 *  Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br> 
 *  Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 *  <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */
package com.android2ee.tuto.lifecycle.management.finishinoncreate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class LauncherActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {

		super.onResume();
		MApplication app = ((MApplication) getApplication());
		int callNum = app.getNumberOfCall();
		if (callNum < 100) {
			Log.e("LauncherActivity", "Called "+callNum);
			Intent mainAct = new Intent(this, MainActivity.class);
			startActivity(mainAct);
			callNum++;
			((MApplication) getApplication()).setNumberOfCall(callNum);
			
		} else {
			setContentView(R.layout.activity_main);
			TextView txv = (TextView) findViewById(R.id.txvValue);
			StringBuilder strb = new StringBuilder("Time results (over 100 iteration) : \r\n");
			strb.append("OnCreate time " + (app.getDelayOnCreate() ) + "\r\n");
			strb.append("OnDestro time " + (app.getDelayOnDestroy() ) + "\r\n");

			strb.append("Activity life time time " + (app.getDelayComplet()) + "\r\n");
			Log.e("LauncherActivity", strb.toString());
			txv.setText(strb.toString());
		}

	}

}
