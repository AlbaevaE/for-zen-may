package com.company;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {  //Добавляем исключение

        FileReader inputFile = new FileReader("input.txt");//адрес для прочтения файла
        FileReader patternsFile = new FileReader("patterns.txt");

        Scanner sc = new Scanner(inputFile);//Передаем ссылку для считывания
        Scanner sc2 = new Scanner(patternsFile);

        List<String> input = new ArrayList<>();//Создаем ArrayList тип элемента String
        List<Pattern> patterns = new ArrayList<>();//ArrayList тип элемента класс Pattern(чтобы работать с регулярными выражениями создадим объект класса Pattern)

        String text1 = "";
        String text2 = "";
        while (sc.hasNextLine()) { //Проверяем, имеется ли в файле еще одна строка
            text1 = sc.nextLine(); //Считываем данные
            input.add(text1);      //ложим данные в лист
        }
        inputFile.close();         //закрываем поток

        while (sc2.hasNextLine()) {
            text2 = sc2.nextLine();
            if (text1.equals(text2)) {                //сравниваем строки
                System.out.println("1: " + text1);    //если есть соответсвие, выводим
            }
            patterns.add(Pattern.compile(text2));     //для создания объекта класса Pattern вызываем статический метод compile и передаем text2. Ложим данные в лист
        }
        patternsFile.close();                        //закрываем поток

        patterns.forEach(pattern -> {
            input.forEach(file -> {
                boolean coincide = pattern.matcher(file).find();  //проверяем на соответсвие, есть ли в строке подстрока
                if (coincide) {                                   //если есть
                    System.out.println("2: " + file + " ");                 //выводим
                }


            });

        });

    }
}
