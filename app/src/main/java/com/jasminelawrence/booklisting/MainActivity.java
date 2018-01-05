package com.jasminelawrence.booklisting;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  {

    TextView searchBoxTextView,results ;
    Button submitButton;
    String queryPart1 = "https://www.googleapis.com/books/v1/volumes?q=";
    String queryPart2="&maxResults=10";
    String finalQuery;
    String booklist;

    private static final String LOG_TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchBoxTextView = (TextView) findViewById(R.id.search_box);
        submitButton = (Button) findViewById(R.id.submit_button);

        results = (TextView) findViewById(R.id.error_text);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getQueryString();

                startBookListActivity();


            }
        });


    }


    private void getQueryString(){


        if(searchBoxTextView.getText().length() >0){

            finalQuery= queryPart1+ searchBoxTextView.getText()+queryPart2;
            results.setText(finalQuery);


        }else{
            finalQuery = getString(R.string.enter_something);
            results.setText(finalQuery);

        }

    }

    private void startBookListActivity() {
        Intent intent = new Intent(this, BookListActivity.class);
        Log.i(LOG_TAG, "the search string is: " + finalQuery);
        intent.putExtra(BookListActivity.LINK_TAG, finalQuery);
        startActivity(intent);

    }

}
