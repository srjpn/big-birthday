package guest.specifics;

public class Age {
    int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isAgeAbove(int other){
        return age>=other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Age)) return false;

        Age age1 = (Age) o;

        return age == age1.age;

    }

    @Override
    public int hashCode() {
        return age;
    }
}
