package com.example.monkey.tipcalculator_mccracken;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "AJM";

    private EditText entry_et;
    private Button calculate_btn;
    private TextView result_tv;

    // NOTE:  import android.view.View.OnClickListener!!!
    // NOTE:  OnClickListener is an interface
    private View.OnClickListener onClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            Log.i(tag, "onClick: Method Entry");

            if (v.getId() == R.id.calculate_btn) {  // not needed with only one button!

                String s = entry_et.getText().toString();
                if (s.length() == 0) {
                    result_tv.setText(getText(R.string.error_string));
                    return;
                }

                Log.i(tag, "onClick: text = [" + s + "]");

                double entry = Double.parseDouble(s);

                double rate = 0.2;
                String rateString = String.format(getString(R.string.rate_string), rate * 100);

                double tipAmount = entry * rate;
                String tipAmountString = String.format(getString(R.string.amount_string), tipAmount);

                double fullPrice = entry + tipAmount;
                String fullPriceString = String.format(getString(R.string.full_price_string), fullPrice);

                String result = rateString + tipAmountString + fullPriceString;
                result_tv.setText(result);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entry_et      = (EditText) findViewById(R.id.entry_et);
        calculate_btn = (Button) findViewById(R.id.calculate_btn);
        result_tv     = (TextView) findViewById(R.id.result_tv);

        calculate_btn.setOnClickListener(onClickListener);

    }
}
