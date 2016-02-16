package com.applivery.applvsdklib.network.api;

import com.applivery.applvsdklib.AppliverySdk;
import com.applivery.applvsdklib.tools.androidimplementations.AndroidCurrentAppInfo;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 11/1/16.
 */
public class HeadersInterceptor implements Interceptor {

  private final AndroidCurrentAppInfo androidCurrentAppInfo;

  public HeadersInterceptor(AndroidCurrentAppInfo androidCurrentAppInfo) {
    this.androidCurrentAppInfo = androidCurrentAppInfo;
  }

  @Override public Response intercept(Chain chain) throws IOException {
    return chain.proceed(composeRequest(chain));
  }

  private Request composeRequest(Chain chain) {
    Request original = chain.request();
    return original.newBuilder()
        .url(chain.request().httpUrl())
        .header("Authorization", AppliverySdk.getToken())
        .header("Accept-Language", Locale.getDefault().getLanguage())
        .header("x_sdk_version", "ANDROID_" + androidCurrentAppInfo.getVersionName() )
        .method(original.method(), original.body())
        .build();
  }

}
