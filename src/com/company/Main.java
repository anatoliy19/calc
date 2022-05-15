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
            t = t.trim();
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
            t = t.trim();
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
        else if (result == 11) resultRome = "XI";
             else if (result == 12) resultRome = "XII";
             else if (result == 13) resultRome = "XIII";
             else if (result == 14) resultRome = "XIV";
             else if (result == 15) resultRome = "XV";
             else if (result == 16) resultRome = "XVI";
             else if (result == 17) resultRome = "XVII";
             else if (result == 18) resultRome = "XVIII";
             else if (result == 19) resultRome = "XIX";
             else if (result == 20) resultRome = "XX";
             else if (result == 21) resultRome = "XXI";
             else if (result == 22) resultRome = "XXII";
             else if (result == 23) resultRome = "XXIII";
             else if (result == 24) resultRome = "XXIV";
             else if (result == 25) resultRome = "XXV";
             else if (result == 26) resultRome = "XXVI";
             else if (result == 27) resultRome = "XXVII";
             else if (result == 28) resultRome = "XXVIII";
             else if (result == 29) resultRome = "XXIX";
             else if (result == 30) resultRome = "XXX";
             else if (result == 31) resultRome = "XXXI";
             else if (result == 32) resultRome = "XXXII";
             else if (result == 33) resultRome = "XXXIII";
             else if (result == 34) resultRome = "XXXIV";
             else if (result == 35) resultRome = "XXXV";
             else if (result == 36) resultRome = "XXXVI";
             else if (result == 37) resultRome = "XXXVII";
             else if (result == 38) resultRome = "XXXVIII";
             else if (result == 39) resultRome = "XXXIX";
             else if (result == 40) resultRome = "XL";
             else if (result == 41) resultRome = "XLI";
             else if (result == 42) resultRome = "XLII";
             else if (result == 43) resultRome = "XLIII";
             else if (result == 44) resultRome = "XLIV";
             else if (result == 45) resultRome = "XLV";
             else if (result == 46) resultRome = "XLVI";
             else if (result == 47) resultRome = "XLVII";
             else if (result == 48) resultRome = "XLVIII";
             else if (result == 49) resultRome = "XLIX";
             else if (result == 50) resultRome = "L";
             else if (result == 51) resultRome = "LI";
             else if (result == 52) resultRome = "LII";
             else if (result == 53) resultRome = "LIII";
             else if (result == 54) resultRome = "LIV";
             else if (result == 55) resultRome = "LV";
             else if (result == 56) resultRome = "LVI";
             else if (result == 57) resultRome = "LVII";
             else if (result == 58) resultRome = "LVIII";
             else if (result == 59) resultRome = "LIX";
             else if (result == 60) resultRome = "LX";
             else if (result == 61) resultRome = "LXI";
             else if (result == 62) resultRome = "LXII";
             else if (result == 63) resultRome = "LXIII";
             else if (result == 64) resultRome = "LXIV";
             else if (result == 65) resultRome = "LXV";
             else if (result == 66) resultRome = "LXVI";
             else if (result == 67) resultRome = "LXVII";
             else if (result == 68) resultRome = "LXVIII";
             else if (result == 69) resultRome = "LXIX";
             else if (result == 70) resultRome = "LXX";
             else if (result == 71) resultRome = "LXXI";
             else if (result == 72) resultRome = "LXXII";
             else if (result == 73) resultRome = "LXXIII";
             else if (result == 74) resultRome = "LXXIV";
             else if (result == 75) resultRome = "LXXV";
             else if (result == 76) resultRome = "LXXVI";
             else if (result == 77) resultRome = "LXXVII";
             else if (result == 78) resultRome = "LXXVIII";
             else if (result == 79) resultRome = "LXXIX";
             else if (result == 80) resultRome = "LXXX";
             else if (result == 81) resultRome = "LXXXI";
             else if (result == 82) resultRome = "LXXXII";
             else if (result == 83) resultRome = "LXXXIII";
             else if (result == 84) resultRome = "LXXXIV";
             else if (result == 85) resultRome = "LXXXV";
             else if (result == 86) resultRome = "LXXXVI";
             else if (result == 87) resultRome = "LXXXVII";
             else if (result == 88) resultRome = "LXXXVIII";
             else if (result == 89) resultRome = "LXXXIX";
             else if (result == 90) resultRome = "XC";
             else if (result == 91) resultRome = "XCI";
             else if (result == 92) resultRome = "XCII";
             else if (result == 93) resultRome = "XCIII";
             else if (result == 94) resultRome = "XCIV";
             else if (result == 95) resultRome = "XCV";
             else if (result == 96) resultRome = "XCVI";
             else if (result == 97) resultRome = "XCVII";
             else if (result == 98) resultRome = "XCVIII";
             else if (result == 99) resultRome = "XCIX";
             else if (result == 100) resultRome = "C";

            if (result < 1) throw new Exception("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
        System.out.println("результат = " + resultRome);
        }
    }




}