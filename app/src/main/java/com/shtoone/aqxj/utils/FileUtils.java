package com.shtoone.aqxj.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void createFile() {
        File sdCard= Environment.getExternalStorageDirectory();
        String fileName = "data.txt";
        File file = new File(sdCard, fileName) ;
        if(!file.exists()){
            try {
                file.createNewFile();
                String oldPath = file.getAbsolutePath();
                String newPath =  "";
                newPath = oldPath.replace(fileName, "other.txt");
                renameFile(oldPath, newPath);
                //file is create
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            String oldPath = file.getAbsolutePath();
            if(!TextUtils.isEmpty(oldPath)) {
                String newPath = file.getAbsolutePath() + "other.txt";
                newPath = oldPath.replace(fileName, "other.txt");
                renameFile(oldPath, newPath);
            }
        }
    }

    /**
     * oldPath 和 newPath必须是新旧文件的绝对路径
     * */
    public static void renameFile(String oldPath, String newPath) {
        if(TextUtils.isEmpty(oldPath)) {
            return;
        }
        if(TextUtils.isEmpty(newPath)) {
            return;
        }
        File file = new File(oldPath);
        file.renameTo(new File(newPath));
    }
}
