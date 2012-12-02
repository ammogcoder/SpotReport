package za.co.house4hack.bluemote;

import android.app.Activity;
import android.content.Intent;

public class Crime extends BaseButtonActivity {

   @Override
   protected void onButtonActivated() {
      Intent i = new Intent(this, BluetoothService.class);
      i.putExtra("video_url", "test.avi");
      startService(i);
      
      finish();
   }
   
}
