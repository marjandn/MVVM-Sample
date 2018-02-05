package dnejad.marjan.mvvmsample.ui.register;

/**
 * Created by Marjan.Dnejad
 * on 23/11/2017.
 *
 *
 *
 * intreactor between registerActivity and registerViewModel
 */

public interface RegisterInteractor {

    void setShowProgress();

    void setHideProgress();

    void setEmailError();

    void setPasswordError();

    void GoLogin();

    void setServerError();

    void setRegisterFailed();

    void setDuplicateError();

    void setConfirmPassError();
}
