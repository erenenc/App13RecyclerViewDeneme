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
    //aynı anda adapter olan yer burası, bu adapter sınıf ana sınıfa extend edilmelidir.
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
                Toast.makeText(mContext, "Seçtiğiniz Ülke : " + ulke, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ulkelerDisaridanGelenList.size();
    }


}

/*
1. BasitRVAdapter class'ını oluştur.
2. bir context oluştur ve veri kümesi oluştur. (mContext, ulkelerDisaridanGelenList)
3. bu sınıfın (BasitRVAdapter) dolu constructor'ını tanımla
4. Card tasarımının içerisindeki görsel nesneleri temsilen yeni bir sınıf oluştur (CardViewTasarimNesneleriniTutucu)
5. bu sınıfı (CardViewTasarimNesneleriniTutucu) ana sınıfa (BasitRVAdapter) extend et
6. extend edince 3 ayrı method implement edilmesi mecburidir.
6.1. onCreateViewHolder methodu ile cart_tasarim xml'ini inflate edeceqiz,
     return ederken CardViewTasarimNesneleriniTutucu sınıfının cunstocter'ını çağıracağız.
6.2. onBindViewHolder methodu veri kümesinden veriyi alıp cart view'a atayacak,
     varsa kartview'ın tıklanma özelliği burada çalıştırılacak.
6.3. getItemCount methodu, kaç adet veri olduğunu bulacak, kaç tane kartview oluşturulacak
     getItemCount methodu onBindViewHolder methodunu o sayı kadar çalıştıracak


*/
