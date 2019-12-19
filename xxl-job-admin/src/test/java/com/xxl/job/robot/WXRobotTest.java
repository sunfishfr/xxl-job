package com.xxl.job.robot;

import com.xxl.job.admin.core.model.QiRobotVo;
import com.xxl.job.admin.service.WXTemplateService;
import com.xxl.job.admin.service.impl.WXTemplateServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luhan
 * @Date 2019/12/19 14:52
 */
public class WXRobotTest {
    private final static String HOOK_ADDRESS="https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=15c082cb-1ee4-40c9-a622-d0633771c2b7";
    WXTemplateService wxTemplateService = new WXTemplateServiceImpl();
    QiRobotVo vo = new QiRobotVo(HOOK_ADDRESS);

    @Test
    public void testText()  {


        //1.第一种情况：发送文本消息
        vo.setContent("我发送的消息是：好好吃饭哦。\uD83D\uDE0B");

        List<String> memberList = new ArrayList<>();
        memberList.add("@all");
        vo.setMemberList(memberList);

        List<String> memberPhoneList = new ArrayList<>();
        memberPhoneList.add("13332900107");
        vo.setMobileList(memberPhoneList);

        vo.setMsgType("text");
        wxTemplateService.sendNews(vo);
    }
    @Test
    public void testMDText()  {


        //1.第一种情况：发送文本消息
        //vo.setContent("我发送的消息是：好好吃饭哦。");
        vo.setContent("实时新增用户反馈\uD83D\uDE41<font color=\\\"warning\\\">132例</font>，请相关同事注意。\n" +
                ">类型:<font color=\\\"comment\\\">用户反馈</font> \n" +
                ">普通用户反馈:<font color=\\\"comment\\\">117例</font> \n" +
                ">VIP用户反馈:<font color=\\\"comment\\\">15例</font>");

        vo.setMsgType("markdown");
        wxTemplateService.sendNews(vo);
    }

    @Test
    public void testImage()  {


        //2.第二种情况，发送图片消息
        vo.setMsgType("image");
        vo.setSavePath("C:/cai.jpg");

        wxTemplateService.sendNews(vo);
    }

    @Test
    public void testNews()  {

        //3.第三种情况，发送机器人消息
        vo.setMsgType("news");
        vo.setTitle("中秋节礼品领取");
        vo.setDescription("今年中秋节公司有豪礼相送");
        vo.setUrl("www.luhan123.top");
        vo.setImageUrl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png");

        wxTemplateService.sendNews(vo);
    }
}
