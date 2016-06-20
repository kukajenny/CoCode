package com.example.zjp.cocode.support;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.zjp.cocode.model.ItemModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zjp on 16-6-17.
 */
public class DataLoader {

    private Context context;
    private String cooked;

    public DataLoader(Context context){
        this.context = context;
    }
    public void getdata(){

        RequestQueue mQueue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://cocode.cc/latest.json", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray users = response.getJSONArray("users");
                            for(int i=0;i<users.length();i++){

                            }
                            JSONObject topic_list = response.getJSONObject("topic_list");
                            JSONArray topics = topic_list.getJSONArray("topics");
                            for(int i=0;i<topics.length();i++){
                                JSONObject jsonObject = topics.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String title = jsonObject.getString("title");
                                String slug = jsonObject.getString("slug");
                                int num_view = jsonObject.getInt("views");
                                int num_posts = jsonObject.getInt("posts_count");
                                int type = jsonObject.getInt("category_id");
                                ItemModel itemModel = new ItemModel();
                                itemModel.setTitle(title);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(jsonObjectRequest);
    }

    public String getCooked() {
        return cooked;
    }

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
