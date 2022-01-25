package com.example.plantdiscovery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<flowerSample> listFlowerSample = new ArrayList<>();
    public Boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readPlantData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton button2 = findViewById(R.id.musicButton2);
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        Drawable playDrawable = getResources().getDrawable(android.R.drawable.ic_media_play);
        Drawable pauseDrawable = getResources().getDrawable(android.R.drawable.ic_media_pause);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playing = !playing; //Button Press detected
                Log.d("MyActivity", String.valueOf(playing));
                if (playing) { // We want music
                    mp.start();
                    button2.setImageDrawable(pauseDrawable);

                } else {
                    mp.pause();
                    button2.setImageDrawable(playDrawable);
                }
            }
        });

    }

    private void readPlantData() {
        InputStream is = getResources().openRawResource(R.raw.data_flower);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        Log.d("MyActivity", "read PlantData");
        try {
            while ((line = reader.readLine()) != null) {
                //split by ','
                String[] tokens = line.split(",");

                // Read the data
                flowerSample sample = new flowerSample();

                sample.setNom(tokens[0]);
                sample.setDescription(tokens[1]);
                sample.setImage(tokens[2]);
                sample.setMore(tokens[3]);

                listFlowerSample.add(sample);

                Log.d("MyActivity", "just created" + sample);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();

        }

        for (int i = 1; i < listFlowerSample.size(); i++) {
            flowerSample f;
            f = listFlowerSample.get(i);
            Log.d("MyActivity", f.getNom());
        }

    }

    public void descActivity(View view) {
        ImageButton b = (ImageButton) view;
        long idButton = b.getId();
        Intent descActivity = new Intent(this, PlantDescriptionActivity.class);
        descActivity.putExtra("buttonId", idButton);
        startActivity(descActivity);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.finish();
        return true;
    }

}

