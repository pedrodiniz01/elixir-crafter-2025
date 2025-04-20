package com.example.wizardelixir.demo.config;

import com.example.wizardelixirmaker.api.ElixirsApi;
import com.example.wizardelixirmaker.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ElixirsApi elixirsApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("https://wizard-world-api.herokuapp.com");
        return new ElixirsApi(apiClient);
    }
}