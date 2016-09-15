package id.sch.smktelkom_mlg.tugas01.xirpl5033.sedekahbermanfaat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etKelas;
    RadioGroup rgJK;
    RadioButton rbLK, rbPM;
    CheckBox cbCD, cbMB, cbMN, cbBR;
    Spinner spAN;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etKelas = (EditText) findViewById(R.id.editTextKelas);

        rbLK = (RadioButton) findViewById(R.id.radioButtonLK);
        rbPM = (RadioButton) findViewById(R.id.radioButtonPM);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);

        cbCD = (CheckBox) findViewById(R.id.checkBoxCD);
        cbMB = (CheckBox) findViewById(R.id.checkBoxMB);
        cbMN = (CheckBox) findViewById(R.id.checkBoxMN);
        cbBR = (CheckBox) findViewById(R.id.checkBoxBR);

        spAN = (Spinner) findViewById(R.id.spinnerAN);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK = (Button) findViewById(R.id.buttonOK);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String kelas = etKelas.getText().toString();
            tvHasil.setText(nama + " \n\n kelas " + kelas);
        }
    }

    private void doClick() {

    }

    public boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String kelas = etKelas.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum Anda isi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (kelas.isEmpty()) {
            etKelas.setError("Kelas belum diisi");
            valid = false;
        } else {
            etKelas.setError(null);
        }

        return valid;
    }
}
