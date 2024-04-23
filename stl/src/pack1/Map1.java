package pack1;

import java.util.*;

public class Map1
{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("aaa",2);
        map.put("bbb",2);
        map.put("ccc",2);
        map.put("aaa",1);

        map.put("aaa",(int)(map.get("aaa"))-1);
       System.out.println(map.size());

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
        {
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println(key+" "+value);
        }

        Collection value = map.values();

        Iterator iterator1 = value.iterator();
        while(iterator1.hasNext())
        {
            Object key = iterator1.next();
            System.out.println(key);
        }

        Set entrySet = map.entrySet();
        Iterator iterator2 = entrySet.iterator();

        while(iterator2.hasNext())
        {
            Map.Entry en = (Map.Entry)iterator2.next();
            System.out.println(en.getKey() + " " + en.getValue());
        }

    }
}
