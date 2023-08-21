package com.example.demo;

import java.lang.reflect.Field;

public class JsonReadingApplication {

        public static <T> T readValue(String json, Class<T> valueType) {
                try {
                        json = json.trim();
                        if (!json.startsWith("{") || !json.endsWith("}")) {
                                throw new IllegalArgumentException("Invalid JSON format");
                        }

                        json = json.substring(1, json.length() - 1);
                        String[] keyValuePairs = json.split(",");

                        T instance = valueType.getDeclaredConstructor().newInstance();

                        for (String keyValuePair : keyValuePairs) {
                                String[] parts = keyValuePair.split(":");
                                String key = parts[0].trim().replaceAll("\"", ""); // Remove double quotes
                                String value = parts[1].trim().replaceAll("\"", "");

                                Field field = valueType.getDeclaredField(key);
                                field.setAccessible(true);

                                Class<?> fieldType = field.getType();
                                if (fieldType == String.class) {
                                        field.set(instance, value);
                                } else if (fieldType == int.class || fieldType == Integer.class) {
                                        field.set(instance, Integer.parseInt(value));
                                }
                        }

                        return instance;
                } catch (Exception e) {
                        throw new RuntimeException("Error reading value: " + e.getMessage(), e);
                }
        }

        public static void main(String[] args) {
                String json = "{\"name\": \"Deepak\", \"age\": 20}";
                Person person = readValue(json, Person.class);

                System.out.println("Name: " + person.getName()); // Output: John
                System.out.println("Age: " + person.getAge());   // Output: 30
        }
}
