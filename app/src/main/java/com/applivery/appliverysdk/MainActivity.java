/*
 * Copyright (c) 2016 Applivery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.applivery.appliverysdk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Chronometer;
import com.applivery.applvsdklib.Applivery;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton disable = (FloatingActionButton) findViewById(R.id.fab);
    FloatingActionButton enable = (FloatingActionButton) findViewById(R.id.fab2);

    enable.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Applivery.enableShakeFeedback();
        Applivery.enableScreenshotFeedback();
        Snackbar.make(view, "Feedback Enabled" , Snackbar.LENGTH_LONG).show();
      }
    });

    disable.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Applivery.disableShakeFeedback();
        Applivery.disableScreenshotFeedback();
        Snackbar.make(view, "Feedback disabled" , Snackbar.LENGTH_LONG).show();
      }
    });

    startChrono();
  }

  private void startChrono() {
    ((Chronometer) findViewById(R.id.chronometer)).start();
  }
}
