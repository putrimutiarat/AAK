package com.example.android.aak;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Detail extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final ObjectKorea receive;
        receive = getIntent().getParcelableExtra("objectKorea");

        String[] pisahTanggal = receive.getTanggalPost().split("T");

        TextView judul = (TextView) findViewById(R.id.detail_judul);
        TextView author_tanggal = (TextView) findViewById(R.id.detail_author_tanggal);
        TextView isi = (TextView) findViewById(R.id.detail_isi);
        Button URLButton = (Button) findViewById(R.id.detail_button_url);

//        isi.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        isi.getSettings().setJavaScriptEnabled(true);
//        isi.getSettings().setLoadsImagesAutomatically(false);
//        isi.getSettings().setBlockNetworkLoads (true);



        judul.setText(Html.fromHtml(receive.getJudulPost()));
        author_tanggal.setText("by : "+Html.fromHtml(receive.getNamaAuthor()) + ", on " + Html.fromHtml(pisahTanggal[0]));
        isi.setText(Html.fromHtml(receive.getIsiPost()));
//        isi.loadData(receive.getIsiPost(), "text/html", "UTF-8");

        URLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(String.valueOf(Html.fromHtml(receive.getUrlPost()))));
                startActivity(intent);
            }
        });

        Toast.makeText(this, receive.getJudulPost(), Toast.LENGTH_SHORT).show();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
}
