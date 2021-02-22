package br.com.zup.casadocodigo;

import br.com.zup.casadocodigo.authors.Author;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Valid;

@SpringBootTest
class CasadocodigoApplicationTests {

    @Test
    void contextLoads() {

    String value = "  340.059.238-28   ";
        System.out.println(value);
        value = value.trim().replace(".", "").replace("-", "");
        System.out.println(value);

        Integer.valueOf(value.substring(0, 1));

        System.out.println("aaa " + value);
    }

}
