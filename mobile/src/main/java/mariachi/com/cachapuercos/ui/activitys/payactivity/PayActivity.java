package mariachi.com.cachapuercos.ui.activitys.payactivity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.model.PoliceMan;

public class PayActivity extends AppCompatActivity {

    @BindView(R.id.police_image_profile)
    ImageView police_image_profile;

    PoliceMan policeMan;

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        intent= getIntent();
        //policeMan= (PoliceMan) intent.getSerializableExtra("Police");

    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}
