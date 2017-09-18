package siukdw.com.contohactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SimpleCalcActivity extends AppCompatActivity {

    private EditText txtBil1,txtBil2,txtHasil;
    private Button btnHitung;
    private RadioButton rdKurang,rdTambah;
    private double hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);

        txtBil1 = (EditText)findViewById(R.id.txtBil1);
        txtBil2 = (EditText)findViewById(R.id.txtBil2);
        txtHasil = (EditText)findViewById(R.id.txtHasil);
        btnHitung = (Button)findViewById(R.id.btnHitung);
        rdKurang = (RadioButton)findViewById(R.id.rdKurang);
        rdTambah = (RadioButton)findViewById(R.id.rdTambah);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bil1 =
                        Double.parseDouble(txtBil1.getText().toString());
                double bil2 =
                        Double.parseDouble(txtBil2.getText().toString());

                if(rdTambah.isChecked()){
                    hasil = Tambah(bil1,bil2);
                }else {
                    hasil=Kurang(bil1,bil2);
                }
                txtHasil.setText(String.valueOf(hasil));
            }
        });

    }

    private double Tambah(double bil1,double bil2){
        return bil1+bil2;
    }

    private double Kurang(double bil1,double bil2){
        return bil1-bil2;
    }
}
