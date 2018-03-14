package com.kh013j;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import com.opentable.db.postgres.embedded.PgBinaryResolver;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.SingleInstancePostgresRule;

import org.junit.Rule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@EnableJpaRepositories("com.kh013j.model.repository")
public class CaffinnoApplicationTestConfiguration {
    @Rule
    public SingleInstancePostgresRule pg = EmbeddedPostgresRules.singleInstance();
    @Bean
    public DataSource dataSource() throws Exception {
        return EmbeddedPostgres
                .builder()
                .setPgBinaryResolver(new ClasspathBinaryResolver())
                .start().getTemplateDatabase();
    }

    class ClasspathBinaryResolver implements PgBinaryResolver {
        public InputStream getPgBinary(String system, String machineHardware) throws IOException {
            ClassPathResource resource = new ClassPathResource(String.format("postgresql-%s-%s.txz", system, machineHardware));
            return resource.getInputStream();
        }
    }
}