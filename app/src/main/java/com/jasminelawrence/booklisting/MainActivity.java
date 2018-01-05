package com.jasminelawrence.booklisting;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView searchBoxTextView,results ;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchBoxTextView = (TextView) findViewById(R.id.search_box);
        submitButton = (Button) findViewById(R.id.submit_button);

        results = (TextView) findViewById(R.id.submitted_text);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                results.setText(searchBoxTextView.getText());
            }
        });





    }
}
