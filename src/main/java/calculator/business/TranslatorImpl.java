package calculator.business;

import calculator.entities.LanguageP;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.HashMap;
//import java.util.List;


public class TranslatorImpl implements Translator {
    public Translate translate;

    private static final String key = "AIzaSyBJ01MsImGXDFSe2WdGMdTe-CvevbTUPoc";

    public TranslatorImpl()
    {
        translate = TranslateOptions.newBuilder().setApiKey(key).build().getService();
    }

    @Override
    public String translate(LanguageP from, LanguageP to, String text) {

        HashMap<String, String> translateMap = new HashMap<String, String>();

        if(translateMap.get(text)==null) {
            Translation translation = translate.translate(
                text,
                TranslateOption.sourceLanguage(from.getId()),
                TranslateOption.targetLanguage(to.getId()));

            translateMap.put(text,translation.getTranslatedText());
        }

        return translateMap.get(text);
    }
}

