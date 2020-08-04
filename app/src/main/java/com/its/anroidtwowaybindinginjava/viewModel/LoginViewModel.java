package com.its.anroidtwowaybindinginjava.viewModel;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.its.anroidtwowaybindinginjava.BR;
import com.its.anroidtwowaybindinginjava.model.LoginModel;

public class LoginViewModel extends BaseObservable {

    public String userName;
    public String password;

    LoginModel loginModel;

    private String successMessage = "Login was Successfull";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserName() {
        return loginModel.getEmail();
    }

    @Bindable
    public String getPassword() {
        return loginModel.getPassword();
    }

    public void setUserName(String userName) {
        loginModel.setEmail(userName);
        notifyPropertyChanged(BR.userName);
    }

    public void setPassword(String password) {
        loginModel.setPassword(password);
        notifyPropertyChanged(BR.password);
    }

    public LoginViewModel() {
        loginModel = new LoginModel("", "");
    }

    public void onLoginClick() {
        if (isInputValid()) {
            setToastMessage(successMessage);
        } else {
            setToastMessage(errorMessage);
        }
    }

    public boolean isInputValid() {
        return !TextUtils.isEmpty(getUserName()) &&
                Patterns.EMAIL_ADDRESS.matcher(getUserName()).matches() &&
                getPassword().length() > 5;
    }

}
