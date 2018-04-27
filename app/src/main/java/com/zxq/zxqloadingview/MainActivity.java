package com.zxq.zxqloadingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zxq.loadingview.LoadingDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button showmessage_dialog;
    private Button showmessage_dialog_2;

    private Button showmessage_dialog_3;
    private Button showmessage_dialog_4;

    private LoadingDialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showmessage_dialog=findViewById(R.id.showmessage_dialog);
        showmessage_dialog_2=findViewById(R.id.showmessage_dialog_2);
        showmessage_dialog_3=findViewById(R.id.showmessage_dialog_3);
        showmessage_dialog_4=findViewById(R.id.showmessage_dialog_4);
        showmessage_dialog.setOnClickListener(this);
        showmessage_dialog_2.setOnClickListener(this);
        showmessage_dialog_3.setOnClickListener(this);
        showmessage_dialog_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showmessage_dialog:
                showLoading("Loding...");
                showmessage_dialog.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dismissLoading();
                            }
                        });
                    }
                },2000);
                break;
            case R.id.showmessage_dialog_2:
                showLoading_2("Loding...");
                break;
            case R.id.showmessage_dialog_3:
                showLoading_3();
                showmessage_dialog.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dismissLoading();
                            }
                        });
                    }
                },2000);
                break;
            case R.id.showmessage_dialog_4:
                showLoading_4();
                break;
        }
    }

    private void showLoading(String message){
        if(loadingDialog!=null&&loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
        loadingDialog=new LoadingDialog.Builder(this).setCancelable(false)
                .setCancelOutside(false)
                .setMessage(message)
                .create();
        loadingDialog.show();
    }

    private void showLoading_2(String message){
        if(loadingDialog!=null&&loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
        loadingDialog=new LoadingDialog.Builder(this).setCancelable(true)
                .setCancelOutside(true)
                .setMessage(message)
                .create();
        loadingDialog.show();
    }

    private void showLoading_3(){
        if(loadingDialog!=null&&loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
        loadingDialog=new LoadingDialog.Builder(this).setCancelable(false)
                .setCancelOutside(false)
                .setShowMessage(false)
                .create();
        loadingDialog.show();
    }

    private void showLoading_4(){
        if(loadingDialog!=null&&loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
        loadingDialog=new LoadingDialog.Builder(this).setCancelable(true)
                .setCancelOutside(true)
                .setShowMessage(false)
                .create();
        loadingDialog.show();
    }

    private void dismissLoading(){
        if(loadingDialog!=null&&loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
    }
}
