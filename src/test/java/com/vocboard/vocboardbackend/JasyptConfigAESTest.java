package com.vocboard.vocboardbackend;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.Test;

@Slf4j
public class JasyptConfigAESTest {

    private final String databaseUrl = "jdbc:mysql://localhost:3306/vocboard-database?serverTimezone=UTC&characterEncoding=UTF-8&useSSL=false";
    private final String username = "root";
    private final String password = "verysecret";
    private final String iamAccessKey = "AKIAS6L4O77C36HH6K64";
    private final String iamSecretKey = "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";
    private final String bucket = "hackfestival";

    @Test
    void stringEncryptor() {

        log.info("databaseUrl : {}", jasyptEncoding(databaseUrl));
        log.info("username : {}", jasyptEncoding(username));
        log.info("password : {}", jasyptEncoding(password));
        log.info("iamAccessKey : {}", jasyptEncoding(iamAccessKey));
        log.info("iamSecretKey : {}", jasyptEncoding(iamSecretKey));
        log.info("bucket : {}", jasyptEncoding(bucket));
    }

    public String jasyptEncoding(String value) {

        String key = "my_jasypt_key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        pbeEnc.setPassword(key);
        pbeEnc.setIvGenerator(new RandomIvGenerator());
        return pbeEnc.encrypt(value);
    }
}
