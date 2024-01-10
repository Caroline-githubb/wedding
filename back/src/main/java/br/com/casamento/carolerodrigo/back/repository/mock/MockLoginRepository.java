package br.com.casamento.carolerodrigo.back.repository.mock;

import br.com.casamento.carolerodrigo.back.model.Login;
import br.com.casamento.carolerodrigo.back.repository.LoginRepository;
import br.com.casamento.carolerodrigo.back.service.HashService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class MockLoginRepository implements LoginRepository {

    private static final String validLogin = "teste";
    private final String validHashedPassword;

    public MockLoginRepository(HashService hashService) {
        this.validHashedPassword = hashService.hashPassword("senha123");
    }


    @Override
    public Login findLogin(String login, String hashedPassword) {
        if (StringUtils.equals(login, validLogin) &&
            StringUtils.equals(hashedPassword, validHashedPassword)) {
            return Login.builder()
                    .login(validLogin)
                    .hashedPassword(validHashedPassword)
                    .build();
        } else {
            return null;
        }
    }

}
