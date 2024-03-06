package com.Ritik.ProducerConsumer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class App {

    static {
        // Initialize Log4j configuration
        Configurator.initialize(null, "src/main/resources/log4j2.xml");
    }

    private static final Logger logger = LogManager.getLogger(App.class);
    private static final Queue<PassengerDetails> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        int producerThreadCount = 3;
        int consumerThreadCount = 2;

        for (int i = 0; i < producerThreadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        PassengerDetails passenger = generatePassenger();
                        produce(passenger);
                    }
                }
            }).start();
        }

        for (int i = 0; i < consumerThreadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        consume();
                    }
                }
            }).start();
        }
    }

    private static PassengerDetails generatePassenger() {
        Random rand = new Random();
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Harry", "Ivy", "Jack"};
        String name = names[rand.nextInt(names.length)];
        int age = rand.nextInt(80) + 1;
        String gender = rand.nextBoolean() ? "Male" : "Female";
        return new PassengerDetails(name, age, gender);
    }

    private static void produce(PassengerDetails passenger) {
        synchronized (priorityQueue) {
            if (passenger.getAge() > 60) {
                priorityQueue.add(passenger);
                logger.info("Priority Request Produced: {}", passenger);
            } else {
                priorityQueue.add(passenger);
                logger.info("Regular Request Produced: {}", passenger);
            }
            priorityQueue.notifyAll();
        }
        sleep(1000);
    }

    private static void consume() {
        synchronized (priorityQueue) {
            while (priorityQueue.isEmpty()) {
                try {
                    priorityQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    logger.error("InterruptedException while waiting: {}", e.getMessage());
                }
            }

            PassengerDetails passenger = priorityQueue.poll();

            try {
                String fileName;
                String fileName1;

                if (passenger.getAge() < 10) {
                    return;
                } else if (passenger.getAge() < 60) {
                    fileName = "D://FileHandling//NormalCitizen.txt";
                } else {
                    fileName = "D://FileHandling//SeniorCitizen.txt";
                }

                if ("Male".equals(passenger.getGender())) {
                    fileName1 = "D://FileHandling//Male.txt";
                } else {
                    fileName1 = "D://FileHandling//Female.txt";
                }
                
                
                // Additional details for logging
                String status ="accepted";
                long startTime= System.currentTimeMillis();
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String timestamp= dateFormat.format(new Date());

                try (FileWriter fileWriter = new FileWriter(fileName, true);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                     bufferedWriter.write(String.format("Name: %s, Age: %d, Gender: %s, Status: %s, " + "Time taken: %d ms, Timestamp: %s\n", passenger.getName(),passenger.getAge(),passenger.getGender(),status,System.currentTimeMillis()-startTime,timestamp));
                    logger.info("Content is successfully written to the file: {}", fileName);
                } catch (IOException e) {
                    logger.error("Unexpected error occurred: {}", e.getMessage());
                    e.printStackTrace();
                }

                try (FileWriter fileWriter = new FileWriter(fileName1, true);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                     bufferedWriter.write(String.format("Name: %s, Age: %d, Gender: %s, Status: %s, " + "Time taken: %d ms, Timestamp: %s\n", passenger.getName(),passenger.getAge(),passenger.getGender(),status,System.currentTimeMillis()-startTime,timestamp));
                    logger.info("Content is successfully written to the file: {}", fileName1);
                } catch (IOException e) {
                    logger.error("Unexpected error occurred: {}", e.getMessage());
                    e.printStackTrace();
                }

            } finally {
                logger.info("Consumed: {}", passenger);
            }

            sleep(1500);
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("InterruptedException while sleeping: {}", e.getMessage());
        }
    }

    private static class PassengerDetails implements Comparable<PassengerDetails> {
        private final String name;
        private final int age;
        private final String gender;

        public PassengerDetails(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }
        public String getName() {
            return gender;
        }

        @Override
        public String toString() {
            return "PassengerDetails{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }

        @Override
        public int compareTo(PassengerDetails other) {
            return Integer.compare(this.age, other.age);
        }
    }
}
