package com.android.camerarecorder;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class CameraRecorder extends Activity implements SurfaceHolder.Callback {
	private static final String TAG = "Recorder";
	public static SurfaceView mSurfaceView;
	public static SurfaceHolder mSurfaceHolder;
	public static Camera mCamera;
	public static boolean mPreviewRunning;
	public static Intent intent;

	// TTS object
	private TextToSpeech myTTS;
	// status check code
	private int MY_DATA_CHECK_CODE = 0;

	// create the Activity

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		intent = getIntent();

		mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
		mSurfaceHolder = mSurfaceView.getHolder();
		mSurfaceHolder.addCallback(this);
		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

		Button btnStart = (Button) findViewById(R.id.StartService);
		btnStart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// speakWords("Recording");
				startRecordService();
			}
		});

		Button btnStop = (Button) findViewById(R.id.StopService);
		btnStop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// speakWords("Stop recording");
				stopService(new Intent(CameraRecorder.this,
						RecorderService.class));
			}
		});

		// check for TTS data
		/*
		 * Intent checkTTSIntent = new Intent();
		 * checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		 * startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
		 */
	}

	/*
	 * private void speakWords(String speech) { //speak straight away
	 * myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null); }
	 * 
	 * protected void onActivityResult(int requestCode, int resultCode, Intent
	 * data) { if (requestCode == MY_DATA_CHECK_CODE) { if (resultCode ==
	 * TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) { //the user has the necessary
	 * data - create the TTS myTTS = new TextToSpeech(this, this); } else { //no
	 * data - install it now Intent installTTSIntent = new Intent();
	 * installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
	 * startActivity(installTTSIntent); } } }
	 * 
	 * //setup TTS public void onInit(int initStatus) { //check for successful
	 * instantiation if (initStatus == TextToSpeech.SUCCESS) {
	 * if(myTTS.isLanguageAvailable
	 * (Locale.ENGLISH)==TextToSpeech.LANG_AVAILABLE) {
	 * myTTS.setLanguage(Locale.ENGLISH); Toast.makeText(this, "Yes",
	 * Toast.LENGTH_LONG).show(); } else Toast.makeText(this, "No",
	 * Toast.LENGTH_LONG).show(); } else if (initStatus == TextToSpeech.ERROR) {
	 * Toast.makeText(this, "Sorry! Text To Speech failed...",
	 * Toast.LENGTH_LONG).show(); } }
	 */
	
	/*
	@Override
	public void onStart() {
		super.onStart();
		String action = intent.getAction();

		if (action.equals(getString(R.string.action_record))) {
			startRecordService();
		} else if (action.equals(getString(R.string.action_stoprecord))) {
			stopService(new Intent(CameraRecorder.this, RecorderService.class));
		}
	}*/

	@Override
	protected void onResume() {
		super.onResume();

		Runnable task = new Runnable() {
			public void run() {
				/* Do something… */
				if (mPreviewRunning) {
					mPreviewRunning = !mPreviewRunning;
					stopService(new Intent(CameraRecorder.this,
							RecorderService.class));
					finish();
				} else {
					mPreviewRunning = !mPreviewRunning;
					Intent intent = new Intent(CameraRecorder.this,
							RecorderService.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startService(intent);
					finish();
				}
			}
		};
		Handler handler = new Handler();
		handler.postDelayed(task, 1000);
	}

	private void startRecordService() {
		Intent intent = new Intent(CameraRecorder.this, RecorderService.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startService(intent);
		// finish();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}
}