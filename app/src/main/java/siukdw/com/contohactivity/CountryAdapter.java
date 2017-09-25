package siukdw.com.contohactivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import models.Country;

/**
 * Created by erick on 25/09/2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    List<Country> countryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCountryName;
        private TextView tvPopulation;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvCountryName = (TextView)itemView.findViewById(R.id.tvCountryName);
            tvPopulation = (TextView)itemView.findViewById(R.id.tvPopulation);
        }
    }

    public CountryAdapter(List<Country> countryList){
        this.countryList = countryList;
    }

    @Override
    public CountryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_simplerec,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CountryAdapter.MyViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.tvCountryName.setText(country.getName());
        holder.tvPopulation.setText(String.valueOf(country.getPopulation()));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }


}
