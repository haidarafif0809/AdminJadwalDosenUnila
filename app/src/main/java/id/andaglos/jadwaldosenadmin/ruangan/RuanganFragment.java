package id.andaglos.jadwaldosenadmin.ruangan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.andaglos.jadwaldosenadmin.R;
import id.andaglos.jadwaldosenadmin.config.CrudService;
import id.andaglos.jadwaldosenadmin.config.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RuanganFragment extends Fragment {
    private ProgressDialog progress;
    EditText edtKodeRuangan,edtNamaRuangan,edtGedung,edtLatitude,edtLongitude,edtBatasJarak;
    Button btnTambahRuangan;
    public RuanganFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_ruangan, container, false);
        edtKodeRuangan = (EditText) view.findViewById(R.id.edtKodeRuangan);
        edtNamaRuangan = (EditText) view.findViewById(R.id.edtNamaRuangan);
        edtGedung = (EditText) view.findViewById(R.id.edtGedung);
        edtLatitude = (EditText) view.findViewById(R.id.edtLatitudeRuangan);
        edtLongitude = (EditText) view.findViewById(R.id.edtLongitudeRuangan);
        edtBatasJarak = (EditText) view.findViewById(R.id.edtBatasjarakAbsen);

        Button button = (Button) view.findViewById(R.id.btnTambahRuangan);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                prosesTambahRuangan();
            }
        });

        Button btnLihatRuangan = (Button) view.findViewById(R.id.btnLihatRuangan);
        btnLihatRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ListRuangan.class));
            }
        });

        return view;
    }

   public void prosesTambahRuangan(){

       String kode_ruangan = edtKodeRuangan.getText().toString();
       String nama_ruangan = edtKodeRuangan.getText().toString();
       String gedung = edtGedung.getText().toString();
       String latitude = edtLatitude.getText().toString();
       String longitude = edtLongitude.getText().toString();
       String batas_jarak = edtBatasJarak.getText().toString();

       //membuat progress dialog
       progress = new ProgressDialog(getActivity());
       progress.setCancelable(false);
       progress.setMessage("Loading ...");
       progress.show();


       CrudService crud = new CrudService();
       crud.tambahRuangan(kode_ruangan, nama_ruangan, gedung, latitude, longitude, batas_jarak, new Callback<Value>() {
           @Override
           public void onResponse(Call<Value> call, Response<Value> response) {
               String value = response.body().getValue();
               String message = response.body().getMessage();
               progress.dismiss();
               if (value.equals("1")) {
                   Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                   kosongingEditText();

               } else if(value.equals("2")) {
                   edtKodeRuangan.setError("Kode Ruangan Sudah Ada !");
                   edtKodeRuangan.requestFocus();

               }
           }

           @Override
           public void onFailure(Call call, Throwable t) {
               Toast.makeText(getActivity(), "Terjadi Kesalahan!", Toast.LENGTH_SHORT).show();

               t.printStackTrace();
               progress.dismiss();
           }
       });

    }



    private  void kosongingEditText(){
        edtKodeRuangan.setText("");
        edtNamaRuangan.setText("");
        edtGedung.setText("");
        edtLatitude.setText("");
        edtLongitude.setText("");
        edtBatasJarak.setText("");
    }








}
