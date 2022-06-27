package com.itproger.shopmyapp.repo;

import com.itproger.shopmyapp.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Language findLanguageByLocale(String locale);

    boolean existsByLocale(String locale);
}
