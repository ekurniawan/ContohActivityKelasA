package siukdw.com.contohactivity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import models.Country;

public class SimpleRecyclerView extends AppCompatActivity {
    private RecyclerView rvData;
    public ArrayList<Country> arrCountry = new ArrayList<>();

    private void IsiData(){
        Country country1 = new Country();
        country1.setName("Indonesia");
        country1.setPopulation(250000000);

        Country country2 = new Country();
        country2.setName("Malaysia");
        country2.setPopulation(100000000);

        Country country3 = new Country();
        country3.setName("Thailand");
        country3.setPopulation(75000000);

        arrCountry.add(country1);
        arrCountry.add(country2);
        arrCountry.add(country3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_view);

        IsiData();
        rvData = (RecyclerView)findViewById(R.id.rvData);
        CountryAdapter adapter = new CountryAdapter(arrCountry);
        rvData.setAdapter(adapter);

        rvData.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(),rvData,
                new RecyclerItemListener.RecyclerTouchListener(){
                    @Override
                    public void OnClickItem(View v, int position) {
                        String negara = arrCountry.get(position).getName();
                        Toast.makeText(SimpleRecyclerView.this,"Anda memilih negara "+negara,
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void OnLongClickItem(View v, int position) {
                        Toast.makeText(SimpleRecyclerView.this,"Long Press",
                                Toast.LENGTH_LONG).show();
                    }
                }));

        //menambahkan horsontal line
        rvData.addItemDecoration(new DividerItemDecoration(ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.item_decorator)));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvData.setLayoutManager(llm);
    }
}
