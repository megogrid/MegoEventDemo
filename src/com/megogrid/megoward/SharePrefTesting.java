package com.megogrid.megoward;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class SharePrefTesting extends Activity {
	private EditText name;
	private EditText mobile;
	private EditText address;
	private EditText category;
	private Button submit;
	private SharedPreferences prefrence;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharepreftesting);



		prefrence = getSharedPreferences("AppBackup", this.MODE_PRIVATE);
		final Editor editor = prefrence.edit();
		//
		// editor.putString("name", n);
		// editor.putString(Phone, ph);
		// editor.putString(Email, e);
		// editor.commit();
		name = (EditText) findViewById(R.id.name);
		mobile = (EditText) findViewById(R.id.mobile);
		address = (EditText) findViewById(R.id.address);
		category = (EditText) findViewById(R.id.category);
		submit = (Button) findViewById(R.id.submit);

		name.setText(prefrence.getString("name", "n"));
		mobile.setText(prefrence.getString("mobile", "m"));
		address.setText(prefrence.getString("address", "a"));
		category.setText(prefrence.getString("category", "c"));



		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editor.putString("name", name.getText().toString());
				editor.putString("mobile", mobile.getText().toString());
				editor.putString("address", address.getText().toString());
				editor.putString("category", category.getText().toString());
				editor.commit();
				setResult(RESULT_OK);
				finish();
				// MeUser.getInstance(this).
			}
		});
	}

}
