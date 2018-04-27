package com.zxq.loadingview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;


/**
 * 作者：zhuxiaoqing on 2018/1/29.
 * 邮箱：516633632@qq.com
 * good luck
 */
public class LoadingDialog extends BaseCenterDialog {
    private TextView tipTextView;
    private String tipst="加载中...";
    private boolean isShowMessage=true;//是否显示提示消息
    private boolean isCancelable=false;//设置是否可以按返回键取消
    private boolean isCancelOutside=false;//设置是否可以取消

    public void setTipst(String tipst) {
        this.tipst = tipst;
    }

    public void setShowMessage(boolean showMessage) {
        isShowMessage = showMessage;
    }

    public void setIsCancelable(boolean cancelable) {
        isCancelable = cancelable;
    }

    public void setCancelOutside(boolean cancelOutside) {
        isCancelOutside = cancelOutside;
    }

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        window.setGravity(Gravity.CENTER);//居中
        setCancelable(isCancelable);
        setCanceledOnTouchOutside(isCancelOutside);
    }

    @Override
    protected void sentContentView() {
        setContentView(R.layout.loading_layout);
    }

    @Override
    protected void initView() {
        tipTextView=findViewById(R.id.tipTextView);
        tipTextView.setText(tipst);
        if(!isShowMessage){
            tipTextView.setVisibility(View.GONE);
        }

    }

    public static class Builder{

        private Context context;
        private String message;
        private boolean isShowMessage=true;
        private boolean isCancelable=false;
        private boolean isCancelOutside=false;


        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置提示信息
         * @param message
         * @return
         */

        public Builder setMessage(String message){
            this.message=message;
            this.isShowMessage=true;
            return this;
        }

        /**
         * 设置是否显示提示信息
         * @param isShowMessage
         * @return
         */
        public Builder setShowMessage(boolean isShowMessage){
            this.isShowMessage=isShowMessage;
            return this;
        }

        /**
         * 设置是否可以按返回键取消
         * @param isCancelable
         * @return
         */

        public Builder setCancelable(boolean isCancelable){
            this.isCancelable=isCancelable;
            return this;
        }

        /**
         * 设置是否可以取消
         * @param isCancelOutside
         * @return
         */
        public Builder setCancelOutside(boolean isCancelOutside){
            this.isCancelOutside=isCancelOutside;
            return this;
        }

        public LoadingDialog create(){

            LoadingDialog loadingDailog=new LoadingDialog(context);
            loadingDailog.setShowMessage(isShowMessage);
            loadingDailog.setTipst(message);
            loadingDailog.setIsCancelable(isCancelable);
            loadingDailog.setCancelOutside(isCancelOutside);
            return  loadingDailog;

        }


    }
}

