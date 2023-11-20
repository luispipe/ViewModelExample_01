package com.example.viewmodelexample_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button increment;
    TextView count;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        increment=findViewById(R.id.button);
        count=findViewById(R.id.textViewCount);

        ViewModel vm= new ViewModelProvider(this).get(ViewModel.class);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  vm.increment(Integer.parseInt(count.getText().toString()));
            }
        });

        Observer<Integer> obj_observer= new Observer<Integer>() {
            @Override
            public void onChanged(Integer result) {
                count.setText(result+"");
            }
        };

        vm.getResult().observe(this,obj_observer);

    }
}