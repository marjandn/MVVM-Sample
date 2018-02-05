package dnejad.marjan.mvvmsample.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.stfalcon.androidmvvmhelper.mvvm.activities.BindingActivity;

import dnejad.marjan.mvvmsample.BR;
import dnejad.marjan.mvvmsample.MainActivity;
import dnejad.marjan.mvvmsample.R;
import dnejad.marjan.mvvmsample.databinding.ActivityLoginBinding;


/**
 * Created by Marjan.Dnejad
 * on 23/11/2017.
 */

public class LoginActivity extends BindingActivity<ActivityLoginBinding, LoginActivityVM>
        implements LoginInteractor{

    @Override
    public LoginActivityVM onCreate() {
        return new LoginActivityVM(this,this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void setShowProgress() {
        getBinding().progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setHideProgress() {
        getBinding().progressBar.setVisibility(View.GONE);
    }

    @Override
    public void GoHome() {
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void setServerError() {
        Toast.makeText(LoginActivity.this,getResources().getString(R.string.server_error),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void setFailedLogin() {
        getBinding().emailEdt.setError(getResources().getString(R.string.login_failed));
    }

    @Override
    public void setEmailError() {
        getBinding().emailEdt.setError(getResources().getString(R.string.email_error));
    }

    @Override
    public void setPasswordError() {
        getBinding().passEdt.setError(getResources().getString(R.string.pass_error));
    }
}