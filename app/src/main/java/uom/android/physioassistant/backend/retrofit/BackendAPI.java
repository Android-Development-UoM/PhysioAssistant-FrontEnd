package uom.android.physioassistant.backend.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendAPI {
    private Retrofit retrofit;

    // API IP address | CHANGE THIS TO YOUR IP ADDRESS
    private static String API_IP = "192.168.2.30";

    // API Port | CHANGE THIS TO YOUR PORT
    private static String API_PORT = "8080";

    private static String API_URL = "http://" + API_IP + ":" + API_PORT + "/";

    public BackendAPI() {
        init();
    }

    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BackendAPI.API_URL)   // Specify API url
                .addConverterFactory(GsonConverterFactory.create(new Gson()))   // Specify we will use gson
                .build();
    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }
}
