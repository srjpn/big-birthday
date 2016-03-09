package guest.specifics;

public class Age {
    int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isAgeAbove(int other){
        return age>=other;
    }
}
