package org.fkit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.mFile;

/**
 * Created by 心痕 on 2017-7-10.
 */
public interface FileMapper {

    /*
    * 保存文件信息
    * @return true
    * */
    @Insert("insert into tb_file(filekey,filename) values(#{filekey},#{filename})")
    @Options(useGeneratedKeys = true,keyProperty = "filekey")
    Boolean saveFileInfo(mFile mfile);

    /*
    * 查询上传文件名称
    * @return 文件信息对象
    * */
    @Select("select * from tb_file where filekey=#{filekey}")
    mFile selectFileName(@Param("filekey") String filekey);

 }
