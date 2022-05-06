@echo off
cls
cd build
del key.cer.pem
del key.key.pem
del keystore.jks
del keystore.p12
"C:\Program Files\AdoptOpenJDK\jdk-11.0.11.9-openj9\bin\keytool.exe" -keystore keystore.jks -alias sampleAlias -genkeypair -keyalg RSA -keysize 4096 -validity 3 -dname "CN=localhost, OU=ktor, O=ktor, L=Unspecified, ST=Unspecified, C=US" -ext "SAN:c=DNS:localhost,IP:127.0.0.1"
"C:\Program Files\AdoptOpenJDK\jdk-11.0.11.9-openj9\bin\keytool.exe" -importkeystore -srckeystore keystore.jks -destkeystore keystore.p12 -deststoretype PKCS12
openssl pkcs12 -in keystore.p12 -nokeys -out key.cer.pem
openssl pkcs12 -in keystore.p12 -nodes -nocerts -out key.key.pem
cd ..
exit