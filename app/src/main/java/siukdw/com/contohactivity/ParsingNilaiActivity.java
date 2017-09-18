package siukdw.com.contohactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ParsingNilaiActivity extends AppCompatActivity {
    private Button btnShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_nilai);

        btnShowData = (Button)findViewById(R.id.btnShowData);
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().getExtras()!=null){
                    Bundle b = getIntent().getExtras();
                    String nim = b.getString("nim");
                    String nama = b.getString("nama");
                    Toast.makeText(ParsingNilaiActivity.this, "Nama :"+nama+" Nim : "+nim,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
