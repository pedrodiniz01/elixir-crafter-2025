package com.wizard.elixircrafter.config;

import com.example.wizardelixirmaker.api.ElixirsApi;
import com.example.wizardelixirmaker.invoker.ApiClient;
import com.wizard.elixircrafter.constants.Constants;

public class ApiConfig {
    public static ElixirsApi createElixirsApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(Constants.ElixirApi.BASE_URL);

        return new ElixirsApi(apiClient);
    }
}
