package me.kiuber.base.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created 2017/5/15 0015 22:19
 * Author Kiuber
 * Description
 */

public class DialogUtil {
    private static DialogUtil instance;

    public static DialogUtil get() {
        if (instance == null) {
            instance = new DialogUtil();
        }
        return instance;
    }

    public AlertDialog.Builder showNormalTipDialog(Context context, boolean isAutoCancel, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(message);
        builder.setPositiveButton("知道了", null);
        if (!isAutoCancel) {
            builder.setCancelable(false);
        }
        builder.show();
        return builder;
    }

    public AlertDialog.Builder showNormalTipDialog(Context context, boolean isAutoCancel, String title, String message, String positive) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positive, null);
        if (!isAutoCancel) {
            builder.setCancelable(false);
        }
        builder.show();
        return builder;
    }

    public AlertDialog.Builder showHandleTipDialog(Context context, boolean isAutoCancel, String message, final MyDialogOnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(message);
        if (!isAutoCancel) {
            builder.setCancelable(false);
        }
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onPositive();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onNegative();
            }
        });
        builder.show();
        return builder;
    }

    public AlertDialog.Builder showHandleTipDialog(Context context, boolean isAutoCancel, String title, String message, String positive, String negative, final MyDialogOnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        if (!isAutoCancel) {
            builder.setCancelable(false);
        }
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onPositive();
            }
        });
        builder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onNegative();
            }
        });
        builder.show();
        return builder;
    }


    public ProgressDialog showNormalTipProgressDialog(Context context, boolean isAutoCancel, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        if (!isAutoCancel) {
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showNormalTipProgressDialog(Context context, boolean isAutoCancel, String title, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        if (!isAutoCancel) {
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
        return progressDialog;
    }

    public interface MyDialogOnClickListener {

        void onPositive();

        void onNegative();

    }
}
