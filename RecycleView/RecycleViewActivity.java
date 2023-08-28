package com.example.recycleviewtest.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycleviewtest.Adapters.RecycleViewAdapter;
import com.example.recycleviewtest.R;

public class RecycleViewActivity extends AppCompatActivity implements RecycleViewAdapter.onClickItem {

    RecyclerView recyclerView;
    RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        recyclerView=findViewById(R.id.recycleView);
       // recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new RecycleViewAdapter(this, "Sample Text", 15);
        adapter.SetonClickItem(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnClickitem(int position, View view) {
        Toast.makeText(this, "Clicked "+position, Toast.LENGTH_SHORT).show();
    }
}