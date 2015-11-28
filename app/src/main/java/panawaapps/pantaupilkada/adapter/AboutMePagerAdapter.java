package panawaapps.pantaupilkada.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.fragments.FriendFragment;
import panawaapps.pantaupilkada.fragments.GroupFragment;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class AboutMePagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private int tabIcons[] = {R.drawable.tab_friend_white, R.drawable.tab_group_white};

    public AboutMePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (position == 0) ? "Friend" : "Group";
    }

    @Override
    public Fragment getItem(int position) {
        return (position == 0) ? new FriendFragment() : new GroupFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}
