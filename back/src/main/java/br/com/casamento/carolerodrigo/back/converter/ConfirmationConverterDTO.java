package br.com.casamento.carolerodrigo.back.converter;

import br.com.casamento.carolerodrigo.back.dto.ConfirmationRequest;
import br.com.casamento.carolerodrigo.back.model.Confirmation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.util.Arrays;

@Slf4j
public class ConfirmationConverterDTO implements Converter<ConfirmationRequest, Confirmation> {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Confirmation convert(MappingContext<ConfirmationRequest, Confirmation> mappingContext) {
        ConfirmationRequest request = mappingContext.getSource();
        Confirmation confirmation = modelMapper.map(request, Confirmation.class);

        confirmation.setAdultsNames(Arrays
                        .stream(request.getAdultsNames())
                        .map(x -> Confirmation.builder()
                                .fullName(x)
                                .build())
                        .toList()
                        .toArray(new Confirmation[0]));

        confirmation.setChildrenNames(Arrays
                .stream(request.getChildrenNames())
                .map(x -> Confirmation.builder()
                        .fullName(x)
                        .build())
                .toList()
                .toArray(new Confirmation[0]));

        return confirmation;
    }
}
