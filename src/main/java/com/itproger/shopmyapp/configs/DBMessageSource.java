package com.itproger.shopmyapp.configs;

import com.itproger.shopmyapp.models.Translation;
import com.itproger.shopmyapp.repo.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

    @Autowired
    private TranslationRepository translationRepository;

    private static final String DEFAULT_LOCALE_CODE = "ru";

    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {
        Translation prod = translationRepository.findByKeyAndLanguageLocale(key, locale.getLanguage()).orElse(new Translation());

        if (prod == null || prod.getProduct_name() == null || prod.getProduct_specification() == null) {
            return null;
        }
        return new MessageFormat(prod.getProduct_specification(), locale);
    }

}