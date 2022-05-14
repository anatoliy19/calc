package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваши числа от 1 до 10 и мат.операцию:");

        String ReadString =  scanner.nextLine();
        long count_plus   =  ReadString.chars().filter(ch -> ch == '+').count();
        long count_minus  =  ReadString.chars().filter(ch -> ch == '-').count();
        long count_mult   =  ReadString.chars().filter(ch -> ch == '*').count();
        long count_div    =  ReadString.chars().filter(ch -> ch == '/').count();

        if (count_plus > 1 || count_minus > 1 || count_mult > 1 || count_div > 1) {throw new Exception("Можно ввести не более одного знака операции");}

        if (!ReadString.contains("+") && !ReadString.contains("-") && !ReadString.contains("*") && !ReadString.contains("/"))
            throw new Exception("Введите один из операторов: +,-,*,/");

        String[] signs = ReadString.split("\\s*(\\+|-|\\*|/)");
        //проверки
        String ArabianString = "12345678910";
        Boolean IsArabian = false;
        String RomeString = "IIIIIIIIIIVIIIX";
        Boolean IsRome = false;

        for (String t : signs) {
            if (ArabianString.contains(t) && IsArabian == false) {
                IsArabian = true;
                continue;
            }
            if (!ArabianString.contains(t) && IsArabian == true) throw new Exception("Должны быть обе арабские цифры");
            if (RomeString.contains(t) && IsRome == false) {
                IsRome = true;
                continue;
            }
            if (!RomeString.contains(t) && IsRome == true) throw new Exception("Должны быть обе римские цифры");

            String firstLetter = String.valueOf(t.charAt(0));  //Rome > 10
            if (RomeString.contains(t) && t.length() > 1 && t.contains("X") && firstLetter.equals("X"))
                throw new Exception("Число больше 10");
            if (t.length() > 10) throw new Exception("Число больше 10");
            if (!ArabianString.contains(t) && (!RomeString.contains(t)))
                throw new Exception("Введен неверный символ " + t);
        }
        //подсчет
        int number1 = 0;
        int number2 = 0;
        for (String t: signs) {
            if (number1 == 0){
                if (IsArabian) {number1 = Integer.parseInt(t); continue;}
                if (IsRome) {
                    if (t.equals("I"))   number1 = 1;
                    else if (t.equals("II"))  number1 = 2;
                    else if (t.equals("III")) number1 = 3;
                    else if (t.equals("IV"))  number1 = 4;
                    else if (t.equals("V"))   number1 = 5;
                    else if (t.equals("VI")) number1 = 6;
                    else if (t.equals("VII")) number1 = 7;
                    else if (t.equals("VIII")) number1 = 8;
                    else if (t.equals("IX")) number1 = 9;
                    else if (t.equals("X")) number1 = 10;
                    continue;
                }
            }
            if (number2 == 0 && IsArabian) number2 = Integer.parseInt(t);
            if (number2 == 0 && IsRome){
                 if (t.equals("I"))   number2 = 1;
            else if (t.equals("II"))   number2 = 2;
            else if (t.equals("III"))   number2 = 3;
            else if (t.equals("IV"))   number2 = 4;
            else if (t.equals("V"))   number2 = 5;
            else if (t.equals("VI"))   number2 = 6;
            else if (t.equals("VII"))   number2 = 7;
            else if (t.equals("VIII"))   number2 = 8;
            else if (t.equals("IX"))   number2 = 9;
            else if (t.equals("X"))   number2 = 10;
              }
            }
        int result = 0;
        if (ReadString.contains("+")) result = number1 + number2;
        if (ReadString.contains("-")) result = number1 - number2;
        if (ReadString.contains("*")) result = number1 * number2;
        if (ReadString.contains("/")) result = number1 / number2;
        //вывод
        if (IsArabian) System.out.println("результат = " + result);
        if (IsRome) {
          String resultRome = "";
             if (result == 1) resultRome = "I";
        else if (result == 2) resultRome = "II";
        else if (result == 3) resultRome = "III";
        else if (result == 4) resultRome = "IV";
        else if (result == 5) resultRome = "V";
        else if (result == 6) resultRome = "VI";
        else if (result == 7) resultRome = "VII";
        else if (result == 8) resultRome = "VIII";
        else if (result == 9) resultRome = "IX";
        else if (result == 10) resultRome = "X";
        if (result < 1) throw new Exception("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
        System.out.println("результат = " + resultRome);
        }
    }
}