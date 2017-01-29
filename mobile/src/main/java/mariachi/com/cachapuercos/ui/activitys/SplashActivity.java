package mariachi.com.cachapuercos.ui.activitys;

import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.chat.view.activity.ChatActivity;

public class SplashActivity extends AwesomeSplash {

  @Override public void initSplash(ConfigSplash configSplash) {
  /* you don't have to override every property */
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimary); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1500); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

    //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.ic_police); //or any other drawable
        configSplash.setAnimLogoSplashDuration(1200); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)
        configSplash.setOriginalHeight(1000); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(1000); //in relation to your svg (path) resource


    //Customize Title
    configSplash.setTitleSplash("");
    configSplash.setTitleTextColor(R.color.colorPrimaryDark);
    configSplash.setTitleTextSize(30f); //float value
    configSplash.setAnimTitleDuration(3000);
    configSplash.setAnimTitleTechnique(Techniques.FlipInX);
  }

  @Override public void animationsFinished() {
    startActivity(new Intent(this, ChatActivity.class));
    this.finish();
  }
}