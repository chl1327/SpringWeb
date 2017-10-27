package org.fkit.util;

import org.fkit.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by chl1327 on 2017/7/9.
 */
public class Util {

    @Autowired
    @Qualifier("fileService")
    private static FileService fileService;

    public static String getUuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String getDateStr(){
        Date date = new Date();
        SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sft.format(date);
        return dateStr;
    }

    public static void main(String [] args){
        System.out.println(getUuid());
        System.out.println(getDateStr());
    }

}
