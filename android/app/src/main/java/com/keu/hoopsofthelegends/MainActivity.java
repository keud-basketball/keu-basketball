package com.keu.hoopsofthelegends;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
	private final Handler orientationHandler = new Handler(Looper.getMainLooper());
	private final Runnable orientationWatcher = new Runnable() {
		@Override
		public void run() {
			if (getBridge() != null && getBridge().getWebView() != null) {
				getBridge().getWebView().evaluateJavascript(
					"document.body.classList.contains('authenticated')",
					value -> {
						boolean authenticated = "true".equals(value);
						setRequestedOrientation(authenticated
							? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
							: ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
					}
				);
			}
			orientationHandler.postDelayed(this, 250);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		super.onCreate(savedInstanceState);
		orientationHandler.post(orientationWatcher);
	}

	@Override
	public void onDestroy() {
		orientationHandler.removeCallbacks(orientationWatcher);
		super.onDestroy();
	}
}
