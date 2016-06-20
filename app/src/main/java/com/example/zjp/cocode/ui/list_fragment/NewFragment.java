package com.example.zjp.cocode.ui.list_fragment;

import com.example.zjp.cocode.model.ItemModel;
import com.example.zjp.cocode.support.DataLoader;

import java.util.List;

/**
 * Created by zjp on 16-6-19.
 */
public class NewFragment extends BaseListFragment{

    @Override
    public List<ItemModel> getList() {
        return DataLoader.loadhome();
    }
}
