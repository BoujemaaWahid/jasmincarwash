package jasmin.carwash.jsw.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
