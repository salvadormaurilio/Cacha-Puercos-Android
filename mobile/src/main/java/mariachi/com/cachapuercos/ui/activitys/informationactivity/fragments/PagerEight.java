package mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import mariachi.com.cachapuercos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerEight extends Fragment {


    public PagerEight() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager_eight, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
