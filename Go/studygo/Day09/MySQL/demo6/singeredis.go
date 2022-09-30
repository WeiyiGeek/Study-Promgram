package main

import (
	"context"
	"fmt"
	"log"
	"time"

	"github.com/go-redis/redis/v8"
	"weiyigeek.top/studygo/Day09/MySQL/mypkg"
)

// 最新版本的go-redis库的相关命令都需要传递context.Context参数
var ctx = context.Background()

// Redis String Set/Get 示例
func setGetExample(rdb *redis.Client, ctx context.Context) {
	// 1.Set 设置 key 如果设置为-1则表示永不过期
	err := rdb.Set(ctx, "score", 100, 60*time.Second).Err()
	if err != nil {
		fmt.Printf("set score failed, err:%v\n", err)
		panic(err)
	}

	// 2.Get 获取已存在的Key其存储的值
	val1, err := rdb.Get(ctx, "score").Result() // 获取其值
	if err != nil {
		fmt.Printf("get score failed, err:%v\n", err)
		panic(err)
	}
	fmt.Printf("val1 -> score ：%v\n", val1)

	// Get 获取一个不存在的值返回redis.Nil 则说明不存在
	val2, err := rdb.Get(ctx, "name").Result()
	if err == redis.Nil {
		fmt.Println("[ERROR] - Key [name] not exist")
	} else if err != nil {
		fmt.Printf("get name failed, err:%v\n", err)
		panic(err)
	}
	// Exists() 方法用于检测某个key是否存在
	n, _ := rdb.Exists(ctx, "name").Result()
	if n > 0 {
		fmt.Println("name key 存在!")
	} else {
		fmt.Println("name key 不存在!")
		rdb.Set(ctx, "name", "weiyi", 60*time.Second)
	}
	val2, _ = rdb.Get(ctx, "name").Result()
	fmt.Println("val2 -> name : ", val2)

	// 3.SetNX 当不存在key时将进行设置该可以并设置其过期时间
	val3, err := rdb.SetNX(ctx, "username", "weiyigeek", 0).Result()
	if err != nil {
		fmt.Printf("set username failed, err:%v\n", err)
		panic(err)
	}
	fmt.Printf("val3 -> username: %v\n", val3)

	// 4.Keys() 根据正则获取keys, DBSize() 查看当前数据库key的数量.
	keys, _ := rdb.Keys(ctx, "*").Result()
	num, err := rdb.DBSize(ctx).Result()
	if err != nil {
		panic(err)
	}
	fmt.Printf("All Keys : %v, Keys number : %v \n", keys, num)

	// 5.Type() 方法用户获取一个key对应值的类型
	vType, err := rdb.Type(ctx, "username").Result()
	if err != nil {
		panic(err)
	}
	fmt.Printf("username key type : %v\n", vType)

	// 6.Expire()方法是设置某个时间段(time.Duration)后过期，ExpireAt()方法是在某个时间点(time.Time)过期失效.
	val4, _ := rdb.Expire(ctx, "name", time.Minute*2).Result()
	if val4 {
		fmt.Println("name 过期时间设置成功", val4)
	} else {
		fmt.Println("name 过期时间设置失败", val4)
	}
	val5, _ := rdb.ExpireAt(ctx, "username", time.Now().Add(time.Minute*2)).Result()
	if val5 {
		fmt.Println("username 过期时间设置成功", val5)
	} else {
		fmt.Println("username 过期时间设置失败", val5)
	}

	// 7.TTL()与PTTL()方法可以获取某个键的剩余有效期
	userTTL, _ := rdb.TTL(ctx, "user").Result() // 获取其key的过期时间
	usernameTTL, _ := rdb.PTTL(ctx, "username").Result()
	fmt.Printf("user TTL : %v, username TTL : %v\n", userTTL, usernameTTL)

	// 8.Del():删除缓存项与FlushDB():清空当前数据
	num, err = rdb.Del(ctx, "user", "username").Result()
	if err != nil {
		panic(err)
	}
	fmt.Println("Del() : ", num)

	// 清空当前数据库，因为连接的是索引为0的数据库，所以清空的就是0号数据库
	flag, err := rdb.FlushDB(ctx).Result()
	if err != nil {
		panic(err)
	}
	fmt.Println("FlushDB() : ", flag)
}

