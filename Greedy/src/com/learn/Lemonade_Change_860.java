package com.learn;

public class Lemonade_Change_860 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        int i = 0;
        while(i < bills.length){

            if(bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                if(five > 0){
                    five--;
                    ten++;
                }
                else{
                    return false;
                }
            }
            else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }
                else if(five >= 3)
                {
                    five = five-3;
                }
                else{
                    return false;
                }
            }

            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Lemonade_Change_860 l = new Lemonade_Change_860();
        System.out.println(l.lemonadeChange(new int[]{5 , 5 , 5, 10 , 20}));
    }
}
