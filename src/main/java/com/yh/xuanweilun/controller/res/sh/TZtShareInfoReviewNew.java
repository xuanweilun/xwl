package com.yh.xuanweilun.controller.res.sh;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TZtShareInfoReviewNew implements Serializable {


	private String id;

	/**
	 * 业务名称
	 *
	 */
	private String busiName;

	/**
	 * 分享地址关键字
	 *
	 */
	private String shareKey;

	/**
	 * 分享链接地址
	 */
	private String shareAddr;

	/**
	 * 是否使用原始链接
	 */
	private String isOriginUrl;

	/**
	 * 分享匹配类型0或空为模糊匹配，1为精准匹配
	 */
	private String shareMatchType;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 状态 0启用，1停用
	 */
	private String status;

	/**
	 * 删除时间，原来控制做软删除使用
	 */
	private Date delTime;

	/**
	 * 删除状态(1 删除、其他 2未删除).
	 */
	private String delStatus;

	/**
	 * 分享渠道
	 */
	private List<TZtShareReviewChannel> shareChannels;


	/**
	 * ----------------------------审核操作状态(1 待审核 ，2 审核通过，3审核不通过)
	 */
	private String reviewStatus;

	/**
	 * 审核操作更新时间
	 */
	private Date reviewTime;

	/**
	 * 审核操作类型(del 审核删除操作、add 审核新增操作、update 审核更新操作)
	 */
	private String reviewType;

	/**
	 * 审核操作者用户
	 */
	private String reviewUser;

	/**
	 * 递交审核用户.
	 */
	private String reviewAuthor;

	/**
	 * 审核原因
	 */
	private String reviewReason;

	/**
	 * 递交审核原因
	 */
	private String reviewSubmitReason;

    
    
}
