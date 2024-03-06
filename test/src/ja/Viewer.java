package ja;

import java.util.List;

public class Viewer {

    private static String getClassName(People people){
        String className = people.getClass().getSimpleName();
        if (className.equals("Worker")){
            return "Рабочий";
        } else if(className.equals("Freelancer")){
            return "Фрилансер";
        }
        return null;
    }
    public static void showAll(List<People> peoples){
        for(People people: peoples){
            people.calcSalary();
            System.out.println("Сотрудник с id " +
                    people.getId() + " относится к " +
                    getClassName(people) + " отработал " +
                    people.getWorkDay() + " ставка " +
                    people.getBet() + " итого зарплата " +
                    people.getSalary());
        }
    }
}
