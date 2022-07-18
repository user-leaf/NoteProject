package com.bamboo.module_test2.test11_multilanguage;

import static com.bamboo.module_test2.test11_multilanguage.ELanguageType.English;
import static com.bamboo.module_test2.test11_multilanguage.ELanguageType.Korea;
import static com.bamboo.module_test2.test11_multilanguage.ELanguageType.SimplifiedChinese;
import static com.bamboo.module_test2.test11_multilanguage.ELanguageType.TraditionalChinese;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import com.orhanobut.hawk.Hawk;

import java.util.Locale;

public class LanguageUtils {

    public static Context setActivityLanguage(Context context) {
        Locale locale = getLanguageLocale();
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            configuration.setLocales(new LocaleList(locale));
//            return context.createConfigurationContext(configuration);
//        } else {
//            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
//        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    public static void setLanguage(Context context, int language) {
        if (language == -1) {
            Locale curLocale = context.getResources().getConfiguration().locale;
            language = getLanguageIndex(curLocale);
        }
        Hawk.put("key_language_index", language); // 需要本地保存这个
        setActivityLanguage(context);
    }

    private static Locale getLanguageLocale() {
        int language = Hawk.get("key_language_index", 0);
        Locale locale = Locale.ENGLISH;
        if (language == SimplifiedChinese.getIndex()) {
            locale = Locale.SIMPLIFIED_CHINESE;
        } else if (language == TraditionalChinese.getIndex()) {
            locale = Locale.TRADITIONAL_CHINESE;
        } else if (language == Korea.getIndex()) {
            locale = Locale.KOREA;
        }
        return locale;
    }

    private static int getLanguageIndex(Locale locale) {
        int index = English.getIndex();
        if (locale.equals(Locale.SIMPLIFIED_CHINESE)) {
            index = SimplifiedChinese.getIndex();
        } else if (locale.equals(Locale.TRADITIONAL_CHINESE)) {
            index = TraditionalChinese.getIndex();
        } else if (locale.equals(Locale.KOREA)) {
            index = Korea.getIndex();
        }
        return index;
    }
}
