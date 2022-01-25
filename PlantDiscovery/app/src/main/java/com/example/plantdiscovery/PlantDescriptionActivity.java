package com.example.plantdiscovery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.text.LineBreaker;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class PlantDescriptionActivity extends AppCompatActivity {
    private List<flowerSample> listFlowerSample;
    private TextView textViewNomFleur;
    private ImageView imageViewFleur;
    private TextView textViewDescFleur;
    private Button KnowMoreButton;
    public String varURL="";


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_description);
        Intent i = getIntent();
        long idButton = i.getLongExtra("buttonId", -1);
        listFlowerSample = MainActivity.listFlowerSample;
        textViewNomFleur = findViewById(R.id.nomFleur);
        imageViewFleur = findViewById(R.id.imageViewFleur);
        textViewDescFleur = findViewById(R.id.TextViewDesc);
        KnowMoreButton = findViewById(R.id.knowMoreButton);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (idButton == R.id.imageButton1) {
            textViewNomFleur.setText(listFlowerSample.get(1).getNom());
            textViewDescFleur.setText(listFlowerSample.get(1).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.orchidee);
            varURL = listFlowerSample.get(1).getMore();
            String myString = listFlowerSample.get(1).getDescription();
            String newStringWithJump = myString.replace(".", "\n");
            Log.d("straa", newStringWithJump);
            Log.d("varURL", varURL);

        }
        if (idButton == R.id.imageButton2) {
            textViewNomFleur.setText(listFlowerSample.get(2).getNom());
            textViewDescFleur.setText(listFlowerSample.get(2).getDescription().replace(". ", "\n\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.dahlia);
            varURL = listFlowerSample.get(2).getMore();
            Log.d("varURL", varURL);

        }
        if (idButton == R.id.imageButton3) {
            textViewNomFleur.setText(listFlowerSample.get(3).getNom());
            textViewDescFleur.setText(listFlowerSample.get(3).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.hibiscus);
            varURL = listFlowerSample.get(3).getMore();

        }
        if (idButton == R.id.imageButton4) {
            textViewNomFleur.setText(listFlowerSample.get(4).getNom());
            textViewDescFleur.setText(listFlowerSample.get(4).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.jacinthes);
            varURL = listFlowerSample.get(4).getMore();

        }
        if (idButton == R.id.imageButton5) {
            textViewNomFleur.setText(listFlowerSample.get(5).getNom());
            textViewDescFleur.setText(listFlowerSample.get(5).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.marguerite);
            varURL = listFlowerSample.get(5).getMore();

        }
        if (idButton == R.id.imageButton6) {
            textViewNomFleur.setText(listFlowerSample.get(6).getNom());
            textViewDescFleur.setText(listFlowerSample.get(6).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.muguet);
            varURL = listFlowerSample.get(6).getMore();

        }
        if (idButton == R.id.imageButton7) {
            textViewNomFleur.setText(listFlowerSample.get(7).getNom());
            textViewDescFleur.setText(listFlowerSample.get(7).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.arum);
            varURL = listFlowerSample.get(7).getMore();

        }
        if (idButton == R.id.imageButton8) {
            textViewNomFleur.setText(listFlowerSample.get(8).getNom());
            textViewDescFleur.setText(listFlowerSample.get(8).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.rose);
            varURL = listFlowerSample.get(8).getMore();
        }
        if (idButton == R.id.imageButton9) {
            textViewNomFleur.setText(listFlowerSample.get(9).getNom());
            textViewDescFleur.setText(listFlowerSample.get(9).getDescription().replace(". ", "\n\n").replace(": ", ":\n"));
            imageViewFleur.setImageResource(R.drawable.tulipe);
            varURL = listFlowerSample.get(9).getMore();
        }

        textViewDescFleur.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
    }

    public void wikipedia1(View view) {
        Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(varURL));
        startActivity(BrowserIntent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Context context = getApplicationContext();
        this.finish();
        return true;
    }
}