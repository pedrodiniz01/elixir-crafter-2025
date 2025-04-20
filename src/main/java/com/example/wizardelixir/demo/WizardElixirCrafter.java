package com.example.wizardelixir.demo;

import com.example.wizardelixir.demo.console.ElixirCliApp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class WizardElixirCrafter {

    @Autowired
    private ElixirCliApp elixirCliApp;

    public static void main(String[] args) {
        SpringApplication.run(WizardElixirCrafter.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        elixirCliApp.run();
    }
}

