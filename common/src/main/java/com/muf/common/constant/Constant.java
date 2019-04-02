package com.muf.common.constant;


import org.apache.commons.lang.StringUtils;

/**
 * @author XYQ
 * 常量
 */
public class Constant {
    /**
     * 请求头中 JWT 的key
     */
    public static final String AUTHOR_PARAM = "token";

    /**
     * JWT 签名
     */
    public static final String JWT_SIGN_KEY = "muf.shopping";

    /**
     * JWT token 用户名
     */
    public static final String JWT_TOKEN_USERNAME = "jtu";

    /**
     * JWT token 用户编号
     */
    public static final String JWT_TOKEN_USERID = "uid";

    /**
     * JWT_编号
     */
    public static final String JWT_ID = "jti";

    /**
     * 服务内部调用前缀
     */
    public static final String API_PATH = "/api/private/";
    public static final String API_PATH_ANON = API_PATH + "**";

    /**
     * 开放接口前缀
     */
    public static final String API_OPEN_PATH = "/api/public/";
    public static final String API_OPEN_PATH_ANON = API_OPEN_PATH + "**";

    public static final String PHONE = "phone";
    public static final String LAND_LINE = "landLine";
    public static final String QQ = "qq";
    public static final String WEI_XIN = "weiXin";

    /**
     * 保护期：15天
     */
    public static final Integer CUSTOMER_PROTECT_TIME = 15;

    /**
     * 通用状态
     */
    public enum Status {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 禁用
         */
        DISABLE(1);

        private Integer value;

        Status(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public boolean equals(Integer value) {
            return value.equals(this.value);
        }
    }

    /**
     * 数据类型
     * 0：字符串 1：整型  2：浮点型  3：布尔  4：json对象
     */
    public enum DataType {
        /**
         * 字符串
         */
        STRING(0),
        /**
         * 整型
         */
        INTEGER(1),
        /**
         * 浮点型
         */
        DOUBLE(2),
        /**
         * 布尔
         */
        BOOLEAN(3),
        /**
         * json对象
         */
        JSON(4);

        private Integer value;

        DataType(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public boolean equals(Integer value) {
            return value.equals(this.value);
        }
    }

    /**
     * 客户联系方式类型
     */
    public enum CustomerContactType {

        /**
         * 0：邮箱
         */
        EMAIL(0),

        /**
         * 1：手机
         */
        PHONE(1),

        /**
         * 2：座机
         */
        LAND_LINE(2),
        /**
         * 3：微信
         */
        WE_CHAT(3),
        /**
         * 4：QQ
         */
        QQ(4);


        private Integer value;


        CustomerContactType(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public boolean equals(Integer value) {
            return value.equals(this.value);
        }
    }


    /**
     * websocket消息类型
     * 不同实体对应不同消息类型,类型编号 从 2000 开始，1000预留为ws的固定类型
     */
    public enum WsData {
        /**
         * 通知 Notice
         */
        NOTICE(2000),
        /**
         * 消息 message
         */
        MESSAGE(2001),
        /**
         * 待办todo
         */
        TODO(2002);

        private Integer value;

        WsData(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public boolean equals(Integer value) {
            return value != null && value.equals(this.value);
        }
    }

    public enum CheckToken {
        /**
         * 验证成功
         */
        SUCCESS(0),
        /**
         * 其他地方登录
         */
        TOKEN_OUT(1),
        /**
         * 登录过期
         */
        TOKEN_OVERDUE(2),
        /**
         * 未登录
         */
        TOKEN_FAULT(3);
        private int value;

