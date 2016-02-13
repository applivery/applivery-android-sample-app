package com.applivery.appliverysdk;

import android.app.Application;
import com.applivery.applvsdklib.Applivery;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 17/1/16.
 */
public class AppliveryApplication extends Application{

  @Override public void onCreate() {
    super.onCreate();
    Applivery.init(this, BuildConfig.APP_KEY, BuildConfig.APP_SECRET, false);
  }

}
