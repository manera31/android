package com.joanmanera.examen;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StarParser {
    private ArrayList<Star> stars;
    private InputStream inputStream;

    public StarParser(Context context) {
        this.inputStream = context.getResources().openRawResource(R.raw.stars);
    }

    public boolean parse(){
        boolean parsed = false;
        String jsonStars = null;
        stars = new ArrayList<>();

        try {
            int sizeStars = inputStream.available();
            byte[] bufferStars = new byte[sizeStars];
            inputStream.read(bufferStars);
            inputStream.close();
            jsonStars = new String(bufferStars, "UTF-8");

            JSONTokener tokener = new JSONTokener(jsonStars);
            JSONArray jsonArray = new JSONArray(tokener);
            for (int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                int hib = jsonObject.getInt("hib");
                String bf = jsonObject.getString("bf");
                String proper = jsonObject.getString("proper");
                double ra = jsonObject.getDouble("ra");
                double dec = jsonObject.getDouble("dec");
                double dist = jsonObject.getDouble("dist");
                double mag = jsonObject.getDouble("mag");
                String spect = jsonObject.getString("spect");

                stars.add(new Star(id, hib, bf, proper, ra, dec, dist, mag, spect));
            }

            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return parsed;
    }

    public Star[] getStars() {
        return (Star[]) stars.toArray();
    }
}
