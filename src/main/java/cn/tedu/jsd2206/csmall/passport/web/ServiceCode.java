package cn.tedu.jsd2206.csmall.passport.web;

/**
 * 业务状态码的枚举
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
public enum ServiceCode {

    OK(20000),
    ERR_NOT_FOUND(40400),
    ERR_CONFLICT(40900);

    private Integer value;

    ServiceCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
