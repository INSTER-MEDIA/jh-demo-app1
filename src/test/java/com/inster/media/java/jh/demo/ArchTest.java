package com.inster.media.java.jh.demo;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.inster.media.java.jh.demo");

        noClasses()
            .that()
            .resideInAnyPackage("com.inster.media.java.jh.demo.service..")
            .or()
            .resideInAnyPackage("com.inster.media.java.jh.demo.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.inster.media.java.jh.demo.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
