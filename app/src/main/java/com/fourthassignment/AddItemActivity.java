package com.fourthassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {

    EditText etItemName, etItemPrice,etImage, etItemDescription;
    Button btnAddMyItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);
        etImage = findViewById(R.id.txtimage);
        etItemDescription = findViewById(R.id.etItemDescription);
        btnAddMyItem = findViewById(R.id.btnAddMyItem);

        btnAddMyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItem();
            }
        });
    }

    private void AddItem(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("items.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etItemName.getText().toString()+ "->"+ etItemPrice.getText().toString()+ "->"+ etImage.getText().toString()+"->"+ etItemDescription.getText().toString());
            Toast.makeText(this,"Item Added" + getFilesDir(),Toast.LENGTH_LONG).show();

            Intent intent = new Intent(AddItemActivity.this,Dashboard.class);
            startActivity(intent);

        }
        catch (IOException e){
            Log.d("ClothingApp","Error: "+ e.toString());
            e.printStackTrace();
        }
    }
}
