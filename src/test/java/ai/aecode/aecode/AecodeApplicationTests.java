package ai.aecode.aecode;

import ai.aecode.aecode.repositories.IScriptRepository;
import ai.aecode.aecode.services.IScriptService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;



@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class AecodeApplicationTests {

    @Autowired
    private IScriptService scriptService;

    @Autowired
    private IScriptRepository scriptRepository; // Opcional

    @Test
    void contextLoads() {
    }

}
