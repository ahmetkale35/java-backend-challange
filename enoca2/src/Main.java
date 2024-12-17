import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static int findNumber(List<Integer> list1, List<Integer> list2) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < list2.size(); i++) {
            sum1 += list1.get(i);
            sum2 += list2.get(i);
        }
        sum1 += list1.get(list1.size() - 1);
        return sum1 - sum2;
    }


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {
            list1.add(random.nextInt(1000));
        }

        List<Integer> list2 = new ArrayList<>(list1);

        int rnd = random.nextInt(100);
        System.out.println("Chosen Number : " + list2.get(rnd));
        list2.remove(rnd);

        System.out.println(" \nDeleted Number is : " + findNumber(list1,list2));
        }
    }
