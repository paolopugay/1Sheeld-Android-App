package com.integreight.onesheeld.shields.controller.utils.glcd;

import android.util.SparseArray;

/**
 * Created by Mouso on 7/22/2015.
 */
public class RadioGroup{
    SparseArray<RadioButton> radios;
    public RadioGroup(){
        radios = new SparseArray<RadioButton>();
    }

    public void add(RadioButton radioButton){
        radios.append(radios.size(),radioButton);
        radioButton.setRadioGroup(this);
    }

    public void remove(RadioButton radioButton){
        if(radios.indexOfValue(radioButton) > 0) {
            radios.get(radios.keyAt(radios.indexOfValue(radioButton))).setRadioGroup(null);
            radios.remove(radios.keyAt(radios.indexOfValue(radioButton)));
        }
    }

    public void select(RadioButton radioButton){
        reset();
        int key = radios.keyAt(radios.indexOfValue(radioButton));
        if(key != -1)
            radios.get(key).setSelected(true);
    }

    public void reset(){
        for(int radiosCount=0;radiosCount<radios.size();radiosCount++){
            radios.get(radios.keyAt(radiosCount)).setSelected(false);
        }
    }
}
