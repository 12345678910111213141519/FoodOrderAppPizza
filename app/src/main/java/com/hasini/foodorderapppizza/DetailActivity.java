package com.hasini.foodorderapppizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    CardView small;

    TextView pizzaname, pizzaprice, pizzadescription, allprice1;

    ImageView pizzaimage;

    Button Buy, cart;

    String Pizzaname1;
    String PizzaDescription1;
    String Imageurl;
    Double Allprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        cart = findViewById(R.id.cart);

        pizzaname = findViewById(R.id.name);

        pizzadescription = findViewById(R.id.description);
        pizzaprice = findViewById(R.id.price);
        allprice1 = findViewById(R.id.allprice);

        pizzaimage = findViewById(R.id.image);


        Buy = findViewById(R.id.addToCart);

        //getting data from homeActivity
        Intent intent = getIntent();
        final String imgurl = intent.getStringExtra("IMG");
        final Double pizzaprice1 = intent.getDoubleExtra("PRICE", 0.00);
        final String pizzaname1 = intent.getStringExtra("NAME");
        final String pizzadescription1 = intent.getStringExtra("DETAILS");


        //assign homeActivity data to DetailsActivity's variables
        Imageurl = imgurl;
        PizzaDescription1 = pizzadescription1;
        Pizzaname1 = pizzaname1;


        //setting data to xml file
        Glide.with(DetailActivity.this).load(imgurl).into(pizzaimage);
        pizzaname.setText(pizzaname1);
        pizzadescription.setText(pizzadescription1);
        pizzaprice.setText("Rs." + pizzaprice1);
        allprice1.setText("Rs. " + pizzaprice1);

        Allprice = pizzaprice1;

        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Your order is placed Successfully", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                finish();
                startActivity(intent1);

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Item is Added to Cart Successfully", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                finish();
                startActivity(intent1);

            }
        });
    }
}

