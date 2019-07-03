package com.example.piyush.fim;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {
    WebView w12;
    ProgressDialog p123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        w12=findViewById(R.id.w145);
        p123=new ProgressDialog(this);
        p123.setMessage("Loading please wait... ");

        w12.setWebViewClient(new WebViewClient()


                            {
                                @Override
                                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                    super.onPageStarted(view, url, favicon);
                                    p123.show();

                                }

                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    super.onPageFinished(view, url);
                                    p123.dismiss();;
                                }
                            }

        );
        w12.loadUrl("https://www.farmers.com/maintenance/");

    }
}
