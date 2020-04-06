package com.example.restoranthesap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    Button btn;
    ListView listView;
    TextView text, textSonuc;
    int b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        btn= findViewById(R.id.button);
        text = findViewById(R.id.adet);
        textSonuc=findViewById(R.id.textView);
        spin=findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        text.setText("2");
                        arrayList.add("Cay");
                        break;
                    case 1:
                        text.setText("5");
                        arrayList.add("Turk Kahvesi");
                        break;
                    case 2:
                        text.setText("7");
                        arrayList.add("Nescafe");
                        break;
                    case 3:
                        text.setText("5");
                        arrayList.add("Kola");
                        break;
                    case 4:
                        text.setText("5");
                        arrayList.add("Sprite");
                        break;
                }}

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                a=Integer.parseInt(text.getText().toString());
                b+=a;
                textSonuc.setText("Toplam : "+b);
                listView.setAdapter(arrayAdapter);

            }
        });
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Hesabiniz: "+b+"TL",Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
