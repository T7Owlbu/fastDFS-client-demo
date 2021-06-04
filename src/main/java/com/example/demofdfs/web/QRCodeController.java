package com.example.demofdfs.web;

import com.alibaba.fastjson.JSON;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequestMapping("/QRCode")
@Controller
public class QRCodeController {

    /**
     * 二维码生成
     */
    @GetMapping
    public void deptShow(HttpServletResponse response) throws IOException, WriterException {

        BitMatrix byteMatrix = new MultiFormatWriter().encode(
                new String("在勒泰吃喝玩乐".getBytes(), "iso-8859-1"),
                BarcodeFormat.QR_CODE,200,200
        );
        MatrixToImageWriter.writeToStream(byteMatrix,"png",response.getOutputStream());



    }

}
