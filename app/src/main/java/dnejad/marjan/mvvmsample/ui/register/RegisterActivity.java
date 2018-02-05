package dnejad.marjan.mvvmsample.ui.register;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.stfalcon.androidmvvmhelper.mvvm.activities.BindingActivity;

import dnejad.marjan.mvvmsample.BR;
import dnejad.marjan.mvvmsample.R;
import dnejad.marjan.mvvmsample.databinding.ActivityRegisterBinding;
import dnejad.marjan.mvvmsample.ui.login.LoginActivity;


/**
 * Created by Marjan.Dnejad
 * on 23/11/2017.
 */

public class RegisterActivity extends BindingActivity<ActivityRegisterBinding, RegisterActivityVM>
 implements RegisterInteractor{

    @Override
    public RegisterActivityVM onCreate() {
        return new RegisterActivityVM(this,this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void setShowProgress() {
        getBinding().progressBar2.setVisibility(View.VISIBLE);
    }

    @Override
    public void setHideProgress() {
        getBinding().progressBar2.setVisibility(View.GONE);
    }

    @Override
    public void setEmailError() {
        getBinding().emailEdt.setError(getResources().getString(R.string.email_error));
    }

    @Override
    public void setPasswordError() {
        getBinding().passEdt.setError(getResources().getString(R.string.pass_error));
    }

    @Override
    public void GoLogin() {
        Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void setServerError() {
        Toast.makeText(RegisterActivity.this,getResources().getString(R.string.server_error)
        ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setRegisterFailed() {
        Toast.makeText(RegisterActivity.this,getResources().getString(R.string.register_failed)
                ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setDuplicateError() {
        Toast.makeText(RegisterActivity.this,getResources().getString(R.string.duplicate_error)
                ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setConfirmPassError() {
        getBinding().confirmPassEdt.setError(getResources().getString(R.string.confirm_error));
    }
}