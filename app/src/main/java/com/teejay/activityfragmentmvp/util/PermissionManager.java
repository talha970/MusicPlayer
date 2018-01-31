package com.teejay.activityfragmentmvp.util;

import android.Manifest;
import android.content.Context;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import javax.inject.Inject;

/**
 * Created by tjaved on 1/27/18.
 */

public class PermissionManager {


    Context context;

    @Inject
    public PermissionManager(Context context) {
        this.context = context;
    }

    public void askForStoragePermissions(PermissionListener permissionlistener){
        TedPermission.with(context)
                .setPermissionListener( permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();
    }
}
