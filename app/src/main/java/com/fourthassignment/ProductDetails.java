package com.fourthassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductDetails extends AppCompatActivity {
    CircleImageView itmImg;
    TextView tvItemName, tvItemPrice,tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        itmImg = findViewById(R.id.imgItem);
        tvItemName = findViewById(R.id.tvItemName);
        tvItemPrice = findViewById(R.id.tvItemPrice);
        tvDescription = findViewById(R.id.tvDescription);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            itmImg.setImageResource(bundle.getInt("id"));
            tvItemName.setText(bundle.getString("name"));
            tvItemPrice.setText(bundle.getString("price"));
            tvDescription.setText(bundle.getString("description"));


        }
    }
}
