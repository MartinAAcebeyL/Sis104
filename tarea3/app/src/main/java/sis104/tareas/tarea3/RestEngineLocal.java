package sis104.tareas.tarea3;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestEngineLocal {
    private static Retrofit retrofit = null;

    public static Retrofit getRestEngine(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.13/sis104/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return  retrofit;
    }
}
