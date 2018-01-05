package com.jasminelawrence.booklisting;

import android.app.LoaderManager;
import android.content.Context;

import android.app.LoaderManager.LoaderCallbacks;

import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Book>> {

    TextView searchBoxTextView,results ;
    Button submitButton;
    String queryPart1 = "https://www.googleapis.com/books/v1/volumes?q=";
    String queryPart2="&maxResults=10";
    String finalQuery;
    ProgressBar loadingIndicator;

    /**
     * Constant value for the book loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int BOOK_LOADER_ID = 1;

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

                if(searchBoxTextView.getText().length() >0){
                    finalQuery= queryPart1+ searchBoxTextView.getText()+queryPart2;
                    results.setText(finalQuery);


                }else{
                    finalQuery = getString(R.string.enter_something);
                    results.setText(finalQuery);

                }
            }
        });



// Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(BOOK_LOADER_ID, null, this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            loadingIndicator = (ProgressBar) findViewById(R.id.loading_spinner);
            loadingIndicator.setVisibility(View.GONE);

            // Update empty state with no connection error message
            results.setText(R.string.no_internet);
        }

    }

    @Override
    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new BookLoader(this, finalQuery);    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> bookList) {
        loadingIndicator = (ProgressBar) findViewById(R.id.loading_spinner);
        loadingIndicator.setVisibility(View.GONE);


        // Clear the adapter of previous earthquake data
//        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (bookList != null && !bookList.isEmpty()) {
           // mAdapter.addAll(earthquakes);
            results.setText("Got some earthquakes!");

        }else{
            // Set empty state text to display "No earthquakes found."
            results.setText(R.string.no_books);
        }


    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {

        // Loader reset, so we can clear out our existing data.
      //  mAdapter.clear();

    }
}
