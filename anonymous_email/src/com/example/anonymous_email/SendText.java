package com.example.anonymous_email;



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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anonymous_email.MainActivity.EmailTask;
import com.nathanhaze.AE.R;
//import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class SendText extends Activity implements OnItemSelectedListener {

//	SharedPreferences sharedPrefs;
 //   public static final String PREFS_NAME = "MyPrefsFile";
    
	EditText etPhone ; 
	EditText etSubject; 
	EditText etFrom; 
	EditText etMessage; 
	
	TextView textStatus;
	TextView textMessage;
	
	Spinner phoneProvider ; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_text);
		
		etPhone = (EditText)findViewById(R.id.user_phone);
		etSubject = (EditText)findViewById(R.id.user_text_subject);
		etFrom = (EditText)findViewById(R.id.user_text_from);
		etMessage = (EditText)findViewById(R.id.user_text);
		
		textStatus = (TextView) findViewById(R.id.text_result);
		textMessage = (TextView) findViewById(R.id.text_last);
		
		phoneProvider = (Spinner) findViewById(R.id.user_phone_provider);
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.phone_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		phoneProvider.setAdapter(adapter);
		
		phoneProvider.setOnItemSelectedListener(this);
		
		
		
		
	//	AdBuddiz.cacheAds(this); // this = current Activity
	//	AdBuddiz.showAd(this); // this = current Activity
		/*
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.setWebViewClient(new WebViewClient());
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		myWebView.loadUrl("http://textafriend.site50.net/textPhone_mobile.html");
		
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text, menu);
		return true;
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	    Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
        return(true);
    }
    
	 public void showStoreDialog(){
			new AlertDialog.Builder(this)
		    .setTitle("Go Pro")
		    .setMessage("Pro version can now send emails. Please read the fully description before buying. Email me at jim.anon33@gmail.com with any questions. With Pro Attach  no ads, and confirmation that your email was sent.")
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
	 
	  
	  public void sendEmail(View v){
		  
		  String phoneExtension = phoneProvider.getSelectedItem().toString();
		  
		  if(phoneExtension.getSelectedItemPosition() != 0){
			  
			  
		  }else{
			  return;
		  }
		  
		  
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
	  
	  
	  

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// TODO Auto-generated method stub
		
		//tools.getExtension((String)parent.getItemAtPosition(pos));
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
