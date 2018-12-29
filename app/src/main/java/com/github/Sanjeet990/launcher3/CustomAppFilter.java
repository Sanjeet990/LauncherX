package com.github.Sanjeet990.launcher3;

import android.content.ComponentName;
import android.content.Context;

public class CustomAppFilter extends IntermediateAppFilter {
    private final Context mContext;
    private final boolean hasIconPack;

    public CustomAppFilter(Context context) {
        super(context);
        mContext = context;
        hasIconPack = !Utilities.getPrefs(context).getString(SettingsActivity.ICON_PACK_PREF, "").isEmpty();
    }

    @Override
    public boolean shouldShowApp(ComponentName componentName) {
        return super.shouldShowApp(componentName) &&
                (!hasIconPack || !CustomIconUtils.isPackProvider(mContext, componentName.getPackageName()));
    }
}

