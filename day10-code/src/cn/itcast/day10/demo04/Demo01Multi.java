package cn.itcast.day10.demo04;

/*多态性，
  父类名称 对象名 = new 子类名称();
 * 父类名称 对象名 = new 实现类名称();
 *左父右子
 *
*/
public class Demo01Multi {
    public static void main(String[] args) {
        Fu obj = new Zi();
        obj.method();
        obj.methodFu();
    }
}
