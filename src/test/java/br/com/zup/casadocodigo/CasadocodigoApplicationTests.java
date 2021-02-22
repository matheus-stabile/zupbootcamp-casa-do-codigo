package br.com.zup.casadocodigo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
