package Lesson_7.hw;

public class TestsClass {

    @BeforeSuite
    public void firstMethod() {
        System.out.println(" Я метод, что выполнился первым по аннотации @BeforeSuite");
    }

//    @BeforeSuite
//    public void firstMethod2() {
//        System.out.println(" Я метод, что выполнился первым по аннотации @BeforeSuite");
//    }

    @Test(priority = 9)
    public void methodOne() {
        System.out.println("methodOne выполнен");
    }

    @Test(priority = 8)
    public void methodTwo() {
        System.out.println("methodTwo выполнен");
    }

    @Test(priority = 7)
    public void methodThree() {
        System.out.println("methodThree выполнен");
    }

    @Test(priority = 6)
    public void methodFour() {
        System.out.println("methodFour выполнен");
    }

    @Test(priority = 5)
    public void methodFive() {
        System.out.println("methodFive выполнен");
    }

    @AfterSuite
    public void lastMethod() {
        System.out.println(" Я метод, что выполнился последним по аннотации @AfterSuite");
    }
}
