package com.example.android.aak;

import java.util.ArrayList;

/**
 * Created by TiaRa on 6/20/2015.
 */
public class StaticContent {
    public static ArrayList<ObjectKorea> getDataSNSD() {
        // membuat arraylist object sederhana
        ArrayList<ObjectKorea> bio = new ArrayList<>();
        bio.add(new ObjectKorea("Lee Sun Kyu", "Energy Pill", "15 Mei 1989", "B", "158cm", "Membantu Vokal"));
        bio.add(new ObjectKorea("Seo Joo Hyun", "The Youngest Princess", "28 Juni 1991", "A", "168cm", "Ketua Vokal yang ke-3"));
        bio.add(new ObjectKorea("Kim Hyo Yeon", "Bright Snow White", "22 September 1989", "AB", "160cm", "Ketua Dancer yang ke-1"));
        bio.add(new ObjectKorea("Jessica Jung", "Ice Princess", "18 April 1989", "B", "163cm", "ketua Vocal yang ke- 2"));
        bio.add(new ObjectKorea("Kim Tae Yeon", "little child ", "9 Maret 1989", "O", "162cm", "ketua vocal yang ke- 1"));
        bio.add(new ObjectKorea("Choi Soo Young", "Fun Loving Princess", "10 Februari 1990", "O", "170cm", "Membantu Vokal"));
        bio.add(new ObjectKorea("Hwang Mi Young, Tiffany Hwang", " Brighter Than Gem", "1 Agustus 1989", "B", "162cm", "Ketua Vokal yang ke-4"));
        bio.add(new ObjectKorea("Im Yoon Ah", "Charming Girl", "30 Mei 1990", "B", "166cm", "Ketua Dancer yang ke-3, membantu vokal"));
        bio.add(new ObjectKorea("Kwon Yuri", "Black Pearl", "5 Desember 1989", "AB", "167cm", "Ketua Dancer yang ke-2, membantu vokal"));

        return bio;
    }
}
