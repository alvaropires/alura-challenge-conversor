import br.com.alura.exceptions.MoedaNaoEncontradaException;
import br.com.alura.service.CotacaoMoedaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
