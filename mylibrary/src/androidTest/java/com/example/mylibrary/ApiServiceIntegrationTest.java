package com.example.mylibrary;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ApiServiceIntegrationTest {
    private ApiService apiService;
    private Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        apiService = new ApiService();
    }

    @Test
    public void testCombinedApiCalls() {
        // 测试计算功能
        int result = apiService.calculate(5, 3);
        assertEquals("基础计算测试", 8, result);

        // 测试问候语功能
        String greeting = apiService.getGreeting("集成测试");
        assertEquals("基础问候语测试", "你好，集成测试！欢迎使用API服务。", greeting);

        // 组合测试：将计算结果融入问候语
        int num1 = 10;
        int num2 = 20;
        int sum = apiService.calculate(num1, num2);
        String combinedGreeting = apiService.getGreeting("用户" + sum);
        String expectedGreeting = "你好，用户30！欢迎使用API服务。";
        assertEquals("组合测试失败", expectedGreeting, combinedGreeting);
    }

    @Test
    public void testContextAvailable() {
        // 验证Android上下文是否可用
        assertNotNull("Context应该可用", context);
        assertEquals("包名验证", "com.example.mylibrary.test", context.getPackageName());
    }
} 