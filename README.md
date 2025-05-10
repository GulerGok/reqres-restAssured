API Test Suite - Reqres API
Bu proje, Reqres API'yi test etmek için yazılmış bir test senaryosu içermektedir. Testler, RestAssured ve TestNG kullanılarak gerçekleştirilmiştir.

İçindekiler
Kurulum

Testler

TC01_getAllUsers

TC02_getUsersPage1

TC03_getUserById

TC04_register

TC05_successfulLogin

TC06_loginWithNoBody

TC07_registerWithoutEmailOrPassword

TC08_loginWithInvalidEmail

TC09_loginWithInvalidPassword

TC10_createUser

TC11_updateUser

TC12_deleteUser

TC13_delayedResponse

Kullanım

Yapılabilecek Geliştirmeler

Kurulum
Projeyi çalıştırmak için aşağıdaki adımları takip edebilirsiniz:

Git ile Projeyi Klonla

bash
Kopyala
Düzenle
git clone https://github.com/your-repository/reqres-api-tests.git
Maven ile Bağımlılıkları İndir
Proje için gerekli bağımlılıkları yüklemek için Maven kullanabilirsiniz:

bash
Kopyala
Düzenle
mvn clean install   
TestNG ile Testleri Çalıştır
Testleri çalıştırmak için:

bash
Kopyala
Düzenle
mvn test   
Bu komut, TestNG'nin sağladığı testng.xml dosyası üzerinden tüm testleri çalıştıracaktır.

Testler
TC01_getAllUsers
Tüm kullanıcıları almak için yapılan GET isteği testidir. Bu test, tüm kullanıcı adlarını toplar ve George kullanıcısının var olup olmadığını doğrular.

API Endpoint: /api/users?page={page}

Testler:

Toplam yanıt süresi 2000ms'den uzun olmamalıdır.

Tüm kullanıcı adları arasında "George" bulunmalıdır.

TC02_getUsersPage1
Sayfa 1'deki kullanıcıları almak için yapılan GET isteği testidir. Yanıtın içinde "George" kullanıcısının yer aldığı doğrulanır.

API Endpoint: /api/users?page=1

Testler:

Yanıtın içeriğinde "George" kullanıcısı bulunmalıdır.

Yanıt süresi 2000ms'den uzun olmamalıdır.

TC03_getUserById
Belirli bir kullanıcıyı (ID: 2) almak için yapılan GET isteği testidir. Yanıtın status kodu ve içeriği doğrulanır.

API Endpoint: /api/users/{id}

Testler:

Kullanıcı bilgileri doğru olmalıdır.

Yanıt süresi 2000ms'den uzun olmamalıdır.

TC04_register
Kullanıcı kayıt işlemi testidir. Geçerli bir e-posta ve şifre ile yapılan POST isteği sonucu doğrulama yapılır.

API Endpoint: /api/register

Testler:

Kayıt işlemi başarılı olmalı ve bir token döndürmelidir.

Yanıt süresi 2000ms'den uzun olmamalıdır.

TC05_successfulLogin
Başarılı giriş işlemi testidir. Doğru kullanıcı adı ve şifre ile yapılan POST isteği sonucu doğrulama yapılır.

API Endpoint: /api/login

Testler:

Başarılı giriş sonucu bir token döndürülmelidir.

Yanıt süresi 2000ms'den uzun olmamalıdır.

TC06_loginWithNoBody
Gövdesiz bir giriş isteği yapılır. Yanıtın 400 Bad Request olması beklenir.

API Endpoint: /api/login

Testler:

Gövdesiz istek yapıldığında doğru hata mesajı döndürülmelidir (Missing email or username).

Yanıt süresi 2000ms'den uzun olmamalıdır.

TC07_registerWithoutEmailOrPassword
Eksik bilgiyle (email veya password olmadan) yapılan kayıt isteği testidir. 400 Bad Request yanıtı alınması beklenir.

API Endpoint: /api/register

Testler:

Yanıt kodu 400 olmalıdır.

Yanıt içinde "Missing password" mesajı yer almalıdır.

TC08_loginWithInvalidEmail
Geçersiz e-posta ile yapılan giriş isteği testidir. 400 Bad Request yanıtı alınması beklenir.

API Endpoint: /api/login

Testler:

Yanıt kodu 400 olmalıdır.

Yanıt içinde "user not found" mesajı yer almalıdır.

TC09_loginWithInvalidPassword
Geçersiz şifreyle yapılan giriş isteği testidir. 401 Unauthorized yanıtı alınması beklenir.

API Endpoint: /api/login

Testler:

Yanıt kodu 401 olmalıdır.

Yanıt içinde "Invalid credentials" mesajı yer almalıdır.

TC10_createUser
Yeni bir kullanıcı oluşturmak için yapılan POST isteği testidir. Oluşturulan kullanıcının bilgileri doğrulanır.

API Endpoint: /api/users

Testler:

Yanıt kodu 201 Created olmalıdır.

Yanıt içeriğinde kullanıcı adı ve meslek bilgisi yer almalıdır.

TC11_updateUser
Var olan bir kullanıcıyı güncellemek için yapılan PUT isteği testidir. Kullanıcı bilgileri güncellenir ve doğrulanır.

API Endpoint: /api/users/{id}

Testler:

Kullanıcı bilgileri başarılı şekilde güncellenmelidir.

Yanıt süresi 2000ms'den uzun olmamalıdır.

TC12_deleteUser
Bir kullanıcıyı silmek için yapılan DELETE isteği testidir. Silme işlemi başarılı olmalıdır.

API Endpoint: /api/users/{id}

Testler:

Yanıt kodu 204 No Content olmalıdır.

TC13_delayedResponse
Gecikmeli bir yanıt almak için yapılan GET isteği testidir. API'den 3 saniye gecikmeli bir yanıt alınması beklenir.

API Endpoint: /api/users?delay=3

Testler:

Yanıt kodu 200 OK olmalıdır.

Kullanım
Projeyi çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

Testleri Çalıştırma: Maven veya IDE (IntelliJ IDEA, Eclipse) üzerinden TestNG testlerini çalıştırabilirsiniz.

bash
Kopyala
Düzenle
mvn test
Test Sonuçları: Testler tamamlandığında, konsolda her bir testin sonucu ve yanıt süreleri görüntülenir.

Yapılabilecek Geliştirmeler
Daha fazla test eklenebilir: API'nin tüm uç noktaları için daha fazla test yazılabilir.

Veri doğrulama: Yanıt içeriklerinin daha detaylı bir şekilde doğrulanması sağlanabilir.

Lisans
Bu proje MIT lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakabilirsiniz.

