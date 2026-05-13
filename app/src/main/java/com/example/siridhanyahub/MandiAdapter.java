package com.example.siridhanyahub;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MandiAdapter extends
        RecyclerView.Adapter<MandiAdapter.MandiViewHolder> {

    private List<MilletPrice> priceList;

    public MandiAdapter(List<MilletPrice> priceList) {
        this.priceList = priceList;
    }

    @NonNull @Override
    public MandiViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_millet_price, parent, false);
        return new MandiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MandiViewHolder holder,
                                 int position) {
        MilletPrice item = priceList.get(position);

        holder.tvName.setText(item.getMilLetName());
        holder.tvCity.setText(item.getCity());
        holder.tvPrice.setText("₹" + item.getCurrentPrice() + " / kg");
        holder.tvHighLow.setText(
                "7-Day High: ₹" + item.getWeekHigh() +
                        "  |  Low: ₹" + item.getWeekLow());

        // Show ▲ or ▼ with color
        if (item.getTrend().equals("UP")) {
            holder.tvTrend.setText("▲");
            holder.tvTrend.setTextColor(Color.parseColor("#388E3C"));
        } else {
            holder.tvTrend.setText("▼");
            holder.tvTrend.setTextColor(Color.parseColor("#D32F2F"));
        }
    }

    @Override
    public int getItemCount() { return priceList.size(); }

    // ViewHolder — holds references to each view in the row
    static class MandiViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCity, tvPrice, tvHighLow, tvTrend;

        public MandiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName     = itemView.findViewById(R.id.tv_millet_name);
            tvCity     = itemView.findViewById(R.id.tv_city);
            tvPrice    = itemView.findViewById(R.id.tv_price);
            tvHighLow  = itemView.findViewById(R.id.tv_high_low);
            tvTrend    = itemView.findViewById(R.id.tv_trend);
        }
    }
}
