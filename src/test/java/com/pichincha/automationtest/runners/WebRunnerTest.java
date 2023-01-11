package com.pichincha.automationtest.runners;

import com.pichincha.automationtest.util.*;
import io.cucumber.junit.CucumberOptions;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@RunWith(CustomCucumberWithSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.pichincha.automationtest.hooks", "com.pichincha.automationtest.glue"},
        plugin = "json:build/cucumber-reports/json/cucumber.json",
        tags = "not @karate and not @ManualTest and not @Mobiletest"
)

public class WebRunnerTest {
    private static final EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    private WebRunnerTest() {
    }

    private static final String ALL_FEATURES = "todos";
    private static final String EXTENSION_FEATURE = ".feature";

    @BeforeSuite
    public static void init() throws IOException {
        String featureName = variables.getProperty("featureName");
        PathConstants.featurePath();
        String[] features = getFeaturesNames(featureName);
        for (String feature : features) {
            if (!feature.contains(EXTENSION_FEATURE)) {
                feature += EXTENSION_FEATURE;
            }
            FeatureOverwrite.overwriteFeatureFileAdd(feature);
        }
    }

    public static String[] getFeaturesNames(String featureName) {
        String[] features;
        if (featureName.equalsIgnoreCase(ALL_FEATURES)) {
            File featureFolder = new File(PathConstants.featurePath());
            features = featureFolder.list();
        } else {
            features = featureName.split(";");
        }
        return features;
    }

    @AfterSuite
    public static void after() throws IOException {
        String featureName = variables.getProperty("featureName");
        String[] features = getFeaturesNames(featureName);
        for (String feature : features) {
            if (!featureName.equals(ALL_FEATURES)) {
                feature += EXTENSION_FEATURE;
            }
            FeatureOverwrite.overwriteFeatureFileRemove(feature);
        }
    }
}
