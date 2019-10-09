package ru.ifmo;

import ru.ifmo.task10.MoneyConverter;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
//        main.taskOne();
//        main.taskTwo();
//        main.taskThree();
//        main.taskFour();
//        main.taskSix();
//        main.taskSeven();
        main.taskTen();

    }

    private void taskOne() {
        int a = 7, b = 10;
        int result = a * b;
        System.out.println(result);
    }

    private void taskTwo() {
        String s1 = "Hello", s2 = ", ", s3 = "World", s4 = "!";
        System.out.println(s1 + s2 + s3 + s4);
        Arrays.asList(s1, s2, s3, s4).forEach(System.out::println);
    }

    private void taskThree() {
        String s1, s2, s3, s4, s5;
        Scanner in = new Scanner(System.in);
        s1 = in.nextLine();
        s2 = in.nextLine();
        s3 = in.nextLine();
        s4 = in.nextLine();
        s5 = in.nextLine();
        List<String> inputLines = Arrays.asList(s1, s2, s3, s4, s5);
        List<String> output = inputLines.stream().filter(i -> Collections.frequency(inputLines, i) > 1)
                .collect(Collectors.toList());
        if (output.size() > 0) output.forEach(System.out::println);
        else System.out.println("Все разные");
    }


    private void taskFour() {
        textPrinterForTaskFourAndFive();
        Scanner in = new Scanner(System.in);
        try {
            int points = in.nextInt();
            if (points > -1 && points < 60)
                System.out.println("Оценка 2");
            if (points > 59 && points < 75)
                System.out.println("Оценка 3");
            if (points > 74 && points < 91)
                System.out.println("Оценка 4");
            if (points > 90 && points < 101)
                System.out.println("Оценка 5");
            else
                System.out.println("Оценка не определена");
        } catch (InputMismatchException e) {
            System.out.println("Input value isn't a number");
        }

    }

    private void taskFive() {
        textPrinterForTaskFourAndFive();
        Scanner in = new Scanner(System.in);
        try {
            int points = in.nextInt();
            int caseNumber = 0;
            if (points > -1 && points < 60)
                caseNumber = 2;
            if (points > 59 && points < 75)
                caseNumber = 3;
            if (points > 74 && points < 91)
                caseNumber = 4;
            if (points > 90 && points < 101)
                caseNumber = 5;
            switch (caseNumber) {
                case 2:
                    System.out.println("Оценка 2");
                    break;
                case 3:
                    System.out.println("Оценка 3");
                    break;
                case 4:
                    System.out.println("Оценка 4");
                    break;
                case 5:
                    System.out.println("Оценка 5");
                    break;
                default:
                    System.out.println("Оценка не определена");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input value isn't a number");
        }

    }

    private void textPrinterForTaskFourAndFive() {
        String text = new Scanner(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("taskfour.txt")), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        System.out.println(text);
        System.out.println("Введите кол-во баллов:");
    }

    private void taskSix() {
        List<Double> inputNumbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Input values line by line");
        try {
            for (int i = 0; i < 15; i++)
                inputNumbers.add(in.nextDouble());
        } catch (InputMismatchException e) {
            System.out.println("Input value isn't a number");
        }
        Collections.sort(inputNumbers);
        inputNumbers.forEach(System.out::println);
    }

    private void taskSeven() {
        int[] testArray = {1, 2, 3, 4, 5, 6};
        try {
            int exceptionValue = testArray[6];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }

    private void taskTen() {
        System.out.println(new MoneyConverter().convertFromRubli(16, "Euro"));
    }

}
