package com.example.shubhammundra.pie_bar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MultiValueSelect extends AppCompatActivity {

    Button StoresSelect;
    TextView dispalyStores;

    String[] listItems;
    boolean[] checkedItems;

    ArrayList<Integer> UserItems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_select);

        StoresSelect = findViewById(R.id.btn_selectStores);
        dispalyStores = findViewById(R.id.tv_displaystores);

        listItems = getResources().getStringArray(R.array.StoreNo);
        checkedItems = new boolean[listItems.length];

        StoresSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MultiValueSelect.this);
                builder.setTitle("Select Stores");

                builder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {

                            if(isChecked)
                            {
                                if (! UserItems.contains(position)){
                                    UserItems.add(position);
                                }
                            }
                            else
                            if (UserItems.contains(position))
                            {
                                UserItems.remove(UserItems.indexOf(position));
                            }

                    }
                });

                builder.setCancelable(false);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String Store = "";
                        for(int i = 0 ; i < UserItems.size() ; i++)
                        {
                            Store = Store + listItems[UserItems.get(i)];
                            if(i != UserItems.size() -1)
                            {
                                Store = Store + ",";
                            }
                        }
                        dispalyStores.setText(Store);
                        StoresSelect.setText(Store);
                    }
                });

                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for(int i = 0 ; i < checkedItems.length ; i++)
                        {
                            checkedItems[i] = false;
                            UserItems.clear();
                            dispalyStores.setText("");
                            StoresSelect.setText("Select Stores");
                        }
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
