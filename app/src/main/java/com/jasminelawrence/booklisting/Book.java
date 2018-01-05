package com.jasminelawrence.booklisting;


/**
 * Created by Jasmine on 1/4/18.
 */

public class Book  {

    private String mTitle, mAuthor, mPublished, mPrice,mUrl;
    private double mPageCount;



    public Book(String title,String author, String published, String price, double pageCount, String url){
        mTitle = title;
        mAuthor = author;
        mPublished =published;
        mPrice = price;
        mPageCount=pageCount;
        mUrl=url;
    }

    public Book(String title, String author, String published, double pageCount, String url){
        mTitle = title;
        mAuthor = author;
        mPublished =published;

        mPrice = "Not for Sale";
        mPageCount=pageCount;
        mUrl=url;
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

    public String getUrl() {
        return mUrl;
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
