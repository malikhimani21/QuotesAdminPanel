package com.example.quotesadminside.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quotesadminside.Model.InsertQuotesModel;
import com.example.quotesadminside.R;

import java.util.List;

public class FetchQuoteAdapter extends ArrayAdapter<InsertQuotesModel> {
    Activity activity;
    List<InsertQuotesModel> list;

    public FetchQuoteAdapter(Activity activity, List<InsertQuotesModel> list) {
        super(activity, R.layout.layout_success, list);
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.layout_success, null, true);

        TextView desc = (TextView) convertView.findViewById(R.id.fetch_success_quote);

        InsertQuotesModel insertQuotesModel = list.get(position);

        desc.setText(insertQuotesModel.getQ_desc());

        return convertView;
    }
}
