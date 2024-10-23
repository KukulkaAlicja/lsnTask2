package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputsChangedToInt = new ArrayList<>();
        List<List<Integer>> pairsWhichGetTarget = new ArrayList<>();
        int target = 13;

        System.out.println("Task 2");
        System.out.println("Please enter input numbers separated by comma");
        String inputData = scanner.nextLine();
        String[] singleInputs = inputData.split(",");

        changeInputOfStringToInt(singleInputs, inputsChangedToInt);

        int numberOfElements = inputsChangedToInt.size();

        findPairsWhichGetTarget(numberOfElements,target, inputsChangedToInt, pairsWhichGetTarget);

        for (List<Integer> pairWhichGetTarget : pairsWhichGetTarget) {
            System.out.println(pairWhichGetTarget.get(0) + " " + pairWhichGetTarget.get(1));
        }
        scanner.close();
    }

    private static void changeInputOfStringToInt(String[] singleInputs, List<Integer> inputsChangedToInt) {
        for (String singleInput : singleInputs) {
            try {
                inputsChangedToInt.add(Integer.parseInt(singleInput));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value: " + "'" + singleInput + "'" + " Couldn't be parse to an integer");
            }
        }
    }

    private static void findPairsWhichGetTarget(int numberOfElements, int target, List<Integer> inputsChangedToInt, List<List<Integer>> pairsWhichGetTarget) {
        for (int i = 0; i < numberOfElements; i++) {
            for (int j = i + 1; j < numberOfElements; j++) {
                if (inputsChangedToInt.get(i) + inputsChangedToInt.get(j) == target) {
                    if (inputsChangedToInt.get(i) > inputsChangedToInt.get(j))
                        pairsWhichGetTarget.add(Arrays.asList(inputsChangedToInt.get(j), inputsChangedToInt.get(i)));
                    else
                        pairsWhichGetTarget.add(Arrays.asList(inputsChangedToInt.get(i), inputsChangedToInt.get(j)));
                }
            }
        }
    }
}