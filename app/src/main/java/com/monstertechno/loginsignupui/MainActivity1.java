package com.monstertechno.loginsignupui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.monstertechno.loginsignupui.Adapter.ProductAdapter;
import com.monstertechno.loginsignupui.Model.ProductModel;
import com.monstertechno.loginsignupui.View.CartActivity;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity implements ProductAdapter.CallBackUs, ProductAdapter.HomeCallBack {

    public static ArrayList<ProductModel> arrayList = new ArrayList<>();
    public static int cart_count = 0;
    ProductAdapter productAdapter;
    RecyclerView productRecyclerView;

    private Button userProfile,cart;
    private TextView aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        addProduct();
        productAdapter = new ProductAdapter(arrayList, this, this);
        productRecyclerView = findViewById(R.id.product_recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapter);

        userProfile = findViewById(R.id.btn_up);
        aboutUs = findViewById(R.id.btn_ab);
        cart = findViewById(R.id.btn_ct);


        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity1.this,UserProfile.class));
            }
        });



        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity1.this,aboutus.class));
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity1.this,CartActivity.class));
            }
        });

    }


    private void addProduct() {
        ProductModel productModel = new ProductModel("Battery", "200", "20", R.drawable.img_battery);
        arrayList.add(productModel);
        ProductModel productModel1 = new ProductModel("Battery charger", "600", "10", R.drawable.img_battery_charger);
        arrayList.add(productModel1);
        ProductModel productModel2 = new ProductModel("Capacitor", "50", "10", R.drawable.img_capacitor);
        arrayList.add(productModel2);

        ProductModel productModel3 = new ProductModel("Resistor", "10", "20", R.drawable.img_resistor);
        arrayList.add(productModel3);
        ProductModel productModel12 = new ProductModel("Bread board", "1500", "10", R.drawable.img_bread_board);
        arrayList.add(productModel12);
        ProductModel productModel23 = new ProductModel("Raspberry", "4000", "10", R.drawable.raspberry);
        arrayList.add(productModel23);

        ProductModel productModel4 = new ProductModel("Solar panel", "1000", "20", R.drawable.img_solar);
        arrayList.add(productModel4);
        ProductModel productModel14 = new ProductModel("Electronics book", "750", "10", R.drawable.img_book);
        arrayList.add(productModel14);
        ProductModel productModel25 = new ProductModel("LED", "90", "100", R.drawable.img_led);
        arrayList.add(productModel25);

        ProductModel productModel5 = new ProductModel("DC Motor", "400", "20", R.drawable.img_dc_motor);
        arrayList.add(productModel5);
        ProductModel productModel16 = new ProductModel("Arduino", "800", "10", R.drawable.arduino);
        arrayList.add(productModel16);

    }

    @Override
    public void addCartItemView() {
        //addItemToCartMethod();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem1 = menu.findItem(R.id.user_profile);
        menuItem1.setIcon(com.monstertechno.loginsignupui.Converter.convertUP(MainActivity1.this,R.drawable.user_profile));
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(com.monstertechno.loginsignupui.Converter.convertLayoutToImage(MainActivity1.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, CartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }

    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }
}
