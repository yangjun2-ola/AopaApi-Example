package com.example.mylibrary;

import org.junit.Test;
import static org.junit.Assert.*;

public class ApiServiceTest {
    private final ApiService apiService = new ApiService();

    @Test
    public void testGetGreeting() {
        String name = "测试用户";
        String expectedGreeting = "你好，测试用户！欢迎使用API服务。";
        String actualGreeting = apiService.getGreeting(name);
        assertEquals("问候语测试失败", expectedGreeting, actualGreeting);
    }

    @Test
    public void testCalculate() {
        int a = 10;
        int b = 20;
        int expectedSum = 30;
        int actualSum = apiService.calculate(a, b);
        assertEquals("计算测试失败", expectedSum, actualSum);
    }
} 