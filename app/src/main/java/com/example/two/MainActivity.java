package com.example.two;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE="key.for.extra.MESSAGE";
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mMessageEditText=findViewById(R.id.editText_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void LaunchSecondActivity(View view) {
        String message;
        Log.d(LOG_TAG,"Button Clicked");
       Log.d(LOG_TAG,mMessageEditText.toString());

        Intent intent=new Intent(this,SecondActivity.class);
        message=mMessageEditText.getText().toString();
        Log.d(LOG_TAG,message);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);


    }
}