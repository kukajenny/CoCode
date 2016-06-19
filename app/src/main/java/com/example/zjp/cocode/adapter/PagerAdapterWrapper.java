package com.example.zjp.cocode.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.zjp.cocode.ui.list_fragment.BaseListFragment;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapterWrapper {

    private FragmentManager fragmentManager;
    private List<BaseListFragment> fragments;
    private List<String> list_Title;

    public PagerAdapterWrapper(FragmentManager fragmentManager, List<BaseListFragment> fragments,List<String>list_Title) {
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
        this.list_Title = list_Title;
    }

    public PagerAdapterWrapper(FragmentManager fragmentManager,List<String>list_Title) {
        this.fragmentManager = fragmentManager;
        this.list_Title = list_Title;
        fragments = new ArrayList<>();
    }

    public PagerAdapterWrapper addFragments(BaseListFragment... fragments){
        if (fragments == null || fragments.length <= 0 ){
            throw new IllegalArgumentException("args must not be null!!!");
        }
        for (BaseListFragment fragment:fragments){
            this.fragments.add(fragment);
        }
        return this;
    }


    /**
     * you must add fragments before invoke this function
     * @return
     */
    public PagerAdapter build(){
        PagerAdapter pagerAdapter = new PagerAdapter(fragmentManager,fragments,list_Title);
        return pagerAdapter;
    }

    /**
     * clear fragments
     */
    public void clear(){
        fragments.clear();
    }




    /***
     * We'd better　declare it to static
     * tips:A static nested class does not have a reference to a nesting instance -- By MummyDing
     */
    static class PagerAdapter extends FragmentStatePagerAdapter {
        List<BaseListFragment> listFragments;
        private List<String>list_Title;
        public PagerAdapter(FragmentManager fm, List<BaseListFragment> listFragments,List<String>list_Title) {
            super(fm);
            this.list_Title = list_Title;
            if (listFragments == null || listFragments.size() <=0){
                throw new IllegalArgumentException("listFragments must not be null!!!");
            }
            this.listFragments = listFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return listFragments.get(position);
        }

        @Override
        public int getCount() {
            return list_Title.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list_Title.get(position % list_Title.size());
        }
    }

}