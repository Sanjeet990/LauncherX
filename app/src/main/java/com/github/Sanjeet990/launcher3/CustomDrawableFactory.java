package com.github.Sanjeet990.launcher3;


import android.content.Context;
import android.graphics.Bitmap;


public class CustomDrawableFactory extends DynamicDrawableFactory {
    private final boolean hasIconPack;

    public CustomDrawableFactory(Context context) {
        super(context);
        hasIconPack = !Utilities.getPrefs(context).getString(SettingsActivity.ICON_PACK_PREF, "").isEmpty();
    }

    @Override
    public FastBitmapDrawable newIcon(Bitmap icon, ItemInfo info) {
        if (hasIconPack) {
            return new FastBitmapDrawable(icon);
        }
        return super.newIcon(icon, info);
    }
}