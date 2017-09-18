package siukdw.com.contohactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity {
    private Button btnSetPreference,btnShowPreference;
    private EditText txtDataPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        btnSetPreference = (Button)findViewById(R.id.btnSetPreference);
        btnShowPreference = (Button)findViewById(R.id.btnShowPreference);
        txtDataPref = (EditText)findViewById(R.id.txtDataPref);

        btnSetPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs =
                        PreferenceActivity.this.getSharedPreferences("myPref",MODE_PRIVATE);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("warna",txtDataPref.getText().toString());
                edit.commit();
            }
        });

        btnShowPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs =
                        PreferenceActivity.this.getSharedPreferences("myPref",MODE_PRIVATE);
                String warna = prefs.getString("warna","");
                Toast.makeText(PreferenceActivity.this, "Warna : "+ warna,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
