package mariachi.com.cachapuercos.ui.activitys.payactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mariachi.com.cachapuercos.R;

/**
 * Created by ederpadilla on 19/01/17.
 */

public class CommentDialog extends DialogFragment {
    @BindView(R.id.btn_dialog_commment_acept)
    Button accept;
    @BindView(R.id.btn_dialog_commment_cancel)
    Button cancel;

    @BindView(R.id.et_commen)
    EditText et_email;

    @BindView(R.id.rating)
    RatingBar ratingBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /** Inflamos nuestra vista */
        View view = inflater.inflate(R.layout.dialog_commment, container,false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        ButterKnife.bind(this, view);
        return view;
    }
    public static CommentDialog newInstance(){
        CommentDialog commentDialog = new CommentDialog();
        return commentDialog;
    }
    @OnClick(R.id.btn_dialog_commment_cancel)
    public void cancelDialog(){
        dismiss();
    }
    @OnClick(R.id.btn_dialog_commment_acept)
    public void acceptDialog(){
        dismiss();

    }
}