// stringIntExample 数据类型演示
func stringIntExample(rdb *redis.Client, ctx context.Context) {
	// 设置字符串类型的key
	err := rdb.Set(ctx, "hello", "Hello World!", 0).Err()
	if err != nil {
		panic(err)
	}
	// GetRange ： 字符串截取
	// 注：即使key不存在，调用GetRange()也不会报错，只是返回的截取结果是空"",可以使用fmt.Printf("%q\n", val)来打印测试
	val1, _ := rdb.GetRange(ctx, "hello", 1, 4).Result()
	fmt.Printf("key: hello, value: %v\n", val1) //截取到的内容为: ello

	// Append()表示往字符串后面追加元素，返回值是字符串的总长度
	length1, _ := rdb.Append(ctx, "hello", " Go Programer").Result()
	val2, _ := rdb.Get(ctx, "hello").Result()
	fmt.Printf("当前缓存key的长度为: %v，值: %v \n", length1, val2)

	// 设置整形的key
	err = rdb.SetNX(ctx, "number", 1, 0).Err()
	if err != nil {
		panic(err)
	}
	// Incr()、IncrBy()都是操作数字，对数字进行增加的操作
	// Decr()、DecrBy()方法是对数字进行减的操作，和Incr正好相反
	// incr是执行原子加1操作
	val3, _ := rdb.Incr(ctx, "number").Result()
	fmt.Printf("Incr -> key当前的值为: %v\n", val3) // 2
	// incrBy是增加指定的数
	val4, _ := rdb.IncrBy(ctx, "number", 6).Result()
	fmt.Printf("IncrBy -> key当前的值为: %v\n", val4) // 8

	// StrLen 也可以返回缓存key的长度
	length2, _ := rdb.StrLen(ctx, "number").Result()
	fmt.Printf("number 值长度: %v\n", length2)
}

func listExample(rdb *redis.Client, ctx context.Context) {
	// 插入指定值到list列表中，返回值是当前列表元素的数量
	// 使用LPush()方法将数据从左侧压入链表（后进先出）,也可以从右侧压如链表对应的方法是RPush()
	count, _ := rdb.LPush(ctx, "list", 1, 2, 3).Result()
	fmt.Println("插入到list集合中元素的数量: ", count)

	// LInsert() 在某个位置插入新元素
	// 在名为key的缓存项值为2的元素前面插入一个值，值为123 ， 注意只会执行一次
	_ = rdb.LInsert(ctx, "list", "before", "2", 123).Err()
	// 在名为key的缓存项值为2的元素后面插入一个值，值为321
	_ = rdb.LInsert(ctx, "list", "after", "2", 321).Err()

	// LSet() 设置某个元素的值
	//下标是从0开始的
	val1, _ := rdb.LSet(ctx, "list", 2, 256).Result()
	fmt.Println("是否成功将下标为2的元素值改成256: ", val1)

	// LLen() 获取链表元素个数
	length, _ := rdb.LLen(ctx, "list").Result()
	fmt.Printf("当前链表的长度为: %v\n", length)

	// LIndex() 获取链表下标对应的元素
	val2, _ := rdb.LIndex(ctx, "list", 2).Result()
	fmt.Printf("下标为2的值为: %v\n", val2)

	// 从链表左侧弹出数据
	val3, _ := rdb.LPop(ctx, "list").Result()
	fmt.Printf("弹出下标为0的值为: %v\n", val3)

	// LRem() 根据值移除元素 lrem key count value
	n, _ := rdb.LRem(ctx, "list", 2, "256").Result()
	fmt.Printf("移除了: %v 个\n", n)
}

