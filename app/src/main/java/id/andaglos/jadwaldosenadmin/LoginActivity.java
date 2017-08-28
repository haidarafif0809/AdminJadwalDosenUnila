package id.andaglos.jadwaldosenadmin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.andaglos.jadwaldosenadmin.config.CrudService;
import id.andaglos.jadwaldosenadmin.config.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername,edtPassword;
    Button btnLogin;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);


    }



    public void prosesLogin(View view){
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        //membuat progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();


        CrudService crud = new CrudService();
        crud.login(username, password, new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();


                    finish();
                    startActivity(new Intent(LoginActivity.this, UtamaActivity.class));

                } else if(value.equals("2")) {
                    edtUsername.setError("Username Atau Password Salah!");
                    edtUsername.requestFocus();
                    edtPassword.setText("");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Terjadi Kesalahan!", Toast.LENGTH_SHORT).show();

                t.printStackTrace();
                progress.dismiss();
            }
        });

    }
}
