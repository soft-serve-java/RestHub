package com.kh013j.model.service;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.IOException;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@Configuration
public class CaffinoApplicationTestConfiguration {
    @Bean(destroyMethod = "stop")
    public EmbeddedPostgres startPostgres() throws IOException, ClassNotFoundException {
        final EmbeddedPostgres postgres = new EmbeddedPostgres(V10);
        System.out.println("Hi, i'm Postgres!");
        final String url = postgres.start("localhost", 5432, "test", "my", "1234");
        System.out.println(url);
        return postgres;
    }
}
