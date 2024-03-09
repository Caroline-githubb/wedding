package br.com.casamento.carolerodrigo.back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MercadoPagoWebHookEntity {

    long id;
    String type;
    String action;
    String api_version;
    String date_created;
    String live_mode;
    String user_id;
    Data data;

    @lombok.Data
    @Builder
    public static class Data {
        long id;
    }

}
