package jasmin.carwash.jsw.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync
public class GeneralConfig {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
