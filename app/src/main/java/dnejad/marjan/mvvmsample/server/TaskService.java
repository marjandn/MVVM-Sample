package dnejad.marjan.mvvmsample.server;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Marjan.Dnejad
 * on 23/11/2017.
 */

public interface TaskService {

    /*
    * @params work : is for define action that should happen in php file in this case it's "1" that mean register
    * @params email : the email that should be register and store in database
    * @params password : the password that should store in database
    */
    @FormUrlEncoded
    @POST("login-signup.php")
    Call<String> register(@Field("work") String work,@Field("email") String email, @Field("password") String password);

    /*
    * @params work : is for define action that should happen in php file in this case it's "2" that mean login
    * @params email : the email that should be check with database user table for user login
    * @params password : the password that should be check with database user table
    */
    @FormUrlEncoded
    @POST("login-signup.php")
    Call<String> login(@Field("work") String work,@Field("email") String email,@Field("password") String password);
}
