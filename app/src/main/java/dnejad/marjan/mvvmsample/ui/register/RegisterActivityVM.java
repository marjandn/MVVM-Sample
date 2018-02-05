package dnejad.marjan.mvvmsample.ui.register;

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

public class RegisterActivityVM extends ActivityViewModel<RegisterActivity> {

    RegisterInteractor interactor;

    ServiceGenerator serviceGenerator;

    public RegisterActivityVM(RegisterActivity activity,RegisterInteractor interactor) {
        super(activity);
        this.interactor=interactor;
        serviceGenerator=new ServiceGenerator();
    }

    public void register(){
        String email=getActivity().getBinding().emailEdt.getText()
                .toString().trim();
        String password=getActivity().getBinding().passEdt.getText()
                .toString().trim();
        String confirmPass=getActivity().getBinding().confirmPassEdt
                .getText().toString().trim();

        if (isValidEmail(email) && isValidPassword(password) && isValidConfirmPassword(confirmPass,password)){

            interactor.setShowProgress();

            Call<String> call=serviceGenerator.getService().register("1",email,password);
                  call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result=response.body();

                            interactor.setHideProgress();

                            /*
                            * all kind of response that come from server
                            */
                            if (result.equals("exist"))
                                interactor.setDuplicateError();
                            else if (result.equals("inserted"))
                                interactor.GoLogin();
                            else if (result.equals("failed"))
                                interactor.setRegisterFailed();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            interactor.setHideProgress();

                            interactor.setServerError();
                        }
                    });



        }else if (!isValidConfirmPassword(confirmPass,password))
            interactor.setConfirmPassError();
        else if (!isValidEmail(email))
            interactor.setEmailError();
        else if (!isValidPassword(password))
            interactor.setPasswordError();

    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String pass){
        return !TextUtils.isEmpty(pass) && pass.length() >=4;
    }

    private boolean isValidConfirmPassword(String confirmPass,String password){
        return !TextUtils.isEmpty(confirmPass) && confirmPass.equals(password);
    }
}