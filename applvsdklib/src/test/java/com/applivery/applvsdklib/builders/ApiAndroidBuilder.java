package com.applivery.applvsdklib.builders;

import com.applivery.applvsdklib.network.api.model.ApiAndroid;
import com.applivery.applvsdklib.network.api.model.ApiAppConfigData;
import com.applivery.applvsdklib.network.api.model.ApiSdK;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 2/1/16.
 */
public class ApiAndroidBuilder {

    public static final String MIN_VERSION = "2";
    public static final String LAST_BUILD_ID = "jfkef38jer328jfdke89";
    public static final String LAST_BUILD_VERSION = "3";
    public static final String UPDATE_MSG = "This is a test MUST update message";
    public static final String MUST_UPDATE_MSG = "This is a test update message";
    public static final boolean FORCE_UPDATE = false;
    public static final boolean OTA = false;

    public static ApiAndroidBuilder Builder() {
      return new ApiAndroidBuilder();
    }

    public ApiAndroid build() {
        ApiAndroid apiAndroid = new ApiAndroid();
        apiAndroid.setForceUpdate(FORCE_UPDATE);
        apiAndroid.setLastBuildId(LAST_BUILD_ID);
        apiAndroid.setLastBuildVersion(LAST_BUILD_VERSION);
        apiAndroid.setMinVersion(MIN_VERSION);
        apiAndroid.setMustUpdateMsg(MUST_UPDATE_MSG);
        apiAndroid.setOta(OTA);
        apiAndroid.setUpdateMsg(UPDATE_MSG);
        return apiAndroid;
    }

    }
