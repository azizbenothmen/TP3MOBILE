package com.example.two;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY="key.for.extra.REPLY";
    private static final String LOG_TAG=SecondActivity.class.getSimpleName();
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String message= intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView= findViewById(R.id.text_message);
        textView.setText(message);
        mReply=findViewById(R.id.editText_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void returnToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void returnReply(View view) {
        String reply= mReply.getText().toString();
        Intent replyIntent= new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyIntent);
        Log.d(LOG_TAG,"End SecondActivity");
        finish();
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }
    public void onDestroy(){
        super.onStop();
        Log.d(LOG_TAG,"onDestroy");
    }
}