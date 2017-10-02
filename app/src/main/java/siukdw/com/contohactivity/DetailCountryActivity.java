package siukdw.com.contohactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

import models.Country;

public class DetailCountryActivity extends AppCompatActivity {
    private EditText etCountry,etPopulation;
    private Button btnEditCountry,btnDeleteCountry;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);

        etCountry = (EditText)findViewById(R.id.etCountry);
        etPopulation = (EditText)findViewById(R.id.etPopulation);

        if(getIntent().getExtras()!=null){
            Bundle b = getIntent().getExtras();
            position = b.getInt("position");
            Country currCountry = SimpleRecyclerView.arrCountry.get(position);
            etCountry.setText(currCountry.getName());
            etPopulation.setText(NumberFormat.getIntegerInstance().format(currCountry.getPopulation()));
        }

        btnEditCountry = (Button)findViewById(R.id.btnEditCountry);
        btnEditCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country editCountry = SimpleRecyclerView.arrCountry.get(position);
                editCountry.setPopulation(Double.parseDouble(etPopulation.getText().toString()));
                Toast.makeText(DetailCountryActivity.this,"Edit data berhasil !",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnDeleteCountry = (Button)findViewById(R.id.btnDeleteCountry);
        btnDeleteCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleRecyclerView.arrCountry.remove(position);
                Toast.makeText(DetailCountryActivity.this,"Delete data berhasil !",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
