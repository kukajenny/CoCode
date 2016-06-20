package com.example.zjp.cocode.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.zjp.cocode.R;
import com.example.zjp.cocode.support.DataLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by zjp on 16-6-19.
 */
public class TypeShowActivity extends Activity{

    private RecyclerView recyclerView;
    private WebView webView;
    private TextView textView;
    final String style = "<style>img{display: inline;height: auto;max-width: 100%;}span{display:none;}</style>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeshow);
        initview();
    }
    public void initview(){
        //recyclerView = (RecyclerView)findViewById(R.id.typeshow_rcv);
        webView = (WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = webView.getSettings(); // webView: 类WebView的实例 webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);  //就是这句

        webView.setWebChromeClient(new WebChromeClient() {
            // 加载进度
            public void onProgressChanged(WebView view, int progress) {

            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Toast.makeText(TypeShowActivity.this,url,Toast.LENGTH_SHORT).show();
                return true;
            }
            // 处理错误
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }

            // 页面开始加载
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {

            }

            // 页面加载完成
            public void onPageFinished(WebView view, String url) {

            }

            // 资源加载
            public void onLoadResource(WebView view, String url) {
                // 例如替换为本地资源
            }
        });
        //webView.loadUrl("https://github.com/");

        //textView = (TextView)findViewById(R.id.text);

        RequestQueue mQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://cocode.cc/t/flasky-heroku/6589.json", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject post_stream = response.getJSONObject("post_stream");
                            JSONArray posts = post_stream.getJSONArray("posts");
                            JSONObject jsonObject = posts.getJSONObject(0);
                            String cooked = jsonObject.getString("cooked");
                            //textView.setText(Html.fromHtml(cooked));
                            webView.getSettings().setDefaultTextEncodingName("utf-8") ;
                            //webView.loadData(cooked, "text/html; charset=UTF-8", null);
                            webView.loadDataWithBaseURL("http://cocode.cc/t/flasky-heroku/6589",style+cooked,"text/html; charset=UTF-8", null,"http://cocode.cc/latest");
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
}
