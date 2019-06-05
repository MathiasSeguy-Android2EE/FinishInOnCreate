package com.android2ee.tuto.lifecycle.management.finishinoncreate;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
                          /**
                           
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
finish();
Returns:
.237: onCreate called
.317: finish called
.337: onCreate finished
.457: onDestroy called
.457: onDestroy finished
onCreate=>100ms
onDestroy=>0ms

finish();
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
Returns:
187: onCreate called
187: finish called
327: onCreate finished
407: onDestroy called
407: onDestroy finished
onCreate=>140ms
onDestroy=>0ms

finish();
super.onCreate(savedInstanceState);
Returns:
857: onCreate called
857: finish called
977: onCreate finished
037: onDestroy called
047: onDestroy finished
onCreate=>120ms
onDestroy=>10ms*/                          
public class MainActivity extends Activity {
	private final String tag = "FinishInOnCreate";
	long debClasse=0;
	int id=(int)(Math.random()*75900);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		long deb=(new Date()).getTime();
		debClasse=deb;
		Log.e(tag, "onCreate called "+id);
		Log.e(tag, "finish called");
		finish();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		long fin=(new Date()).getTime();
		((MApplication)getApplication()).setDelayOnCreate(fin-deb);
		Log.e(tag, "onCreate finished"+id);
	}
	@Override
	protected void onDestroy() {
		long deb=(new Date()).getTime();
		Log.e(tag, "onDestroy called"+id);
		super.onDestroy();
		Log.e(tag, "onDestroy finished"+id);
		long fin=(new Date()).getTime();
		((MApplication)getApplication()).setDelayOnDestroy(fin-deb);
		((MApplication)getApplication()).setDelayComplet(fin-debClasse);
	}

	@Override
	protected void onStart() {
		Log.e(tag, "onStart called");
		super.onStart();
		Log.e(tag, "onStart finished");
	}

	@Override
	protected void onRestart() {
		Log.e(tag, "onRestart called");
		super.onRestart();
		Log.e(tag, "onRestart finished");
	}

	@Override
	protected void onResume() {
		Log.e(tag, "onResume called");
		super.onResume();
		Log.e(tag, "onResume finished");
	}

	@Override
	protected void onPause() {
		Log.e(tag, "onPause called");
		super.onPause();
		Log.e(tag, "onPause finished");
	}

	@Override
	protected void onStop() {
		Log.e(tag, "onStop called");
		super.onStop();
		Log.e(tag, "onStop finished");
	}

	
	@Override
	public void onBackPressed() {
		Log.e(tag, "onBackPressed called");
		super.onBackPressed();
		Log.e(tag, "onBackPressed finished");
	}

}
