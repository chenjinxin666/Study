#对比Hashtable、HashMap、TreeMap有什么不同？

Hashtable、HashMap、TreeMap都是最常见的一些Map实现，是以键值对的形式存储和操作数据的容器类型。

Hashtable是早期Java类库提供的一个哈希表实现，是同步的，会导致性能开销，不支持null键和值，很少使用。

HashMap是应用更加广泛的哈希表实现，行为上大致与HashTable一致，主要区别在于HashMap不是同步的，支持null键和值等。
通常情况下，HashMap进行put或者get操作，可以达到常数时间的性能，所以**它是绝大部分利用键值对存取场景的首选**，
比如，实现一个用户ID和用户信息对用的运行时存储结构。

TreeMap是基于红黑树的一种提供顺序访问的Map，和HashMap不同，它的get、put、remove之类的操作都是O(log(n))的时间复杂度，
具体顺序可以由指定的Comparator来决定，或者根据键的字典顺序来判断。