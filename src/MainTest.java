import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;


@DisplayName("PersonEntry count tests")
class MainTest {

    @Nested
    @DisplayName("Tests for countPerson method")
    class  CountPersonTests{

        @Test
        @DisplayName("List with duplicates")
        void listWithDuplicates(){
            List<Person> list = List.of(
                    new Person("Jack",12),
                    new Person("John",22),
                    new Person("Jack",12),
                    new Person("Jack",12)
            );

            Set<PersonEntry> expected = Set.of(
                    new PersonEntry(new Person("Jack",12),3),
                    new PersonEntry(new Person("John",22),1)
            );

            Set<PersonEntry> actual =Main.countPerson(list);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @DisplayName("List without duplicates")
        void listWithoutDuplicates(){
            List<Person> list = List.of(
                    new Person("Jack",12),
                    new Person("John",22)
            );

            Set<PersonEntry> expected = Set.of(
                    new PersonEntry(new Person("Jack",12),1),
                    new PersonEntry(new Person("John",22),1)
            );

            Set<PersonEntry> actual =Main.countPerson(list);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        @DisplayName("Empty list")
        void emptyList(){
            List<Person> list = List.of();

            Set<PersonEntry> actual = Main.countPerson(list);
            Assertions.assertTrue(actual.isEmpty());
        }
        @Test
        @DisplayName("Null list")
        void nullList(){
            List<Person> list = null;

            Set<PersonEntry> actual = Main.countPerson(list);
            Assertions.assertTrue(actual.isEmpty());
        }

        @Test
        @DisplayName("One value test")
        void oneValueTest(){
            List<Person> list = List.of(
                    new Person("Jack",12),
                    new Person("John",22),
                    new Person("Jack",12),
                    new Person("Jack",12)
            );

            PersonEntry expectedEntry = new PersonEntry(new Person("John",22),1);

            Set<PersonEntry> actual =Main.countPerson(list);
            Assertions.assertTrue(actual.contains(expectedEntry));
        }
        @Test
        @DisplayName("Specific value test")
        void specificValueTest(){
            List<Person> list = List.of(
                    new Person("Jack",12),
                    new Person("John",22),
                    new Person("Jack",12),
                    new Person("Jack",12)
            );
            Set<PersonEntry> result = Main.countPerson(list);

            PersonEntry expectedEntry = new PersonEntry(new Person("Jack",12),3);
            Assertions.assertTrue(result.contains(expectedEntry));


    }

}
}