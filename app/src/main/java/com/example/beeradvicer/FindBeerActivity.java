package com.example.beeradvicer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private final BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());
        List<String> advicedBeers = expert.getBrands(beerType);
        StringBuilder advice = new StringBuilder();
        for (String advicedBeer : advicedBeers) {
            advice.append(advicedBeer).append("\n");
        }
        brands.setText(advice.toString());
    }
}