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
public class TenFragment extends Fragment {


    public TenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ten, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
