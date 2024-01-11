package br.com.casamento.carolerodrigo.back.config;

import br.com.casamento.carolerodrigo.back.converter.ConfirmationConverterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.addConverter(new ConfirmationConverterDTO());

        return modelMapper;
    }

}
