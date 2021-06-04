package com.example.demofdfs.web;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RequestMapping("/fdfs")
@RestController
public class FdfsController {

    @Autowired
    private FastFileStorageClient client;

    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        StorePath storePath = client.uploadFile(file.getInputStream(), file.getSize(), FdfsController.getExtName(file.getOriginalFilename()), null);
        return storePath.getFullPath();
    }

    /**
     * 文件下载
     * @param response
     * @param fullPath
     * @throws IOException
     */
    @GetMapping("/download")
    public void  download(HttpServletResponse response,String fullPath) throws IOException {
        int index = fullPath.indexOf('/');
        String fileName = fullPath.substring(fullPath.lastIndexOf('/') + 1);
        byte[] bytes = client.downloadFile(fullPath.substring(0, index), fullPath.substring(index+1), new DownloadByteArray());
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        response.getOutputStream().write(bytes);
    }

    public static String getExtName(String fileName){
        return fileName.substring(fileName.lastIndexOf('.')+1);
    }

}