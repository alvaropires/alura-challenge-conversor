package br.com.alura.service;

import br.com.alura.exceptions.MoedaNaoEncontradaException;
import br.com.alura.model.ConversorMoedaModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.http.HttpConnectTimeoutException;

public class CotacaoMoedaService {
    static String WEB_SERVICE = "https://economia.awesomeapi.com.br/json/last/";
    static int CODIGO_SUCESSO= 200;

    public static ConversorMoedaModel getServicoDeCotacao(String codigoMoeda) throws Exception{
        String urlParaChamada = WEB_SERVICE + codigoMoeda;


            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.connect();

            if(conexao.getResponseCode()!=CODIGO_SUCESSO){
                throw new MoedaNaoEncontradaException("Tipo de moeda não encontrada.");
            }
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(conexao.getInputStream()));
            JsonObject jsonPrimario = root.getAsJsonObject();
            JsonObject jsonSecundario =(JsonObject) jsonPrimario.get(codigoMoeda.replace("-",""));

            Gson gson = new Gson();

            ConversorMoedaModel resposta = gson.fromJson(jsonSecundario, ConversorMoedaModel.class);

            conexao.disconnect();

            return resposta;

    }
}
