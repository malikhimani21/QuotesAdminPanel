package com.example.quotesadminside.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.quotesadminside.Model.InsertQuotesModel;
import com.example.quotesadminside.R;
import com.example.quotesadminside.adapter.FetchQuoteAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SuccessActivity extends AppCompatActivity {

    ListView listView;
    Query databaseReference;
    List<InsertQuotesModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        listView = findViewById(R.id.listviewSuccess);

        databaseReference = FirebaseDatabase.getInstance().getReference("quotes").orderByChild("q_cat").equalTo("Success");
        listView = findViewById(R.id.listviewSuccess);
        list = new ArrayList<>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    InsertQuotesModel insertQuotesModel = snap.getValue(InsertQuotesModel.class);
                    list.add(insertQuotesModel);
                }

                FetchQuoteAdapter fetchQuoteAdapter = new FetchQuoteAdapter(SuccessActivity.this, list);
                listView.setAdapter(fetchQuoteAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
