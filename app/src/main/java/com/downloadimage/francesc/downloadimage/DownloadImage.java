package com.downloadimage.francesc.downloadimage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by francesc on 10/01/16.
 */

// DownloadImage AsyncTask
public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

    ProgressDialog mProgressDialog;
    ImageView image;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Create a progressdialog
        mProgressDialog = new ProgressDialog(new MainActivity());
        // Set progressdialog title
        mProgressDialog.setTitle("Download Image Tutorial");
        // Set progressdialog message
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setIndeterminate(false);
        // Show progressdialog
        mProgressDialog.show();
    }

    @Override
    protected Bitmap doInBackground(String... URL) {

        String imageURL = URL[0];

        Bitmap bitmap = null;
        try {
            // Download Image from URL
            InputStream input = new java.net.URL(imageURL).openStream();
            // Decode Bitmap
            bitmap = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        // Set the bitmap into ImageView
        image.setImageBitmap(result);
    }
}
