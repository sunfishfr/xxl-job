package com.xxl.job.executor.core.robot;


import com.xxl.job.executor.core.model.QiRobotVo;
import com.xxl.job.executor.service.WXTemplateService;
import com.xxl.job.executor.service.impl.WXTemplateServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luhan
 * @Date 2019/12/19 17:14
 */
public class ReportRobot {
    private final static String HOOK_ADDRESS="https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=d182ba7d-45ef-49bb-a0fd-0afedc912f6d";
    private WXTemplateService wxTemplateService ;
    private QiRobotVo vo;

    public ReportRobot() {
        vo = new QiRobotVo(HOOK_ADDRESS);
        wxTemplateService = new WXTemplateServiceImpl();
    }



    public void sendText(String msg) {

        //1.第一种情况：发送文本消息
        vo.setContent("\uD83D\uDE0B"+msg+"。");

        List<String> memberList = new ArrayList<>();
        //memberList.add("@all");
        vo.setMemberList(memberList);

        List<String> memberPhoneList = new ArrayList<>();
        memberPhoneList.add("15218628435");
        vo.setMobileList(memberPhoneList);

        vo.setMsgType("text");
        wxTemplateService.sendNews(vo);
    }

    public void sendMDText(String msg) {

            vo.setContent("\uD83D\uDE0B<font color=\\\"warning\\\">提醒</font>："+msg+"。\n" +
                    ">错误信息：<font color=\\\"comment\\\">1</font> \n" +
                    ">执行器地址：<font color=\\\"comment\\\">2</font> \n" +
                    ">执行器名称：<font color=\\\"comment\\\">3</font>");

        vo.setMsgType("markdown");
        wxTemplateService.sendNews(vo);
    }

    public void sendImage() {


        //2.第二种情况，发送图片消息
        vo.setMsgType("image");
        vo.setSavePath("C:/cai.jpg");

        wxTemplateService.sendNews(vo);
    }


    public void sendNews()  {

        //3.第三种情况，发送机器人消息
        vo.setMsgType("news");
        vo.setTitle("中秋节礼品领取");
        vo.setDescription("今年中秋节公司有豪礼相送");
        vo.setUrl("www.luhan123.top");
        vo.setImageUrl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png");

        wxTemplateService.sendNews(vo);
    }
}
