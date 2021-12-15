package com.imooc.app.update.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import com.imooc.app.R;
import com.imooc.app.update.AppUpdater;
import com.imooc.app.update.bean.DownloadBean;
import com.imooc.app.update.net.INetDownloadCallback;
import com.imooc.app.update.utils.AppUtils;

import java.io.File;

public class UpdateVersionShowDialog extends DialogFragment {

    private static final String TAG = UpdateVersionShowDialog.class.getSimpleName();
    private static final String KEY_DOWNLOAD_BEAN = "download_bean";

    private DownloadBean mDownloadBean;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mDownloadBean = (DownloadBean) arguments.getSerializable(KEY_DOWNLOAD_BEAN);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_updater, container, false);
        bindEvents(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 正常dialog是应该写theme的，这里偷个懒
    //        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
    //        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void bindEvents(View view) {
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvContent = view.findViewById(R.id.tvContent);
        TextView tvUpdate = view.findViewById(R.id.tvUpdate);
        tvTitle.setText(mDownloadBean.title);
        tvContent.setText(mDownloadBean.content);
        tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                File targetFile = new File(getActivity().getCacheDir(), "target.apk");
                AppUpdater.getInstance().getNetManager().download(mDownloadBean.url, targetFile, new INetDownloadCallback() {
                    @Override
                    public void success(File apkFile) {
                        // 安装的代码
                        Log.d(TAG, "success: " + apkFile.getAbsolutePath());
                        v.setEnabled(true);
                        dismiss();
                        // TODO: 2021/12/15 check md5
                        AppUtils.installApk(getActivity(), apkFile);
                    }

                    @Override
                    public void progress(int progress) {
                        // 更新界面的代码
                        Log.d(TAG, "progress: " + progress);
                        tvUpdate.setText(progress+"%");
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        Log.d(TAG, "failed: ");
                        v.setEnabled(true);
                        Toast.makeText(getActivity(), "文件下载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    // 和onCreateView二选一，这里选择onCreateView
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    public static void show(FragmentActivity activity, DownloadBean bean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_DOWNLOAD_BEAN, bean);
        UpdateVersionShowDialog dialog = new UpdateVersionShowDialog();
        dialog.setArguments(bundle);
        dialog.show(activity.getSupportFragmentManager(), "updateVersionShowDialog");//fragment要么有id，要么有个tag
    }

}
