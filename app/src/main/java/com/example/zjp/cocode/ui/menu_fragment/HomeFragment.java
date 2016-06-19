package com.example.zjp.cocode.ui.menu_fragment;

import com.example.zjp.cocode.model.ItemModel;
import com.example.zjp.cocode.support.DataLoader;
import com.example.zjp.cocode.ui.list_fragment.BaseListFragment;
import com.example.zjp.cocode.ui.list_fragment.BeginnerFragment;
import com.example.zjp.cocode.ui.list_fragment.HomeListFragment;
import com.example.zjp.cocode.ui.list_fragment.RecruitFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 16-6-17.
 */
public class HomeFragment extends BaseTabFtagment {

    @Override
    public List<String> getTitleList() {
        List<String>list_title = new ArrayList<>();
        list_title.add("首页");
        list_title.add("初学入门");
        list_title.add("求职招聘");
        return list_title;
    }

    @Override
    public BaseListFragment[] getFragmentList() {
        BaseListFragment [] fragments = new BaseListFragment[3];
        fragments[0] = new HomeListFragment();
        fragments[1] = new BeginnerFragment();
        fragments[2] = new RecruitFragment();
        return fragments;
    }
}
