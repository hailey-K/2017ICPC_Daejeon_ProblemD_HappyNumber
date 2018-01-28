package problemd_happynumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2017 ACM-ICPC Daejeon Regional Problem D - Happy Number Date : Jan 27th 2018
 * Name : Hailey Kim
 */
public class ProblemD_HappyNumber {

    public static void main(String[] args) {
        System.out.println("Please enter number.");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        String[] splitedNumber = numbers.split("");
        int[] number = new int[splitedNumber.length];
        List resultList = new ArrayList();
        boolean loopCheck = true;
        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(splitedNumber[i]);
        }

        while (loopCheck) {
         int sum = sumNumber(number);
         resultList.add(sum);
         number =  splitedNumber(sum);
        
            if (sum == 1) {
                loopCheck = false;
                System.out.println("HAPPY");
            } else if (checkIfSameNumberInList(resultList)) 
            {
                loopCheck = false;
                System.out.println("UNHAPPY");
            }

        }
    }
   public static int[] splitedNumber(int sum)
   {
        String numbers = Integer.toString(sum);
        String[] splitedNumber = numbers.split("");
        int[] number = new int[splitedNumber.length];
         for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(splitedNumber[i]);
        }
        return number;
   }
public static int sumNumber(int[] number) {
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += Math.pow(number[i], 2);
        }
        return sum;
    }

    public static boolean checkIfSameNumberInList(List numbersList) {
        boolean check = false;
        for (int i = 0; i < numbersList.size(); i++) {
            for (int j = 0; j < numbersList.size(); j++) {
                if (numbersList.get(i) == numbersList.get(j) && i!=j) {
                    check = true;
                }
            }
        }
        return check;
    }
}
