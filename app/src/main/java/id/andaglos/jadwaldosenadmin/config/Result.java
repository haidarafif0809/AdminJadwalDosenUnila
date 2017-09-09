package id.andaglos.jadwaldosenadmin.config;

/**
 * Created by mac on 24/08/17.
 */

public class Result {

    String username;
    String password;
    String kode_ruangan;
    String nama_ruangan;
    String lokasi_ruangan;
    String latitude;
    String longitude;
    String batas_jarak_absen;
    String id;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String getKodeRuangan() {
        return kode_ruangan;
    }
    public String getNamaRuangan(){
        return nama_ruangan;
    }
    public String getGedung(){
        return lokasi_ruangan;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude(){
        return longitude;
    }
    public String getBatasJarak(){
        return batas_jarak_absen;
    }
    public String getId(){
        return id;
    }
}
