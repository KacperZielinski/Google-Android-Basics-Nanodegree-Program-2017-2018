package com.zielinski.kacper.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(@NonNull Context context, @NonNull List<News> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        News news = getItem(position);

        if (news != null) {
            TextView nameTextView = convertView.findViewById(R.id.title);
            nameTextView.setText(news.getTitle());

            TextView sectionNameTextView = convertView.findViewById(R.id.section_name);
            sectionNameTextView.setText(news.getSectionName());

            TextView dateTextView = convertView.findViewById(R.id.date);
            dateTextView.setText(news.getDate());

            TextView timeTextView = convertView.findViewById(R.id.time);
            timeTextView.setText(news.getTime());

            TextView authorTextView = convertView.findViewById(R.id.author);
            authorTextView.setText(news.getAuthor());
        }

        return convertView;
    }
}
