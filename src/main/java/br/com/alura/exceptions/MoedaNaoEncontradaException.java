package br.com.alura.exceptions;

public class MoedaNaoEncontradaException extends RuntimeException{
    public MoedaNaoEncontradaException(String message) {
        super(message);
    }
}
