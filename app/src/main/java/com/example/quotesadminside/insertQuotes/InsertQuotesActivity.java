package com.example.quotesadminside.insertQuotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quotesadminside.Model.InsertQuotesModel;
import com.example.quotesadminside.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertQuotesActivity extends AppCompatActivity {

    private EditText q_id, q_quotes, q_author, q_desc, q_cat_id;
    private Spinner q_cat;
    private Button q_button;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;
    ArrayAdapter arrayAdapter;
    String string[] = {"Success", "Motivation", "Inspiration", "Life", "Love", "Failure", "Happiness", "Education"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_quotes);

        q_id = findViewById(R.id.insert_quotes_id);
        q_quotes = findViewById(R.id.insert_quotes_quotes);
        q_author = findViewById(R.id.insert_quotes_author);
        q_desc = findViewById(R.id.insert_quotes_desc1);

        q_cat_id = findViewById(R.id.insert_quotes_cat_id);
        q_cat = findViewById(R.id.insert_quotes_cat);

        q_button = findViewById(R.id.insert_quotes_button);
        progressBar = findViewById(R.id.insert_quotes_progressBar);

        arrayAdapter = new ArrayAdapter(InsertQuotesActivity.this, android.R.layout.simple_list_item_1, string);
        q_cat.setAdapter(arrayAdapter);

        q_cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (q_cat.getSelectedItem().equals("Success")) {
                    q_cat_id.setText("1");
                }

                if (q_cat.getSelectedItem().equals("Motivation")) {
                    q_cat_id.setText("2");
                }

                if (q_cat.getSelectedItem().equals("Inspiration")) {
                    q_cat_id.setText("3");
                }

                if (q_cat.getSelectedItem().equals("Life")) {
                    q_cat_id.setText("4");
                }

                if (q_cat.getSelectedItem().equals("Love")) {
                    q_cat_id.setText("5");
                }

                if (q_cat.getSelectedItem().equals("Failure")) {
                    q_cat_id.setText("6");
                }

                if (q_cat.getSelectedItem().equals("Happiness")) {
                    q_cat_id.setText("7");
                } 

                if (q_cat.getSelectedItem().equals("Education")) {
                    q_cat_id.setText("8");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("quotes");

        q_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                q_button.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);

                String Q_ID = q_id.getText().toString().trim();
                String Q_CAT_ID = q_cat_id.getText().toString();
                String Q_CAT = q_cat.getSelectedItem().toString();
                String Q_QUOTES = q_quotes.getText().toString().trim();
                String Q_AUTHOR = q_author.getText().toString();
                String Q_DESC = q_desc.getText().toString().trim();

                String ID = databaseReference.push().getKey();

                InsertQuotesModel insertQuotesModel = new InsertQuotesModel(ID, Q_ID, Q_CAT_ID, Q_CAT, Q_QUOTES, Q_AUTHOR, Q_DESC);

                databaseReference.child(ID).setValue(insertQuotesModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(InsertQuotesActivity.this, "Quotes Added", Toast.LENGTH_SHORT).show();

                            q_button.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);

                            q_id.setText("");
                            q_quotes.setText("");
                            q_author.setText("");
                            q_desc.setText("");

                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(InsertQuotesActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                q_button.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.GONE);
                            }
                        });

            }
        });


    }
}
