package translator.business;

import translator.entities.LanguageP;

public interface Translator {

    public String translate(LanguageP from, LanguageP to, String text);
}
