package siukdw.com.contohactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import models.Country;

public class DetailCountryActivity extends AppCompatActivity {
    private EditText etCountry,etPopulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);

        etCountry = (EditText)findViewById(R.id.etCountry);
        etPopulation = (EditText)findViewById(R.id.etPopulation);

        if(getIntent().getExtras()!=null){
            Bundle b = getIntent().getExtras();
            int position = b.getInt("position");
            Country currCountry = SimpleRecyclerView.arrCountry.get(position);
            etCountry.setText(currCountry.getName());
            etPopulation.setText(String.valueOf(currCountry.getPopulation()));
        }
    }
}
