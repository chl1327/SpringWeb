package org.fkit.service.impl;

import org.fkit.domain.mFile;
import org.fkit.mapper.FileMapper;
import org.fkit.service.FileService;
import org.fkit.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 心痕 on 2017-7-10.
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("fileService")
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    /*
    * 插入文件信息
    * @see { FileService }
    * */
    @Transactional
    @Override
     public Boolean insertFile(FileVo fileVo){
        mFile mfile = FileVo.toMFile(fileVo);
        return fileMapper.saveFileInfo(mfile);
    }

    /**
     * 根据filekey查找文件信息
     *  @see { FileService }
     * */
    @Transactional(readOnly = true)
    @Override
    public mFile selectFile(String filekey){
        return fileMapper.selectFileName(filekey);
    }
}
