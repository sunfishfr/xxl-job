package com.xxl.job.admin.core.robot;

import com.xxl.job.admin.core.model.QiRobotVo;
import com.xxl.job.admin.core.model.XxlJobLog;
import com.xxl.job.admin.service.WXTemplateService;
import com.xxl.job.admin.service.impl.WXTemplateServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luhan
 * @Date 2019/12/19 17:14
 */
public class ReportRobot {
    private final static String HOOK_ADDRESS="https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=15c082cb-1ee4-40c9-a622-d0633771c2b7";
    private WXTemplateService wxTemplateService = new WXTemplateServiceImpl();
    private QiRobotVo vo = new QiRobotVo(HOOK_ADDRESS);
    private XxlJobLog jobLog;
    public ReportRobot() {
    }

    public ReportRobot(XxlJobLog jobLog) {
        this.jobLog = jobLog;
    }

    public void sendText(String msg) {
        int index = msg.lastIndexOf("：")+1;
        //1.第一种情况：发送文本消息
        vo.setContent("错误消息："+msg.substring(index));

        List<String> memberList = new ArrayList<>();
        memberList.add("@all");
        vo.setMemberList(memberList);

        List<String> memberPhoneList = new ArrayList<>();
        memberPhoneList.add("13332900107");
        vo.setMobileList(memberPhoneList);

        vo.setMsgType("text");
        wxTemplateService.sendNews(vo);
    }

    public void sendMDText(String msg) {
        int index = msg.lastIndexOf("：") +1;
        //http://bj.96weixin.com/emoji/
        //1.第一种情况：发送文本消息
        vo.setContent("\uD83D\uDE41任务调度出错，状态码为：<font color=\\\"warning\\\">"+jobLog.getHandleCode()+"</font>，请相关同事注意。\n" +
                ">错误信息：<font color=\\\"comment\\\">"+msg.substring(index)+"</font> \n" +
                ">执行器地址：<font color=\\\"comment\\\">"+jobLog.getExecutorAddress()+"</font> \n" +
                ">执行器名称：<font color=\\\"comment\\\">"+jobLog.getExecutorHandler()+"</font>");

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
