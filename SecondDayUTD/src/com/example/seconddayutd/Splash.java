package com.example.seconddayutd;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Splash extends Activity {
	MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView myTextView=(TextView)findViewById(R.id.textView1);
        Button b1=(Button)findViewById(R.id.button1);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/black_jack.ttf");
        myTextView.setTypeface(typeFace);
        b1.setTypeface(typeFace);
        song=MediaPlayer.create(Splash.this,R.raw.chahun);
        song.start();
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent newIntent=new Intent(Splash.this,Menu.class);	
				startActivity(newIntent);
			}
		});
        /*Thread splashTime=new Thread(){
			public void run(){
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
				//Intent newIntent=new Intent("com.example.seconddayutd.Menu");	
				//startActivity(newIntent);
				}
			}
		};*/
		//splashTime.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.stop();
	}
}
