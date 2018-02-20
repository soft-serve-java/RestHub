package com.kh013j.model.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.IOException;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

//@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@Configuration
@EnableJpaRepositories("com.kh013j.model.repository")
public class CaffinoApplicationTestConfiguration {
    @Bean(destroyMethod = "stop")
    public EmbeddedPostgres startPostgres() throws IOException, ClassNotFoundException {
        final EmbeddedPostgres postgres = new EmbeddedPostgres(V10);
        final String url = postgres.start("localhost", 5432, "test", "my", "1234");
        return postgres;
    }

   /* @Bean
    public DishRepository dishRepository() {
        return Mockito.mock(DishRepository.class);
    }

    @Bean
    public CategoryRepository categoryRepository() {
        return Mockito.mock(CategoryRepository.class);
    }

    /*@Bean
    public CategoryRepository categoryRepository() {
        return Mockito.mock(CategoryRepository.class);
    }*/
}
