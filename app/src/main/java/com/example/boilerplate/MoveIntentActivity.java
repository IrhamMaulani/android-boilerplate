package com.example.boilerplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MoveIntentActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_VALUE = "extra_value";

    TextView textView;

    EditText editText;

    Button btnReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_intent);

        textView = findViewById(R.id.textView);

        editText = findViewById(R.id.et_value);

        btnReply = findViewById(R.id.btn_reply);

        String valueFromIntent = getIntent().getStringExtra(MainActivity.EXTRA_VALUE);

        textView.setText(valueFromIntent);

        btnReply.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reply:
                String text = editText.getText().toString();

                Intent intent = new Intent(MoveIntentActivity.this, MainActivity.class);

                intent.putExtra(MoveIntentActivity.EXTRA_VALUE, text);

//                startActivity(intent);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
