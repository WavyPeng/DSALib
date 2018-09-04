package wavy.util.dsa.Sort;

/**
 * 自定义类，用来测试排序算法
 * Created by WavyPeng on 2018/9/04.
 */
public class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 重写compareTo函数
     * 如果分数相等，则按照名字的字母序排序
     * 如果分数不等，则分数高的靠前
     * @param s
     * @return
     */
    @Override
    public int compareTo(Student s) {
        if(this.score < s.score)
            return -1;
        else if(this.score > s.score)
            return 1;
        else
            return this.name.compareTo(s.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}