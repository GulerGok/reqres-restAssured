
# API Test Suite - Reqres API

Bu proje, **Reqres API**'yi test etmek için yazılmış bir test senaryosu içermektedir. Testler, **RestAssured** ve **TestNG** kullanılarak gerçekleştirilmiştir.

## İçindekiler

1. [Kurulum](#kurulum)
2. [Testler](#testler)
3. [Kullanım](#kullanım)
4. [Allure Raporları](#allure-raporları)
5. [Geliştirme Önerileri](#yapılabilecek-geliştirmeler)
6. [Lisans](#lisans)

---
# 1. Kurulum

Projeyi çalıştırmak için aşağıdaki adımları takip edebilirsiniz:

**Projeyi çalıştırmak için:**
```bash
   git clone https://github.com/GulerGok/reqres-restAssured.git
   cd reqres-restAssured
   mvn clean install
```

---
# 2. Testler

## TC01_getAllUsers ##
Tüm kullanıcıları almak için yapılan GET isteği testidir. Bu test, tüm kullanıcı adlarını toplar ve George kullanıcısının var olup olmadığını doğrular.

API Endpoint: /api/users?page={page}

Testler:

- Toplam yanıt süresi 2000ms'den uzun olmamalıdır.

- Tüm kullanıcı adları arasında "George" bulunmalıdır.

## TC02_getUsersPage1 ##
Sayfa 1'deki kullanıcıları almak için yapılan GET isteği testidir. Yanıtın içinde "George" kullanıcısının yer aldığı doğrulanır.

API Endpoint: /api/users?page=1

Testler:

- Yanıtın içeriğinde "George" kullanıcısı bulunmalıdır.

- Yanıt süresi 2000ms'den uzun olmamalıdır.

## TC03_getUserById ##
Belirli bir kullanıcıyı (ID: 2) almak için yapılan GET isteği testidir. Yanıtın status kodu ve içeriği doğrulanır.

API Endpoint: /api/users/{id}

Testler:

- Kullanıcı bilgileri doğru olmalıdır.

- Yanıt süresi 2000ms'den uzun olmamalıdır.

## TC04_register ##
Kullanıcı kayıt işlemi testidir. Geçerli bir e-posta ve şifre ile yapılan POST isteği sonucu doğrulama yapılır.

API Endpoint: /api/register

Testler:

- Kayıt işlemi başarılı olmalı ve bir token döndürmelidir.

- Yanıt süresi 2000ms'den uzun olmamalıdır.

## TC05_successfulLogin ##
Başarılı giriş işlemi testidir. Doğru kullanıcı adı ve şifre ile yapılan POST isteği sonucu doğrulama yapılır.

API Endpoint: /api/login

Testler:

- Başarılı giriş sonucu bir token döndürülmelidir.

- Yanıt süresi 2000ms'den uzun olmamalıdır.

## TC06_loginWithNoBody ##
Gövdesiz bir giriş isteği yapılır. Yanıtın 400 Bad Request olması beklenir.

API Endpoint: /api/login

Testler:

- Gövdesiz istek yapıldığında doğru hata mesajı döndürülmelidir (Missing email or username).

- Yanıt süresi 2000ms'den uzun olmamalıdır.

## TC07_registerWithoutEmailOrPassword ##
Eksik bilgiyle (email veya password olmadan) yapılan kayıt isteği testidir. 400 Bad Request yanıtı alınması beklenir.

API Endpoint: /api/register

Testler:

- Yanıt kodu 400 olmalıdır.

- Yanıt içinde "Missing password" mesajı yer almalıdır.

## TC08_loginWithInvalidEmail ##
Geçersiz e-posta ile yapılan giriş isteği testidir. 400 Bad Request yanıtı alınması beklenir.

API Endpoint: /api/login

Testler:

- Yanıt kodu 400 olmalıdır.

- Yanıt içinde "user not found" mesajı yer almalıdır.

## TC09_loginWithInvalidPassword ##
Geçersiz şifreyle yapılan giriş isteği testidir. 401 Unauthorized yanıtı alınması beklenir.

API Endpoint: /api/login

Testler:

- Yanıt kodu 401 olmalıdır.

- Yanıt içinde "Invalid credentials" mesajı yer almalıdır.

## TC10_createUser ##
Yeni bir kullanıcı oluşturmak için yapılan POST isteği testidir. Oluşturulan kullanıcının bilgileri doğrulanır.

API Endpoint: /api/users

Testler:

- Yanıt kodu 201 Created olmalıdır.

- Yanıt içeriğinde kullanıcı adı ve meslek bilgisi yer almalıdır.

## TC11_updateUser ##
Var olan bir kullanıcıyı güncellemek için yapılan PUT isteği testidir. Kullanıcı bilgileri güncellenir ve doğrulanır.

API Endpoint: /api/users/{id}

Testler:

- Kullanıcı bilgileri başarılı şekilde güncellenmelidir.

- Yanıt süresi 2000ms'den uzun olmamalıdır.

## TC12_deleteUser ##
Bir kullanıcıyı silmek için yapılan DELETE isteği testidir. Silme işlemi başarılı olmalıdır.

API Endpoint: /api/users/{id}

Testler:

- Yanıt kodu 204 No Content olmalıdır.

## TC13_delayedResponse ##
Gecikmeli bir yanıt almak için yapılan GET isteği testidir. API'den 3 saniye gecikmeli bir yanıt alınması beklenir.

API Endpoint: /api/users?delay=3

Testler:

- Yanıt kodu 200 OK olmalıdır.

---
# 3. Kullanım #
Projeyi çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

```bash
mvn test
```
TestNG yapılandırması src/test/resources/testng.xml dosyasındadır.

---
# 4. Allure Raporu
Testlerinizi çalıştırdıktan sonra Allure raporunu görmek için aşağıdaki adımları izleyebilirsiniz.

**Allure Raporunu Oluşturma:**
Test sonuçlarını topladıktan sonra Allure raporlarını oluşturmak için şu komutu kullanabilirsiniz:

```bash
mvn allure:report
```
**Allure Raporunu Sunma (Serve):**
Oluşturduğunuz raporu sunmak ve görüntülemek için aşağıdaki komutu kullanabilirsiniz:

```bash
mvn allure:serve
```
Bu komut, test sonuçlarınızı görselleştiren bir web sunucusu başlatır.

### Allure Raporu Kullanımı ###
   Testler çalıştıktan sonra Allure ile oluşturulan test sonuçları allure-results klasörüne yazılır. Bu klasör genellikle proje ana dizininde oluşur.

**Allure Raporunu Görüntülemek için:**

```bash
allure serve allure-results
```
Bu komut, geçici olarak bir web sunucusu başlatır ve varsayılan tarayıcınızda Allure test raporunu açar.

### Not: 
Eğer allure komutu tanınmıyor hatası alırsanız, Allure CLI aracını Allure Resmi Dokümantasyonu üzerinden sisteminize yüklemeniz gerekir.

### Maven Konfigürasyonu (Allure)
Raporda test sonuçlarını toplamak ve görselleştirmek için aşağıdaki pom.xml dosyasındaki konfigürasyonu kullanabilirsiniz:

```xml
<build>
<plugins>
<!-- Maven Surefire Plugin: Testlerinizi çalıştırmak için kullanılır -->
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>2.22.2</version>
<configuration>
<suiteXmlFiles>
<suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
</suiteXmlFiles>
</configuration>
</plugin>

        <!-- Allure Maven Plugin: Test sonuçlarını rapor halinde sunmak için kullanılır -->
        <plugin>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-maven</artifactId>
            <version>2.11.2</version>
            <executions>
                <execution>
                    <goals>
                        <goal>report</goal> <!-- Raporu oluşturacak -->
                    </goals>
                    <phase>verify</phase> <!-- Testlerin ardından çalışır -->
                </execution>
            </executions>
            <configuration>
                <!-- Test sonuçlarının bulunduğu dizini belirtin -->
                <resultsDirectory>${project.basedir}/allure-results</resultsDirectory>
                <!-- Oluşturulacak raporların dizini -->
                <reportDirectory>${project.build.directory}/allure-report</reportDirectory>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### Not:
allure-results dizini, test sonuçlarını içerir ve Allure raporları bu dizindeki verileri kullanarak raporları oluşturur. Bu dizin, ana proje dizininde veya target altında oluşturulabilir.

mvn allure:serve komutunu çalıştırarak, raporları yerel bir web sunucusunda görüntüleyebilirsiniz.

---
# 5. Yapılabilecek Geliştirmeler #
Daha fazla test eklenebilir: API'nin tüm uç noktaları için daha fazla test yazılabilir.

- Daha fazla uç nokta için kapsamlı testler eklenebilir.

- Yanıt verilerinde detaylı doğrulama (JSON schema, değer kontrolü).

- CI/CD entegrasyonu ile otomatik test ve rapor oluşturma (GitHub Actions, Jenkins).

- Allure etiketlemeleri (@Severity, @Feature, @Story) ile daha anlamlı raporlar.

---
# 6. Lisans #
Bu proje MIT lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakabilirsiniz.