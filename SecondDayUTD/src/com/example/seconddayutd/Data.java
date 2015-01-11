package com.example.seconddayutd;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Data extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
	}
	Button b1,b2;
	TextView tv1;
	EditText ed1;
	public void intialize(){
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button1);
		tv1=(TextView)findViewById(R.id.tv1);
		ed1=(EditText)findViewById(R.id.editText1);
	}

}
