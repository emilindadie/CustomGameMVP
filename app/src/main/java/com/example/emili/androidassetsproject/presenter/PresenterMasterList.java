package com.example.emili.androidassetsproject.presenter;

/**
 * Created by emili on 08/09/2017.
 */


import com.example.emili.androidassetsproject.model.AndroidImageAssets;
import com.example.emili.androidassetsproject.view.ViewFragmentMasterList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emili on 08/09/2017.
 */

public class PresenterMasterList {

    List<Integer> all;
    ViewFragmentMasterList viewFragmentMasterList;

    public PresenterMasterList(ViewFragmentMasterList viewFragmentMasterList){
        this.viewFragmentMasterList = viewFragmentMasterList;
        all = AndroidImageAssets.getAll();
    }
    public void updateMasterList(){
        viewFragmentMasterList.updateMasterList(all);
    }
}
