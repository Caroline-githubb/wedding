package br.com.casamento.carolerodrigo.back.controller;

import br.com.casamento.carolerodrigo.back.model.Gift;
import br.com.casamento.carolerodrigo.back.repository.GiftRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gift")
@RequiredArgsConstructor
public class GiftController {

    private final GiftRepository giftRepository;

    @GetMapping("/available")
    public ResponseEntity<Gift[]> getAllAvailable() {
        var gifts = giftRepository.findAllAvailable();
        if (ArrayUtils.isEmpty(gifts)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(gifts);
        }
    }

}
