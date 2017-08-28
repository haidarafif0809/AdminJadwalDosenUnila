package id.andaglos.jadwaldosenadmin.ruangan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import id.andaglos.jadwaldosenadmin.R;
import id.andaglos.jadwaldosenadmin.config.Result;
import id.andaglos.jadwaldosenadmin.config.adapter.RecyclerViewAdapter;

public class ListRuangan extends AppCompatActivity {

    private List<Result> results = new ArrayList<>();
    private RecyclerViewAdapter viewAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ruangan);
    }
}
