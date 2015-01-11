package com.example.seconddayutd;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{

	Button b1;
	TextView tv1;
	EditText ed1;
	ToggleButton tb1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textplay);
		
		baconAndEggs();
		b1.setOnClickListener(this);
		tb1.setOnClickListener(this);
	}
	public void baconAndEggs(){
		b1=(Button)findViewById(R.id.button1);
		tv1=(TextView)findViewById(R.id.tv1);
		ed1=(EditText)findViewById(R.id.editText1);
		tb1=(ToggleButton)findViewById(R.id.tb1);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.button1:
			String check=ed1.getText().toString();
			tv1.setText(check);
			if(check.contentEquals("left"))
			{
				tv1.setGravity(Gravity.LEFT);
			}
			else if(check.contentEquals("center"))
			{
				tv1.setGravity(Gravity.CENTER);
			}
			else if(check.contentEquals("right")){
				tv1.setGravity(Gravity.RIGHT);
			}
			else if(check.contentEquals("blue")){
				tv1.setText("blue");
				tv1.setTextColor(Color.BLUE);
			}
			else if(check.contentEquals("WTF")){
				Random crazy=new Random();
				tv1.setTextSize(crazy.nextInt(75));
				tv1.setTextColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265)));
				switch(crazy.nextInt(3)){
				case 1:
					tv1.setGravity(Gravity.LEFT);
					break;
				case 2:
					tv1.setGravity(Gravity.RIGHT);
					break;
				case 3:
					tv1.setGravity(Gravity.CENTER);
					break;
				}
			}
			else{
				tv1.setText("Invalid");
				tv1.setGravity(Gravity.CENTER);
				tv1.setTextColor(Color.WHITE);
			}
			break;
		case R.id.tb1:
			
				// TODO Auto-generated method stub
				if(tb1.isChecked()){
					ed1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
				else{
					ed1.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				
			
			break;
		}
	}

}
 