package com.hndsolution.battery.ui.recommendation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecomViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RecomViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is \n recommendation fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}