func setExample(rdb *redis.Client, ctx context.Context) {
	// 集合元素缓存设置
	keyname := "Program"
	mem := []string{"C", "Golang", "C++", "C#", "Java", "Delphi", "Python", "Golang"}
	// //由于Golang已经被添加到Program集合中，所以重复添加时无效的
	for _, v := range mem {
		rdb.SAdd(ctx, keyname, v)
	}

	// SCard() 获取集合元素个数
	total, _ := rdb.SCard(ctx, keyname).Result()
	fmt.Println("golang集合成员个数: ", total)

	// SPop() 随机获取一个元素 （无序性，是随机的）
	val1, _ := rdb.SPop(ctx, keyname).Result()
	// SPopN()  随机获取多个元素.
	val2, _ := rdb.SPopN(ctx, keyname, 2).Result()

	// SSMembers() 获取所有成员
	val3, _ := rdb.SMembers(ctx, keyname).Result()
	fmt.Printf("随机获取一个元素: %v , 随机获取多个元素: %v \n所有成员: %v\n", val1, val2, val3)

	// SIsMember() 判断元素是否在集合中
	exists, _ := rdb.SIsMember(ctx, keyname, "golang").Result()
	if exists {
		fmt.Println("golang 存在 Program 集合中.") // 注意:我们存入的是Golang而非golang
	} else {
		fmt.Println("golang 不存在 Program 集合中.")
	}

	// SUnion():并集, SDiff():差集, SInter():交集
	rdb.SAdd(ctx, "setA", "a", "b", "c", "d")
	rdb.SAdd(ctx, "setB", "a", "d", "e", "f")

	//并集
	union, _ := rdb.SUnion(ctx, "setA", "setB").Result()
	fmt.Println("并集", union)

	//差集
	diff, _ := rdb.SDiff(ctx, "setA", "setB").Result()
	fmt.Println("差集", diff)

	//交集
	inter, _ := rdb.SInter(ctx, "setA", "setB").Result()
	fmt.Println("交集", inter)
	// 删除集合中指定元素(返回成功)
	n, _ := rdb.SRem(ctx, "setB", "a", "f").Result()
	fmt.Println(n)
}

func zsetExample(rdb *redis.Client, ctx context.Context) {
	// 有序集合成员与分数设置
	// zSet类型需要使用特定的类型值*redis.Z，以便作为排序使用
	lang := []*redis.Z{
		&redis.Z{Score: 90.0, Member: "Golang"},
		&redis.Z{Score: 98.0, Member: "Java"},
		&redis.Z{Score: 95.0, Member: "Python"},
		&redis.Z{Score: 97.0, Member: "JavaScript"},
		&redis.Z{Score: 99.0, Member: "C/C++"},
	}
	//插入ZSet类型
	num, err := rdb.ZAdd(ctx, "language_rank", lang...).Result()
	if err != nil {
		fmt.Printf("zadd failed, err:%v\n", err)
		return
	}
	fmt.Printf("zadd %d succ.\n", num)

	// 将ZSet中的某一个元素顺序值增加: 把Golang的分数加10
	newScore, err := rdb.ZIncrBy(ctx, "language_rank", 10.0, "Golang").Result()
	if err != nil {
		fmt.Printf("zincrby failed, err:%v\n", err)
		return
	}
	fmt.Printf("Golang's score is %f now.\n", newScore)

	// 根据分数排名取出元素:取分数最高的3个
	ret, err := rdb.ZRevRangeWithScores(ctx, "language_rank", 0, 2).Result()
	if err != nil {
		fmt.Printf("zrevrange failed, err:%v\n", err)
		return
	}
	fmt.Printf("zsetKey前3名热度的是: %v\n,Top 3 的 Memeber 与 Score 是:\n", ret)
	for _, z := range ret {
		fmt.Println(z.Member, z.Score)
	}

	// ZRangeByScore()、ZRevRangeByScore():获取score过滤后排序的数据段
	// 此处表示取95~100分的
	op := redis.ZRangeBy{
		Min: "95",
		Max: "100",
	}
	ret, err = rdb.ZRangeByScoreWithScores(ctx, "language_rank", &op).Result()
	if err != nil {
		fmt.Printf("zrangebyscore failed, err:%v\n", err)
		return
	}
	// 输出全部成员及其score分数
	fmt.Println("language_rank 键存储的全部元素:")
	for _, z := range ret {
		fmt.Println(z.Member, z.Score)
	}
}

