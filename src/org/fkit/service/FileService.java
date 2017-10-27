package org.fkit.service;

import org.fkit.domain.mFile;
import org.fkit.vo.FileVo;

/**
 * Created by 心痕 on 2017-7-10.
 */
public interface FileService {

    /**
    * 插入文件信息
    * @param mFile mfile
    * @return true
    * */
    Boolean insertFile(FileVo fileVo);

    /**
     * 根据filekey查找文件信息
     * @param String filekey
     * @return 文件对象
     * */
    mFile selectFile(String filekey);
}
