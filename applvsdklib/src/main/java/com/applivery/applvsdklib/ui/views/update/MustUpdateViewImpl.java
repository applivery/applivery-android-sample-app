package com.applivery.applvsdklib.ui.views.update;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.applivery.applvsdklib.AppliverySdk;
import com.applivery.applvsdklib.R;
import com.applivery.applvsdklib.ui.model.UpdateInfo;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 3/1/16.
 */
public class MustUpdateViewImpl extends Dialog implements UpdateView {

  private Button update;
  private ProgressBar progressBar;
  private TextView appName;
  private TextView updateMessage;
  private final UpdateListener updateListener;

  public MustUpdateViewImpl(UpdateInfo updateInfo, UpdateListener updateListener) {

    super(AppliverySdk.getCurrentActivity(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);

    this.updateListener = updateListener;

    setCancelable(false);

    setContentView(R.layout.must_update);
    initViewElements();
    initViewElementsData(updateInfo);
  }

  private void initViewElements() {
    this.appName = (TextView) findViewById(R.id.must_update_title);
    this.updateMessage = (TextView) findViewById(R.id.must_update_message);
    this.update = (Button) findViewById(R.id.must_update_button);
    this.progressBar = (ProgressBar) findViewById(R.id.must_update_progress_bar);
  }

  private void initViewElementsData(UpdateInfo updateInfo) {
    appName.setText(updateInfo.getAppName());
    updateMessage.setText(updateInfo.getAppUpdateMessage());

    update.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        updateListener.onUpdateButtonClick();
      }
    });
  }

  @Override public void showUpdateDialog() {
    show();
  }

  @Override public void hideDownloadInProgress() {
    update.setVisibility(View.VISIBLE);
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showDownloadInProgress() {
    update.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);
  }

}
