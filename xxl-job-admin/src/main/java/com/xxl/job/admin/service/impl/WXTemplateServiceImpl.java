package com.xxl.job.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xxl.job.admin.core.model.QiRobotVo;
import com.xxl.job.admin.core.util.ImageUtil;
import com.xxl.job.admin.core.util.SendRequest;
import com.xxl.job.admin.service.WXTemplateService;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.util.Strings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author luhan
 * @Date 2019/12/19 14:44
 */
public class WXTemplateServiceImpl implements WXTemplateService {
    @Override
    public void sendNews(QiRobotVo vo) {
        List<String> memberList = vo.getMemberList();
        List<String> mobileList = vo.getMobileList();
        String jsonData = "";
        String strMember = "";
        String strMobile = "";
        if (vo.getMsgType().equals("text")) {
            strMember = dealMemberListToString(memberList);
            strMobile = dealMemberListToString(mobileList);

            jsonData = "{\n" +
                    "\t\"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                    "    \"text\": {\n" +
                    "        \"content\": \"" + vo.getContent() + "\",\n" +
                    "        \"mentioned_list\":[" + strMember + "],\n" +
                    "        \"mentioned_mobile_list\":[" + strMobile + "]\n" +
                    "    }\n" +
                    "}";

        }else if (vo.getMsgType().equals("markdown")) {

            jsonData = "{\n" +
                    "    \"msgtype\": \""+vo.getMsgType() +"\",\n" +
                    "    \"markdown\": {\n" +
                    "        \"content\": \""+vo.getContent()+"\"\n" +
                    "    }\n" +
                    "}\n";
        } else if (vo.getMsgType().equals("image")) {
            try {
                //图片base64加密的值
                vo.setImageBase64Value(ImageUtil.getImageStr(vo.getSavePath()));
                //图片md5加密的值
                vo.setImageMd5Value(DigestUtils.md5Hex(new FileInputStream(vo.getSavePath())));
                jsonData = "{\n" +
                        "    \"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                        "    \"image\": {\n" +
                        "        \"base64\": \"" + vo.getImageBase64Value() + "\",\n" +
                        "        \"md5\": \"" + vo.getImageMd5Value() + "\"\n" +
                        "    }\n" +
                        "}";
            }catch (IOException e){
                e.printStackTrace();
            }
        } else if (vo.getMsgType().equals("news")) {
            //图文消息
            vo.setTitle(!Strings.isNullOrEmpty(vo.getTitle()) ? vo.getTitle() : "");
            jsonData = "{\n" +
                    "    \"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                    "    \"news\": {\n" +
                    "       \"articles\" : [\n" +
                    "           {\n" +
                    "               \"title\" : \"" + vo.getTitle() + "\",\n" +
                    "               \"description\" : \"" + vo.getDescription() + "\",\n" +
                    "               \"url\" : \"" + vo.getUrl() + "\",\n" +
                    "               \"picurl\" : \"" + vo.getImageUrl() + "\"\n" +
                    "           }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
        }
        JSONObject jsonObject = SendRequest.sendPost(vo.getWebhookAddress(), jsonData);
    }

    private String dealMemberListToString(List<String> list){
        String str="";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str += "\"" + list.get(i) + "\"";
            } else {
                str += "\"" + list.get(i) + "\"" + ",";
            }
        }
        return str;
    }
}
