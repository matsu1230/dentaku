package com.example.dentaku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recentOperator = R.id.button_equal;
            result = 0;
            isOperatorKeyPushed = false;

            textView.setText("");
            editText.setText("");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        textView.setText(String.valueOf(42));

        editText = findViewById(R.id.edittext);
        textView.setText("ここにもじ");

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(buttonListener);

        findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_4).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_5).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_6).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_7).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_8).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_9).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_0).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_dot).setOnClickListener(buttonNumberListener);


        findViewById(R.id.button_add).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_equal).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_divide).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_multiply).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_subtract).setOnClickListener(buttonOperatorListener);

    }

    int recentOperator = R.id.button_equal;
    double result;
    boolean isOperatorKeyPushed;    // 計算キーが押されたことを記憶
    CharSequence number1;
    CharSequence number2;

    View.OnClickListener buttonOperatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button operatorButton = (Button) view;
            if (editText.getText().toString().isEmpty() == false) {
                double value = Double.parseDouble(editText.getText().toString());
                editText.setText("");
                if (recentOperator == R.id.button_equal) {
                    result = value;
                } else {
                    result = calc(recentOperator, result, value);
                    editText.setText(String.valueOf(result));
                }
                recentOperator = operatorButton.getId();
                textView.setText(operatorButton.getText());
                isOperatorKeyPushed = true;
            }
        }
    };

    View.OnClickListener buttonNumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            editText.append(button.getText());
        }

    };

    double calc(int operator, double value1, double value2) {
        switch (operator) {
            case R.id.button_add:
                return value1 + value2;
            case R.id.button_subtract:
                return value1 - value2;
            case R.id.button_multiply:
                return value1 * value2;
            case R.id.button_divide:
                if (value2 != 0) {
                    return value1 / value2;
                } else {
                    return 0;
                }
            default:
                return value1;
        }
    }
}
