package translator.business;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import translator.entities.LanguageP;

public class TranslatorImpl implements Translator {

    public Translate translate;

    private static TranslatorImpl instance;

    private static final String key = "AIzaSyBJ01MsImGXDFSe2WdGMdTe-CvevbTUPoc";

    public TranslatorImpl() {
        translate = TranslateOptions.newBuilder().setApiKey(key).build().getService();
    }

     /*synchronized public static TranslatorImpl getInstance() {
        if (instance == null) {
            instance = new TranslatorImpl();
        }

        return instance;
    }*/

    @Override
    public String translate(LanguageP from, LanguageP to, String text) {

        Translation translation = translate.translate(
                text,
                TranslateOption.sourceLanguage(from.getId()),
                TranslateOption.targetLanguage(to.getId()));

        String translated = translation.getTranslatedText();

        return translated;
    }

}
