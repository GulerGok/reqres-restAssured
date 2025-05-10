package utils;

public class TestUtil {

    /**
     * Yanıt süresini kontrol eder ve sınırın aşılması durumunda uyarı mesajı basar.
     *
     * @param responseTime Yanıt süresi (ms)
     * @param thresholdMs  Kabul edilebilir maksimum süre (ms)
     */
    public static void checkPerformance(long responseTime, long thresholdMs) {
        System.out.println("Yanıt süresi: " + responseTime + " ms");

        if (responseTime > thresholdMs) {
            System.out.println("⚠️ Yanıt süresi " + thresholdMs + "ms sınırını aşıyor. Performans testi önerilir.");
        } else {
            System.out.println("✅ Yanıt süresi kabul edilebilir düzeyde.");
        }
    }
}
