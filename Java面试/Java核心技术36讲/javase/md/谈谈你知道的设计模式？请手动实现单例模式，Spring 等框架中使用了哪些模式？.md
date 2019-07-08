#谈谈你知道的设计模式？请手动实现单例模式，Spring 等框架中使用了哪些模式？
按照模式的应用目标分类，设计模式可以分为创建型模式、结构型模式和行为型模式。

-创建型模式，是对对象创建过程的各种问题和解决方案的总结，包括各种工厂模式（Factory、Abstract Factory）、单例模式（Singleton）、
构建器模式（Builder）、原型模式（ProtoType）。
-结构型模式，是针对软件设计结构的总结，关注于类、对象继承、组合方式的实践经验。常见的结构型模式，包括桥接模式（Bridge）、适配器模式
（Adapter）、装饰者模式（Decorator）、代理模式（Proxy）、组合模式（Composite）、外观模式（Facade）、享元模式（Flyweight）等。
-行为型模式，是从类或对象之间交互、职责划分等角度总结的模式。比较常见的行为模式有策略模式（Strategy）、解释器模式（Interpreter）、
命令模式（Command）、观察者模式（Observer）、迭代器模式（Iterator）、模板方法模式（Template Method）、访问者模式（Visitor）。

Spring在API设计中使用的设计模式：
-BeanFactory和ApplicationContext应用了工厂模式。
-在bean的创建中，Spring也为不同scope定义的对象，提供了单例和原型等模式实现。
-AOP领域使用了代理模式、装饰器模式、适配器模式等。
-各种事件监听器，是观察者模式的典型应用。
-类似JDBCTemplate等则是应用了模板模式。