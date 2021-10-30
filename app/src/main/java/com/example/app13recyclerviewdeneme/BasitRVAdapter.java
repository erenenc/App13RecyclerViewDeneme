package com.example.app13recyclerviewdeneme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasitRVAdapter extends RecyclerView.Adapter<BasitRVAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    private List<String> ulkelerDisaridanGelenList;

    public BasitRVAdapter(Context mContext, List<String> ulkelerDisaridanGelenList) {
        this.mContext = mContext;
        this.ulkelerDisaridanGelenList = ulkelerDisaridanGelenList;
    }

    //kart tasarımını temsil eden sınıf
    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public TextView satirYazi;
        public CardView satirCardView;

        public CardViewTasarimNesneleriniTutucu(View view){
            super(view);
            satirYazi = view.findViewById(R.id.satirYazi);
            satirCardView = view.findViewById(R.id.satirCardView);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_tasarim,parent,false);

        return new CardViewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) {

        final String ulke = ulkelerDisaridanGelenList.get(position);
        holder.satirYazi.setText(ulke);
        holder.satirCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(mContext, "Seçtiğiniz Ülke : " + ulke, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ulkelerDisaridanGelenList.size();
    }


}
