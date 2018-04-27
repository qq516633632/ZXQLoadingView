package com.zxq.loadingview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


/**
 * 作者：zhuxiaoqing on 2018/2/1.
 * 邮箱：516633632@qq.com
 * good luck
 * 居中淡入淡出Dialog
 */
public abstract class BaseCenterDialog extends Dialog {
    protected Window window;
    protected Context context;

    public BaseCenterDialog(@NonNull Context context) {
        super(context, R.style.center_dialog_style);
        setCancelable(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sentContentView();
        initView();
        window = getWindow(); //得到对话框
        window.setWindowAnimations(R.style.center_in_anim); //设置窗口弹出动画
        window.setGravity(Gravity.CENTER);//让其在底部
    }

    protected abstract void sentContentView();

    @Override
    public void show() {
        super.show();
        //让Dialog横向铺满
        Window win = getWindow();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        win.setAttributes(lp);

    }

    /**
     * 初始化控件
     */
    protected abstract void initView();
}

