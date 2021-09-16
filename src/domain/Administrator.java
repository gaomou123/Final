package domain;

/**
 * Description:
 * 实现与控制台的交互
 *
 * @author: gyt
 * @date: 2021/6/19 23:00
 */
public class Administrator {
    //定义相关的操作类
    private NameListService listSvc = new NameListService();
    private Service Svc = new Service();

    //进入主要的页面
    public void enterMainMenu() {

        boolean loopFlag = true;
        char menu = '0';
        while (loopFlag) {

            if (menu != '1') {
                listAllPerson();
            }
            System.out.print("1-宿舍列表 2-添加宿舍成员 3-删除宿舍成员 4-退出 请选择(1-4): ");
            //TSUtility类中获取一个1-4的数字
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getPersons();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    //显示所有的学生信息
    public void listAllPerson() {
        System.out.println("--------------------------------欢迎进入男生宿舍管理系统--------------------------------\n");

        Person[] persons = listSvc.getAllperson();
        if (persons == null || persons.length == 0) {
            System.out.println("宿舍中没有任何人！");
        } else {
            System.out.println("ID\t姓  名\t年龄\t性别\t学    院\t状  态");
        }
        //输出
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
        System.out.println("----------------------------------------------------------------------------\n");
    }

    //查看宿舍中的学生
    public void getPersons() {
        System.out.println("-----------------------宿舍成员列表-----------------------");

        Person[] pep = Svc.getPeople();
        if (pep == null || pep.length == 0) {
            System.out.println("宿舍中目前没有学生入住！");
        } else {
            System.out.println("TID\t姓  名\t年龄\t性别\t学    院");
            for (int i = 0; i < pep.length; i++) {
                System.out.println(pep[i].string());
            }
            System.out.println("----------------------------------------------------------\n");
        }
    }

    //为宿舍中添加学生
    private void addMember() {
        System.out.println("--------------------添加学生--------------------");
        System.out.print("请输入要添加的学生ID:");
        int id = TSUtility.readInt();

        try {
            Person per = listSvc.getPerson(id);
            Svc.addBedRoom(per);
            System.out.println("添加成功");
        } catch (DomainExcepion domainExcepion) {
            System.out.println("添加失败，原因" + domainExcepion.getMessage());
        }
        //按回车继续
        TSUtility.readReturn();
    }

    //删除宿舍成员
    private void deleteMember() {
        System.out.println("--------------------删除宿舍成员--------------------");
        System.out.print("请输入要删除学生的TID:");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N): ");
        char isDelete = TSUtility.readConfirmSelection();

        if (isDelete == 'N') {
            return;
        }
        try {
            Svc.removeBedRoom(memberId);
            System.out.println("删除成功");
        } catch (DomainExcepion domainExcepion) {
            System.out.println("删除失败，原因：" + domainExcepion.getMessage());
        }
        //按回车继续
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        Administrator administrator = new Administrator();
        administrator.enterMainMenu();
    }
}
