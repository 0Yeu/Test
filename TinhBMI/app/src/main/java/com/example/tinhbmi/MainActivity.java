package com.example.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edittextchieucao, edittextcannang;
    Button buttontinhbmi;
    TextView textviewketqua, textviewnhanxet;
    double ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittextchieucao = findViewById(R.id.edittext_chieucao);
        edittextcannang = findViewById(R.id.edittext_cannang);
        buttontinhbmi = findViewById(R.id.button_tinhbmi);
        textviewketqua = findViewById(R.id.textview_ketqua);
        textviewnhanxet = findViewById(R.id.textview_nhanxet);
        edittextcannang.setText("0");
        edittextchieucao.setText("0");
        buttontinhbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double chieucao = Double.parseDouble(edittextchieucao.getText().toString());
                double cannang = Double.parseDouble(edittextcannang.getText().toString());

                ketqua = Math.round((cannang/Math.pow(chieucao,2))*10.0)/10.0;
            if(chieucao==0 && cannang==0){
                Toast.makeText(MainActivity.this, "Chiều cao và cân nặng phải khác 0", Toast.LENGTH_LONG).show();
            } else {
                if(ketqua > 35){
                    textviewketqua.setText(String.valueOf(ketqua));
                    textviewnhanxet.setText("Bạn là người béo phì cấp độ III");
                } else if (ketqua <= 35 && ketqua >= 30){
                    textviewketqua.setText(String.valueOf(ketqua));
                    textviewnhanxet.setText("Bạn là người béo phì cấp độ II");
                } else if (ketqua <= 29.9 && ketqua >= 25){
                    textviewketqua.setText(String.valueOf(ketqua));
                    textviewnhanxet.setText("Bạn là người béo phì cấp độ I");
                } else if (ketqua <= 24.9 && ketqua >= 18){
                    textviewketqua.setText(String.valueOf(ketqua));
                    textviewnhanxet.setText("Bạn là người bình thường");
                } else if (ketqua < 18){
                    textviewketqua.setText(String.valueOf(ketqua));
                    textviewnhanxet.setText("Bạn là người gầy");
                }
            }
            }
        });
    }
}