package com.jasminelawrence.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.jasminelawrence.booklisting.Book;
import com.jasminelawrence.booklisting.QueryUtils;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {

    /** Tag for log messages */
    private static final String LOG_TAG = BookLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public BookLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public List<Book> loadInBackground() {

        // Don't perform the request if there are no URLs, or the first URL is null.
        if ( mUrl == null) {
            return null;
        }

        List<Book> result = QueryUtils.fetchBookData(mUrl);
        return result;        }
}
