package dnejad.marjan.mvvmsample.ui.login;

/**
 * Created by Marjan.Dnejad
 * on 23/11/2017.
 *
 *
 *
 * interactor between loginActivity and loginViewModel
 */

public interface LoginInteractor {

    void setShowProgress();

    void setHideProgress();

    void GoHome();

    void setServerError();

    void setFailedLogin();

    void setEmailError();

    void setPasswordError();
}
