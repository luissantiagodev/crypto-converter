package com.luis_santiago.cryptoconverter.tools;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luis_santiago.cryptoconverter.ConverterActivity;
import com.luis_santiago.cryptoconverter.Model.Crypto;
import com.luis_santiago.cryptoconverter.R;

import java.util.ArrayList;

/**
 * Created by Luis Fernando Santiago Ruiz on 1/13/18.
 */

public class CryptoCoinAdapter extends RecyclerView.Adapter<CryptoCoinAdapter.ViewHolder>{

    private ArrayList<Crypto> mListOfCriptos = new ArrayList<>();

    public CryptoCoinAdapter(ArrayList <Crypto> anotherListOfCriptos){
        this.mListOfCriptos = anotherListOfCriptos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item_layout ,parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Crypto criptoCurrency = mListOfCriptos.get(position);
        String value = criptoCurrency.getUnit() + " = "+criptoCurrency.getValue();
        holder.imageCrypto.setImageResource(criptoCurrency.getDrawable());
        holder.nameCrypto.setText(criptoCurrency.getName());
        holder.valueOfCrypto.setText(value + " MX");
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext() , ConverterActivity.class);
                intent.putExtra(Keys.KEY_UNIT_COIN , criptoCurrency.getUnit());
                intent.putExtra(Keys.KEY_VALUE_COIN , criptoCurrency.getValue());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListOfCriptos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageCrypto;
        private TextView nameCrypto;
        private TextView valueOfCrypto;
        private CardView container;

        public ViewHolder(View v) {
            super(v);
            imageCrypto = v.findViewById(R.id.image_id);
            nameCrypto = v.findViewById(R.id.name_of_cripto);
            valueOfCrypto = v.findViewById(R.id.value_of_cripto);
            container = v.findViewById(R.id.container);
        }
    }
}