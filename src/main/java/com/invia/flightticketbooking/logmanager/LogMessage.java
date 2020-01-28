package com.invia.flightticketbooking.logmanager;

import java.util.Objects;

/**
 * @Author Varadharajan on 20/11/19 23:06
 * @Projectname logging-demo
 */
public class LogMessage {

    private int httpStatus;

    private String httpMethod;

    private String path;

    private String clientIp;

    private String javaMethod;

    private String response;


    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getJavaMethod() {
        return javaMethod;
    }

    public void setJavaMethod(String javaMethod) {
        this.javaMethod = javaMethod;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogMessage)) return false;
        LogMessage that = (LogMessage) o;
        return httpStatus == that.httpStatus &&
                Objects.equals(httpMethod, that.httpMethod) &&
                Objects.equals(path, that.path) &&
                Objects.equals(clientIp, that.clientIp) &&
                Objects.equals(javaMethod, that.javaMethod) &&
                Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpStatus, httpMethod, path, clientIp, javaMethod, response);
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "httpStatus=" + httpStatus +
                ", httpMethod='" + httpMethod + '\'' +
                ", path='" + path + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", javaMethod='" + javaMethod + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}