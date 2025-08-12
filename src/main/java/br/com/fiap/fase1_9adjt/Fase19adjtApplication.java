package br.com.fiap.fase1_9adjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fiap.fase1_9adjt.domain")
public class Fase19adjtApplication {
    public static void main(String[] args) {
        SpringApplication.run(Fase19adjtApplication.class, args);
    }
}
