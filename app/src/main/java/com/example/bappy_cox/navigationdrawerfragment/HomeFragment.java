package com.example.bappy_cox.navigationdrawerfragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    TabLayout tablayout;
    public HomeFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);


        viewPager= (ViewPager)view.findViewById(R.id.viewpager);

        setupewviewpager(viewPager);
        tabLayout= (TabLayout)view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


        return view;

    }
    private void setupewviewpager(ViewPager viewPager){
        ViewPagerAdapter adpter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adpter.addFragment(new AllNews(),"সকল খবর");
        adpter.addFragment(new Bangladesh(),"বাংলাদেশ");
        adpter.addFragment(new International(),"আন্তর্জাতিক");
        adpter.addFragment(new Sports(),"খেলা");
        adpter.addFragment(new Entertainment(),"বিনোদন");
        adpter.addFragment(new Science(),"বিজ্ঞান ও প্রযুক্তি");
        viewPager.setAdapter(adpter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mfragmentlist =new ArrayList<>();
        private final List<String> mfragmentTitlelist = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentlist.size();
        }
        public void addFragment(Fragment fragment,String title){
            mfragmentlist.add(fragment);
            mfragmentTitlelist.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mfragmentTitlelist.get(position);
        }
    }


}
