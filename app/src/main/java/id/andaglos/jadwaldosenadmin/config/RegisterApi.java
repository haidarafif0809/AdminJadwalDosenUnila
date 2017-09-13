package id.andaglos.jadwaldosenadmin.config;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by mac on 24/08/17.
 */

public interface RegisterApi {

    @FormUrlEncoded
    @POST("login_android")
    Call<Value> login(@Field("username") String username,
                       @Field("password") String password);

    @FormUrlEncoded
    @POST("tambah_ruangan")
    Call<Value> tambahRuangan(@Field("kode_ruangan") String kode_ruangan,
                              @Field("nama_ruangan") String nama_ruangan,
                              @Field("gedung") String gedung,
                              @Field("latitude") String latitude,
                              @Field("longitude") String longitude,
                              @Field("batas_jarak") String batas_jarak
    );

    @GET("list_ruangan")
    Call<Value> list_ruangan();

    @FormUrlEncoded
    @POST("update_ruangan")
    Call<Value> updateRuangan(@Field("id") String id,
                              @Field("kode_ruangan") String kode_ruangan,
                             @Field("nama_ruangan") String nama_ruangan,
                             @Field("gedung") String gedung,
                             @Field("latitude") String latitude,
                             @Field("longitude") String longitude,
                             @Field("batas_jarak") String batas_jarak
    );

    @FormUrlEncoded
    @POST("hapus_ruangan")
    Call<Value> hapusRuangan(@Field("id") String id);

    @FormUrlEncoded
    @POST("cari_ruangan")
    Call<Value> cari_ruangan(@Field("search") String search);

}
