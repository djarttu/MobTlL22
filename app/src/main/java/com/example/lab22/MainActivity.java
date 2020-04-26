package com.example.lab22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list = new ArrayList<>();
    ArrayList<Stock> arrayList = new ArrayList<>();
    ListView listView;
    MyAdapter myAdapter;
    String url="https://financialmodelingprep.com/api/company/price/AAPL,GOOGL,FB,NOK?datatype=json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        list.add("NOK");
        list.add("AAPL");
        list.add("GOOGL");
        list.add("FB");

        myAdapter = new MyAdapter(this, R.layout.list_view_items, arrayList);
        listView.setAdapter(myAdapter);


        try {
            requestJSON();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void requestJSON() throws JSONException {


        RequestQueue requestQueue = Volley.newRequestQueue(this);






        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url,null,  new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       for(int i=0; i<list.size(); i++) {
                           try {
                               arrayList.add(new Stock(list.get(i), response.getJSONObject(list.get(i)).getString("price")));
                               //Log.d("lhf", response.getJSONObject(list.get(i)).getString("price"));
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }
                       }
                        myAdapter.notifyDataSetChanged();
                    }



                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ei", error.toString());
                    }




                }
                );
        requestQueue.add(jsonObjectRequest);

    }
}

