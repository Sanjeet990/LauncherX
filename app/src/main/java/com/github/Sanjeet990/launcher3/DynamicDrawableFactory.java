package com.github.Sanjeet990.launcher3;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;

import com.github.Sanjeet990.launcher3.clock.DynamicClock;
import com.github.Sanjeet990.launcher3.graphics.DrawableFactory;

public class DynamicDrawableFactory extends DrawableFactory {
    private final DynamicClock mDynamicClockDrawer;

    public DynamicDrawableFactory(Context context) {
        mDynamicClockDrawer = new DynamicClock(context);
    }

    @Override
    public FastBitmapDrawable newIcon(Bitmap icon, ItemInfo info) {
        if (info != null &&
                info.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPLICATION &&
                DynamicClock.DESK_CLOCK.equals(info.getTargetComponent()) &&
                info.user.equals(Process.myUserHandle())) {
            return mDynamicClockDrawer.drawIcon(icon);
        }
        return super.newIcon(icon, info);
    }
}
