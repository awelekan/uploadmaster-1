package com.example.chydee.HelloConstraint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chydee.hellotoast.R;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        //what happens when user clicks on the button_toast Button goes here
        //Create a toast and show it.
        Toast toast = Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUp(View view) {
        // what happens when the user clicks on the button_count Button goes here
        mShowCount = (TextView) findViewById(R.id.show_count);
        mCount++;
        if(mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

    }
}
