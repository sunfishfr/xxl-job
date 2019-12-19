package com.xxl.job.executor.core.model;



import java.util.List;

/**
 * 给企业微信机器人发送消息
 * @Author luhan
 * @Date 2019/12/19 14:19
 */
public class QiRobotVo {
    /**
     * 机器人id
     */
    private String robotId;
    /**
     * 机器人名字
     */
    private String robotName;
    /**
     * 当前机器人的webhook地址
     */
    private String webhookAddress;


    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 富文本框里面的内容
     */
    private String content;
    /**
     * 涉及的人员
     */
    private List<String> memberList;
    /**
     * 电话
     */
    private List<String> mobileList;
    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * base64编码后的值
     */
    private String imageBase64Value;

    /**
     * 图片md5加密后的值
     */
    private String imageMd5Value;

    /**
     * 发送消息的标题
     */
    private String title;
    /**
     * 发送图文消息的描述信息
     */
    private String description;
    /**
     * 图片url地址集合
     */
    private List<String> imageUrlList;
    /**
     * 图片打开的地址
     */
    private String url;

    /**
     * 消息内容集合
     */
    private List<String> contentList;
    /**
     * 图片路径
     */
    private String savePath;

    public QiRobotVo() {
    }

    public QiRobotVo(String webhookAddress) {
        this.webhookAddress = webhookAddress;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public String getWebhookAddress() {
        return webhookAddress;
    }

    public void setWebhookAddress(String webhookAddress) {
        this.webhookAddress = webhookAddress;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }

    public List<String> getMobileList() {
        return mobileList;
    }

    public void setMobileList(List<String> mobileList) {
        this.mobileList = mobileList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageBase64Value() {
        return imageBase64Value;
    }

    public void setImageBase64Value(String imageBase64Value) {
        this.imageBase64Value = imageBase64Value;
    }

    public String getImageMd5Value() {
        return imageMd5Value;
    }

    public void setImageMd5Value(String imageMd5Value) {
        this.imageMd5Value = imageMd5Value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getContentList() {
        return contentList;
    }

    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
