import java.io.*;
import java.util.LinkedList;
import java.util.Arrays;
public class Gogol {
    public static void main(String[] args) {

        String[] roles = {"Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Аммос",
                "Фея",
                "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы Городничий: сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                };

        StringBuilder sum = new StringBuilder();


        for (int i = 0; i <= roles.length - 1; i++) { //цикл по ролям
            if (i==0) {
                sum.append(roles[i]+":"+"\n");
            }
            else {
                sum.append("\n"+roles[i]+":"+"\n");
            }
            for (int j = 0; j <= textLines.length - 1; j++) {  // цикл по строчкам
                if (textLines[j].startsWith(roles[i]+":")) {  // проверка на условие равна ли роль первой подстроки проверяемой строчки.
                    //if (sum.lastIndexOf(roles[i]+":") != -1) { // проверка на условие, есть ли уже роль в текстовой переменной, если есть то
//                        if (j!=textLines.length-1) { // для избавления от последнего Enter
//                            sum.append((j+1)+")"+textLines[j].substring(textLines[j].indexOf(":")+1) + "\n"); // добавление в переменную sum только строчки без роли
//                            continue; //для скорости
//                        }
//                        else {
//                            sum.append((j+1)+")"+textLines[j].substring(textLines[j].indexOf(":")+1)); // добавление в переменную sum только строчки без роли
//                            continue; //для скорости
//                        }
                    sum.append((j+1)+")"+ textLines[j].replaceFirst(roles[i]+":", "") + "\n" );
                    //}

//                    //else {
//                        if (i==0) { // условие на избавление от первого Enter
//                        sum.append(roles[i]+":" +"\n" + (j+1)+")"+textLines[j].replaceFirst(roles[i]+":", "") + "\n"); // если роли нет, то добавляем роль со строчкой
//                        }
//                        else if(j==textLines.length-1){
//                        sum.append("\n"+roles[i]+":" +"\n" + (j+1)+")"+textLines[j].replaceFirst(roles[i]+":", "")); // избавляемся от последнего энтера
//                        }
//                        else {
//                        sum.append("\n"+roles[i]+":" +"\n" + (j+1)+")"+ textLines[j].replaceFirst(roles[i]+":", "") + "\n"); // если роли нет, то добавляем роль со строчкой
//
//                        //}
                    }

                }
            }
        System.out.println(sum.toString());

        }
    }

