package com.k4.rekapnilai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.net.http.HttpClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RekapnilaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RekapnilaiApplication.class, args);

	}

}
