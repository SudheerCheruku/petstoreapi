package com.pet.store.apitest.service;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.util.Random;

public class EmailGeneratorService {
    Random rand = new Random();
    int rand_int1 = rand.nextInt(100000);

    public final String EMAIL_TEMPLATE = Faker.instance().name().lastName().concat("_")
            .concat(String.valueOf(rand_int1)).concat("@gmail.com");


    public String generate() {
        return String.format(EMAIL_TEMPLATE, Instant.now().toEpochMilli());
    }
}