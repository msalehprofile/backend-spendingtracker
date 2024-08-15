package com.spendingTracker.SpendingTracker;

import org.hibernate.cache.spi.Region;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@SpringBootApplication()
public class SpendingTrackerApplication {

	public static void getSecret() {

		String secretName = "rds-username";
		Region region = Region.of("us-east-1");

		// Create a Secrets Manager client
		SecretsManagerClient client = SecretsManagerClient.builder()
				.region(region)
				.build();

		GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
				.secretId(secretName)
				.build();

		GetSecretValueResponse getSecretValueResponse;

		try {
			getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
		} catch (Exception e) {
			// For a list of exceptions thrown, see
			// https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
			throw e;
		}

		String secret = getSecretValueResponse.secretString();

		// Your code goes here.
	}

	public static void main(String[] args) {
		SpringApplication.run(SpendingTrackerApplication.class, args);


	}

}
