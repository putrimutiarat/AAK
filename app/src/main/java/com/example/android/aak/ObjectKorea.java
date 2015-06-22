package com.example.android.aak;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by TiaRa on 6/19/2015.
 */
public class ObjectKorea implements Parcelable {
    private String idPost, namaAuthor, tanggalPost, judulPost, urlPost, isiPost;

    public ObjectKorea() {
    }

    public ObjectKorea(String idPost, String namaAuthor, String
            tanggalPost, String judulPost, String urlPost, String isiPost)
    {
        super();
        this.idPost = idPost;
        this.namaAuthor = namaAuthor;
//        this.authorSite = authorSite;
        this.tanggalPost = tanggalPost;
        this.judulPost = judulPost;
        this.urlPost = urlPost;
        this.isiPost = isiPost;
    }

    public ObjectKorea(Parcel in) {
        String[] input = new String[6];
        in.readStringArray(input);
        this.idPost = input[0];
        this.namaAuthor = input[1];
        this.tanggalPost = input[2];
        this.judulPost = input[3];
        this.urlPost = input[4];
        this.isiPost = input[5];
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getNamaAuthor() {
        return namaAuthor;
    }

    public void setNamaAuthor(String namaAuthor) {
        this.namaAuthor = namaAuthor;
    }

    public String getTanggalPost() {
        return tanggalPost;
    }

    public void setTanggalPost(String tanggalPost) {
        this.tanggalPost = tanggalPost;
    }

    public String getJudulPost() {
        return judulPost;
    }

    public void setJudulPost(String judulPost) {
        this.judulPost = judulPost;
    }

    public String getUrlPost() {
        return urlPost;
    }

    public void setUrlPost(String urlPost) {
        this.urlPost = urlPost;
    }

    public String getIsiPost() {
        return isiPost;
    }

    public void setIsiPost(String isiPost) {
        this.isiPost = isiPost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{this.idPost, this.namaAuthor, this.tanggalPost,
                this.judulPost, this.urlPost, this.isiPost});
    }

    public static final Creator<ObjectKorea> CREATOR = new Creator<ObjectKorea>() {
        @Override
        public ObjectKorea createFromParcel(Parcel parcel) {
            return new ObjectKorea(parcel);
        }

        @Override
        public ObjectKorea[] newArray(int i) {
            return new ObjectKorea[i];
        }
    };
}
