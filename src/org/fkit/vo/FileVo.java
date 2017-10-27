package org.fkit.vo;

import org.fkit.domain.mFile;

/**
 * Created by 心痕 on 2017-7-10.
 */

public class FileVo {
    private String filekey;
    private String filename;

    public String getFilekey() {
        return filekey;
    }

    public void setFilekey(String filekey) {
        this.filekey = filekey;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public static mFile toMFile(FileVo fileVo){
        mFile mfile = new mFile();
        mfile.setFilekey(fileVo.getFilekey());
        mfile.setFilename(fileVo.getFilename());
        return mfile;
    }
}
