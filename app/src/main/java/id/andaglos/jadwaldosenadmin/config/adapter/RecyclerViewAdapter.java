package id.andaglos.jadwaldosenadmin.config.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.andaglos.jadwaldosenadmin.R;
import id.andaglos.jadwaldosenadmin.config.Result;

/**
 * Created by mac on 24/08/17.
 */

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


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
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        Result result = results.get(position);
        holder.textKodeRuangan.setText(result.getKodeRuangan());
        holder.textNamaRuangan.setText(result.getNamaRuangan());
        holder.textGedung.setText(result.getGedung());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.textKodeRuangan)
        TextView textKodeRuangan;
        @BindView(R.id.textNamaRuangan) TextView textNamaRuangan;
        @BindView(R.id.textGedung) TextView textGedung;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//
//            String npm = textViewNPM.getText().toString();
//            String nama = textViewNama.getText().toString();
//            String kelas = textViewKelas.getText().toString();
//            String sesi = textViewSesi.getText().toString();
//
//            Intent i = new Intent(context, UpdateActivity.class);
//            i.putExtra("npm", npm);
//            i.putExtra("nama", nama);
//            i.putExtra("kelas", kelas);
//            i.putExtra("sesi", sesi);
//            context.startActivity(i);

        }
    }
}
