package domain;

/**
 * Description:
 * 关于宿舍成员的管理、添加、删除等
 *
 * @author: gyt
 * @date: 2021/6/19 16:41
 */
public class Service {
    //    private int[] bed=new int[6];   //定义6个床位，供学生入住
    //用于给memberId赋值
    private static int counter = 1;
    //用Person类的team数组储存已成功入住的学生
    private Person[] team = new Person[6];  //team团队
    private int total; //记录宿舍中实际的人数

    public Person[] getPeople() {
        Person[] team1 = new Person[total];//获取宿舍中的所有成员
        //遍历宿舍中所有的学生
        for (int i = 0; i < team1.length; i++) {
            team1[i] = this.team[i];
        }
        return team1;
    }

    //将指定的学生添加到宿舍中
    public void addBedRoom(Person p) throws DomainExcepion {

        //添加失败的情况
        //①宿舍人已满
        if (total >= 6) {
            throw new DomainExcepion("宿舍成员已满，添加失败");
        }
        //②要添加的学生已在该宿舍之中
        if (isExist(p)) {
            throw new DomainExcepion("该学生已在本宿舍中，添加失败");
        }
        //③该学生为女生，无法添加
        if (p.getSex().equals("女")) {
            throw new DomainExcepion("该学生为女生，添加失败");
        }
        //④该学生已有宿舍或正在休假
        //equalsIgnoreCase忽略大小写进行比较
        if ("BUSY".equalsIgnoreCase(p.getStatus().toString())) {
            throw new DomainExcepion("该学生已有宿舍，添加失败");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().toString())) {
            throw new DomainExcepion("该学生已休学，添加失败");
        }

        //若都不是上述情况，则添加成功
        team[total++] = p;

        //添加成功后，对p的属性值进行修改
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    public boolean isExist(Person p) {
        //如果当前要添加的学生的id于宿舍中学生id相同，则添加失败
        for (int i = 0; i < total; i++) {
            return team[i].getId() == p.getId();
        }
        return false;
    }

    //删除宿舍中指定的学生
    public void removeBedRoom(int memberId) throws DomainExcepion {
        int i = 0;   //计数器
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //未找到指定的memberId
        if (i == total) {
            throw new DomainExcepion("找不到指定memberId，删除失败");
        }
        //剩余元素向前移动
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }

        team[--total] = null;
    }

}
