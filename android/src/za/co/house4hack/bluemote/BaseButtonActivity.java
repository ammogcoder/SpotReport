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

public abstract class BaseButtonActivity extends Activity
{
   public static Boolean recording;

   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.button_activity);

     

      Toast.makeText(this, "Button " + getButtonName() + " pressed", Toast.LENGTH_LONG).show();
      
      if (!recording || recording==null)
      {
    	  Intent intent= new Intent();
    	  intent.setAction("com.android.camerarecorder.RECORD");
    	  intent.setPackage("com.android.camerarecorder");
    	  startActivity(intent);
    	  recording=true;
      }
      else
      {
    	  Intent intent= new Intent();
    	  intent.setAction("com.android.camerarecorder.STOPRECORD");
    	  intent.setPackage("com.android.camerarecorder");
    	  startActivity(intent);
    	  recording=false;
      }
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


}
