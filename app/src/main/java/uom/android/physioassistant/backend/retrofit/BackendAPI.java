package uom.android.physioassistant.backend.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendAPI {
    private Retrofit retrofit;
    private static String API_URL = "http://192.168.71.125:8080";

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
