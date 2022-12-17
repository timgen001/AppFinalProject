package com.example.musicplayerexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag1 extends Fragment {
    private View view;

    public String[] name={"Rick Astley-Never Gonna Give You Up","結束バンド-ギターと孤独と蒼い惑星","結束バンド-Distortion!!"};
    public static int[] icons={R.drawable.music0,R.drawable.music1,R.drawable.music2};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.music_list, null);

        ListView listView = view.findViewById(R.id.lv);

        MyBaseAdapter adapter = new MyBaseAdapter();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(frag1.this.getContext(), MusicActivity.class);
                intent.putExtra("name", name[position]);
                intent.putExtra("position", String.valueOf(position));

                startActivity(intent);
            }
        });
        return view;
    }

    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int i) {
            return name[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {

            View view = View.inflate(frag1.this.getContext(), R.layout.item_layout, null);
            TextView tv_name = view.findViewById(R.id.item_name);
            ImageView iv = view.findViewById(R.id.iv);

            tv_name.setText(name[i]);
            iv.setImageResource(icons[i]);

            return view;
        }
    }
}
