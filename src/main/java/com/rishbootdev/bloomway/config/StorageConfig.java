package com.rishbootdev.bloomway.config;


import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "minio")
@Data
public class StorageConfig {

    private String url;
    private String accessKey;
    private String secretKey;

    @Bean
    public MinioClient minioClient() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        log.info("the connection with the minio established successfully");

        MinioClient client = MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();

        log.warn("The springboot server is going to connect the minio client :{}",client.listBuckets().getFirst().creationDate());

        return client;
    }
}

