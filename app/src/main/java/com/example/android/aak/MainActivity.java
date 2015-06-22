package com.example.android.aak;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    public static Context context;
    public static JSONObject response1;
    private String URL_FEED = "https://public-api.wordpress.com/rest/v1.1/sites/koreanindo.net/posts/?number=1";

    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<ObjectKorea> objectKorea;

    private ProgressDialog pDialog;
    private static String url = "https://public-api.wordpress.com/rest/v1.1/sites/koreanindo.net/posts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        listView = (ListView) findViewById(R.id.listview);
        objectKorea = new ArrayList<ObjectKorea>();

        new GetKoreaObject().execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ObjectKorea selected = objectKorea.get(i);
                Intent intent  = new Intent(getApplicationContext(), Detail.class);
                intent.putExtra("objectKorea", selected);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetKoreaObject extends AsyncTask <Void, Void, Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Tunggu dulu ya...");
            pDialog.setCancelable(false);
            pDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);
            if (jsonStr != null) {
                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray postsArray= jsonObj.getJSONArray("posts");

                    for (int i = 0; i < postsArray.length(); i++)
                    {
                        JSONObject postsObject = (JSONObject) postsArray.get(i);

                        ObjectKorea object = new ObjectKorea();
                        object.setIdPost(postsObject.getString("ID"));

                        JSONObject author = postsObject.getJSONObject("author");
                        String authornya =  author.isNull("name") ? null : author.getString("name");
                        object.setNamaAuthor(authornya);

                        String tanggal = postsObject.isNull("date") ? null : postsObject.getString("date");
                        String judul = postsObject.isNull("title") ? null : postsObject.getString("title");
                        String urlPost = postsObject.isNull("URL") ? null : postsObject.getString("URL");
                        String isiPost = postsObject.isNull("content") ? null : postsObject.getString("content");

                        object.setTanggalPost(tanggal);
                        object.setJudulPost(judul);
                        object.setUrlPost(urlPost);
                        object.setIsiPost(isiPost);

                        objectKorea.add(object);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (pDialog.isShowing())
                pDialog.dismiss();

            for(ObjectKorea x : objectKorea) {
                Log.d("Object Korea > ", x.getIsiPost());
            }
            listAdapter = new KoreaAdapter(context, objectKorea);
            listView.setAdapter(listAdapter);
        }

    }
}
