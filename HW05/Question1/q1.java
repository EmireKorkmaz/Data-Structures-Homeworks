public class q1<K, V> {

    public static void main(String[] args){
        MyMap<Integer,Integer> m = new MyMap<Integer, Integer>();
        m.put(1894, 444);
        m.put(1692, 222);
        m.put(1995,23);
        m.put(1997,21);
        m.put(884,8844);
        m.put(581,581);
        m.put(2013,5);
        m.put(1793, 333);
        m.put(1591, 11);
        m.put(1077, 777);
        m.put(1086, 888);

        System.out.println(m.get(1793) +"  " + m.get(1692));
        System.out.println(m.get(1591) +"  " + m.get(1692));
        System.out.println(m.get(1077) +"  " + m.get(1591));
        System.out.println(m.get(1077) +"  " + m.get(1086));
        System.out.println(m.get(884) +"  " + m.get(581));
        System.out.println(m.remove(884));
        System.out.println(m.get(884) +"  " + m.get(581));

    }
}
