package ru.netology.lists;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {
    final String NAME_TITTLE = "tittle";
    final String NAME_SUBTITTLE = "subtittle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);
        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);
        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        String[] from = {NAME_TITTLE, NAME_SUBTITTLE};
        int[] to = {R.id.id_tittle, R.id.id_subtitle};
        return new SimpleAdapter(this, values, R.layout.activity_list_item, from, to);
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> m;

        for (String s : arrayContent) {
            m = new HashMap<>();
            m.put(NAME_TITTLE, s);
            m.put(NAME_SUBTITTLE, s.length() + "");
            data.add(m);
        }
        return data;
    }
}
