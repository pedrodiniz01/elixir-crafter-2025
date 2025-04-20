package com.wizard.elixircrafter;

import com.example.wizardelixirmaker.api.ElixirsApi;
import com.wizard.elixircrafter.cli.ElixirCli;
import com.wizard.elixircrafter.config.ApiConfig;
import com.wizard.elixircrafter.service.ElixirService;

public class App {

    private final ElixirCli cli;

    /**
     * App is responsible for wiring up its dependencies.
     */
    public App() {
        ElixirsApi elixirsApi = ApiConfig.createElixirsApi();
        ElixirService elixirService = new ElixirService(elixirsApi);
        this.cli = new ElixirCli(elixirService);
    }

    public void start() {
        cli.run();
    }

    public static void main(String[] args) {
        new App().start();
    }
}
