package com.example.emili.androidassetsproject.presenter;

/**
 * Created by emili on 08/09/2017.
 */

import com.example.emili.androidassetsproject.model.AndroidImageAssets;
import com.example.emili.androidassetsproject.view.ViewFragmentBodyPart;

import java.util.List;

/**
 * Created by emili on 07/09/2017.
 */

public class PresenterFragmentBodyPart {

    ViewFragmentBodyPart viewFragmentBodyPart;

    List<Integer> part;
    int index;


    public PresenterFragmentBodyPart(ViewFragmentBodyPart viewFragmentBodyPart, int index){

        this.index = index;
        this.viewFragmentBodyPart = viewFragmentBodyPart;

        if(index == 0){
            part = AndroidImageAssets.getHeads();
        }
        else if(index == 1){
            part = AndroidImageAssets.getBodies();
        }
        else {
            part = AndroidImageAssets.getLegs();
        }
    }

    public void updateImageViewBodyPart(){
        viewFragmentBodyPart.updateImageViewBodyPart(part);
    }

}
