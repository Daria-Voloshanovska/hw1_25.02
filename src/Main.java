/* Давайте создадим класс PersonEntry. У него будет два поля:
Person person
Integer value
ну т.е. в одном поле будет хранится сам person, а в другом - сколько раз этот person встретился в списке.

Теперь представьте, у вас есть метод Set<PersonEntry> countPerson(List<Person> list)
,который считает, сколько раз Person встретился в данном листе, создает PersonEntry,
и возвращает сет из PersonEntry ну, т.е. так
Исходный List:
List<Person> list1 = List.of(
       new Person("Jack", 12),
       new Person("John", 22),
       new Person("Jack", 12),
       new Person("Jack", 12)
);
Результат сет из двух объектов PersonEntry:
	PersonEntry{Person("Jack", 12),3}
	PersonEntry{Person("John", 22),1}

Ваша задача написать тесты для этого метода
 */



import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
List<Person> list = List.of(
        new Person("Jack",12),
        new Person("John",22),
        new Person("Jack",12),
        new Person("Jack",12)
);

        Set<PersonEntry> result = countPerson(list);
        System.out.println(result);
    }
        public static Set<PersonEntry> countPerson (List < Person > list) {
            if (list == null || list.isEmpty()) {
                return new HashSet<>();
            }

            Set<PersonEntry> result = new HashSet<>();
            for (int i = 0; i < list.size(); i++) {
                Person currentPerson = list.get(i);
                int count = 0;


                for (Person person : list) {
                    if (currentPerson.equals(person)) {
                        count++;
                    }
                }
                result.add(new PersonEntry(currentPerson, count));
            }
            return result;
        }
}

