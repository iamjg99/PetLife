package com.example.pl1.Adoptview;

import com.google.gson.annotations.SerializedName;

public class Pet {

    @SerializedName("imageUrl")
    private String mImageUrl;
    @SerializedName("info")
    private String mInfo;
    @SerializedName("subTitle")
    private String mSubTitle;
    @SerializedName("title")
    private String mTitle;

    public Pet(String mImageUrl, String mInfo, String mSubTitle, String mTitle) {
        this.mImageUrl = mImageUrl;
        this.mInfo = mInfo;
        this.mSubTitle = mSubTitle;
        this.mTitle = mTitle;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getInfo() {
        return mInfo;
    }

    public void setInfo(String info) {
        mInfo = info;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String subTitle) {
        mSubTitle = subTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}