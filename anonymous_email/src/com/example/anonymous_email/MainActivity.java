package com.example.anonymous_email;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.nathanhaze.AE.R;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class MainActivity extends Activity {

	//SharedPreferences sharedPrefs;
    //public static final String PREFS_NAME = "MyPrefsFile";
    
	private InterstitialAd interstitial;

    String emailAddress = "";
    String fromAddress = "notme@gmx.com";
    String subject = "hey";
    String message = "";
    
    EditText fromBox;
    EditText subjectBox;
    EditText messageBox;
    EditText toBox;
    
    TextView status;
    TextView lastmessage;
    
    Context context;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_email);
		
		fromBox = (EditText)findViewById(R.id.user_from);
		toBox = (EditText)findViewById(R.id.user_email);
		subjectBox  = (EditText)findViewById(R.id.user_subject);
		messageBox = (EditText)findViewById(R.id.user_message);
		
		status = (TextView)findViewById(R.id.message_result);
		lastmessage = (TextView)findViewById(R.id.message_last);
		
		context = this;
		/*
	//	AdBuddiz.cacheAds(this); // this = current Activity
	//	AdBuddiz.showAd(this); // this = current Activity
		
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.setWebViewClient(new WebViewClient());

		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		myWebView.loadUrl("http://textafriend.site50.net/anonymous_email_mobile.html");
		
        try{
        	sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        } catch (NullPointerException e) {
        	sharedPrefs = null;
        }
        
        if( sharedPrefs != null){
        	int count = sharedPrefs.getInt("count", 0);
        //	SharedPreferences.Editor editor = sharedPrefs.edit();
        	final Editor editor = sharedPrefs.edit();
	        if(count == 1){
	    		showStoreDialog();
	    		count ++;
	        	editor.putInt("count", count);
	        }
	        else if(count == 20){
	        	editor.putInt("count", 1);
	        }
	        else{        	
	        	count++;
	        	editor.putInt("count", count);
	        }
        	editor.commit();
	        Log.d("COUNT", Integer.toString(sharedPrefs.getInt("count", 999)));
        }
        */
        
        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId("ca-app-pub-2377934805759836/4545554962");
 
        // Request for Ads
        AdRequest adRequest = new AdRequest.Builder()
        // Add a test device to show Test Ads
        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        .addTestDevice("5E39C82DA23AB651436D5DA0866A484D")
                .build();
 
        // Load ads into Interstitial Ads
        interstitial.loadAd(adRequest);
 
        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
        
        
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {
		    Intent intent = new Intent(this, SendText.class);
		    startActivity(intent);
	        return(true);
	  }
	 
	 public void showStoreDialog(){
			new AlertDialog.Builder(this)
		    .setTitle("Go Pro")
		    .setMessage("Pro version can now send emails. Please read the fully description before buying. Email me at jim.anon33@gmail.com with any questions. With Pro no ads, and confirmation that your email was sent.")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
			        String url = "https://play.google.com/store/apps/details?id=com.nathanhaze.anonymousemailpro";
		  	    //   String url = "amzn://apps/android?asin=B00LQAG7CI";
		        	Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
		  	        Uri.parse(url));
		  	        startActivity(intent);
		  	    
		        }
		     })
		    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		     .show(); 
	 }

	  // Invoke displayInterstitial() when you are ready to display an interstitial.
	  public void displayInterstitial() {
	    if (interstitial.isLoaded()) {
	      interstitial.show();
	    }
	  }
	  
	  public void sendEmail(View v){
		  emailAddress = toBox.getEditableText().toString();
		  
		  if(!fromBox.getEditableText().toString().equalsIgnoreCase("")){
		      fromAddress = fromBox.getEditableText().toString();
		  }else{
			fromAddress = "notme@gmx.com"  ;
		  }
		  
		  if(!subjectBox.getEditableText().toString().equalsIgnoreCase("")){
		      subject = subjectBox.getEditableText().toString();
		  }else{
			  subject ="hey";
		  }
		  
		  message = messageBox.getEditableText().toString();
		  
		  if(emailAddress.equalsIgnoreCase("")){
			  Toast toast = Toast.makeText(context, "Enter a email address", Toast.LENGTH_LONG);
	        	toast.show();
	        	return;
		  }
		  if(message.equalsIgnoreCase("")){
			  Toast toast = Toast.makeText(context, "Enter a message" , Toast.LENGTH_LONG);
	        	toast.show();
	        	return;
		  }
		  new EmailTask().execute();
	  }
	  
	  private class EmailTask extends AsyncTask<Void, Void, Boolean> {

		  ProgressDialog progress;
		  
		  @Override
	        protected void onPreExecute() {
			  progress = ProgressDialog.show(context, "Status", 
					    "sending...", true);
		    }
		  
	        @Override
	        protected Boolean doInBackground(Void... params) {
	        	
	        	boolean emailSent;
	        	 GMailSender mailsender = new GMailSender("jim.anon33@gmail.com", "going2gm");

                 String[] toArr = { emailAddress};
                 mailsender.set_to(toArr);
                 mailsender.set_from(fromAddress);
                 mailsender.set_subject(subject);
                 mailsender.setBody(message);

                 try {
                     //mailsender.addAttachment("/sdcard/filelocation");

                     if (mailsender.send()) {
                         emailSent = true;
                     } else {
                         emailSent = false;
                     }
                 } catch (Exception e) {
                    emailSent = false;
                 }
                 
				return emailSent;    
	        }

	        @Override
	        protected void onPostExecute(Boolean param) {
                String messageSent;
	        	if(param){
	        		messageSent = "Message was sent";
	        		status.setText("Sent Successful");
		        	messageBox.setText("");
                    lastmessage.setText(message);
		        	
	        	}else{
	        		messageSent = "Message was NOT sent";
	        		status.setText("Last message did not send");
	        		lastmessage.setText(message);
	        	}
	        	Toast toast = Toast.makeText(context, messageSent, Toast.LENGTH_LONG);
	        	toast.show();
	        	
	        	progress.dismiss();
	        }

	        

	    }
	  
	  @Override
	  protected void onResume() {
	         super.onResume();
	         if(status !=null && lastmessage!=null){
	        	 status.setText("");
	        	 lastmessage.setText("");
	         }
	  }
	  
}
