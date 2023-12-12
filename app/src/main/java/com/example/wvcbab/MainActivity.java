package com.example.wvcbab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
private WebView webview;
private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview=findViewById(R.id.webview);
        checkbox=findViewById(R.id.checkbox);

        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings= webview.getSettings();
        webSettings.getJavaScriptEnabled();
        webview.loadUrl("https://en.wikipedia.org");

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    showAlertDialog();
                }
            }
        });

    }

    private void showAlertDialog(){
        AlertDialog.Builder b= new AlertDialog.Builder(this);
        b.setMessage("checkbox is checked");
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=b.create();
        dialog.show();
    }
}