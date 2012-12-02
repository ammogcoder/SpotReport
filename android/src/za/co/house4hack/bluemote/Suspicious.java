package za.co.house4hack.bluemote;

public class Suspicious extends BaseButtonActivity {

   @Override
   protected void onButtonActivated() {
      startVoiceRecord();
      finish();
   }
   
}
