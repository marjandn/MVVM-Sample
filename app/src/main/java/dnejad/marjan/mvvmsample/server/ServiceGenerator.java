package dnejad.marjan.mvvmsample.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marjan.Dnejad
 * on 23/11/2017.
 *
 *
 * static service request base
 * for more info please check
 * https://futurestud.io/tutorials/retrofit-2-creating-a-sustainable-android-client
 */

public class ServiceGenerator {

    private static final String BASE_URL="http://10.0.3.2:8080";

    TaskService taskService;

    public ServiceGenerator(){
        OkHttpClient okHttpClient=new OkHttpClient();

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        retrofit2.Retrofit retrofit=new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        taskService=retrofit.create(TaskService.class);
    }
    public TaskService getService(){
        return taskService;
    }
}
