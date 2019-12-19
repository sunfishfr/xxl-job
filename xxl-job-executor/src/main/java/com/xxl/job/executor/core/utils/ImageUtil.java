package com.xxl.job.executor.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @Author luhan
 * @Date 2019/12/19 14:21
 */
public class ImageUtil {
    /**
     * 根据图片地址转换为base64编码字符串
     * @param imgFile
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }
}
