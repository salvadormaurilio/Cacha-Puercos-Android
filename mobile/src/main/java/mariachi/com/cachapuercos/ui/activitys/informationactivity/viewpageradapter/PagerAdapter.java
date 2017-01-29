package mariachi.com.cachapuercos.ui.activitys.informationactivity.viewpageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerEight;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerFive;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerFour;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerNine;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerOne;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerSeven;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerSix;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerThree;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.fragments.PagerTwo;

/**
 * Created by ederpadilla on 29/01/17.
 */

public class PagerAdapter  extends FragmentPagerAdapter {
    Fragment frOne, frTwo, frThree;

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {
            case 0:
                frOne = new PagerOne();
                return frOne;
            case 1:
                frTwo = new PagerTwo();
                return frTwo;
            case 2:
                frThree = new PagerThree();
                return frThree;
            case 3:
                frThree = new PagerFour();
                return frThree;
            case 4:
                frThree = new PagerFive();
                return frThree;
            case 5:
                frThree = new PagerSix();
                return frThree;
            case 6:
                frThree = new PagerSeven();
                return frThree;
            case 7:
                frThree = new PagerEight();
                return frThree;
            case 8:
                frThree = new PagerNine();
                return frThree;

            default: return PagerOne.newInstance();
        }
    }

    public Fragment getFragmet(int posit){
        Fragment fragmento = null;
        switch (posit)
        {
            case 0:
                fragmento = frOne;
                break;
            case 1:
                fragmento = frTwo;
                break;
            case 2:
                fragmento = frThree;
                break;
        }
        return fragmento;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
