package com.example.zjp.cocode.ui.menu_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.zjp.cocode.R;
import com.example.zjp.cocode.adapter.PagerAdapterWrapper;
import com.example.zjp.cocode.ui.TypeShowActivity;
import com.example.zjp.cocode.ui.list_fragment.BaseListFragment;

import java.util.List;

/**
 * Created by zjp on 16-6-18.
 */
public abstract class BaseTabFragment extends Fragment {

    public abstract List<String> getTitleList();
    public abstract BaseListFragment[] getFragmentList();
    private View parentView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    protected RecyclerView.LayoutManager mLayoutManager;
    private ImageButton ib_more;

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
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        ib_more = (ImageButton) parentView.findViewById(R.id.tab_ib_more);
        ib_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TypeShowActivity.class);
                startActivity(intent);
            }
        });
    }
}
