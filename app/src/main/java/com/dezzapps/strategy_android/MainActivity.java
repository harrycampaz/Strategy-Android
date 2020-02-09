package com.dezzapps.strategy_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dezzapps.strategy_android.models.Card;
import com.dezzapps.strategy_android.models.Cash;
import com.dezzapps.strategy_android.models.Coupon;
import com.dezzapps.strategy_android.models.Payment;
import com.dezzapps.strategy_android.models.SinglePrice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public SinglePrice singlePrice = SinglePrice.getInstance();
    private Button card_button;
    private Button cash_button;
    private Button coupon_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePrice.setPrice(2.5f);

        cash_button = findViewById(R.id.cash_payment);
        coupon_button = findViewById(R.id.coupon_payment);
        card_button = findViewById(R.id.card_payment);

        card_button.setOnClickListener(this);
        cash_button.setOnClickListener(this);
        coupon_button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Payment p;

        switch (view.getId()){

            case R.id.card_payment:
                p = new Payment(new Card());
                break;

            case R.id.coupon_payment:
                p = new Payment(new Coupon());
                break;
            case R.id.cash_payment:

                default:
                    p = new Payment(new Cash());
                   break;
        }

        String finalPrice = new StringBuilder()
                .append("Precio final: ")
                .append(p.employStrategy(singlePrice.getPrice()))
                .append(" $")
                .toString();

        Toast.makeText(this, finalPrice, Toast.LENGTH_LONG).show();

    }
}
