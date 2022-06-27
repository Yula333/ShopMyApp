package com.itproger.shopmyapp.repo;

import com.itproger.shopmyapp.models.Translation;
import com.itproger.shopmyapp.projections.TranslationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TranslationRepository extends JpaRepository<Translation, Integer> {

    Optional<Translation> findByKeyAndLanguageLocale(String key, String locale);
    boolean existsByKeyAndLanguageLocale(String key, String locale);

    @Query(value =
            "SELECT \"translate_key\",\n" +
                    "       MAX(CASE WHEN (\"locale\"='1') THEN \"product_specification\" ELSE null END ) AS content_ru," +
                    "       MAX(CASE WHEN (\"locale\"='2') THEN \"product_specification\" ELSE null END ) AS content_en," +
                    "       MAX(CASE WHEN (\"locale\"='1') THEN \"translation_id\" ELSE null END ) AS id_ru," +
                    "       MAX(CASE WHEN (\"locale\"='2') THEN \"translation_id\" ELSE null END ) AS id_en " +
                    "FROM \"translations\" GROUP BY \"translate_key\";", nativeQuery = true)
    List<TranslationProjection> getAllTranslationsWithLocaleAndId();
}

