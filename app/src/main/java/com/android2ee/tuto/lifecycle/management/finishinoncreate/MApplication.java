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

import android.app.Application;
import android.util.Log;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 * This class aims to:
 * <ul><li></li></ul>
 */
public class MApplication extends Application {
/*
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
	final String tag="MApplication";
	int numberOfCall=0;
	long delayOnCreate=0;
	long delayOnDestroy=0;
	long delayComplet=0;
	/**
	 * @return the numberOfCall
	 */
	public final int getNumberOfCall() {
		return numberOfCall;
	}
	/**
	 * @param numberOfCall the numberOfCall to set
	 */
	public final void setNumberOfCall(int numberOfCall) {
		this.numberOfCall = numberOfCall;
	}
	
	/**
	 * @return the totalTimeMs
	 */
	public final long getTotalTimeMs() {
		return delayOnCreate+delayOnDestroy;
	}
	
	/**
	 * @return the delayOnCreate
	 */
	public final long getDelayOnCreate() {
		return delayOnCreate;
	}
	/**
	 * @param delayOnCreate the delayOnCreate to set
	 */
	public final void setDelayOnCreate(long delayOnCreate) {
		Log.e(tag, "onCreate takes "+delayOnCreate+" ms");
		this.delayOnCreate = this.delayOnCreate+delayOnCreate;
	}
	/**
	 * @return the delayOnDestroy
	 */
	public final long getDelayOnDestroy() {
		return delayOnDestroy;
	}
	/**
	 * @param delayOnDestroy the delayOnDestroy to set
	 */
	public final void setDelayOnDestroy(long delayOnDestroy) {
		Log.e(tag, "onDestroy takes "+delayOnDestroy+" ms");
		this.delayOnDestroy =this.delayOnDestroy+ delayOnDestroy;
	}
	/**
	 * @return the delayComplet
	 */
	public final long getDelayComplet() {
		return delayComplet;
	}
	/**
	 * @param delayComplet the delayComplet to set
	 */
	public final void setDelayComplet(long delayComplet) {
		Log.e(tag, "Cycle takes "+delayComplet+" ms");
		this.delayComplet = this.delayComplet+delayComplet;
	}
	
}
