package com.example.zjp.cocode.ui.menu_fragment;

import com.example.zjp.cocode.ui.list_fragment.BaseListFragment;
import com.example.zjp.cocode.ui.list_fragment.CareerFragment;
import com.example.zjp.cocode.ui.list_fragment.JuniorFragment;
import com.example.zjp.cocode.ui.list_fragment.LatestFragment;
import com.example.zjp.cocode.ui.list_fragment.TopFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 16-6-17.
 */
public class HomeFragment extends BaseTabFragment {

    @Override
    public List<String> getTitleList() {
        List<String>list_title = new ArrayList<>();
        list_title.add("最新");
        list_title.add("热门");
        return list_title;
    }

    @Override
    public BaseListFragment[] getFragmentList() {
        BaseListFragment [] fragments = new BaseListFragment[3];
        fragments[0] = new LatestFragment();
        fragments[1] = new TopFragment();

        return fragments;
    }
}
