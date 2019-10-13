import cn.huangzijian.datastructures.Array;

/**
 * @author: huangzijian888
 * @date: 2019/10/14 02:06
 */
public class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s , score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("Alice", 100));
        studentArray.addLast(new Student("Bob", 66));
        studentArray.addLast(new Student("Charlie", 88));
        System.out.println(studentArray);
    }
}
