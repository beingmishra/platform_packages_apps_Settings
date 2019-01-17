/*
 * Copyright (C) 2018 Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.fred;

import android.content.Context;
import android.os.SystemProperties;
import android.os.UserManager;

import com.android.settings.R;

public class CAFVersionDialogController {

    private static final String CAF_PROPERTY = "ro.caf.version";
    private static final int CAF_VERSION_VALUE_ID = R.id.caf_version_value;
    private static final int CAF_VERSION_LABEL_ID = R.id.caf_version_label;

    private final FredInfoDialogFragment mDialog;
    private final Context mContext;
    private final UserManager mUserManager;

    public CAFVersionDialogController(FredInfoDialogFragment dialog) {
        mDialog = dialog;
        mContext = dialog.getContext();
        mUserManager = (UserManager) mContext.getSystemService(Context.USER_SERVICE);
    }

    public void initialize() {

        mDialog.setText(CAF_VERSION_VALUE_ID, SystemProperties.get(CAF_PROPERTY,
                mContext.getResources().getString(R.string.device_info_default)));
    }
}