// hash 是一个 string 类型的 field（字段） 和 value（值） 的映射表，hash 特别适合用于存储对象。
func hashExample(rdb *redis.Client, ctx context.Context) {
	// (1) HSet() 设置字段和值
	rdb.HSet(ctx, "huser", "key1", "value1", "key2", "value2")
	rdb.HSet(ctx, "huser", []string{"key3", "value3", "key4", "value4"})
	rdb.HSet(ctx, "huser", map[string]interface{}{"key5": "value5", "key6": "value6"})

	// (2) HMset():批量设置
	rdb.HMSet(ctx, "hmuser", map[string]interface{}{"name": "WeiyiGeek", "age": 88, "address": "重庆"})

	// (3) HGet() 获取某个元素
	address, _ := rdb.HGet(ctx, "hmuser", "address").Result()
	fmt.Println("hmuser.address -> ", address)

	// (4) HGetAll() 获取全部元素
	hmuser, _ := rdb.HGetAll(ctx, "hmuser").Result()
	fmt.Println("hmuser :=> ", hmuser)

	// (5) HExists 判断元素是否存在
	flag, _ := rdb.HExists(ctx, "hmuser", "address").Result()
	fmt.Println("address 是否存在 hmuser 中: ", flag)

	// (6) HLen() 获取长度
	length, _ := rdb.HLen(ctx, "hmuser").Result()
	fmt.Println("hmuser hash 键长度: ", length)

	// (7) HDel() 支持一次删除多个元素
	count, _ := rdb.HDel(ctx, "huser", "key3", "key4").Result()
	fmt.Println("删除元素的个数: ", count)
}

func hyperLogLogExample(rdb *redis.Client, ctx context.Context) {
	log.Println("Start ExampleClient_HyperLogLog")
	defer log.Println("End ExampleClient_HyperLogLog")
	//  设置 HyperLogLog 类型的键  pf_test_1
	for i := 0; i < 5; i++ {
		rdb.PFAdd(ctx, "pf_test_1", fmt.Sprintf("pf1key%d", i))
	}
	ret, err := rdb.PFCount(ctx, "pf_test_1").Result()
	log.Println(ret, err)

	//  设置 HyperLogLog 类型的键  pf_test_2
	for i := 0; i < 10; i++ {
		rdb.PFAdd(ctx, "pf_test_2", fmt.Sprintf("pf2key%d", i))
	}
	ret, err = rdb.PFCount(ctx, "pf_test_2").Result()
	log.Println(ret, err)

	//  合并两个 HyperLogLog 类型的键  pf_test_1 + pf_test_1
	rdb.PFMerge(ctx, "pf_test", "pf_test_2", "pf_test_1")
	ret, err = rdb.PFCount(ctx, "pf_test").Result()
	log.Println(ret, err)
}

func ExampleClient_CMD(rdb *redis.Client, ctx context.Context) {
	log.Println("Start ExampleClient_CMD")
	defer log.Println("End ExampleClient_CMD")

	// 1.执行redis指令 Set 设置缓存
	v := rdb.Do(ctx, "set", "NewStringCmd", "redis-cli").String()
	log.Println(">", v)

	// 2.执行redis指令 Get 设置缓存
	v = rdb.Do(ctx, "get", "NewStringCmd").String()
	log.Println("Method1 >", v)

	// 3.匿名方式执行自定义redis命令
	// Set
	Set := func(client *redis.Client, ctx context.Context, key, value string) *redis.StringCmd {
		cmd := redis.NewStringCmd(ctx, "set", key, value) // 关键点
		client.Process(ctx, cmd)
		return cmd
	}
	v, _ = Set(rdb, ctx, "NewCmd", "go-redis").Result()
	log.Println("> set NewCmd go-redis:", v)

	// Get
	Get := func(client *redis.Client, ctx context.Context, key string) *redis.StringCmd {
		cmd := redis.NewStringCmd(ctx, "get", key) // 关键点
		client.Process(ctx, cmd)
		return cmd
	}
	v, _ = Get(rdb, ctx, "NewCmd").Result()
	log.Println("Method2 > get NewCmd:", v)

	// 4.执行redis指令 hset 设置哈希缓存 (实践以下方式不行)
	// kv := map[string]interface{}{"key5": "value5", "key6": "value6"}
	// v, _ = rdb.Do(ctx, "hmset", "NewHashCmd", kv)
	// log.Println("> ", v)
}

