package org.fkit.controller;

import org.apache.commons.io.FileUtils;
import org.fkit.domain.mFile;
import org.fkit.service.FileService;
import org.fkit.service.UserService;
import org.fkit.util.Util;
import org.fkit.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by 心痕 on 2017-7-6.
 */
@Controller
@RequestMapping("/file")
public class UploadController {

    @Autowired
    @Qualifier("fileService")
    private FileService fileService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map<String,Object> upload(@RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        HashMap map = new HashMap();
        FileVo fileVo = new FileVo();
        if(file!=null){
            String path = request.getServletContext().getRealPath("/imgUpload/");
            String filename = file.getOriginalFilename();
            String newName=String.valueOf(Util.getUuid());
            fileVo.setFilekey(newName);
            fileVo.setFilename(filename);
            fileService.insertFile(fileVo);
            String suffix = "."+filename.substring(filename.lastIndexOf(".") + 1);
            String newFile = newName+suffix;
                File filepath = new File(path);
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                File fileUpload = new File(path+File.separator+newFile);
                //mFile fileUpload = mFile.createTempFile(newName,suffix,filepath);
                file.transferTo(fileUpload);
                map.put("filekey",newName);
                map.put("message", "success");
        } else {
            map.put("message", "error");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(@RequestParam String filekey,HttpServletRequest request,
                                           HttpServletResponse response)throws IOException{
        mFile mfile = fileService.selectFile(filekey);
        String downFileName = "";
        File file = new File("");
        if (mfile != null) {
            String path = request.getServletContext().getRealPath("/imgUpload/");
            String filename = mfile.getFilekey() + "." + mfile.getFilename().substring(mfile.getFilename().lastIndexOf(".") + 1);
            file = new File(path + File.separator + filename);
            downFileName = mfile.getFilename();
        }else{
            String path = request.getServletContext().getRealPath("/images/bg/");
            file = new File(path + File.separator + "Index.jpg");
            downFileName = "Index.jpg";
        }
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(downFileName.getBytes("UTF-8"),"ISO-8859-1");
        headers.setContentDispositionFormData("attachment",downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/upload1",method = RequestMethod.POST)
    public Map<String,Object> upload1(@RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        HashMap map = new HashMap();
        String path = request.getServletContext().getRealPath("/imgUpload/");
        String filename = file.getOriginalFilename();
        String suffix="."+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        String filenametime = String.valueOf(System.currentTimeMillis());
        String fileName = filenametime;
        File filePath = new File(path);
        File tempFile =File.createTempFile(fileName,suffix, filePath);
        file.transferTo(tempFile);

        File fileUpload = new File(path+File.separator+tempFile.getName());
        file.transferTo(fileUpload);
        map.put("success",true);
        return map;
    }



}
