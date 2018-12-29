package com.github.Sanjeet990;

import android.content.ComponentName;
import android.content.Context;

import com.github.Sanjeet990.launcher3.AppFilter;

import java.util.HashSet;

public class IntermediateAppFilter extends AppFilter {
        private final HashSet<ComponentName> mHideList = new HashSet<>();

        public IntermediateAppFilter(Context context) {
            //Voice Search
            mHideList.add(ComponentName.unflattenFromString("com.google.android.googlequicksearchbox/.VoiceSearchActivity"));

            //Wallpapers
            mHideList.add(ComponentName.unflattenFromString("com.google.android.apps.wallpaper/.picker.CategoryPickerActivity"));

            //Google Now Launcher
            mHideList.add(ComponentName.unflattenFromString("com.google.android.launcher/com.google.android.launcher.StubApp"));
        }

        @Override
        public boolean shouldShowApp(ComponentName componentName) {
            return !mHideList.contains(componentName);
        }
    }
