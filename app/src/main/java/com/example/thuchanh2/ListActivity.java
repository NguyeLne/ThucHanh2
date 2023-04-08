package com.example.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thuchanh2.model.Place;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        initListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = arrayAdapter.getItem(i);
//               Toast.makeText(getApplicationContext(),selection,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListActivity.this,DetailActivity.class);
                intent.putExtra("place",selection);
                startActivity(intent);

            }
        });
    }

    private void initView() {
        listView = findViewById(R.id.place);
    }
    private void initListView() {
        String[] list = getResources().getStringArray(R.array.place);
        arrayAdapter = new ArrayAdapter<>(this,R.layout.item,list);
        listView.setAdapter(arrayAdapter);
    }


}
//https://xuanthulab.net/su-dung-listview-hien-thi-du-lieu-dang-danh-sach-trong-android.html