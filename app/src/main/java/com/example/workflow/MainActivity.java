package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.workflow.databinding.ActivityMainBinding;
import com.example.mylibrary.ApiService;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'workflow' library on application startup.
    static {
        System.loadLibrary("workflow");
    }

    private ActivityMainBinding binding;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化ApiService
        apiService = new ApiService();

        // 调用第一个接口方法
        String greeting = apiService.getGreeting("Android用户");
        
        // 调用第二个接口方法
        int result = apiService.calculate(10, 20);

        // 显示结果
        TextView tv = binding.sampleText;
        tv.setText(greeting + "\n计算结果: " + result + "\nJNI结果: " + stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'workflow' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}