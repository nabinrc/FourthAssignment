package com.fourthassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapter.ProductAdapter;
import model.Product;


public class Dashboard extends AppCompatActivity {
    private RecyclerView recyclerView;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);
        btnAddItem = findViewById(R.id.btnAddItem);

        List<Product> clothlist = new ArrayList<>();
        try {
            FileInputStream fos = openFileInput("items.txt");
            InputStreamReader isr=new InputStreamReader(fos);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null){
                String[] parts=line.split("->");



                int image= getResources().getIdentifier(parts[2],"drawable",getPackageName());
                clothlist.add(new Product(image,parts[0],parts[1],parts[3]));
            }

            ProductAdapter clothesadapter=new ProductAdapter(this,clothlist);
            recyclerView.setAdapter(clothesadapter);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        }  catch (IOException e) {
            e.printStackTrace();
        }


        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Dashboard.this,AddItemActivity.class);
                startActivity(intent);
            }
        });
    }
}
