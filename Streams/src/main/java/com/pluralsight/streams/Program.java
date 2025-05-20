package com.pluralsight.streams;

import java.util.ArrayList;
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

        System.out.println("Enter a name: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name to search");
        String nameToSearch = scanner.nextLine().trim();
        List<Person> matches =
                people.stream().filter(person -> person.getFirstName().equalsIgnoreCase(nameToSearch)).toList();
        int ageSum = 0;
        int totalMatches = matches.size();
        int oldestAge = matches.get(0).getAge();
        int youngestAge = matches.get(0).getAge();
        for (Person match : matches) {
            System.out.println(match);
            int age = match.getAge();
            ageSum += age;
            if (age > oldestAge) {
                oldestAge = age;
            } else if (age < youngestAge) {
                youngestAge = age;
            }
        }
        int avgAge = ageSum / totalMatches;
        System.out.printf("Youngest Age in Matches: %d\nOldest Age in Matches: %d\nAverage Age: %d", youngestAge,
                oldestAge, avgAge);
    }
}