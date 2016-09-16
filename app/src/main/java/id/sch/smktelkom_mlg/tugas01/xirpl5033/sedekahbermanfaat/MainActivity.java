package id.sch.smktelkom_mlg.tugas01.xirpl5033.sedekahbermanfaat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNama;
    EditText etKelas;
    RadioGroup rgJK;
    RadioButton rbLK, rbPM;
    CheckBox cbCD, cbMB, cbMN, cbBR;
    Spinner spAN;
    Button bOK;
    TextView tvHasil, tvHobi, tvHasil2;
    int nbHobi;

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

        cbCD.setOnCheckedChangeListener(this);
        cbMB.setOnCheckedChangeListener(this);
        cbMN.setOnCheckedChangeListener(this);
        cbBR.setOnCheckedChangeListener(this);


        spAN = (Spinner) findViewById(R.id.spinnerAN);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHobi = (TextView) findViewById(R.id.textViewHobi);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);

        bOK = (Button) findViewById(R.id.buttonOK);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String kelas = etKelas.getText().toString();
            tvHasil.setText("Nama : " + nama + " \n\n Kelas " + kelas);
        }
    }

    private void doClick() {
        String JN = null;

        if (rbLK.isChecked()) {
            JN = rbLK.getText().toString();
        } else if (rbPM.isChecked()) {
            JN = rbPM.getText().toString();
        }

        if (JN == null) {
            tvHasil.setText("Anda belum memilih gander");
        } else {
            tvHasil.setText("\n\n Jenis Kelamin : " + JN);
        }

        String HB = "\n\n Hobi Anda : ";
        int startlen = HB.length();
        if (cbCD.isChecked()) HB += cbCD.getText() + "\n";
        if (cbMB.isChecked()) HB += cbMB.getText() + "\n";
        if (cbMN.isChecked()) HB += cbMN.getText() + "\n";
        if (cbBR.isChecked()) HB += cbBR.getText() + "\n";

        if (HB.length() == startlen) HB += "Tidak ada pada Pilihan";
        String nama = etNama.getText().toString();
        String kelas = etKelas.getText().toString();
        tvHasil.setText(" \n\n Nama : " + nama + " \n\n Kelas : " + kelas + HB + "\n Jenis Kelamin : " + JN + "\n\n\n");
        tvHasil2.setText("Terimakasih telah bergabung di Sedekah Bermanfaat. \n Semoga menjadi amal sholeh kita.");
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nbHobi += 1;
        else nbHobi -= 1;

        tvHobi.setText("Hobi(" + nbHobi + " terpilih)");

    }
}
