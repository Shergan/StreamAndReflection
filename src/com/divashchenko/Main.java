package com.divashchenko;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(10));
        }

        double ans = 0;
        for (Integer integer : list) {
            ans += (integer * integer);
        }
        ans /= list.size();
        System.out.println("Standard method: " + ans);


        System.out.println(list);


        Double answer = list
                .stream()
                .map(x -> Math.pow(x, 2) / list.size())
                .reduce(0.0, (x1, x2) -> x1 + x2);

        System.out.println("Stream method: " + answer);
        System.out.println();


        //Reflection
        String className = "test3";
        TestReflection testReflection = new TestReflection();

        try {
            Method method = testReflection.getClass().getDeclaredMethod(className);
            method.invoke(testReflection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
