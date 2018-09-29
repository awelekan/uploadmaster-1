package com.example.chydee.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;

    private EditText mLocationEditText;

    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = (EditText) findViewById(R.id.website_edittext);

        mLocationEditText = (EditText) findViewById(R.id.location_edittext);

        mShareTextEditText = (EditText) findViewById(R.id.share_edittext);

    }

    public void openWebsite(View view){

        //get the Url text
        String url = mWebsiteEditText.getText().toString();

        //Parse the URI and create intent
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        //To find an activity that handles the implicit intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("implictIntents", "Can't handle this");
        }

    }
    public void openLocation (View view) {
        // get the string value of the mLocationEditText
        String loc = mLocationEditText.getText().toString();

        //parse the URI object with a geo search query
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);

        // creating a new intent
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        //Resolve the intent and check... if so startActivity()
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "can't handle this");
        }
    }

    public void shareText (View view) {
        //Get the string value of the mShareTextEditText
        String txt = mShareTextEditText.getText().toString();
        //Define the mime type of the Text to share
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }


}
