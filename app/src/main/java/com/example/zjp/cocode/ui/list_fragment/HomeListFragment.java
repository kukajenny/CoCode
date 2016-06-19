package com.example.zjp.cocode.ui.list_fragment;

import android.provider.ContactsContract;

import com.example.zjp.cocode.model.ItemModel;
import com.example.zjp.cocode.support.DataLoader;

import java.util.List;

/**
 * Created by zjp on 16-6-18.
 */
public class HomeListFragment extends BaseListFragment{

    @Override
    public List<ItemModel> getList() {
        return DataLoader.loadhome();
    }
}
