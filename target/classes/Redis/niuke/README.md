# Redis config 简介

# Set the number of databases. The default database is DB 0, you can select
# a different one on a per-connection basis using SELECT <dbid> where
# dbid is a number between 0 and 'databases'-1
databases 16

#   after 900 sec (15 min) if at least 1 key changed
#   after 300 sec (5 min) if at least 10 keys changed
#   after 60 sec if at least 10000 keys changed
save 900 1
save 300 10
save 60 10000

KV 单一数值，验证码（设置超时时间），PV，缓存
Sorted Sets 适合排序；排行榜；优先队列 
Sets 适合无序集合去重；赞踩；抽奖；已读；共同好友
List 适合存储最新列表，关注列表；双向列表；
Hash 适合不定项的属性值，不知道会有多少个，例如存储JSON格式值；对象属性
