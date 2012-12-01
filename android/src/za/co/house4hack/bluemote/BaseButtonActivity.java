package za.co.house4hack.bluemote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public abstract class BaseButtonActivity extends Activity implements SurfaceHolder.Callback {
   public static SurfaceView mSurfaceView;
   public static SurfaceHolder mSurfaceHolder;
   public static Camera mCamera;
   public static boolean mPreviewRunning;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.button_activity);

      mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
      mSurfaceHolder = mSurfaceView.getHolder();
      mSurfaceHolder.addCallback(this);
      mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

      Toast.makeText(this, "Button " + getButtonName() + " pressed", Toast.LENGTH_LONG).show();
      
      Intent intent = new Intent(this, VideoRecordService.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startService(intent);
      
      finish();
   }

   public Location getBestLastKnownLoaction(Context context) {
      LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
      Criteria criteria = new Criteria();
      String bestProvider = lm.getBestProvider(criteria, false);
      Location loc = lm.getLastKnownLocation(bestProvider);
      return loc;
   }

   public String getButtonName() {
      return getClass().getName();
   }

   @Override
   public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
      // TODO Auto-generated method stub

   }

   @Override
   public void surfaceCreated(SurfaceHolder arg0) {
      // TODO Auto-generated method stub

   }

   @Override
   public void surfaceDestroyed(SurfaceHolder arg0) {
      // TODO Auto-generated method stub

   }

}
