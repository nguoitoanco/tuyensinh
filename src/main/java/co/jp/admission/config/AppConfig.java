package co.jp.admission.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("co.jp.admission")
@EnableWebMvc
@Import({JdbcConfig.class, WebMvcConfig.class, MessageConfig.class})
public class AppConfig {
}
