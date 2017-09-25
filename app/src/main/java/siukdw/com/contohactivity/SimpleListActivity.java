package siukdw.com.contohactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListActivity extends AppCompatActivity {

    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        String[] arrNama = {"Erick","Budi","Bambang","Joko","Andi","Susi"};

        myListView = (ListView)findViewById(R.id.myListView);
        myListView.setAdapter(new ArrayAdapter<String>(SimpleListActivity.this,
                android.R.layout.simple_list_item_1,arrNama));

    }
}
