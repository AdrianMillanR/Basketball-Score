package com.adrian.basketballscore;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public Integer localScore=0;
    public Integer visitantScore=0;

    public void resetScore(){
        localScore=0;
        visitantScore=0;
    }

    public void plusScore(int numberPoints, MainActivity.TypeScore typescore){
        switch (typescore){
            case VISITANT:
                visitantScore+=numberPoints;
                break;
            case LOCAL:
                localScore+=numberPoints;
                break;
        }
    }

    public void minusScore(int numberPoints, MainActivity.TypeScore typescore){
        switch (typescore){
            case VISITANT:
                if(visitantScore>0){
                    visitantScore-=numberPoints;
                }
                break;
            case LOCAL:
                if(localScore>0){
                    localScore-=numberPoints;
                }
                break;

        }
    }
}
