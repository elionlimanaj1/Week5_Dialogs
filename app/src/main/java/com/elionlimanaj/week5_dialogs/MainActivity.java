package com.elionlimanaj.week5_dialogs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    Configuration configuration;
    @BindView(R.id.btn_date_ma)
    Button dateBtn;
    @BindView(R.id.txt_Label)
    TextView label;
    @BindView(R.id.activity_main)
    LinearLayout rootLayout;
    int numOfViews = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configuration = getResources().getConfiguration();
        dateBtn.setOnClickListener(new MyLsntr());

        ScrollView scrollView = new ScrollView(this);
        LinearLayout subLayer = new LinearLayout(this);

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            subLayer.setOrientation(LinearLayout.HORIZONTAL);
        else
            subLayer.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < numOfViews; i++) {
            Button btn = new Button(this);
            btn.setText("Btn " + i);
            btn.setWidth(20);
            btn.setHeight(10);
            subLayer.addView(btn);
        }
        scrollView.addView(subLayer);
        rootLayout.addView(scrollView);

    }

    private class MyLsntr implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    label.setText(month + 1 + "/" + dayOfMonth + "/" + year);
                }
            }, 2017, 0, 1);
            datePickerDialog.show();
        }
    }

    public void showAlert(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("The title of the Alert")
                .setMessage("Message body to go in this area....")
                .setPositiveButton("Agreee", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }
}