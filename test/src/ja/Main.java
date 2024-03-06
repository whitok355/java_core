package ja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<People> peoples = new ArrayList();
        Scanner scan  = new Scanner(System.in);
        System.out.println("Please enter quantity workers to generation");
        int quantity = scan.nextInt();

        for(int i = 0 ; i < quantity; i++){
            peoples.add(Generator.generateWorkers(peoples.size()));
        }

        Viewer.showAll(peoples);

    }
}
