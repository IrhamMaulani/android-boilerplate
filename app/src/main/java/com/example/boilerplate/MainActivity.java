package com.example.boilerplate;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnWebsite;

    Button btnLocation;

    Button btnShareText;

    EditText editWebSite;

    EditText editLocation;

    EditText editTextShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.open_website_button);

        btnLocation = findViewById(R.id.open_location_button);

        btnShareText = findViewById(R.id.share_text_button);

        editWebSite = findViewById(R.id.website_edittext);

        editLocation = findViewById(R.id.location_edittext);

        editTextShare = findViewById(R.id.share_edittext);

        btnWebsite.setOnClickListener(this);

        btnLocation.setOnClickListener(this);

        btnShareText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.open_website_button:

                String url =  editWebSite.getText().toString();

                Uri webPage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }

                break;

            case R.id.open_location_button:
                String loc = editLocation.getText().toString();

                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);

                Intent intentLocation = new Intent(Intent.ACTION_VIEW, addressUri);

                if (intentLocation.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentLocation);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }

                break;

            case R.id.share_text_button:

                String txt = editTextShare.getText().toString();
                String mimeType = "text/plain";

                ShareCompat.IntentBuilder
                        .from(this)
                        .setType(mimeType)
                        .setChooserTitle("Share this text with: ")
                        .setText(txt)
                        .startChooser();
                break;
        }
    }
}
