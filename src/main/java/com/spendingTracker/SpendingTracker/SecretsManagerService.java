package com.spendingTracker.SpendingTracker;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretsManagerService {

    private final SecretsManagerClient secretsManagerClient;

    public SecretsManagerService() {
        this.secretsManagerClient = SecretsManagerClient.builder().build();
    }

    public String getSecret(String secretName) {
        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse = secretsManagerClient.getSecretValue(getSecretValueRequest);
        return getSecretValueResponse.secretString();
    }
}
