package za.co.house4hack.bluemote;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseButtonActivity extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Toast.makeText(this, "Button " + getButtonName() + " pressed", Toast.LENGTH_LONG).show();
   }
   
   public String getButtonName() {
      return getClass().getName();
   }
   
}
