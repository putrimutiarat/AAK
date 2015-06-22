package com.example.android.aak;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TiaRa on 6/20/2015.
 */
public class KoreaAdapter extends BaseAdapter {
    private final ArrayList<ObjectKorea> korea;
    private final Context context;

    public KoreaAdapter(Context applicationContext, ArrayList<ObjectKorea> korea) {
        this.context = applicationContext;
        this.korea = korea;
    }

    @Override
    public int getCount() {
        return korea.size();
    }

    @Override
    public Object getItem(int position) {
        return korea.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //kalau bisa ini nanti di kasih kondisi jika isinya == null

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ObjectKorea objectKorea = korea.get(position);

        String[] tanggalAja = objectKorea.getTanggalPost().split("T");

        View gView = inflater.inflate(R.layout.list_item, null);

        TextView judul = (TextView) gView.findViewById(R.id.list_item_judul);
        TextView tanggal = (TextView) gView.findViewById(R.id.list_item_tanggal);
        TextView author = (TextView) gView.findViewById(R.id.list_item_author);

        judul.setText(Html.fromHtml(objectKorea.getJudulPost()));
        tanggal.setText(Html.fromHtml(tanggalAja[0]));
        author.setText(Html.fromHtml("by : "+objectKorea.getNamaAuthor()));

        return gView;
    }
}
