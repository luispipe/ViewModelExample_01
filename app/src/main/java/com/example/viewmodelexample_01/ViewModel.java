package com.example.viewmodelexample_01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<Integer> result;

    public ViewModel(){
        result= new MutableLiveData<>();
    }

    public LiveData<Integer> getResult(){
        return result;
    }

    public void increment(int data){
        result.setValue(Model.add(data));
    }

}
