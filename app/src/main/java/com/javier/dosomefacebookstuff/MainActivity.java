package com.javier.dosomefacebookstuff;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends AppCompatActivity {
    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());

       shareDialog = new ShareDialog(this);

        CallbackManager callbackManager = CallbackManager.Factory.create();
        shareDialog.registerCallback(callbackManager, new

                FacebookCallback<Sharer.Result>() {
                    @Override
                    public void onSuccess(Sharer.Result result) {
                    }

                    @Override
                    public void onCancel() {
                    }

                    @Override
                    public void onError(FacebookException error) {
                    }
                });

    }


    public void fbShareLink(View view){
        if (ShareDialog.canShow(ShareLinkContent.class)) {


            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("My first Share Using Android Development ")
                    .setContentDescription("This is sick. I'm learning how to post stuff on FB for any Android app I create.")
                    .setContentUrl(Uri.parse("www.google.com"))
                    .build();

            shareDialog.show(linkContent);
        }

    }
}
