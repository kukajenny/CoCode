package com.example.zjp.cocode.ui.list_fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.zjp.cocode.R;
import com.example.zjp.cocode.adapter.ListAdapter;
import com.example.zjp.cocode.model.ItemModel;
import com.example.zjp.cocode.ui.TypeShowActivity;

import java.util.List;

/**
 * Created by zjp on 16-6-16.
 */
public abstract class BaseListFragment extends Fragment {

    public abstract List<ItemModel> getList();


    private View parentView;
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView =  inflater.inflate(R.layout.fragment_list, container, false);
        initView();
        return parentView;
    }

    private void initView(){
        recyclerView = (RecyclerView) parentView.findViewById(R.id.list_recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter = new ListAdapter(getList());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);


    }


}
