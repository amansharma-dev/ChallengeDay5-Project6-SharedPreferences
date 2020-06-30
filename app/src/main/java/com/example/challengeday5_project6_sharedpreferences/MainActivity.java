package com.example.challengeday5_project6_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String MESSAGE_ID = "message_sharedPref";
    private EditText editText;
    private Button button;
    private TextView previousUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.saveButton);
        previousUser = findViewById(R.id.previousUserName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString().trim();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userName",userName);
                editor.apply(); // save to disk

                previousUser.setText(userName);
            }
        });

        //get the saved user name

        SharedPreferences getSharedPref = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
        String getPreviousUser = getSharedPref.getString("userName","Nothing Yet...!!");
        previousUser.setText(getPreviousUser);

    }
}
