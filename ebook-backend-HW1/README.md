# HW1: Stateful Service and RMI 

## 1. Stateful & Stateless 重构

- 重构服务: ``CartService`` 和 ``StatefulCartService``
  -  ``CartService``: Stateless服务, 所有Bean对象都是**scope=singleton**的.
  - ``StatefulCartService``: Stateful服务, 该类是**scope=session**的.
- 差异:
  - ``CartService``: 
    - 在多个浏览器中访问, springboot工程中相同层调用的对象id一致, 即Bean是单例的.
    - 业务逻辑不含状态, 简单将参数 (购物车中商品, 操作, 购物车编号) 在**数据库**中操作.
  - ``StatefulCartService``
    - 在多个浏览器中访问, springboot工程中相同层调用的其他对象id一致, 但是``StatefulCartService``每个浏览器都不同, 相同浏览器多次调用相同.
    - 业务逻辑与用户状态相关. 没有将购物车信息立即存储在数据库中, 在该类的私有变量``private List<String> tmpCart``(即内存)中存储用户购物车信息.
    - 每个浏览器对购物车操作独立, 该设计合理

## 2. 重构的原因

- 版本1利用读写数据库来实现每次用户对购物车的操作造成了大量的数据库访问:
  1. 购物车的操作对用户为高频操作;
  2. 购物车内容无需做持久化化处理;
  3. ebook后端整体业务逻辑不复杂, 内存开销不大.
- 综上, 决定对``CartService``进行重构:
  1. 减少数据库访问, 在内存中存储购物车
  2. 利用**scope=session**, 不同用户间购物车信息不会相互干扰

## 3. RMI提供

- RMI 远程调用对象: ``BookDao``

- RMI Server: ``./src/main/java/ebook/dao/RmiServer.java``

- RMI Client: ``./src/main/java/ebook/dao/RmiClient.java``

- 完整工程及修改diff: 

  https://github.com/WXM99/SE228_SpringbootDemo/commit/ecb6295a0cd7bed4aefef5f9b9f61cb09de354ae

  