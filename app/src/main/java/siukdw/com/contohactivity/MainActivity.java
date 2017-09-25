package siukdw.com.contohactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello,tvHello2;
    private Button btnHello,btnShowToast,btnCalcActivity,btnKirimNilai;
    private View.OnClickListener btnShowToast_Click;
    private EditText txtBil1,txtNim,txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcActivity = (Button)findViewById(R.id.btnCalcActivity);
        btnCalcActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCalc = new Intent(MainActivity.this,
                        SimpleCalcActivity.class);
                startActivity(intentCalc);
            }
        });


        tvHello = (TextView)findViewById(R.id.tvHello);
        tvHello.setText("Ini diubah dari kode java");

        tvHello2 = (TextView)findViewById(R.id.tvHello2);
        tvHello2.setText(tvHello.getText());

        btnHello = (Button)findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHello.setText("Hello Android Studio");
                tvHello2.setText("Belajar Event Handler di Android");
            }
        });

        btnShowToast = (Button)findViewById(R.id.btnShowToast);
        btnShowToast_Click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        txtBil1.getText(),Toast.LENGTH_LONG).show();
            }
        };
        btnShowToast.setOnClickListener(btnShowToast_Click);


        txtBil1 = (EditText)findViewById(R.id.txtBil1);


        txtNim = (EditText)findViewById(R.id.txtNim);
        txtNama = (EditText)findViewById(R.id.txtNama);
        btnKirimNilai = (Button)findViewById(R.id.btnKirimNilai);

        btnKirimNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentParsing = new Intent(MainActivity.this,ParsingNilaiActivity.class);
                Bundle b = new Bundle();
                b.putString("nim",txtNim.getText().toString());
                b.putString("nama",txtNama.getText().toString());
                intentParsing.putExtras(b);
                startActivity(intentParsing);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSimpleCalc:
                Intent intentSimpleCalc = new Intent(MainActivity.this,
                        SimpleCalcActivity.class);
                startActivity(intentSimpleCalc);
                return true;
            case R.id.menuSimpleList:
                Intent intentSimpleList = new Intent(MainActivity.this,
                        SimpleListActivity.class);
                startActivity(intentSimpleList);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
