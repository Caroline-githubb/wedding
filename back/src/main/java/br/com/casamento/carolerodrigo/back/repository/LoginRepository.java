package br.com.casamento.carolerodrigo.back.repository;

import br.com.casamento.carolerodrigo.back.model.Login;

public interface LoginRepository {

    Login findLogin(String login, String hasedPassword);

}
