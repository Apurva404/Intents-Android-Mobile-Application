package com.apurva.assignment.implicitIntent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityA extends Activity{
    private String mActivityName;
    private EditText mURLView;
    private EditText mPhoneView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mActivityName = getString(R.string.activity_a_label);
        mURLView = (EditText)findViewById(R.id.url_view);
        mPhoneView = (EditText)findViewById(R.id.phone_view);
    }

    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }

    public void launchURL(View v) {
        String input = mURLView.getText().toString();
        if (!input.startsWith("https://") && !input.startsWith("http://")){
            input = "http://" + input;
        }
        Uri weblink = Uri.parse(input);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, weblink);
        Intent browserChooserIntent = Intent.createChooser(browserIntent , "Choose browser of your choice");
        startActivity(browserIntent );

    }
    public void ringNumber(View v) {
        String input = mPhoneView.getText().toString();
        Uri numberToDial = Uri.parse("tel:" + input);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, numberToDial);
        startActivity(callIntent);
    }




}
