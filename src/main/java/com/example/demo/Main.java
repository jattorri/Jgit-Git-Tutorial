package com.example.demo;

import com.example.demo.gitcontrol.gitControl;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws IOException, GitAPIException, URISyntaxException {
		SpringApplication.run(Main.class, args);
		gitControl git = new gitControl();
		git.initLocal();
		git.initRemote();

	}

}
