package com.jasminelawrence.booklisting;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jasmine on 1/4/18.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param books   A List of word objects to display in a list
     *
     */


    public BookAdapter(Activity context, ArrayList<Book> books) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, books);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Book currentbook = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);


        titleTextView.setText(currentbook.getTitle());



        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView

        authorTextView.setText(currentbook.getAuthor());


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView publishedTextView = (TextView) listItemView.findViewById(R.id.published);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView

        publishedTextView.setText(currentbook.getPublished());



        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView


        priceTextView.setText(currentbook.getPrice());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView pageCountTextView = (TextView) listItemView.findViewById(R.id.pageCount);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView



        DecimalFormat formatter = new DecimalFormat("0");
        String count = formatter.format(currentbook.getPageCount());

        pageCountTextView.setText(count);


// Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) pageCountTextView.getBackground();

        // Get the appropriate background color based on the current book magnitude
        int pageCountColor = getPageCountColor(currentbook.getPageCount());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(pageCountColor);


        return listItemView;

    }



    private int getPageCountColor(double pageCount){

        int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);

        switch ((int) pageCount){
            case 1:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;

            default:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
        }

        return magnitude1Color;
    }
}
