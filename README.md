# ZXQLoadingView
最简单的Loading 适合网络Loading，耗时操作Loading以及各种场景下的
## 效果图 
![](https://github.com/qq516633632/ZXQLoadingView/blob/master/loding_img.gif)   

## 使用方法
## Gradle添加引用
```
compile 'com.zhuxiaoqing.LoadingView：ZXQLoadingView：1.0.0'

```

## 代码中
```
//显示
 loadingDialog=new LoadingDialog.Builder(this).setCancelable(false)
                .setCancelOutside(false)
                .setMessage(message)
                .create();
        loadingDialog.show();
        
//销毁
loadingDialog.dismiss();
        
```
跟多使用可查看DMO
## 方法介绍
```
        //设置提示信息
        setMessage(String message)
        //设置是否显示提示信息
        setShowMessage(boolean isShowMessage)
        //设置是否可以按返回键取消
        setCancelable(boolean isCancelable)
        //设置是否可以取消
        setCancelOutside(boolean isCancelOutside)
```
