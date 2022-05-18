package shoppe;

/**
 * 虾皮一面
 *
 * @author Mr.黄
 * @date 2022/05/10
 **/
public class Shoppe1 {
    public static void main(String[] args) {
        /*
        以下为某游戏用户每天的游玩记录表（数据已去重，每个用户每天只有一条记录）
        userid, date
        1, 2021-03-21
        1, 2021-03-23
        1, 2021-03-24
        1, 2021-03-25
        2, 2021-03-22
        2, 2021-03-23
      ...
        1. 计算每一天的新用户数（第一次游玩）
        date, count
        2. 计算3日留存率（当天游玩，3天后也游玩的用户数 / 当天游玩的用户数）
        date, count, retention
        3. 找出所有连续3天都有游玩的用户
            userid
           
         */
        
        // 解题思路：
        /* 1、先按照userid分组，求用户的游玩最小时间，此时这个时间就是他的首次登录时间。然后再按最小时间分组，统计用户数，即可求得每日新增用户数
        select first_date,count(user_id)
        from (select user_id,min(date) as first_date from table group by user_id) t
        group by first_date;
         */
        /*
        2、
        首先自己与自己做一个左连接，连接条件是user_id相同，并且右表日期=左表日期+N天（N为留存天数）
        然后针对这个左连接的表按照date分组，再count(distinct user_id)，分别统计出活跃用户数和N天留存用户数（注意count(具体列)不会统计null值，count(*)和count(1)会统计null）
        最后根据上述得到的表进行N天留存率统计，N天留存用户数/活跃用户数，样例sql如下：
        select
          concat(round(100 * 次日留存用户数/活跃用户数, 2), '%') 次日留存率,
          concat(round(100 * 三日留存用户数/活跃用户数, 2), '%') 三日留存率,
          concat(round(100 * 七日留存用户数/活跃用户数, 2), '%') 七日留存率
        from (
          select
		    a.date 日期,
		    count(distinct(a.user_id)) 活跃用户数,
		    count(distinct(b.user_id)) 次日留存用户数,
		    count(distinct(c.user_id)) 三日留存用户数,
		    count(distinct(d.user_id)) 七日留存用户数
	      from user_log a
	      left join user_log b on a.user_id = b.user_id and b.date = a.date + 1
	      left join user_log c on a.user_id = c.user_id and c.date = a.date + 3
	      left join user_log d on a.user_id = d.user_id and d.date = a.date + 7
	      group by a.date
	    ) p;
         */
        
    
    }
}