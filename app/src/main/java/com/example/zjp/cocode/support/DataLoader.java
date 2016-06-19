package com.example.zjp.cocode.support;

import com.example.zjp.cocode.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 16-6-17.
 */
public class DataLoader {
    public static List<ItemModel> loadhome() {

        List<ItemModel> list = new ArrayList<>();

        ItemModel model = new ItemModel();

        model.setTitle("a");
        list.add(model);

        model = new ItemModel();
        model.setTitle("b");
        list.add(model);

        model = new ItemModel();
        model.setTitle("c");
        list.add(model);

        return list;
    }
    public static List<ItemModel> loadnew() {

        List<ItemModel> list = new ArrayList<>();

        ItemModel model = new ItemModel();

        model.setTitle("a");
        list.add(model);

        model = new ItemModel();
        model.setTitle("b");
        list.add(model);

        return list;
    }
}
