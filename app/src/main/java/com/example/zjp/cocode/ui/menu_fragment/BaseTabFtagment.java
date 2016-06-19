package com.example.zjp.cocode.ui.menu_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zjp.cocode.R;
import com.example.zjp.cocode.adapter.ListAdapter;
import com.example.zjp.cocode.adapter.PagerAdapterWrapper;
import com.example.zjp.cocode.model.ItemModel;
import com.example.zjp.cocode.ui.list_fragment.BaseListFragment;
import com.example.zjp.cocode.ui.list_fragment.BeginnerFragment;
import com.example.zjp.cocode.ui.list_fragment.HomeListFragment;
import com.example.zjp.cocode.ui.list_fragment.RecruitFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 16-6-18.
 */
public abstract class BaseTabFtagment extends Fragment {

    public abstract List<String> getTitleList();
    public abstract BaseListFragment[] getFragmentList();
    private View parentView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView =  inflater.inflate(R.layout.fragment_tab, container, false);
        initView();
        return parentView;
    }

    private void initView(){
        tabLayout = (TabLayout)parentView.findViewById(R.id.tab_tablayout);
        viewPager = (ViewPager) parentView.findViewById(R.id.tab_viewPager);


        PagerAdapterWrapper pagerAdapterWrapper = new PagerAdapterWrapper(getChildFragmentManager(),getTitleList());
        viewPager.setAdapter(pagerAdapterWrapper.addFragments(getFragmentList()).build());
        tabLayout.setupWithViewPager(viewPager);
    }
}
