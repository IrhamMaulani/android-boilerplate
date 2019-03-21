package com.example.boilerplate;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView textView;
    Button button;
    EditText editText;
    public static final String EXTRA_VALUE = "extra_value";

    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_reply_message);

        button = findViewById(R.id.btn_click);

        editText = findViewById(R.id.et_value);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_click) {


            Intent intent = new Intent(MainActivity.this, MoveIntentActivity.class);

            String text = editText.getText().toString();

            intent.putExtra(MainActivity.EXTRA_VALUE, text);

            startActivityForResult(intent, TEXT_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(MoveIntentActivity.EXTRA_VALUE);

                textView.setText(reply);
            }
        }
    }
}
