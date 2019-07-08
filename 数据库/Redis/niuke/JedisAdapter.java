import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class JedisAdapter {
    public static void print(int index, Object obj) {
        System.out.println(String.format("%d,%s", index, obj));
    }

    public static void main(String[] args) {
        //选择数据库
        Jedis jedis = new Jedis("redis://localhost:6379/3");
        //清空该数据库
        jedis.flushDB();

        jedis.set("hello", "world");
        print(1, jedis.get("hello"));
        jedis.rename("hello", "newHello");
        print(1, jedis.get("newHello"));
        //设置过期时间
        jedis.setex("hello2", 10, "world2");
        print(2, jedis.get("hello2"));

        jedis.set("pv", "100");
        print(3, jedis.get("pv"));
        //给 key 加一
        jedis.incr("pv");
        print(3, jedis.get("pv"));
        //给 key 加 n
        jedis.incrBy("pv", 3);
        print(3, jedis.get("pv"));
        //通过正则表达式获取 keys
        print(4, jedis.keys("*ll*"));

        //List
        String listName = "list";
        jedis.del(listName);
        print(5, listName);
        for (int i = 0; i < 5; i++) {
            //从左边插入
            jedis.lpush(listName, "a" + String.valueOf(i));
        }
        for (int i = 0; i < 5; i++) {
            //从右边插入
            jedis.rpush(listName, "b" + String.valueOf(i));
        }
        print(5, jedis.lrange(listName, 0, 12));
        print(5, jedis.lrange(listName, 0, 5));
        print(5, jedis.lrange(listName, 0, 12));
        print(5, jedis.lrange(listName, 0, 5));
        print(6, jedis.llen(listName));
        print(7, jedis.lpop(listName));
        print(7, jedis.rpop(listName));
        print(8, jedis.llen(listName));
        print(9, jedis.lrange(listName, 2, 5));
        print(10, jedis.lindex(listName, 4));
        print(11, jedis.linsert(listName, BinaryClient.LIST_POSITION.AFTER, "a0", "a"));
        print(11, jedis.linsert(listName, BinaryClient.LIST_POSITION.BEFORE, "b0", "b"));
        print(12, jedis.lrange(listName, 0, 10));

        //hash
        String userKey = "user";
        jedis.hset(userKey, "name", "zzq");
        jedis.hset(userKey, "age", "12");
        jedis.hset(userKey, "phone", "18866669999");
        print(13, jedis.hget(userKey, "name"));
        print(13, jedis.hgetAll(userKey));
        jedis.hdel(userKey, "phone");
        print(14, jedis.hgetAll(userKey));
        print(15, jedis.hexists(userKey, "email"));
        print(15, jedis.hexists(userKey, "age"));
        print(16, jedis.hkeys(userKey));
        print(16, jedis.hvals(userKey));
        //hsetnx:userKey中不存在key="school"?"school"="zju":不变;
        jedis.hsetnx(userKey, "lv", "100");
        jedis.hsetnx(userKey, "age", "13");
        print(17, jedis.hgetAll(userKey));

        //sets
        String setsKey1 = "sets1";
        String setsKey2 = "sets2";
        for (int i = 0; i < 10; i++) {
            jedis.sadd(setsKey1, String.valueOf(i));
            jedis.sadd(setsKey2, String.valueOf(i * i));
        }
        print(18,jedis.smembers(setsKey1));
        print(18,jedis.smembers(setsKey2));
        //并
        print(19,jedis.sunion(setsKey1,setsKey2));
        //交
        print(19,jedis.sinter(setsKey1,setsKey2));
        //差
        print(19,jedis.sdiff(setsKey1,setsKey2));
        //是否存在
        print(20,jedis.sismember(setsKey1,"8"));
        print(20,jedis.sismember(setsKey2,"8"));
        //获取长度
        print(21,jedis.scard(setsKey1));
        //随机取 3 个值
        print(22,jedis.srandmember(setsKey1,3));

        //SortedSets
        String rankKey="rankKey";
        //数值默认双精度，为了能保存所有类型的值
        //排序规则：先按score升序，再按照key字典序升序
        jedis.zadd(rankKey,101,"a");
        jedis.zadd(rankKey,100,"b");
        jedis.zadd(rankKey,99,"c");
        jedis.zadd(rankKey,99,"d");
        jedis.zadd(rankKey,101,"e");
        jedis.zadd(rankKey,98,"f");
        jedis.zadd(rankKey,98,"g");
        //count
        print(23,jedis.zcard(rankKey));
        //包含上下界的count
        print(23,jedis.zcount(rankKey,99,100));
        //获取某键的值
        print(24,jedis.zscore(rankKey,"c"));
        //加分
        print(25,jedis.zincrby(rankKey,1,"e"));
        //当要加的key不存在时，创建该key，并默认值为 0
        print(25,jedis.zincrby(rankKey,98,"h"));
        print(26,jedis.zrange(rankKey,0,3));
        print(26,jedis.zrange(rankKey,0,30));
        print(26,jedis.zrange(rankKey,1,3));
        print(27,jedis.zrevrange(rankKey,0,2));
        Set<Tuple> tuples = jedis.zrangeByScoreWithScores(rankKey, 99, 100);
        for (Tuple tuple:tuples) {
            print(28,tuple.getElement()+":"+tuple.getScore());
        }
        //获取升序排名。从0开始计算
        print(29,jedis.zrank(rankKey,"a"));
        //获取降序排名
        print(29,jedis.zrevrank(rankKey,"a"));
        //统计负无穷到正无穷之间的数
        //        ( 表示不包含边界
        //        [ 表示包含边界
        print(30,jedis.zlexcount(rankKey,"-","+"));
        print(30,jedis.zlexcount(rankKey,"[a","[g"));
        print(30,jedis.zlexcount(rankKey,"(a","(g"));
        print(30,jedis.zlexcount(rankKey,"[g","[a"));
        print(31,jedis.zrange(rankKey,0,10));
        //按照范围移除key
        jedis.zremrangeByLex(rankKey,"[a","[g");
        print(31,jedis.zrange(rankKey,0,10));

        JedisPool jedisPool = new JedisPool();
        for (int i = 0; i < 20; i++) {
            Jedis j = jedisPool.getResource();
            print(32,j.get("pv"));
            //默认 8 个线程，用完还回去
            j.close();
        }

        User user = new User();
        user.setName("swk");
        user.setPassword("123");
        user.setHeadUrl("aaa");
        user.setSalt("bbb");
        user.setId(1);
        jedis.set("user",JSONObject.toJSONString(user));
        print(33, jedis.get("user"));
        String user1 = jedis.get("user");
        print(34, JSON.parseObject(user1,User.class));
    }
}
