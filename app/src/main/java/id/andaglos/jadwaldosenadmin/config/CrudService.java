package id.andaglos.jadwaldosenadmin.config;

import java.util.concurrent.TimeUnit;

import id.andaglos.jadwaldosenadmin.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mac on 24/08/17.
 */

public class CrudService {

    private RegisterApi registerApi;

    public CrudService () {

        OkHttpClient.Builder okhttpBuilder = new OkHttpClient().newBuilder();
        okhttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.readTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.retryOnConnectionFailure(true);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okhttpBuilder.addInterceptor(interceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(okhttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        registerApi = retrofit.create(RegisterApi.class);

    }

    public void login(String username, String password, Callback callback){
        registerApi.login(username,password).enqueue(callback);
    }
    public void tambahRuangan(String kode_ruangan, String nama_ruangan,String gedung,String latitude,String longitude,String batas_jarak, Callback callback){
        registerApi.tambahRuangan(kode_ruangan,nama_ruangan,gedung,latitude,longitude,batas_jarak).enqueue(callback);
    }
    public void listRuangan(Callback callback){
        registerApi.list_ruangan().enqueue(callback);
    }

}
