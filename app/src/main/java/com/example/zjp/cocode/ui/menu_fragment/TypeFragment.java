package com.example.zjp.cocode.ui.menu_fragment;

import com.example.zjp.cocode.model.ItemModel;
import com.example.zjp.cocode.support.DataLoader;
import com.example.zjp.cocode.ui.list_fragment.BaseListFragment;

import java.util.List;

/**
 * Created by zjp on 16-6-18.
 */
public class TypeFragment extends BaseListFragment {

    @Override
    public List<ItemModel> getList() {
        return DataLoader.loadhome();
    }
}
