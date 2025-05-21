package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Anna", "Harbour", 29));
        people.add(new Person("Anna", "Collene", 29));
        people.add(new Person("John", "Doe", 34));
        people.add(new Person("Jane", "Smith", 28));
        people.add(new Person("Michael", "Brown", 45));
        people.add(new Person("Emily", "Davis", 22));
        people.add(new Person("Chris", "Wilson", 31));
        people.add(new Person("Sarah", "Taylor", 27));
        people.add(new Person("David", "Anderson", 39));
        people.add(new Person("Laura", "Thomas", 33));
        people.add(new Person("James", "Jackson", 40));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name to search");
        String nameToSearch = scanner.nextLine().trim();
        List<Person> matches =
                people.stream().filter(person -> person.getFirstName().equalsIgnoreCase(nameToSearch)).toList();
        int ages[] = matches.stream().mapToInt(Person::getAge).sorted().toArray();
        int oldestAge = ages[ages.length - 1];
        int youngestAge = ages[0];
        double avgAge = (double) Arrays.stream(ages).sum() / ages.length;
        System.out.printf("Youngest Age in Matches: %d\nOldest Age in Matches: %d\nAverage Age: %.2f", youngestAge,
                oldestAge, avgAge);
    }
}