package id.andaglos.jadwaldosenadmin.ruangan;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import id.andaglos.jadwaldosenadmin.R;
import id.andaglos.jadwaldosenadmin.config.CrudService;
import id.andaglos.jadwaldosenadmin.config.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateRuangan extends AppCompatActivity {

    private ProgressDialog progress;

    EditText edtKodeRuangan,edtNamaRuangan,edtGedung,edtLatitudeRuangan,edtLongitudeRuangan,edtBatasJarakAbsen;
    Button btnUpdate;

    String id;


    public void prosesUpdateRuangan(){
        //membuat progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        //mengambil data dari edittext
        String kode_ruangan = edtKodeRuangan.getText().toString();
        String nama_ruangan = edtNamaRuangan.getText().toString();
        String gedung = edtGedung.getText().toString();
        String latitude = edtLatitudeRuangan.getText().toString();
        String longitude = edtLongitudeRuangan.getText().toString();
        String batas_jarak_absen = edtBatasJarakAbsen.getText().toString();

        CrudService crud = new CrudService();
        crud.updateRuangan(id, kode_ruangan, nama_ruangan, gedung, latitude, longitude, batas_jarak_absen, new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(UpdateRuangan.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(UpdateRuangan.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
                Toast.makeText(UpdateRuangan.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ruangan);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ubah Data");

        Intent intent = getIntent();
        String kode_ruangan = intent.getStringExtra("kode_ruangan");
        String nama_ruangan = intent.getStringExtra("nama_ruangan");
        String gedung = intent.getStringExtra("lokasi_ruangan");
        String latitude = intent.getStringExtra("latitude");
        String longitude = intent.getStringExtra("longitude");
        String batas_jarak = intent.getStringExtra("batas_jarak_absen");
        id = intent.getStringExtra("id");

        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        edtKodeRuangan = (EditText) findViewById(R.id.edtTextKodeRuangan);
        edtNamaRuangan = (EditText) findViewById(R.id.edtTextNamaRuangan);
        edtGedung = (EditText) findViewById(R.id.edtTextGedung);
        edtLatitudeRuangan = (EditText) findViewById(R.id.edtTextLatitudeRuangan);
        edtLongitudeRuangan = (EditText) findViewById(R.id.edtTextLongitudeRuangan);
        edtBatasJarakAbsen = (EditText) findViewById(R.id.edtTextBatasjarakAbsen);

        edtKodeRuangan.setText(kode_ruangan);
        edtNamaRuangan.setText(nama_ruangan);
        edtGedung.setText(gedung);
        edtLatitudeRuangan.setText(latitude);
        edtLongitudeRuangan.setText(longitude);
        edtBatasJarakAbsen.setText(batas_jarak);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prosesUpdateRuangan();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            case R.id.action_delete:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Peringatan");
                alertDialogBuilder
                        .setMessage("Apakah Anda yakin ingin mengapus data ini?")
                        .setCancelable(false)
                        .setPositiveButton("Hapus",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id_ruangan) {


                                CrudService crud = new CrudService();
                                crud.hapusRuangan(id, new Callback<Value>() {

                                    @Override
                                    public void onResponse(Call<Value> call, Response<Value> response) {
                                        String value = response.body().getValue();
                                        String message = response.body().getMessage();
                                        if (value.equals("1")) {
                                            Toast.makeText(UpdateRuangan.this, message, Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            Toast.makeText(UpdateRuangan.this, message, Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call call, Throwable t) {
                                        t.printStackTrace();
                                        Toast.makeText(UpdateRuangan.this, "Terjadi Kesalahan!", Toast.LENGTH_SHORT).show();
                                    }
                                });


                            }
                        })
                        .setNegativeButton("Batal",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delete, menu);
        return true;
    }

}
