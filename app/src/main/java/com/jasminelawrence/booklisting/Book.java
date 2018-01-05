package com.jasminelawrence.booklisting;

/**
 * Created by Jasmine on 1/4/18.
 */

public class Book {

    private String mTitle, mAuthor, mPublished, mPrice;
    private double mPageCount;

    public Book(String title, String author, String published, String price, double pageCount){
        mTitle = title;
        mAuthor = author;
        mPublished =published;
        mPrice = price;
        mPageCount=pageCount;
    }

    public Book(String title, String author, String published, double pageCount){
        mTitle = title;
        mAuthor = author;
        mPublished =published;
        mPrice = String.valueOf(R.string.no_price);
        mPageCount=pageCount;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getPublished() {
        return mPublished;
    }

    public String getPrice() {
        return mPrice;
    }

    public double getPageCount() {
        return mPageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mPublished='" + mPublished + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mPageCount=" + mPageCount +
                '}';
    }
}
