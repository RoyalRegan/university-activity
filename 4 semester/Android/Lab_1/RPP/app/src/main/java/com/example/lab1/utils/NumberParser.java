package com.example.lab1.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class NumberParser {
    private static RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"),
            RuleBasedNumberFormat.SPELLOUT);

    public static String valueToString(Integer value) {
        return nf.format(value);
    }
}
