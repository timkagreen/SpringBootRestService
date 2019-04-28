package main;

public class BaseResponse {

    private final String name;
    private final int age;

    public BaseResponse(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
