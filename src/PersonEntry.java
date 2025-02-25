import java.util.Objects;

public class PersonEntry {
    private Person person;
    private Integer value;

    public PersonEntry(Person person, Integer value) {
        this.person = person;
        this.value = value;
    }

    public Person getPerson() {
        return person;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntry that = (PersonEntry) o;
        return Objects.equals(person, that.person) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(person);
        result = 31 * result + Objects.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "PersonEntry{" +
                "person=" + person +
                ", value=" + value +
                '}';
    }
}