        CheckToken(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 性别枚举
     */
    public enum Gender {
        /**
         * 未知
         */
        UNKNOWN(0, "未知"),
        /**
         * 男
         */
        MAN(1, "男"),
        /**
         * 女
         */
        WOMEN(2, "女");

        private Integer value;
        private String code;

        Gender(Integer value, String code) {
            this.value = value;
            this.code = code;
        }

        public Integer getValue() {
            return value;
        }

        public String getCode() {
            return code;
        }

    }

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 学历
     */
    public enum Education {
        /**
         * 无
         */
        NONE(0, "无"),
        /**
         * 小学
         */
        PRIMARY(1, "小学"),
        /**
         * 初中
         */
        MIDDLE(2, "初中"),
        /**
         * 高中
         */
        HIGH(3, "高中"),
        /**
         * 大专
         */
        COLLEGE(4, "大专"),
        /**
         * 本科
         */
        UNDERGRADUATE(5, "本科"),
        /**
         * 硕士
         */
        MASTER(6, "硕士"),
        /**
         * 博士
         */
        DOCTORAL(7, "博士");

        private Integer value;

        private String code;

        Education(Integer value, String code) {
            this.value = value;
            this.code = code;
        }

        public Integer getValue() {
            return value;
        }

        public boolean equals(Integer value) {
            return value.equals(this.value);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        /**
         * 获取学历
         */
        public String handleEducationName(String educationName) {
            if (StringUtils.isNotEmpty(educationName)) {
                for (Constant.Education e : Constant.Education.values()) {
                    for (String s : e.getCode().split(",")) {
                        if (educationName.contains(s)) {
                            return e.getCode();
                        }
                    }
                }
            }
            return Constant.Education.NONE.getCode();
        }
        /**
         * 根据学历获取对应学历编码
         */
        public Integer getValueByEducationName(String code) {
            if (StringUtils.isNotEmpty(code)) {
                for (Constant.Education e : Constant.Education.values()) {
                    if (code.contains(e.getCode())) {
                        return e.getValue();
                    }
                }
            }
            return Constant.Education.NONE.getValue();
        }
    }

    /**
     * 客户状态
     */
    public enum CustomerStatus {

        /**
         * 潜在
         */
        POTENTIAL(0, "潜在"),
        /**
         * 有效失败
         */
        FAILED_VALID(1, "有效失败"),
        /**
         * 无效失败
         */
        FAILED_INVALID(2, "无效失败"),
        /**
         * 预约
         */
        RESERVATION(3, "预约"),
        /**
         * 成交
         */
        DEAL(4, "成交");

        private Integer value;

        private String code;

        CustomerStatus(Integer value, String code) {
            this.value = value;
            this.code = code;
        }

        public Integer getValue() {
            return value;
        }

        public boolean equals(Integer value) {
            return value.equals(this.value);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }


    /**
     * 工作经验
     */
    public enum EXPERIENCE {
        /**
         * 无经验
         */
        NO_EXPERIENCE(0, "无经验"),
        /**
         * 应届生
         */
        GRADUATE(1, "应届生"),
        /**
         * 一年以内
         */
        ONE_EXPERIENCE(2, "一年以内"),
        /**
         * 两年
         */
        TWO_EXPERIENCE(3, "两年"),
        /**
         * 三年
         */
        THREE_EXPERIENCE(4, "三年"),
        /**
         * 三年以上
         */
        MORE_THREE_EXPERIENCE(5, "三年以上");

        private Integer value;

        private String code;

        EXPERIENCE(Integer value, String code) {
            this.value = value;
            this.code = code;
        }

        public Integer getValue() {
            return value;
        }

        public boolean equals(Integer value) {
            return value.equals(this.value);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    /**
     * 推广方式
     */
    public enum GetWayStatus {
        /**
         * 主动获取
         */
        ACTIVE_GET("主动获取", 1),
        /**
         * 被动获取
         */
        PASSIVE_GET("被动获取", 2);
        private Integer value;
        private String code;

        GetWayStatus(String code, Integer value) {
            this.value = value;
            this.code = code;
        }

        public Integer getValue() {
            return value;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 费用类型
     *
     * @author xieyuqing
     */
    public enum CostType {

        /**
         * 人民币
         */
        RMB(1),
        /**
         * 虚拟币
         */
        VIRTUAL_RMB(2);

        private int value;

        CostType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 角色
     */
    public enum Role {

        /**
         * 超级管理员
         */
        SUPER_ADMIN("SUPER_ADMIN"),

        /**
         * 管理员
         */
        ADMIN("ADMIN"),
        /**
         * 客服专员
         */
        SERVICE_COMMISSIONER("SERVICE_COMMISSIONER"),
        /**
         * 电销专员
         */
        SALE_COMMISSIONER("SALE_COMMISSIONER"),

        /**
         * 质检专员
         */
        INSPECT_COMMISSIONER("INSPECT_COMMISSIONER");

        private String code;

        Role(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }

}
