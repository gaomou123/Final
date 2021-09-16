package domain;

import org.junit.Test;

/**
 * Description:
 *
 * @author: gyt
 * @date: 2021/6/19 20:41
 */
public class NmaeListServiceTest {   //测试类
    @Test
    public void testGetAllPerson(){
        NameListService service = new NameListService();
        Person[] person = service.getAllperson();
        for (int i = 0; i <person.length; i++) {
            System.out.println(person[i]);
        }
    }
    @Test
    public void testGetPerson() throws DomainExcepion {
        NameListService service = new NameListService();
        Person person = service.getPerson(5);
        System.out.println(person);
    }
}
