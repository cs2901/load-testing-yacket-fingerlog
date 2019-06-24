package calculator.business;

import calculator.entities.LanguageP;

public interface Translator {

    public String translate(LanguageP from, LanguageP to, String text);
}
