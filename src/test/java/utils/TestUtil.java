package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import io.qameta.allure.AllureLifecycle;

public class TestUtil {

    public static void checkPerformance(long responseTime, long thresholdMs) {
        String message = "Yanıt süresi: " + responseTime + " ms";
        System.out.println(message);
        Allure.addAttachment("Yanıt Süresi", "text/plain", message, ".txt");

        if (responseTime > thresholdMs) {
            String warning = "⚠️ Yanıt süresi sınırı aşıldı: " + responseTime + " ms > " + thresholdMs + " ms";
            System.out.println(warning);
            Allure.addAttachment("Performans Uyarısı", "text/plain", warning, ".txt");

            // Performans testi önerilenler için özel etiket
            Allure.getLifecycle().updateTestCase(testResult -> {
                testResult.getLabels().add(new Label().setName("performance").setValue("needs-check"));
            });

        } else {
            String success = "✅ Yanıt süresi sınır içinde.";
            System.out.println(success);
            Allure.addAttachment("Performans Durumu", "text/plain", success, ".txt");
        }
    }
}
