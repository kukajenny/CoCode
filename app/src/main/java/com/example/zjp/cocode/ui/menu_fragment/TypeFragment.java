package com.example.zjp.cocode.ui.menu_fragment;

import com.example.zjp.cocode.ui.list_fragment.BaseListFragment;
import com.example.zjp.cocode.ui.list_fragment.CareerFragment;
import com.example.zjp.cocode.ui.list_fragment.Erlang21Fragment;
import com.example.zjp.cocode.ui.list_fragment.JuniorFragment;
import com.example.zjp.cocode.ui.list_fragment.LangFragment;
import com.example.zjp.cocode.ui.list_fragment.NewFragment;
import com.example.zjp.cocode.ui.list_fragment.LatestFragment;
import com.example.zjp.cocode.ui.list_fragment.PMFragment;
import com.example.zjp.cocode.ui.list_fragment.StudyFragment;
import com.example.zjp.cocode.ui.list_fragment.SuggestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 16-6-18.
 */
public class TypeFragment extends BaseTabFragment {

    @Override
    public List<String> getTitleList() {
        List<String>list = new ArrayList<>();
        list.add("初学入门");
        list.add("招聘求职");
        list.add("一周成果分享");
        list.add("招聘求职");
        list.add("招聘求职");
        list.add("招聘求职");
        list.add("招聘求职");
        return list;
    }

    @Override
    public BaseListFragment[] getFragmentList() {
        BaseListFragment [] fragments = new BaseListFragment[7];
        fragments[0] = new JuniorFragment();
        fragments[1] = new CareerFragment();
        fragments[2] = new LangFragment();
        fragments[3] = new SuggestFragment();
        fragments[4] = new StudyFragment();
        fragments[5] = new PMFragment();
        fragments[6] = new Erlang21Fragment();
        return fragments;
    }
}
