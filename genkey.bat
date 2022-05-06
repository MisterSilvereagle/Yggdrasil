cd build
del key.cer.pem
del key.key.pem
del keystore.jks
del keystore.p12
keytool -keystore keystore.jks -alias sampleAlias -genkeypair -keyalg RSA -keysize 4096 -validity 3 -dname 'CN=localhost, OU=ktor, O=ktor, L=Unspecified, ST=Unspecified, C=US'
keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.p12 -deststoretype PKCS12
openssl pkcs12 -in keystore.p12 -nokeys -out key.cer.pem
openssl pkcs12 -in keystore.p12 -nodes -nocerts -out key.key.pem