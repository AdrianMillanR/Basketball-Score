package com.adrian.basketballscore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Integer> localScore= new MutableLiveData<>();
    private final MutableLiveData<Integer> visitantScore= new MutableLiveData<>();

    public MainViewModel(){
        resetScore();
    }

    public LiveData<Integer> getLocalScore(){
        return localScore;
    }
    public  LiveData<Integer> getVisitantScore(){
        return  visitantScore;
    }

    public void resetScore(){
        localScore.setValue(0);
        visitantScore.setValue(0);
    }

    public void plusScore(int numberPoints, MainActivity.TypeScore typescore){
        switch (typescore){
            case VISITANT:
                visitantScore.setValue(visitantScore.getValue()+numberPoints);
                break;
            case LOCAL:
                localScore.setValue(localScore.getValue()+numberPoints);
                break;
        }
    }

    public void minusScore(int numberPoints, MainActivity.TypeScore typescore){
        switch (typescore){
            case VISITANT:
                if(visitantScore.getValue()>0){
                    visitantScore.setValue(visitantScore.getValue()-numberPoints);
                }
                break;
            case LOCAL:
                if(localScore.getValue()>0){
                    localScore.setValue(localScore.getValue()-numberPoints);
                }
                break;

        }
    }
}
