package com.example.mylibrary;

/**
 * API服务类，提供两个可调用接口
 */
public class ApiService {
    
    /**
     * 获取问候语
     * @param name 用户名
     * @return 问候语字符串
     */
    public String getGreeting(String name) {
        return "你好，" + name + "！欢迎使用API服务。";
    }
    
    /**
     * 执行计算操作
     * @param a 第一个数字
     * @param b 第二个数字
     * @return 两数之和
     */
    public int calculate(int a, int b) {
        return a + b;
    }
} 