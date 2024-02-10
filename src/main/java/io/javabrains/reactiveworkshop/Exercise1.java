package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
//        StreamSources.intNumbersStream().forEach(System.out::println);
        printStream(StreamSources.intNumbersStream());

        // Print numbers from intNumbersStream that are less than 5
//        StreamSources.intNumbersStream().filter(n -> n < 5).forEach(System.out::println);
        printStream(StreamSources.intNumbersStream().filter(n -> n < 5));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        printStream(StreamSources.intNumbersStream().filter(n -> n > 5)
                .skip(1)
                .limit(2));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        printStream(StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .findFirst()
                .orElse(-1)
        );

        // Print first names of all users in userStream
        printStream(StreamSources.userStream().map(user -> user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        printStream(StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> String.format("%s %s", user.getFirstName(), user.getLastName())));

    }

    private static void printStream(Stream s) {
        System.out.println("-*-*-*-*-*-*-*-*-*-");
        s.forEach(System.out::println);
    }

    private static void printStream(int s) {
        System.out.println("-*-*-*-*-*-*-*-*-*-");
        System.out.println(s);
    }

}
