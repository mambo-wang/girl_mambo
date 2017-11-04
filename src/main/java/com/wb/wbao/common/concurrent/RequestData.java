package com.wb.wbao.common.concurrent;

import com.wb.wbao.server.user.User;

public class RequestData<T> {

    /** 请求类型 */
    private int requestType;

    /** 请求数据 */
    private T data;

    /** 操作用户 */
    private User user;

    /** 推送前台任务台进度使用 */
    private long massageId;

    public RequestData() {
    }

    public RequestData(int requestType, T data, User user, long massageId) {
        this.requestType = requestType;
        this.data = data;
        this.user = user;
        this.massageId = massageId;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getMassageId() {
        return massageId;
    }

    public void setMassageId(long massageId) {
        this.massageId = massageId;
    }



}
