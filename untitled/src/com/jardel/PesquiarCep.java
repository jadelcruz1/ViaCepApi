package com.jardel;

import java.security.PrivateKey;

public class PesquiarCep {
    private String cep;
    private String logadouro;
    private String bairro;

    public PesquiarCep(String cep, String logadouro, String bairro) {
        this.cep = cep;
        this.logadouro = logadouro;
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public String getBairro() {
        return bairro;
    }

    @Override
    public String toString() {
        return "PesquiarCep{" +
                "cep='" + cep + '\'' +
                ", logadouro='" + logadouro + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
