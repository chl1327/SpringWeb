package org.fkit.domain;

import java.io.Serializable;

/**
 * Created by 心痕 on 2017-7-10.
 */

public class mFile implements Serializable {
    private String filekey;
    private String filename;

    public mFile() {
        super();
        // TODO Auto-generated constructor stub
    }

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

    @Override
    public String toString() {
        return "mFile [filekey=" + filekey + ", filename=" + filename+"]";
    }
}
