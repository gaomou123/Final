package domain;

//将包domain.Data中的所有静态结构都导入进来

import static domain.Data.*;

/**
 * Description:负责将Data中的数据封装到Person[]数组中， 同时提供相关操作Person[]的方法
 *
 * @author: gyt
 * @date: 2021/6/19 15:46
 */
public class NameListService {
    //定义一个Person类型的数组
    private Person[] person;

    //提供空参构造器
    public NameListService() {

        //初始化数组，数组的长度为PERSON内元素的个数
        person = new Person[PERSON.length];

        //挨个遍历PERSON数组中的元素
        for (int i = 0; i < person.length; i++) {

            String college = PERSON[i][0];
            int id = Integer.parseInt(PERSON[i][1]);
            String name = PERSON[i][2];

            int age = Integer.parseInt(PERSON[i][3]);
            String sex = PERSON[i][4];

            person[i] = new Person(college, name, sex, age, id, Status.FREE);

        }

    }

    //获取当前所有学生
    public Person[] getAllperson() {
        return person;
    }

    //按照指定Id获取学生
    public Person getPerson(int id) throws DomainExcepion {
        for (int i = 0; i < person.length; i++) {
            if (person[i].getId() == id) {
                return person[i];
            }

        }
        //如果找不到指定学生，则抛出异常
        throw new DomainExcepion("找不到指定学生");
    }

}
