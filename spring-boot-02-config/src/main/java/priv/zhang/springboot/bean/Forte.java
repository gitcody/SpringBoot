package priv.zhang.springboot.bean;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/7 0007 下午 21:59
 * @Description:
 */

public class Forte {
    private String name;
    private Integer time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Forte{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
