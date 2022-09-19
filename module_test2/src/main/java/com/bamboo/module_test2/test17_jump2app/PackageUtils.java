package com.bamboo.module_test2.test17_jump2app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.util.List;

public class PackageUtils {

    /*
    https://blog.csdn.net/lanlangaogao/article/details/125624162
     */

    /**
     * 判断设备是否已经安装某应用
     * @param context   上下文
     * @param pkgName   应用包名
     * @return
     */
    public static boolean checkInstalled(Context context, String pkgName) {
        if (TextUtils.isEmpty(pkgName)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(pkgName, 0);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isPackageExist(Context context, String pkgName){
        PackageManager manager = context.getPackageManager();
//        List<PackageInfo> pkgList = manager.getInstalledPackages(0);
        List<ApplicationInfo> pkgList = manager.getInstalledApplications(0);
        for (int i = 0; i < pkgList.size(); i++) {
            ApplicationInfo pi = pkgList.get(i);
            if (pi.packageName.equalsIgnoreCase(pkgName))
                return true;
        }
        return false;
    }
}
