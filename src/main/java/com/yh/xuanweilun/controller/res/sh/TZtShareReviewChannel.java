package com.yh.xuanweilun.controller.res.sh;


public class TZtShareReviewChannel {

    private String id;

    /**
     * 名称【weChat,weChatCircle,qq,qqCircle,weibo】
     */
    private String name;

    /**
     * 中文名称【微信好友，微信朋友圈，qq好友，qq朋友圈，微博】
     */
    private String nameCh;

    /**
     * 分享类型【h5页面、海报分享、截屏分享、小程序分享、口令分享】
     */
    private String shareType;

    /**
     * 分享图片地址
     */
    private String shareImgUrl;

    /**
     * 分享描述
     */
    private String shareDescribe;

    /**
     * 海报
     */
    private String posterUrl;

    /**
     * 是否使用默认二维码
     */
    private String useDefaultQRCode;

    /**
     * 默认二维码地址
     */
    private String defaultQRCodeUrl;

    /**
     * 分享标题
     */
    private String shareTitle;

    /**
     * 匹配路径
     */
    private String matcherUrl;

    /**
     * 应用渠道
     */
    private String appChannel;

    /**
     * 兼容低版本小程序链接
     */
    private String lowVersionAppUrl;

    /**
     * 弹窗按钮 共14个
     */
    private String popupButtonUrl;
}
