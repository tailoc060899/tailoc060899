package com.example.thithu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thithu.Sqlite.Dao;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText ml,msp,sln,slx,dgn, dgx,nn,nx;
    Button button,ds;
    Dao dao;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new Dao(this);
        ml = findViewById(R.id.ed_mLoaiSp);
        msp = findViewById(R.id.ed_maSP);
        sln= findViewById(R.id.ed_soluongNhap);
        slx= findViewById(R.id.ed_soluongXuat);
        dgn = findViewById(R.id.ed_donGiaN);
        dgx = findViewById(R.id.ed_donGiaX);
        nn = findViewById(R.id.ed_ngayNhap);
        nx = findViewById(R.id.ed_Ngayxuat);
        button = findViewById(R.id.bnt_them);
        ds = findViewById(R.id.bnt_ds);
        random = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mlsp = ml.getText().toString();
                String MSP = msp.getText().toString();
                int SLN = Integer.parseInt(sln.getText().toString());
                int SLX = Integer.parseInt(slx.getText().toString());
                int DGN = Integer.parseInt(dgn.getText().toString());
                int DGX = Integer.parseInt(dgx.getText().toString());
                String NN = nn.getText().toString();
                String NX = nx.getText().toString();
                dao.insert(mlsp,MSP,DGN,DGX,SLN,SLX,NN,NX, String.valueOf(random.nextInt()));
                Toast.makeText(MainActivity.this, "thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });
    }
}