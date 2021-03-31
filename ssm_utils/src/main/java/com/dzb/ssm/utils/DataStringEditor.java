package com.dzb.ssm.utils;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.util.Date;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/30 13:36
 */
public class DataStringEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date=DateUtils.string2Date(text,"yyyy-MM-dd HH:mm");
            super.setValue(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
