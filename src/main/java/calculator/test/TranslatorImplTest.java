package calculator.test;

import calculator.business.Translator;
import calculator.business.TranslatorImpl;
import calculator.entities.LanguageP;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TranslatorImplTest {
    Translator translator;
    LanguageP from;
    LanguageP to;

    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        from = new LanguageP("EN", "English");
        to = new LanguageP("ES", "Spanish");
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testTranslate() throws Exception {
        String response = translator.translate(from, to, "Hello World");
        Assert.assertEquals(response, "Hola Mundo");
    }

}