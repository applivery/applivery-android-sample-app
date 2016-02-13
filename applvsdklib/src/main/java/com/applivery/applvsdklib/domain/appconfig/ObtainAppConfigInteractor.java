package com.applivery.applvsdklib.domain.appconfig;

import com.applivery.applvsdklib.domain.BaseInteractor;
import com.applivery.applvsdklib.domain.InteractorCallback;
import com.applivery.applvsdklib.domain.appconfig.update.CurrentAppInfo;
import com.applivery.applvsdklib.network.api.AppliveryApiService;
import com.applivery.applvsdklib.domain.model.AppConfig;
import com.applivery.applvsdklib.domain.model.BusinessObject;
import com.applivery.applvsdklib.domain.model.ErrorObject;
import com.applivery.applvsdklib.network.api.requests.ObtainAppConfigRequest;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 7/11/15.
 */
public class ObtainAppConfigInteractor extends BaseInteractor<AppConfig> {

  private final ObtainAppConfigRequest obtainAppConfigRequest;
  private final InteractorCallback appConfigInteractorCallback;

  public ObtainAppConfigInteractor(AppliveryApiService apiService, String appId, String authToken,
      CurrentAppInfo currentAppInfo) {
    this.obtainAppConfigRequest = new ObtainAppConfigRequest(apiService, appId, authToken);
    this.appConfigInteractorCallback = new ObtainAppConfigInteractorCallback(apiService, currentAppInfo);
  }

  @Override protected void receivedResponse(BusinessObject obj) {
    super.receivedResponse(obj, AppConfig.class);
  }

  @Override protected void error(ErrorObject errorObject) {
    appConfigInteractorCallback.onError(errorObject);
  }

  @Override protected void success(AppConfig appConfig) {
    appConfigInteractorCallback.onSuccess(appConfig);
  }

  @Override protected BusinessObject performRequest() {
    return obtainAppConfigRequest.execute();
  }

  public static Runnable getInstance(AppliveryApiService appliveryApiService, String applicationId,
      String authToken, CurrentAppInfo currentAppInfo) {

    ObtainAppConfigInteractor obtainAppConfigInteractor = new ObtainAppConfigInteractor(
        appliveryApiService, applicationId, authToken, currentAppInfo);

    return obtainAppConfigInteractor;
  }

}
