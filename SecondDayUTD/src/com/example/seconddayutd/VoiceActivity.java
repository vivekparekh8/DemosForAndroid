package com.example.seconddayutd;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
 
public class VoiceActivity extends Activity {
 
    Button speak;
    ListView options;
    ArrayList<String> results;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.voice_activity);
 
        speak = (Button) findViewById(R.id.bSpeak);
        options = (ListView) findViewById(R.id.lvOptions);
 
        speak.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // This are the intents needed to start the Voice recognizer
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
 
                startActivityForResult(i, 1010);
            }
        });
 
        // retrieves data from the previous state. This is incase the phones
        // orientation changes
        if (savedInstanceState != null) {
            results = savedInstanceState.getStringArrayList("results");
 
            if (results != null)
                options.setAdapter(new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, results));
        }
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        // retrieves data from the VoiceRecognizer
        if (requestCode == 1010 && resultCode == RESULT_OK) {
            results = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            options.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, results));
        }
 
        super.onActivityResult(requestCode, resultCode, data);
    }
 
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // This should save all the data so that when the phone changes
        // orientation the data is saved
        super.onSaveInstanceState(outState);
 
        outState.putStringArrayList("results", results);
    }
 
}