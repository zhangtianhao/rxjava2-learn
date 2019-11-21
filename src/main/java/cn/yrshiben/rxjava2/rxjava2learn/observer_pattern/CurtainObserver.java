package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern;

/**
 * @author zhangbin
 * @Description: 窗帘，作为观察者关注人的动作，对人的动作做出反应。
 * @date create at 2019/10/25 9:59 AM
 */
public class CurtainObserver implements Observer<String> {

    @Override
    public void respondBySomethin(String s) {
        if ("起床".equals(s)) {
            System.out.println("打开窗帘");
        }
        if ("睡觉".equals(s)) {
            System.out.println("关闭窗帘");
        }
    }
}
