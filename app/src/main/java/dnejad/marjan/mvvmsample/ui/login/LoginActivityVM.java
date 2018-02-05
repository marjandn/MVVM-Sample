package dnejad.marjan.mvvmsample.ui.login;

import android.text.TextUtils;
import android.util.Patterns;

import com.stfalcon.androidmvvmhelper.mvvm.activities.ActivityViewModel;

import dnejad.marjan.mvvmsample.server.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Marjan.Dnejad
 * on 23/11/2017.
 */

public class LoginActivityVM extends ActivityViewModel<LoginActivity> {

    LoginInteractor interactor;
    ServiceGenerator serviceGenerator;

    public LoginActivityVM(LoginActivity activity,LoginInteractor interactor) {
        super(activity);
        this.interactor=interactor;
        serviceGenerator=new ServiceGenerator();
    }

    public void login(){

        String email=getActivity().getBinding().emailEdt.getText().toString().trim();
        String password=getActivity().getBinding().passEdt.getText().toString().trim();

        if (isValidEmail(email) && isValidPassword( password)) {
            interactor.setShowProgress();

            Call<String> call = serviceGenerator.getService().login("2", email, password);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String result = response.body();
                    interactor.setHideProgress();

                    /*
                    * all kind of response that come from server for login mode
                    */
                    if (result.equals("login"))
                        interactor.GoHome();
                    else if (result.equals("failed"))
                        interactor.setFailedLogin();

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    interactor.setHideProgress();

                    interactor.setServerError();

                }
            });
        }else if (!isValidPassword(password))
            interactor.setPasswordError();
        else if (!isValidEmail(email))
            interactor.setEmailError();


    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String pass){
        return !TextUtils.isEmpty(pass) && pass.length() >=4;
    }
}