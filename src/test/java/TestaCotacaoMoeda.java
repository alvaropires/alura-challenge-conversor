import br.com.alura.exceptions.MoedaNaoEncontradaException;
import br.com.alura.model.ConversorMoedaModel;
import br.com.alura.service.CotacaoMoedaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestaCotacaoMoeda {
    @Test
    void testaCotacaoDolarParaRealRetornaObjeto(){
        Assertions.assertDoesNotThrow(()->CotacaoMoedaService.getServicoDeCotacao("USD-BRL"));
    }
    @Test
    void TestaNaoConsegueCotarMoedaRetornaException(){
        Assertions.assertThrows(MoedaNaoEncontradaException.class,
                ()->CotacaoMoedaService.getServicoDeCotacao("não existe"));
    }



}
