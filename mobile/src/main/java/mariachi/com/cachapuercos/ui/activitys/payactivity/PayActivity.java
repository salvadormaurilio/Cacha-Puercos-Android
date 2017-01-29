package mariachi.com.cachapuercos.ui.activitys.payactivity;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.model.PoliceMan;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class PayActivity extends AppCompatActivity {

    @BindView(R.id.police_image_profile)
    ImageView police_image_profile;

    @BindView(R.id.tv_profile_name)
    TextView tv_profile_name;

    @BindView(R.id.tv_profile_description)
    TextView tv_profile_description;

    @BindView(R.id.library_normal_ratingbar)
    RatingBar library_normal_ratingbar;

    @BindView(R.id.pen)
    ImageView pen;

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

    private void initValues(){
        Glide
                .with(getApplicationContext())
                .load(policeMan.getImageUrl())
                .centerCrop()
                .crossFade()
                .into(police_image_profile);
        tv_profile_name.setText(policeMan.getName());
        tv_profile_description.setText(policeMan.getDescription());
        library_normal_ratingbar.setDrawingCacheBackgroundColor(getResources().getColor(R.color.yellow));
        library_normal_ratingbar.setBackgroundColor(getResources().getColor(R.color.yellow));
        library_normal_ratingbar.setDrawingCacheBackgroundColor(getResources().getColor(R.color.yellow));
        library_normal_ratingbar.setRating(policeMan.getRate());
        library_normal_ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {


            }
        });
    }

    @OnClick(R.id.pen)
    public void write(){
        CommentDialog commentDialog = CommentDialog.newInstance();
        commentDialog.show(getSupportFragmentManager(),"Init diaolog");

    }
}
