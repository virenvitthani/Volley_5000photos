package com.example.volley_5000photos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    Recyclerview_Adapater adapter;
    RecyclerView recyclerView;
    ArrayList<DataModel> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = findViewById(R.id.imagebutton);
        recyclerView = findViewById(R.id.recyclerview);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new Recyclerview_Adapater(MainActivity.this,list);
                LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/photos";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("vvv", "onResponse: "+response.toString());
                        JSONObject mainobj = null;
                        try
                        {
                            JSONArray jsonArray = new JSONArray(response.toString());

                            for (int i=0;i<jsonArray.length();i++)
                            {
                                mainobj=jsonArray.getJSONObject(i);
                                int id=mainobj.getInt("id");
                                String title=mainobj.getString("title");
                                int albumId=mainobj.getInt("albumId");
                                String url=mainobj.getString("url");
                                DataModel model=new DataModel(id,title,albumId,url);
                                list.add(model);
                            }
                            Log.d("vvv", "list: "+list);

                        }
                        catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("vvv", "onErrorResponse: "+error.getLocalizedMessage());
            }
        });
        queue.add(stringRequest);
    }
}