package com.atguigu.cateyes.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public class HotShowPageForListViewBean {


    /**
     * expires : 1800
     */

    private ControlBean control;
    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":false,"movies":[{"late":false,"showInfo":"今天151家影院放映2003场","cnms":0,"sn":0,"nm":"惊天魔盗团2","ver":"2D/3D/中国巨幕","sc":8.7,"src":"","rt":"本周五上映","pn":244,"preSale":0,"vd":"","scm":"周董变魔术，敌人挡不住","showDate":"","imax":false,"dir":"朱浩伟","star":"杰西·艾森伯格,马克·鲁法洛,伍迪·哈里森","cat":"动作,喜剧,惊悚","wish":513937,"3d":true,"dur":126,"img":"http://p1.meituan.net/165.220/movie/2e0b5b5c6c086cc93068fbc212f9f6b0142193.jpg","time":"","id":246333,"snum":44771},{"late":false,"showInfo":"今天152家影院放映1826场","cnms":0,"sn":0,"nm":"独立日：卷土重来","ver":"3D/IMAX 3D/中国巨幕/全景声","sc":8.5,"src":"","rt":"本周五上映","pn":226,"preSale":0,"vd":"","scm":"外星再入侵，地核将燃尽","showDate":"","imax":true,"dir":"罗兰·艾默里奇","star":"利亚姆·海姆斯沃斯,杰夫·高布伦,杰西·厄舍","cat":"动作,冒险,科幻","wish":164747,"3d":true,"dur":120,"img":"http://p1.meituan.net/165.220/movie/b408a9322cd0da51d4bdd3261ba3d1c0278866.jpg","time":"","id":246375,"snum":37431},{"late":false,"showInfo":"今天146家影院放映919场","cnms":0,"sn":0,"nm":"三人行","ver":"2D","sc":7.2,"src":"","rt":"本周五上映","pn":186,"preSale":0,"vd":"","scm":"悍匪有手段，中枪再作案","showDate":"","imax":false,"dir":"杜琪峰","star":"赵薇,古天乐,钟汉良","cat":"动作,犯罪,悬疑","wish":72910,"3d":false,"dur":88,"img":"http://p1.meituan.net/165.220/movie/1c82df174422d9374f821482f445171b129671.jpg","time":"","id":246972,"snum":18965},{"late":false,"showInfo":"今天145家影院放映683场","cnms":0,"sn":0,"nm":"海底总动员2：多莉去哪儿","ver":"2D/3D/IMAX 3D/中国巨幕","sc":8.7,"src":"","rt":"2016-06-17上映","pn":123,"preSale":0,"vd":"","scm":"唠叨鱼多莉，上路找父母","showDate":"","imax":true,"dir":"安德鲁·斯坦顿,安格斯·麦克莱恩","star":"艾伦·德詹尼丝,徐帆,艾伯特·布鲁克斯","cat":"动画,喜剧,冒险","wish":144949,"3d":true,"dur":97,"img":"http://p0.meituan.net/165.220/movie/4c20a91505854dcd0f9617069c5fec21843230.jpg","time":"","id":246366,"snum":61683},{"late":false,"showInfo":"今天119家影院放映406场","cnms":0,"sn":0,"nm":"魔兽","ver":"2D/3D/IMAX 3D/中国巨幕/全景声","sc":9.2,"src":"","rt":"2016-06-08上映","pn":347,"preSale":0,"vd":"","scm":"怒拳为谁握，联盟斗部落","showDate":"","imax":true,"dir":"邓肯·琼斯","star":"崔维斯·费米尔,宝拉·巴顿,本·福斯特","cat":"动作,冒险,奇幻","wish":479894,"3d":true,"dur":124,"img":"http://p0.meituan.net/165.220/movie/f94e67dcd5b48f034bd7adc892f1b20695854.jpeg","time":"","id":78421,"snum":722677},{"late":false,"showInfo":"2016-07-08上映","cnms":0,"sn":0,"nm":"致青春·原来你还在这里","ver":"2D","sc":0,"src":"","rt":"2016-07-08上映","pn":333,"preSale":1,"vd":"","scm":"霸道男学霸，爱上女学渣","showDate":"","imax":false,"dir":"周拓如","star":"吴亦凡,刘亦菲,金世佳","cat":"剧情,爱情","wish":200510,"3d":false,"dur":98,"img":"http://p0.meituan.net/165.220/movie/37e7ed909843270f0880c325b6be7b60436509.jpg","time":"","id":246575,"snum":4310},{"late":false,"showInfo":"2016-07-02 下周六上映","cnms":0,"sn":0,"nm":"忍者神龟2：破影而出","ver":"2D/3D/IMAX 3D/中国巨幕","sc":0,"src":"","rt":"下周六上映","pn":249,"preSale":1,"vd":"","scm":"儿时忍者龟，犀牛也回归","showDate":"","imax":true,"dir":"戴夫·格林","star":"梅根·福克斯,皮特·普劳泽克,阿伦·瑞奇森","cat":"动作,冒险,喜剧","wish":259820,"3d":true,"dur":113,"img":"http://p1.meituan.net/165.220/movie/a375ebfcdc2a396423c368b943813b01179997.jpg","time":"","id":13511,"snum":1484},{"late":false,"showInfo":"2016-06-30 下周四上映","cnms":0,"sn":0,"nm":"所以\u2026\u2026和黑粉结婚了","ver":"2D","sc":0,"src":"","rt":"下周四上映","pn":121,"preSale":1,"vd":"","scm":"黑粉变新娘，这是闹哪样","showDate":"","imax":false,"dir":"金帝荣","star":"朴灿烈,袁姗姗,姜潮","cat":"爱情,喜剧","wish":89324,"3d":false,"dur":99,"img":"http://p1.meituan.net/165.220/movie/79311d41bea3be8f1677c0b69a5868fa289298.jpg","time":"","id":343379,"snum":6955},{"late":false,"showInfo":"今天60家影院放映111场","cnms":0,"sn":0,"nm":"X战警：天启","ver":"3D/IMAX 3D/中国巨幕/全景声","sc":9.1,"src":"","rt":"2016-06-03上映","pn":692,"preSale":0,"vd":"","scm":"天启当炮灰，千年洗剪吹","showDate":"","imax":true,"dir":"布莱恩·辛格","star":"詹姆斯·麦卡沃伊,迈克尔·法斯宾德,詹妮弗·劳伦斯","cat":"动作,科幻,奇幻","wish":559919,"3d":true,"dur":144,"img":"http://p1.meituan.net/165.220/movie/ba2386a26648c1875e3fc780950f0ae0144875.jpg","time":"","id":246177,"snum":447153},{"late":false,"showInfo":"今天47家影院放映83场","cnms":0,"sn":0,"nm":"近在咫尺的爱恋","ver":"2D","sc":7.6,"src":"","rt":"本周五上映","pn":49,"preSale":0,"vd":"","scm":"真爱在身旁，挥拳为理想","showDate":"","imax":false,"dir":"程孝泽","star":"彭于晏,郭采洁,杨子姗","cat":"爱情,运动,剧情","wish":12564,"3d":false,"dur":103,"img":"http://p1.meituan.net/165.220/movie/a70da0aefb82886efbae696181e966ff620085.jpg","time":"","id":57217,"snum":421},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"赏金猎人","ver":"2D/3D","sc":0,"src":"","rt":"下周五上映","pn":196,"preSale":1,"vd":"","scm":"编外铁饭碗，收钱抓逃犯","showDate":"","imax":false,"dir":"申太罗","star":"李敏镐,钟汉良,唐嫣","cat":"动作,喜剧,剧情,悬疑","wish":122279,"3d":true,"dur":105,"img":"http://p1.meituan.net/165.220/movie/45f8587cb425a01c9a279082772a8bd0379497.jpg","time":"","id":338506,"snum":4175},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"魔轮","ver":"2D/3D","sc":0,"src":"","rt":"下周五上映","pn":49,"preSale":1,"vd":"","scm":"天涯号起航，失控大逃亡","showDate":"","imax":false,"dir":"王早","star":"林心如,何润东,金世佳","cat":"悬疑,惊悚,恐怖","wish":8670,"3d":true,"dur":92,"img":"http://p0.meituan.net/165.220/movie/1d44cc6185a7ee4ee1def1f3a0f5821a584683.jpg","time":"","id":342741,"snum":439},{"late":false,"showInfo":"今天18家影院放映20场","cnms":0,"sn":0,"nm":"筷仙","ver":"2D","sc":4.4,"src":"","rt":"2016-06-17上映","pn":32,"preSale":0,"vd":"","scm":"笔仙已玩坏，筷仙来作怪","showDate":"","imax":false,"dir":"姬雨","star":"胡影怡,朱璇,周骏","cat":"恐怖,惊悚","wish":20373,"3d":false,"dur":87,"img":"http://p1.meituan.net/165.220/movie/31a325f0796cfebbab24776024eeec91100800.jpeg","time":"","id":343597,"snum":12196},{"late":false,"showInfo":"2016-07-02 下周六上映","cnms":0,"sn":0,"nm":"丑小鸭历险记","ver":"2D","sc":0,"src":"","rt":"下周六上映","pn":66,"preSale":1,"vd":"","scm":"月球机器鸭，化身小飞鸭","showDate":"","imax":false,"dir":"郑义","star":"朱可可,阿飞,夏倚轩","cat":"动画,科幻,冒险","wish":2928,"3d":false,"dur":81,"img":"http://p1.meituan.net/165.220/movie/0484f8ad5aec878112f1a04715d32b4e360620.jpg","time":"","id":368271,"snum":90},{"late":false,"showInfo":"今天10家影院放映11场","cnms":0,"sn":0,"nm":"百鸟朝凤","ver":"2D","sc":9.2,"src":"","rt":"2016-05-06上映","pn":105,"preSale":0,"vd":"","scm":"两代手艺人，唢呐感情深","showDate":"","imax":false,"dir":"吴天明","star":"陶泽如,郑伟,李岷城","cat":"历史,音乐,剧情","wish":3981,"3d":false,"dur":108,"img":"http://p1.meituan.net/165.220/movie/ef968fd382173c45b0c2d10572ca10b8354896.jpg","time":"","id":248260,"snum":109089},{"late":false,"showInfo":"今天6家影院放映11场","cnms":0,"sn":0,"nm":"爱丽丝梦游仙境2：镜中奇遇记","ver":"2D/3D/IMAX 3D/中国巨幕/全景声","sc":8.6,"src":"","rt":"2016-05-27上映","pn":82,"preSale":0,"vd":"","scm":"镜中再梦游，拯救老朋友","showDate":"","imax":true,"dir":"詹姆斯·波宾","star":"约翰尼·德普,安妮·海瑟薇,米娅·华希科沃斯卡","cat":"奇幻,冒险,喜剧","wish":248677,"3d":true,"dur":115,"img":"http://p1.meituan.net/165.220/movie/dbcc3eabae012da794fe4b74ed1365fc659390.jpg","time":"","id":248680,"snum":225631},{"late":false,"showInfo":"今天10家影院放映10场","cnms":0,"sn":0,"nm":"我叫MT之山口山战记","ver":"3D/中国巨幕","sc":7.6,"src":"","rt":"2016-06-17上映","pn":40,"preSale":0,"vd":"","scm":"贱萌牛头人，爆笑刷副本","showDate":"","imax":false,"dir":"核桃","star":"奶茶,YOYO,CBI","cat":"动画,喜剧,冒险","wish":43480,"3d":true,"dur":86,"img":"http://p0.meituan.net/165.220/movie/73f6abbb90259d1fa8a88fa907ca3062587352.jpg","time":"","id":246045,"snum":19355},{"late":false,"showInfo":"2016-06-27 下周一上映","cnms":0,"sn":0,"nm":"大火种","ver":"2D","sc":0,"src":"","rt":"下周一上映","pn":4,"preSale":1,"vd":"","scm":"誓死护宣言，智斗救火种","showDate":"","imax":false,"dir":"苗月","star":"白威,陈瑾,王柠","cat":"剧情,历史,战争","wish":359,"3d":false,"dur":114,"img":"http://p1.meituan.net/165.220/movie/c8545c7bd1f6070f0d52a77bd0ddd8738720802.jpg","time":"","id":337438,"snum":35},{"late":false,"showInfo":"今天6家影院放映6场","cnms":0,"sn":0,"nm":"北京遇上西雅图之不二情书","ver":"2D/中国巨幕","sc":8.5,"src":"","rt":"2016-04-29上映","pn":547,"preSale":0,"vd":"","scm":"异国心未远，书信寄情缘","showDate":"","imax":false,"dir":"薛晓路","star":"汤唯,吴秀波,惠英红","cat":"爱情,剧情","wish":307383,"3d":false,"dur":132,"img":"http://p1.meituan.net/165.220/movie/fe80bc40822d0a5f3168b73089c47d71101133.jpg","time":"","id":247575,"snum":445951},{"late":false,"showInfo":"今天4家影院放映6场","cnms":0,"sn":0,"nm":"南口1937","ver":"2D","sc":0,"src":"","rt":"本周四上映","pn":26,"preSale":0,"vd":"","scm":"南口抗日战，疆场洒血汗","showDate":"","imax":false,"dir":"朱丹","star":"孙看,孙洪涛,刘忠元","cat":"剧情,历史,战争","wish":2034,"3d":false,"dur":98,"img":"http://p1.meituan.net/165.220/movie/f4b5d903571ec3c3fc952f86261b04fd227842.jpg","time":"","id":368071,"snum":108},{"late":false,"showInfo":"今天5家影院放映5场","cnms":0,"sn":0,"nm":"愤怒的小鸟","ver":"3D/中国巨幕","sc":8.9,"src":"","rt":"2016-05-20上映","pn":132,"preSale":0,"vd":"","scm":"绿猪来偷蛋，鸟儿群奋战","showDate":"","imax":false,"dir":"费格尔·雷利,克莱·凯蒂","star":"杰森·苏戴奇斯,乔什·盖德,丹尼·麦克布耐德","cat":"动画,奇幻,冒险","wish":123045,"3d":true,"dur":97,"img":"http://p0.meituan.net/165.220/movie/b721e73740601799c065affb619d837e151622.jpg","time":"","id":246188,"snum":320225},{"late":false,"showInfo":"今天3家影院放映3场","cnms":0,"sn":0,"nm":"叶问2：宗师传奇","ver":"2D","sc":8.5,"src":"","rt":"2010-04-27上映","pn":63,"preSale":0,"vd":"","scm":"叶问搬香港，仇恨值渐长","showDate":"","imax":false,"dir":"叶伟信","star":"甄子丹,洪金宝,熊黛林","cat":"动作,历史,传记","wish":211,"3d":false,"dur":108,"img":"http://p0.meituan.net/165.220/movie/70/612717.jpg","time":"","id":524,"snum":1032},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"党的女儿尹灵芝","ver":"2D","sc":0,"src":"","rt":"下周五上映","pn":17,"preSale":1,"vd":"","scm":"心中有信仰，少年变战士","showDate":"","imax":false,"dir":"卫晓茼","star":"郜耀平,张志宏,姚安濂","cat":"剧情,历史","wish":632,"3d":false,"dur":107,"img":"http://p0.meituan.net/165.220/movie/1dffa0a076e3514234f2029d6b29b3da157605.jpg","time":"","id":672123,"snum":139},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"nm":"人再囧途之泰囧","ver":"2D","sc":8.8,"src":"","rt":"2012-12-12上映","pn":232,"preSale":0,"vd":"","scm":"囧途太荒唐，甩不掉宝强","showDate":"","imax":false,"dir":"徐峥","star":"徐峥,王宝强,黄渤","cat":"喜剧","wish":22543,"3d":false,"dur":105,"img":"http://p0.meituan.net/165.220/movie/38/280521.jpg","time":"","id":938,"snum":15635},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"nm":"同桌的你","ver":"2D","sc":8.6,"src":"","rt":"2014-04-25上映","pn":88,"preSale":0,"vd":"","scm":"初恋要结婚，回国忆青春","showDate":"","imax":false,"dir":"郭帆","star":"周冬雨,林更新,隋凯","cat":"剧情,爱情","wish":24267,"3d":false,"dur":98,"img":"http://p0.meituan.net/165.220/movie/__40811615__5745234.jpg","time":"","id":78653,"snum":73040},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"nm":"死亡游戏","ver":"2D","sc":5.8,"src":"","rt":"2016-06-03上映","pn":145,"preSale":0,"vd":"","scm":"同学生日会，恶鬼来相会","showDate":"","imax":false,"dir":"麦子","star":"徐洁儿,陈欢,陈炳强","cat":"恐怖,惊悚,悬疑","wish":3301,"3d":false,"dur":90,"img":"http://p1.meituan.net/165.220/movie/c3eec836300c5a9f0429d96921aa168472038.jpg","time":"","id":346286,"snum":5395},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"终极胜利","ver":"2D","sc":0,"src":"","rt":"下周五上映","pn":122,"preSale":1,"vd":"","scm":"辛德勒名单，推出中国版","showDate":"","imax":false,"dir":"冼杞然","star":"窦骁,约瑟夫·费因斯,娄宇健","cat":"剧情,战争,历史","wish":4811,"3d":false,"dur":108,"img":"http://p1.meituan.net/165.220/movie/0c93b5987ae440497dd985982aad1c4b233221.jpg","time":"","id":341123,"snum":65},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"宫锁沉香","ver":"2D","sc":7.8,"src":"","rt":"2013-08-13上映","pn":36,"preSale":0,"vd":"","scm":"唯美清宫戏，阴谋不见底","showDate":"","imax":false,"dir":"潘安子","star":"周冬雨,陈晓,赵丽颖","cat":"剧情,爱情,古装","wish":3080,"3d":false,"dur":115,"img":"http://p0.meituan.net/165.220/movie/__18327195__7709930.jpg","time":"","id":78176,"snum":2509},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"有人赞美聪慧,有人则不","ver":"2D","sc":7.8,"src":"","rt":"2013-11待定","pn":98,"preSale":0,"vd":"","scm":"离家偷玩耍，乡下过暑假","showDate":"","imax":false,"dir":"杨瑾","star":"李书晨,王琛,卫永绍","cat":"动画,家庭","wish":184,"3d":false,"dur":108,"img":"http://p0.meituan.net/165.220/movie/__16523889__6590864.jpg","time":"2013-11","id":78224,"snum":54},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"警察故事2013","ver":"2D/IMAX 3D","sc":8,"src":"","rt":"2013-12-24上映","pn":44,"preSale":0,"vd":"","scm":"女儿乱交友，老爹来出头","showDate":"","imax":true,"dir":"丁晟","star":"刘烨,成龙,景甜","cat":"剧情,动作,犯罪","wish":14520,"3d":true,"dur":108,"img":"http://p0.meituan.net/165.220/movie/__29561506__7176229.jpg","time":"","id":77192,"snum":19133},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"北京爱情故事","ver":"2D","sc":8,"src":"","rt":"2014-02-14上映","pn":145,"preSale":0,"vd":"","scm":"恋爱分五段，激情不会散","showDate":"","imax":false,"dir":"陈思诚","star":"梁家辉,刘嘉玲,王学兵","cat":"爱情","wish":12286,"3d":false,"dur":121,"img":"http://p0.meituan.net/165.220/movie/__33456063__6265360.jpg","time":"","id":78324,"snum":28686},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"催眠大师","ver":"2D","sc":9,"src":"","rt":"2014-04-29上映","pn":78,"preSale":0,"vd":"","scm":"催眠治心伤，侧击猜真相","showDate":"","imax":false,"dir":"陈正道","star":"徐峥,莫文蔚,吕中","cat":"剧情,悬疑,惊悚","wish":11396,"3d":false,"dur":102,"img":"http://p1.meituan.net/165.220/movie/__39582689__9041214.jpg","time":"","id":78672,"snum":46536},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"闺蜜","ver":"2D","sc":8,"src":"","rt":"2014-07-30上映","pn":203,"preSale":0,"vd":"","scm":"永远好闺蜜，渣男靠边去","showDate":"","imax":false,"dir":"黄真真","star":"陈意涵,薛凯琪,杨子姗","cat":"剧情,爱情","wish":30224,"3d":false,"dur":118,"img":"http://p1.meituan.net/165.220/movie/__48665963__9098444.jpg","time":"","id":78772,"snum":68752},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"十万个冷笑话","ver":"2D","sc":8.2,"src":"","rt":"2014-12-31上映","pn":79,"preSale":0,"vd":"","scm":"男主有点拽，二次元崩坏","showDate":"","imax":false,"dir":"卢恒宇,李姝洁","star":"张杰,皇贞季,宝木中阳","cat":"动画,喜剧,奇幻","wish":25775,"3d":false,"dur":100,"img":"http://p1.meituan.net/165.220/movie/56cb96b2c6df95b66db4ce719993d5d0666565.jpg","time":"","id":246067,"snum":122612},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"奔跑吧！兄弟","ver":"2D","sc":4.7,"src":"","rt":"2015-01-30上映","pn":118,"preSale":0,"vd":"","scm":"跑男再出发，集体游三亚","showDate":"","imax":false,"dir":"胡笳,岑俊义","star":"杨颖,王宝强,李晨","cat":"喜剧,冒险,动作","wish":49025,"3d":false,"dur":88,"img":"http://p0.meituan.net/165.220/movie/85f0d9a604e26be5523a848269346697296774.jpg","time":"","id":246316,"snum":361096},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"横冲直撞好莱坞","ver":"2D/中国巨幕","sc":7.7,"src":"","rt":"2015-06-26上映","pn":273,"preSale":0,"vd":"","scm":"逗比好基友，遇到坏导游","showDate":"","imax":false,"dir":"蒂姆·肯德尔","star":"赵薇,黄晓明,佟大为","cat":"喜剧,动作,冒险","wish":64522,"3d":false,"dur":119,"img":"http://p1.meituan.net/165.220/movie/1c06c9055cb3990e76ee93c2c70789bb145247.jpg","time":"","id":246178,"snum":282793},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"通灵之六世古宅","ver":"2D/3D/中国巨幕","sc":4.5,"src":"","rt":"2015-07-24上映","pn":101,"preSale":0,"vd":"","scm":"古宅心慌慌，通灵少女忙","showDate":"","imax":false,"dir":"彭发","star":"徐娇,张兆辉,毕秀茹","cat":"惊悚,恐怖","wish":34072,"3d":true,"dur":87,"img":"http://p1.meituan.net/165.220/movie/575f1cee324dd206d981b4dfcb1ec1bd1381691.jpg","time":"","id":246249,"snum":20076},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"既然青春留不住","ver":"2D","sc":8.2,"src":"","rt":"2015-10-23上映","pn":172,"preSale":0,"vd":"","scm":"校草撞菠菜，青春已不再","showDate":"","imax":false,"dir":"田蒙","star":"张翰,陈乔恩,施予斐","cat":"喜剧,爱情","wish":78433,"3d":false,"dur":92,"img":"http://p0.meituan.net/165.220/movie/90422e83536df2153ecc57ff9703e99c1111187.jpg","time":"","id":246540,"snum":83843},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"我的诗篇","ver":"2D","sc":0,"src":"","rt":"2015-11-01上映","pn":19,"preSale":0,"vd":"","scm":"生产线诗歌，朴素却深刻","showDate":"","imax":false,"dir":"吴飞跃,秦晓宇","star":"乌鸟鸟,陈年喜,老井","cat":"纪录片","wish":631,"3d":false,"dur":110,"img":"http://p1.meituan.net/165.220/movie/a93a7b21b94073e778d30962a409cb02172463.jpg","time":"","id":341084,"snum":124},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"大电影2.0之两个傻瓜的荒唐事","ver":"2D","sc":5.6,"src":"","rt":"2007-12-21上映","pn":3,"preSale":0,"vd":"","scm":"姚晨王宝强，爆笑太疯狂","showDate":"","imax":false,"dir":"阿甘","star":"郭涛,刘心悠,李灿森","cat":"喜剧","wish":107,"3d":false,"dur":97,"img":"http://p1.meituan.net/165.220/movie/76ac89dad45ac25c676246dc92794b03318660.png","time":"","id":536,"snum":93},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"Hold住爱","ver":"2D","sc":5.9,"src":"","rt":"2012-08-23上映","pn":300,"preSale":0,"vd":"","scm":"假戏变真做，幂威秀爱火","showDate":"","imax":false,"dir":"张琦","star":"杨幂,刘恺威,周秀娜","cat":"喜剧,爱情,悬疑","wish":280,"3d":false,"dur":95,"img":"http://p0.meituan.net/165.220/movie/29/274730.jpg","time":"","id":729,"snum":754},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"厨子戏子痞子","ver":"2D","sc":8.3,"src":"","rt":"2013-03-29上映","pn":281,"preSale":0,"vd":"","scm":"三男一台戏，客栈解僵局","showDate":"","imax":false,"dir":"管虎","star":"黄渤,刘烨,张涵予","cat":"剧情,喜剧,动作","wish":10110,"3d":false,"dur":108,"img":"http://p0.meituan.net/165.220/movie/__7277442__6071578.jpg","time":"","id":969,"snum":5760},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"人间蒸发","ver":"2D","sc":7,"src":"","rt":"2013-04-28上映","pn":22,"preSale":0,"vd":"","scm":"惊心动魄的寻亲之旅","showDate":"","imax":false,"dir":"梁德森","star":"钟丽缇,柳岩,李灿森","cat":"悬疑,惊悚","wish":771,"3d":false,"dur":90,"img":"http://p0.meituan.net/165.220/movie/__6680785__5992311.jpg","time":"","id":78094,"snum":182},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"京城81号","ver":"2D/3D","sc":5,"src":"","rt":"2014-07-18上映","pn":98,"preSale":0,"vd":"","scm":"古宅阴森处，少妇诉凄苦","showDate":"","imax":false,"dir":"叶伟民","star":"吴镇宇,林心如,杨祐宁","cat":"剧情,悬疑,恐怖","wish":36817,"3d":true,"dur":90,"img":"http://p1.meituan.net/165.220/movie/__48584093__3431812.jpg","time":"","id":78267,"snum":122362},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"左耳","ver":"2D","sc":7.9,"src":"","rt":"2015-04-24上映","pn":315,"preSale":0,"vd":"","scm":"青春要恋爱，别忘堕堕胎","showDate":"","imax":false,"dir":"苏有朋","star":"陈都灵,欧豪,杨洋","cat":"爱情","wish":82116,"3d":false,"dur":117,"img":"http://p0.meituan.net/165.220/movie/da55f29972ec0b9692ba7055905892c8123092.jpg","time":"","id":246210,"snum":538090},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"美人鱼之海盗来袭","ver":"2D","sc":5.5,"src":"","rt":"2015-07-31上映","pn":38,"preSale":0,"vd":"","scm":"国产美人鱼，俩海盗来袭","showDate":"","imax":false,"dir":"邱浩强","star":"李思娴,郭亚维,宋磊","cat":"动画,喜剧,冒险","wish":27716,"3d":false,"dur":85,"img":"http://p0.meituan.net/165.220/movie/7e15953aa8bc5be4e7bff00913426a06920765.jpg","time":"","id":248550,"snum":21962},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"陪安东尼度过漫长岁月","ver":"2D","sc":7.8,"src":"","rt":"2015-11-13上映","pn":564,"preSale":0,"vd":"","scm":"文艺大暖男，不二常相伴","showDate":"","imax":false,"dir":"秦小珍","star":"刘畅,白百何,唐艺昕","cat":"剧情,爱情","wish":120703,"3d":false,"dur":121,"img":"http://p1.meituan.net/165.220/movie/9f0d994eafbf52e7b0145b7746d1d881246635.jpg","time":"","id":246583,"snum":78393},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"大唐玄奘","ver":"2D/中国巨幕","sc":7.7,"src":"","rt":"2016-04-29上映","pn":232,"preSale":0,"vd":"","scm":"了却世间恨，尽是取经人","showDate":"","imax":false,"dir":"霍建起","star":"黄晓明,蒲巴甲,徐峥","cat":"剧情,历史","wish":23799,"3d":false,"dur":120,"img":"http://p0.meituan.net/165.220/movie/c1cbba6359ef62bbb5bdd5311708c828413080.jpg","time":"","id":338357,"snum":28471},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"记忆碎片","ver":"2D","sc":6.9,"src":"","rt":"2016-06-03上映","pn":47,"preSale":0,"vd":"","scm":"宿醉陷疑案，奋力查嫌犯","showDate":"","imax":false,"dir":"朴裕焕","star":"雷佳音,夏梓桐,李菁","cat":"悬疑,喜剧,犯罪","wish":4154,"3d":false,"dur":94,"img":"http://p1.meituan.net/165.220/movie/ea15948d63d527d092a70e39cbb74636357253.jpg","time":"","id":345923,"snum":2974}]}
     */

    private int status;
    /**
     * hasNext : false
     * movies : [{"late":false,"showInfo":"今天151家影院放映2003场","cnms":0,"sn":0,"nm":"惊天魔盗团2","ver":"2D/3D/中国巨幕","sc":8.7,"src":"","rt":"本周五上映","pn":244,"preSale":0,"vd":"","scm":"周董变魔术，敌人挡不住","showDate":"","imax":false,"dir":"朱浩伟","star":"杰西·艾森伯格,马克·鲁法洛,伍迪·哈里森","cat":"动作,喜剧,惊悚","wish":513937,"3d":true,"dur":126,"img":"http://p1.meituan.net/165.220/movie/2e0b5b5c6c086cc93068fbc212f9f6b0142193.jpg","time":"","id":246333,"snum":44771},{"late":false,"showInfo":"今天152家影院放映1826场","cnms":0,"sn":0,"nm":"独立日：卷土重来","ver":"3D/IMAX 3D/中国巨幕/全景声","sc":8.5,"src":"","rt":"本周五上映","pn":226,"preSale":0,"vd":"","scm":"外星再入侵，地核将燃尽","showDate":"","imax":true,"dir":"罗兰·艾默里奇","star":"利亚姆·海姆斯沃斯,杰夫·高布伦,杰西·厄舍","cat":"动作,冒险,科幻","wish":164747,"3d":true,"dur":120,"img":"http://p1.meituan.net/165.220/movie/b408a9322cd0da51d4bdd3261ba3d1c0278866.jpg","time":"","id":246375,"snum":37431},{"late":false,"showInfo":"今天146家影院放映919场","cnms":0,"sn":0,"nm":"三人行","ver":"2D","sc":7.2,"src":"","rt":"本周五上映","pn":186,"preSale":0,"vd":"","scm":"悍匪有手段，中枪再作案","showDate":"","imax":false,"dir":"杜琪峰","star":"赵薇,古天乐,钟汉良","cat":"动作,犯罪,悬疑","wish":72910,"3d":false,"dur":88,"img":"http://p1.meituan.net/165.220/movie/1c82df174422d9374f821482f445171b129671.jpg","time":"","id":246972,"snum":18965},{"late":false,"showInfo":"今天145家影院放映683场","cnms":0,"sn":0,"nm":"海底总动员2：多莉去哪儿","ver":"2D/3D/IMAX 3D/中国巨幕","sc":8.7,"src":"","rt":"2016-06-17上映","pn":123,"preSale":0,"vd":"","scm":"唠叨鱼多莉，上路找父母","showDate":"","imax":true,"dir":"安德鲁·斯坦顿,安格斯·麦克莱恩","star":"艾伦·德詹尼丝,徐帆,艾伯特·布鲁克斯","cat":"动画,喜剧,冒险","wish":144949,"3d":true,"dur":97,"img":"http://p0.meituan.net/165.220/movie/4c20a91505854dcd0f9617069c5fec21843230.jpg","time":"","id":246366,"snum":61683},{"late":false,"showInfo":"今天119家影院放映406场","cnms":0,"sn":0,"nm":"魔兽","ver":"2D/3D/IMAX 3D/中国巨幕/全景声","sc":9.2,"src":"","rt":"2016-06-08上映","pn":347,"preSale":0,"vd":"","scm":"怒拳为谁握，联盟斗部落","showDate":"","imax":true,"dir":"邓肯·琼斯","star":"崔维斯·费米尔,宝拉·巴顿,本·福斯特","cat":"动作,冒险,奇幻","wish":479894,"3d":true,"dur":124,"img":"http://p0.meituan.net/165.220/movie/f94e67dcd5b48f034bd7adc892f1b20695854.jpeg","time":"","id":78421,"snum":722677},{"late":false,"showInfo":"2016-07-08上映","cnms":0,"sn":0,"nm":"致青春·原来你还在这里","ver":"2D","sc":0,"src":"","rt":"2016-07-08上映","pn":333,"preSale":1,"vd":"","scm":"霸道男学霸，爱上女学渣","showDate":"","imax":false,"dir":"周拓如","star":"吴亦凡,刘亦菲,金世佳","cat":"剧情,爱情","wish":200510,"3d":false,"dur":98,"img":"http://p0.meituan.net/165.220/movie/37e7ed909843270f0880c325b6be7b60436509.jpg","time":"","id":246575,"snum":4310},{"late":false,"showInfo":"2016-07-02 下周六上映","cnms":0,"sn":0,"nm":"忍者神龟2：破影而出","ver":"2D/3D/IMAX 3D/中国巨幕","sc":0,"src":"","rt":"下周六上映","pn":249,"preSale":1,"vd":"","scm":"儿时忍者龟，犀牛也回归","showDate":"","imax":true,"dir":"戴夫·格林","star":"梅根·福克斯,皮特·普劳泽克,阿伦·瑞奇森","cat":"动作,冒险,喜剧","wish":259820,"3d":true,"dur":113,"img":"http://p1.meituan.net/165.220/movie/a375ebfcdc2a396423c368b943813b01179997.jpg","time":"","id":13511,"snum":1484},{"late":false,"showInfo":"2016-06-30 下周四上映","cnms":0,"sn":0,"nm":"所以\u2026\u2026和黑粉结婚了","ver":"2D","sc":0,"src":"","rt":"下周四上映","pn":121,"preSale":1,"vd":"","scm":"黑粉变新娘，这是闹哪样","showDate":"","imax":false,"dir":"金帝荣","star":"朴灿烈,袁姗姗,姜潮","cat":"爱情,喜剧","wish":89324,"3d":false,"dur":99,"img":"http://p1.meituan.net/165.220/movie/79311d41bea3be8f1677c0b69a5868fa289298.jpg","time":"","id":343379,"snum":6955},{"late":false,"showInfo":"今天60家影院放映111场","cnms":0,"sn":0,"nm":"X战警：天启","ver":"3D/IMAX 3D/中国巨幕/全景声","sc":9.1,"src":"","rt":"2016-06-03上映","pn":692,"preSale":0,"vd":"","scm":"天启当炮灰，千年洗剪吹","showDate":"","imax":true,"dir":"布莱恩·辛格","star":"詹姆斯·麦卡沃伊,迈克尔·法斯宾德,詹妮弗·劳伦斯","cat":"动作,科幻,奇幻","wish":559919,"3d":true,"dur":144,"img":"http://p1.meituan.net/165.220/movie/ba2386a26648c1875e3fc780950f0ae0144875.jpg","time":"","id":246177,"snum":447153},{"late":false,"showInfo":"今天47家影院放映83场","cnms":0,"sn":0,"nm":"近在咫尺的爱恋","ver":"2D","sc":7.6,"src":"","rt":"本周五上映","pn":49,"preSale":0,"vd":"","scm":"真爱在身旁，挥拳为理想","showDate":"","imax":false,"dir":"程孝泽","star":"彭于晏,郭采洁,杨子姗","cat":"爱情,运动,剧情","wish":12564,"3d":false,"dur":103,"img":"http://p1.meituan.net/165.220/movie/a70da0aefb82886efbae696181e966ff620085.jpg","time":"","id":57217,"snum":421},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"赏金猎人","ver":"2D/3D","sc":0,"src":"","rt":"下周五上映","pn":196,"preSale":1,"vd":"","scm":"编外铁饭碗，收钱抓逃犯","showDate":"","imax":false,"dir":"申太罗","star":"李敏镐,钟汉良,唐嫣","cat":"动作,喜剧,剧情,悬疑","wish":122279,"3d":true,"dur":105,"img":"http://p1.meituan.net/165.220/movie/45f8587cb425a01c9a279082772a8bd0379497.jpg","time":"","id":338506,"snum":4175},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"魔轮","ver":"2D/3D","sc":0,"src":"","rt":"下周五上映","pn":49,"preSale":1,"vd":"","scm":"天涯号起航，失控大逃亡","showDate":"","imax":false,"dir":"王早","star":"林心如,何润东,金世佳","cat":"悬疑,惊悚,恐怖","wish":8670,"3d":true,"dur":92,"img":"http://p0.meituan.net/165.220/movie/1d44cc6185a7ee4ee1def1f3a0f5821a584683.jpg","time":"","id":342741,"snum":439},{"late":false,"showInfo":"今天18家影院放映20场","cnms":0,"sn":0,"nm":"筷仙","ver":"2D","sc":4.4,"src":"","rt":"2016-06-17上映","pn":32,"preSale":0,"vd":"","scm":"笔仙已玩坏，筷仙来作怪","showDate":"","imax":false,"dir":"姬雨","star":"胡影怡,朱璇,周骏","cat":"恐怖,惊悚","wish":20373,"3d":false,"dur":87,"img":"http://p1.meituan.net/165.220/movie/31a325f0796cfebbab24776024eeec91100800.jpeg","time":"","id":343597,"snum":12196},{"late":false,"showInfo":"2016-07-02 下周六上映","cnms":0,"sn":0,"nm":"丑小鸭历险记","ver":"2D","sc":0,"src":"","rt":"下周六上映","pn":66,"preSale":1,"vd":"","scm":"月球机器鸭，化身小飞鸭","showDate":"","imax":false,"dir":"郑义","star":"朱可可,阿飞,夏倚轩","cat":"动画,科幻,冒险","wish":2928,"3d":false,"dur":81,"img":"http://p1.meituan.net/165.220/movie/0484f8ad5aec878112f1a04715d32b4e360620.jpg","time":"","id":368271,"snum":90},{"late":false,"showInfo":"今天10家影院放映11场","cnms":0,"sn":0,"nm":"百鸟朝凤","ver":"2D","sc":9.2,"src":"","rt":"2016-05-06上映","pn":105,"preSale":0,"vd":"","scm":"两代手艺人，唢呐感情深","showDate":"","imax":false,"dir":"吴天明","star":"陶泽如,郑伟,李岷城","cat":"历史,音乐,剧情","wish":3981,"3d":false,"dur":108,"img":"http://p1.meituan.net/165.220/movie/ef968fd382173c45b0c2d10572ca10b8354896.jpg","time":"","id":248260,"snum":109089},{"late":false,"showInfo":"今天6家影院放映11场","cnms":0,"sn":0,"nm":"爱丽丝梦游仙境2：镜中奇遇记","ver":"2D/3D/IMAX 3D/中国巨幕/全景声","sc":8.6,"src":"","rt":"2016-05-27上映","pn":82,"preSale":0,"vd":"","scm":"镜中再梦游，拯救老朋友","showDate":"","imax":true,"dir":"詹姆斯·波宾","star":"约翰尼·德普,安妮·海瑟薇,米娅·华希科沃斯卡","cat":"奇幻,冒险,喜剧","wish":248677,"3d":true,"dur":115,"img":"http://p1.meituan.net/165.220/movie/dbcc3eabae012da794fe4b74ed1365fc659390.jpg","time":"","id":248680,"snum":225631},{"late":false,"showInfo":"今天10家影院放映10场","cnms":0,"sn":0,"nm":"我叫MT之山口山战记","ver":"3D/中国巨幕","sc":7.6,"src":"","rt":"2016-06-17上映","pn":40,"preSale":0,"vd":"","scm":"贱萌牛头人，爆笑刷副本","showDate":"","imax":false,"dir":"核桃","star":"奶茶,YOYO,CBI","cat":"动画,喜剧,冒险","wish":43480,"3d":true,"dur":86,"img":"http://p0.meituan.net/165.220/movie/73f6abbb90259d1fa8a88fa907ca3062587352.jpg","time":"","id":246045,"snum":19355},{"late":false,"showInfo":"2016-06-27 下周一上映","cnms":0,"sn":0,"nm":"大火种","ver":"2D","sc":0,"src":"","rt":"下周一上映","pn":4,"preSale":1,"vd":"","scm":"誓死护宣言，智斗救火种","showDate":"","imax":false,"dir":"苗月","star":"白威,陈瑾,王柠","cat":"剧情,历史,战争","wish":359,"3d":false,"dur":114,"img":"http://p1.meituan.net/165.220/movie/c8545c7bd1f6070f0d52a77bd0ddd8738720802.jpg","time":"","id":337438,"snum":35},{"late":false,"showInfo":"今天6家影院放映6场","cnms":0,"sn":0,"nm":"北京遇上西雅图之不二情书","ver":"2D/中国巨幕","sc":8.5,"src":"","rt":"2016-04-29上映","pn":547,"preSale":0,"vd":"","scm":"异国心未远，书信寄情缘","showDate":"","imax":false,"dir":"薛晓路","star":"汤唯,吴秀波,惠英红","cat":"爱情,剧情","wish":307383,"3d":false,"dur":132,"img":"http://p1.meituan.net/165.220/movie/fe80bc40822d0a5f3168b73089c47d71101133.jpg","time":"","id":247575,"snum":445951},{"late":false,"showInfo":"今天4家影院放映6场","cnms":0,"sn":0,"nm":"南口1937","ver":"2D","sc":0,"src":"","rt":"本周四上映","pn":26,"preSale":0,"vd":"","scm":"南口抗日战，疆场洒血汗","showDate":"","imax":false,"dir":"朱丹","star":"孙看,孙洪涛,刘忠元","cat":"剧情,历史,战争","wish":2034,"3d":false,"dur":98,"img":"http://p1.meituan.net/165.220/movie/f4b5d903571ec3c3fc952f86261b04fd227842.jpg","time":"","id":368071,"snum":108},{"late":false,"showInfo":"今天5家影院放映5场","cnms":0,"sn":0,"nm":"愤怒的小鸟","ver":"3D/中国巨幕","sc":8.9,"src":"","rt":"2016-05-20上映","pn":132,"preSale":0,"vd":"","scm":"绿猪来偷蛋，鸟儿群奋战","showDate":"","imax":false,"dir":"费格尔·雷利,克莱·凯蒂","star":"杰森·苏戴奇斯,乔什·盖德,丹尼·麦克布耐德","cat":"动画,奇幻,冒险","wish":123045,"3d":true,"dur":97,"img":"http://p0.meituan.net/165.220/movie/b721e73740601799c065affb619d837e151622.jpg","time":"","id":246188,"snum":320225},{"late":false,"showInfo":"今天3家影院放映3场","cnms":0,"sn":0,"nm":"叶问2：宗师传奇","ver":"2D","sc":8.5,"src":"","rt":"2010-04-27上映","pn":63,"preSale":0,"vd":"","scm":"叶问搬香港，仇恨值渐长","showDate":"","imax":false,"dir":"叶伟信","star":"甄子丹,洪金宝,熊黛林","cat":"动作,历史,传记","wish":211,"3d":false,"dur":108,"img":"http://p0.meituan.net/165.220/movie/70/612717.jpg","time":"","id":524,"snum":1032},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"党的女儿尹灵芝","ver":"2D","sc":0,"src":"","rt":"下周五上映","pn":17,"preSale":1,"vd":"","scm":"心中有信仰，少年变战士","showDate":"","imax":false,"dir":"卫晓茼","star":"郜耀平,张志宏,姚安濂","cat":"剧情,历史","wish":632,"3d":false,"dur":107,"img":"http://p0.meituan.net/165.220/movie/1dffa0a076e3514234f2029d6b29b3da157605.jpg","time":"","id":672123,"snum":139},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"nm":"人再囧途之泰囧","ver":"2D","sc":8.8,"src":"","rt":"2012-12-12上映","pn":232,"preSale":0,"vd":"","scm":"囧途太荒唐，甩不掉宝强","showDate":"","imax":false,"dir":"徐峥","star":"徐峥,王宝强,黄渤","cat":"喜剧","wish":22543,"3d":false,"dur":105,"img":"http://p0.meituan.net/165.220/movie/38/280521.jpg","time":"","id":938,"snum":15635},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"nm":"同桌的你","ver":"2D","sc":8.6,"src":"","rt":"2014-04-25上映","pn":88,"preSale":0,"vd":"","scm":"初恋要结婚，回国忆青春","showDate":"","imax":false,"dir":"郭帆","star":"周冬雨,林更新,隋凯","cat":"剧情,爱情","wish":24267,"3d":false,"dur":98,"img":"http://p0.meituan.net/165.220/movie/__40811615__5745234.jpg","time":"","id":78653,"snum":73040},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"nm":"死亡游戏","ver":"2D","sc":5.8,"src":"","rt":"2016-06-03上映","pn":145,"preSale":0,"vd":"","scm":"同学生日会，恶鬼来相会","showDate":"","imax":false,"dir":"麦子","star":"徐洁儿,陈欢,陈炳强","cat":"恐怖,惊悚,悬疑","wish":3301,"3d":false,"dur":90,"img":"http://p1.meituan.net/165.220/movie/c3eec836300c5a9f0429d96921aa168472038.jpg","time":"","id":346286,"snum":5395},{"late":false,"showInfo":"2016-07-01 下周五上映","cnms":0,"sn":0,"nm":"终极胜利","ver":"2D","sc":0,"src":"","rt":"下周五上映","pn":122,"preSale":1,"vd":"","scm":"辛德勒名单，推出中国版","showDate":"","imax":false,"dir":"冼杞然","star":"窦骁,约瑟夫·费因斯,娄宇健","cat":"剧情,战争,历史","wish":4811,"3d":false,"dur":108,"img":"http://p1.meituan.net/165.220/movie/0c93b5987ae440497dd985982aad1c4b233221.jpg","time":"","id":341123,"snum":65},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"宫锁沉香","ver":"2D","sc":7.8,"src":"","rt":"2013-08-13上映","pn":36,"preSale":0,"vd":"","scm":"唯美清宫戏，阴谋不见底","showDate":"","imax":false,"dir":"潘安子","star":"周冬雨,陈晓,赵丽颖","cat":"剧情,爱情,古装","wish":3080,"3d":false,"dur":115,"img":"http://p0.meituan.net/165.220/movie/__18327195__7709930.jpg","time":"","id":78176,"snum":2509},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"有人赞美聪慧,有人则不","ver":"2D","sc":7.8,"src":"","rt":"2013-11待定","pn":98,"preSale":0,"vd":"","scm":"离家偷玩耍，乡下过暑假","showDate":"","imax":false,"dir":"杨瑾","star":"李书晨,王琛,卫永绍","cat":"动画,家庭","wish":184,"3d":false,"dur":108,"img":"http://p0.meituan.net/165.220/movie/__16523889__6590864.jpg","time":"2013-11","id":78224,"snum":54},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"警察故事2013","ver":"2D/IMAX 3D","sc":8,"src":"","rt":"2013-12-24上映","pn":44,"preSale":0,"vd":"","scm":"女儿乱交友，老爹来出头","showDate":"","imax":true,"dir":"丁晟","star":"刘烨,成龙,景甜","cat":"剧情,动作,犯罪","wish":14520,"3d":true,"dur":108,"img":"http://p0.meituan.net/165.220/movie/__29561506__7176229.jpg","time":"","id":77192,"snum":19133},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"北京爱情故事","ver":"2D","sc":8,"src":"","rt":"2014-02-14上映","pn":145,"preSale":0,"vd":"","scm":"恋爱分五段，激情不会散","showDate":"","imax":false,"dir":"陈思诚","star":"梁家辉,刘嘉玲,王学兵","cat":"爱情","wish":12286,"3d":false,"dur":121,"img":"http://p0.meituan.net/165.220/movie/__33456063__6265360.jpg","time":"","id":78324,"snum":28686},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"催眠大师","ver":"2D","sc":9,"src":"","rt":"2014-04-29上映","pn":78,"preSale":0,"vd":"","scm":"催眠治心伤，侧击猜真相","showDate":"","imax":false,"dir":"陈正道","star":"徐峥,莫文蔚,吕中","cat":"剧情,悬疑,惊悚","wish":11396,"3d":false,"dur":102,"img":"http://p1.meituan.net/165.220/movie/__39582689__9041214.jpg","time":"","id":78672,"snum":46536},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"闺蜜","ver":"2D","sc":8,"src":"","rt":"2014-07-30上映","pn":203,"preSale":0,"vd":"","scm":"永远好闺蜜，渣男靠边去","showDate":"","imax":false,"dir":"黄真真","star":"陈意涵,薛凯琪,杨子姗","cat":"剧情,爱情","wish":30224,"3d":false,"dur":118,"img":"http://p1.meituan.net/165.220/movie/__48665963__9098444.jpg","time":"","id":78772,"snum":68752},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"十万个冷笑话","ver":"2D","sc":8.2,"src":"","rt":"2014-12-31上映","pn":79,"preSale":0,"vd":"","scm":"男主有点拽，二次元崩坏","showDate":"","imax":false,"dir":"卢恒宇,李姝洁","star":"张杰,皇贞季,宝木中阳","cat":"动画,喜剧,奇幻","wish":25775,"3d":false,"dur":100,"img":"http://p1.meituan.net/165.220/movie/56cb96b2c6df95b66db4ce719993d5d0666565.jpg","time":"","id":246067,"snum":122612},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"奔跑吧！兄弟","ver":"2D","sc":4.7,"src":"","rt":"2015-01-30上映","pn":118,"preSale":0,"vd":"","scm":"跑男再出发，集体游三亚","showDate":"","imax":false,"dir":"胡笳,岑俊义","star":"杨颖,王宝强,李晨","cat":"喜剧,冒险,动作","wish":49025,"3d":false,"dur":88,"img":"http://p0.meituan.net/165.220/movie/85f0d9a604e26be5523a848269346697296774.jpg","time":"","id":246316,"snum":361096},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"横冲直撞好莱坞","ver":"2D/中国巨幕","sc":7.7,"src":"","rt":"2015-06-26上映","pn":273,"preSale":0,"vd":"","scm":"逗比好基友，遇到坏导游","showDate":"","imax":false,"dir":"蒂姆·肯德尔","star":"赵薇,黄晓明,佟大为","cat":"喜剧,动作,冒险","wish":64522,"3d":false,"dur":119,"img":"http://p1.meituan.net/165.220/movie/1c06c9055cb3990e76ee93c2c70789bb145247.jpg","time":"","id":246178,"snum":282793},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"通灵之六世古宅","ver":"2D/3D/中国巨幕","sc":4.5,"src":"","rt":"2015-07-24上映","pn":101,"preSale":0,"vd":"","scm":"古宅心慌慌，通灵少女忙","showDate":"","imax":false,"dir":"彭发","star":"徐娇,张兆辉,毕秀茹","cat":"惊悚,恐怖","wish":34072,"3d":true,"dur":87,"img":"http://p1.meituan.net/165.220/movie/575f1cee324dd206d981b4dfcb1ec1bd1381691.jpg","time":"","id":246249,"snum":20076},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"既然青春留不住","ver":"2D","sc":8.2,"src":"","rt":"2015-10-23上映","pn":172,"preSale":0,"vd":"","scm":"校草撞菠菜，青春已不再","showDate":"","imax":false,"dir":"田蒙","star":"张翰,陈乔恩,施予斐","cat":"喜剧,爱情","wish":78433,"3d":false,"dur":92,"img":"http://p0.meituan.net/165.220/movie/90422e83536df2153ecc57ff9703e99c1111187.jpg","time":"","id":246540,"snum":83843},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"我的诗篇","ver":"2D","sc":0,"src":"","rt":"2015-11-01上映","pn":19,"preSale":0,"vd":"","scm":"生产线诗歌，朴素却深刻","showDate":"","imax":false,"dir":"吴飞跃,秦晓宇","star":"乌鸟鸟,陈年喜,老井","cat":"纪录片","wish":631,"3d":false,"dur":110,"img":"http://p1.meituan.net/165.220/movie/a93a7b21b94073e778d30962a409cb02172463.jpg","time":"","id":341084,"snum":124},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"大电影2.0之两个傻瓜的荒唐事","ver":"2D","sc":5.6,"src":"","rt":"2007-12-21上映","pn":3,"preSale":0,"vd":"","scm":"姚晨王宝强，爆笑太疯狂","showDate":"","imax":false,"dir":"阿甘","star":"郭涛,刘心悠,李灿森","cat":"喜剧","wish":107,"3d":false,"dur":97,"img":"http://p1.meituan.net/165.220/movie/76ac89dad45ac25c676246dc92794b03318660.png","time":"","id":536,"snum":93},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"Hold住爱","ver":"2D","sc":5.9,"src":"","rt":"2012-08-23上映","pn":300,"preSale":0,"vd":"","scm":"假戏变真做，幂威秀爱火","showDate":"","imax":false,"dir":"张琦","star":"杨幂,刘恺威,周秀娜","cat":"喜剧,爱情,悬疑","wish":280,"3d":false,"dur":95,"img":"http://p0.meituan.net/165.220/movie/29/274730.jpg","time":"","id":729,"snum":754},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"厨子戏子痞子","ver":"2D","sc":8.3,"src":"","rt":"2013-03-29上映","pn":281,"preSale":0,"vd":"","scm":"三男一台戏，客栈解僵局","showDate":"","imax":false,"dir":"管虎","star":"黄渤,刘烨,张涵予","cat":"剧情,喜剧,动作","wish":10110,"3d":false,"dur":108,"img":"http://p0.meituan.net/165.220/movie/__7277442__6071578.jpg","time":"","id":969,"snum":5760},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"人间蒸发","ver":"2D","sc":7,"src":"","rt":"2013-04-28上映","pn":22,"preSale":0,"vd":"","scm":"惊心动魄的寻亲之旅","showDate":"","imax":false,"dir":"梁德森","star":"钟丽缇,柳岩,李灿森","cat":"悬疑,惊悚","wish":771,"3d":false,"dur":90,"img":"http://p0.meituan.net/165.220/movie/__6680785__5992311.jpg","time":"","id":78094,"snum":182},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"京城81号","ver":"2D/3D","sc":5,"src":"","rt":"2014-07-18上映","pn":98,"preSale":0,"vd":"","scm":"古宅阴森处，少妇诉凄苦","showDate":"","imax":false,"dir":"叶伟民","star":"吴镇宇,林心如,杨祐宁","cat":"剧情,悬疑,恐怖","wish":36817,"3d":true,"dur":90,"img":"http://p1.meituan.net/165.220/movie/__48584093__3431812.jpg","time":"","id":78267,"snum":122362},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"左耳","ver":"2D","sc":7.9,"src":"","rt":"2015-04-24上映","pn":315,"preSale":0,"vd":"","scm":"青春要恋爱，别忘堕堕胎","showDate":"","imax":false,"dir":"苏有朋","star":"陈都灵,欧豪,杨洋","cat":"爱情","wish":82116,"3d":false,"dur":117,"img":"http://p0.meituan.net/165.220/movie/da55f29972ec0b9692ba7055905892c8123092.jpg","time":"","id":246210,"snum":538090},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"美人鱼之海盗来袭","ver":"2D","sc":5.5,"src":"","rt":"2015-07-31上映","pn":38,"preSale":0,"vd":"","scm":"国产美人鱼，俩海盗来袭","showDate":"","imax":false,"dir":"邱浩强","star":"李思娴,郭亚维,宋磊","cat":"动画,喜剧,冒险","wish":27716,"3d":false,"dur":85,"img":"http://p0.meituan.net/165.220/movie/7e15953aa8bc5be4e7bff00913426a06920765.jpg","time":"","id":248550,"snum":21962},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"陪安东尼度过漫长岁月","ver":"2D","sc":7.8,"src":"","rt":"2015-11-13上映","pn":564,"preSale":0,"vd":"","scm":"文艺大暖男，不二常相伴","showDate":"","imax":false,"dir":"秦小珍","star":"刘畅,白百何,唐艺昕","cat":"剧情,爱情","wish":120703,"3d":false,"dur":121,"img":"http://p1.meituan.net/165.220/movie/9f0d994eafbf52e7b0145b7746d1d881246635.jpg","time":"","id":246583,"snum":78393},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"nm":"大唐玄奘","ver":"2D/中国巨幕","sc":7.7,"src":"","rt":"2016-04-29上映","pn":232,"preSale":0,"vd":"","scm":"了却世间恨，尽是取经人","showDate":"","imax":false,"dir":"霍建起","star":"黄晓明,蒲巴甲,徐峥","cat":"剧情,历史","wish":23799,"3d":false,"dur":120,"img":"http://p0.meituan.net/165.220/movie/c1cbba6359ef62bbb5bdd5311708c828413080.jpg","time":"","id":338357,"snum":28471},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"nm":"记忆碎片","ver":"2D","sc":6.9,"src":"","rt":"2016-06-03上映","pn":47,"preSale":0,"vd":"","scm":"宿醉陷疑案，奋力查嫌犯","showDate":"","imax":false,"dir":"朴裕焕","star":"雷佳音,夏梓桐,李菁","cat":"悬疑,喜剧,犯罪","wish":4154,"3d":false,"dur":94,"img":"http://p1.meituan.net/165.220/movie/ea15948d63d527d092a70e39cbb74636357253.jpg","time":"","id":345923,"snum":2974}]
     */

    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        private boolean hasNext;
        /**
         * late : false
         * showInfo : 今天151家影院放映2003场
         * cnms : 0
         * sn : 0
         * nm : 惊天魔盗团2
         * ver : 2D/3D/中国巨幕
         * sc : 8.7
         * src :
         * rt : 本周五上映
         * pn : 244
         * preSale : 0
         * vd :
         * scm : 周董变魔术，敌人挡不住
         * showDate :
         * imax : false
         * dir : 朱浩伟
         * star : 杰西·艾森伯格,马克·鲁法洛,伍迪·哈里森
         * cat : 动作,喜剧,惊悚
         * wish : 513937
         * 3d : true
         * dur : 126
         * img : http://p1.meituan.net/165.220/movie/2e0b5b5c6c086cc93068fbc212f9f6b0142193.jpg
         * time :
         * id : 246333
         * snum : 44771
         */

        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            private boolean late;
            private String showInfo;
            private int cnms;
            private int sn;
            private String nm;
            private String ver;
            private double sc;
            private String src;
            private String rt;
            private int pn;
            private int preSale;
            private String vd;
            private String scm;
            private String showDate;
            private boolean imax;
            private String dir;
            private String star;
            private String cat;
            private int wish;
            @SerializedName("3d")
            private boolean value3d;
            private int dur;
            private String img;
            private String time;
            private int id;
            private int snum;

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean isValue3d() {
                return value3d;
            }

            public void setValue3d(boolean value3d) {
                this.value3d = value3d;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }
        }
    }
}
