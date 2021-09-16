package domain;

/**
 * Description:
 *自定义异常类
 * @author: gyt
 * @date: 2021/6/19 16:26
 */
public class DomainExcepion extends Exception{
    static final long serialVersionUID = -336993124229948L;

    public DomainExcepion() {
        super();
    }

    public DomainExcepion(String msg) {
        super(msg);
    }
}
