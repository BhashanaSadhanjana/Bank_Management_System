package lk.epic.bankmanagemet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({lk.epic.bankmanagemet.config.JPAConfig.class})
public class WebRootConfig {
}
