package id.andaglos.jadwaldosenadmin.config.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import id.andaglos.jadwaldosenadmin.R;
import id.andaglos.jadwaldosenadmin.config.Result;
import id.andaglos.jadwaldosenadmin.ruangan.UpdateRuangan;

/**
 * Created by mac on 24/08/17.
 */



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Result> results;



    public RecyclerViewAdapter(Context context, List<Result> results) {

        this.context = context;
        this.results = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ruangan, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Result result = results.get(position);
        holder.txtKodeRuangan.setText(result.getKodeRuangan());
        holder.txtNamaRuangan.setText(result.getNamaRuangan());
        holder.txtGedung.setText(result.getGedung());
        holder.txtLatitude.setText(result.getLatitude());
        holder.txtLongitude.setText(result.getLongitude());
        holder.txtBatasJarak.setText(result.getBatasJarak());
        holder.txtIdRuangan.setText(result.getId());



    }

    @Override
    public int getItemCount() {

        return results.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtKodeRuangan,txtNamaRuangan, txtGedung, txtLatitude,txtLongitude, txtBatasJarak, txtIdRuangan;

        public ViewHolder(View itemView) {
            super(itemView);

            txtKodeRuangan = itemView.findViewById(R.id.textKodeRuangan);
            txtNamaRuangan = itemView.findViewById(R.id.textNamaRuangan);
            txtGedung = itemView.findViewById(R.id.textGedung);
            txtLatitude = itemView.findViewById(R.id.textLatitude);
            txtLongitude = itemView.findViewById(R.id.textLongitude);
            txtBatasJarak = itemView.findViewById(R.id.textBatasJarak);
            txtIdRuangan = itemView.findViewById(R.id.textIdRuangan);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            String kode_ruangan = txtKodeRuangan.getText().toString();
            String nama_ruangan = txtNamaRuangan.getText().toString();
            String gedung = txtGedung.getText().toString();
            String latitude = txtLatitude.getText().toString();
            String longitude = txtLongitude.getText().toString();
            String batas_jarak = txtBatasJarak.getText().toString();
            String id = txtIdRuangan.getText().toString();



            Intent i = new Intent(context, UpdateRuangan.class);
            i.putExtra("kode_ruangan", kode_ruangan);
            i.putExtra("nama_ruangan", nama_ruangan);
            i.putExtra("lokasi_ruangan", gedung);
            i.putExtra("latitude", latitude);
            i.putExtra("longitude", longitude);
            i.putExtra("batas_jarak_absen", batas_jarak);
            i.putExtra("id", id);
            context.startActivity(i);
        }
    }
}
