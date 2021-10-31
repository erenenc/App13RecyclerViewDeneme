package com.example.app13recyclerviewdeneme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
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
        public ImageView noktaResim;

        public CardViewTasarimNesneleriniTutucu(View view){
            super(view);
            satirYazi = view.findViewById(R.id.satirYazi);
            satirCardView = view.findViewById(R.id.satirCardView);
            noktaResim = view.findViewById(R.id.noktaResim);
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

        holder.noktaResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Resim : " + ulke, Toast.LENGTH_SHORT).show();

                PopupMenu popup = new PopupMenu(mContext, holder.noktaResim);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.card_menu, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.action_sil:
                                Toast.makeText(mContext, "Sile Tıklandı : "+ulke, Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_duzenle:
                                Toast.makeText(mContext, "Düzenleye Tıklandı : "+ulke, Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;

                        }

                    }
                });
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
