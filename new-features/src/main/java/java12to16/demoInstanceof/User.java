package java12to16.demoInstanceof;

import java.util.Objects;

public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(name, user.name);
//        if(o instanceof User){
//            User user = (User) o;
//            return o.name.equals(this.name);
//        }
        if(o instanceof  User user){
            return user.name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