func TxPipelineExample(rdb *redis.Client, ctx context.Context) {
	// 开pipeline与事务
	pipe := rdb.TxPipeline()
	// 设置TxPipeline键缓存
	v, _ := rdb.Do(ctx, "set", "TxPipeline", 1023.0).Result()
	log.Println(v)
	// 自增+1.0
	incr := pipe.IncrByFloat(ctx, "TxPipeline", 1026.0)
	log.Println(incr) // 未提交时  incr.Val() 值 为 0
	// 设置键过期时间
	pipe.Expire(ctx, "TxPipeline", time.Hour)
	// 提交事务
	_, err := pipe.Exec(ctx)
	if err != nil {
		log.Println("执行失败, 进行回滚操作!")
		return
	}
	fmt.Println("事务执行成功,已提交!")
	log.Println("TxPipeline :", incr.Val()) // 提交后值 为 2049
}

func ScriptExample(rdb *redis.Client, ctx context.Context) {
	// Lua脚本定义1. 传递key输出指定格式的结果
	EchoKey := redis.NewScript(`
		if redis.call("GET", KEYS[1]) ~= false then
			return {KEYS[1],"==>",redis.call("get", KEYS[1])}
		end
		return false
	`)

	err := rdb.Set(ctx, "xx_name", "WeiyiGeek", 0).Err()
	if err != nil {
		panic(err)
	}
	val1, err := EchoKey.Run(ctx, rdb, []string{"xx_name"}).Result()
	log.Println(val1, err)

	// Lua脚本定义2. 传递key与step使得，key值等于`键值+step`
	IncrByXX := redis.NewScript(`
		if redis.call("GET", KEYS[1]) ~= false then
			return redis.call("INCRBY", KEYS[1], ARGV[1])
		end
		return false
	`)

	// 判断键是否存在，存在就删除该键
	exist, err := rdb.Exists(ctx, "xx_counter").Result()
	if exist > 0 {
		res, err := rdb.Del(ctx, "xx_counter").Result()
		log.Printf("is Exists?: %v, del xx_counter: %v, err: %v \n", exist, res, err)
	}

	// 首次调用
	val2, err := IncrByXX.Run(ctx, rdb, []string{"xx_counter"}, 2).Result()
	log.Println("首次调用 IncrByXX.Run ->", val2, err)

	// 写入 xx_counter 键
	err = rdb.Set(ctx, "xx_counter", 40, 0).Err()
	if err != nil {
		panic(err)
	}
	// 二次调用
	val3, err := IncrByXX.Run(ctx, rdb, []string{"xx_counter"}, 2).Result()
	log.Println("二次调用 IncrByXX.Run ->", val3, err)
}

func main() {
	// 实例化RedisSingleObj结构体
	conn := &mypkg.RedisSingleObj{
		Redis_host: "10.20.172.248",
		Redis_port: 6379,
		Redis_auth: "weiyigeek",
	}

	// 初始化连接 Single Redis 服务端
	redisClient, err := conn.InitSingleRedis()
	if err != nil {
		fmt.Printf("[Error] - %v\n", err)
		return
	}

	// 程序执行完毕释放资源
	defer redisClient.Close()

	// 常规数据类型操作
	// setGetExample(redisClient, ctx)

	// 字符串整形数据类型
	// stringIntExample(redisClient, ctx)

	// 列表（list）数据类型操作
	// listExample(redisClient, ctx)

	// 集合（set）数据类型操作
	// setExample(redisClient, ctx)

	// 有序集合（zset）数据类型操作
	// zsetExample(redisClient, ctx)

	// 哈希 (hash) 数据类型操作
	// hashExample(redisClient, ctx)

	// 基数统计 (hyperLogLog) 数据类型操作
	// hyperLogLogExample(redisClient, ctx)

	// 执行自定义客户端命令
	// ExampleClient_CMD(redisClient, ctx)

	// pipeline 与 事务处理操作
	// TxPipelineExample(redisClient, ctx)

	// script 执行操作
	ScriptExample(redisClient, ctx)
}
