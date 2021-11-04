package com.example.thithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thithu.Sqlite.Dao;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    Dao dao;
    List<String> list;
    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dao =new Dao(this);
        listView = findViewById(R.id.list);
        textView = findViewById(R.id.tv_sl);
        list = dao.getAll();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        textView.setText("số lượng bản ghi: "+adapter.getCount());
    }
}