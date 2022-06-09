package CarRental.utils;

import java.util.Scanner;

public class Utils {

    public static int getPageOption(int minRange, int maxRange) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(true) {
            try {
                option = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Apenas valores numérico");
            }
            if(option >= minRange && option <= maxRange){
                return option;
            }else{
                System.out.println("Opção inválida");
            }
        }
    }
}
