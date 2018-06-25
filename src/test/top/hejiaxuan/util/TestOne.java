package top.hejiaxuan.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

public class TestOne {

    String name = "A·B·C·D·E·F·G·H·I·J·K·L·M·N·O·P·Q·R·S·T·U·V·W·X·Y·Z·璃莹殇·安洁莉娜·樱雪羽晗灵·血丽魑·魅·J·Q·安塔利亚·伤梦薰魅·海瑟薇·蔷薇玫瑰泪·羽灵·邪儿·凡多姆海威恩·夏影·琉璃舞·雅·蕾玥瑷雅·曦梦月·玥蓝·岚樱·紫蝶·丽馨·蕾琦洛·凤·颜鸢·希洛·玖兮·雨烟·叶洛莉兰·凝羽冰·泪伊如冰落·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·安吉拉·姆斯基·柔月兰·美惠可薇安朵·兰殇月·梦茹妙可铃·云裳月舞纱·莉可朵·塲殇雪颖泪蝶·影梦雅兰·觞蕴燢覮·铧累觷儠·摋孆瞲櫗刿鷡·氩浅趯鸑萦儽·骅璎糜婺嚻觷龠鹦·苏韎凪麴莳·雪乖冰·娥爱寂翼巧·丝哀琪·俏莉娅·梦茹莎·樱冰泪蝶喃凤涅盘·璃殇玖璃梦·沫辰芝兰琴艾柒·安娜·黛丝·艾曼妲·眉纱御寇·安妮·苏丽·莉莉丝·艾米丽·菲奥娜·格格利亚·萨曼塔·温蒂·兰尼·丽塔吉娜·洛丽丝·可菲尔·欣·佳奈·璃莹殇·安洁莉娜·樱雪羽晗灵·血丽魑·魅·J·Q·安塔利亚·伤梦薰魅·海瑟薇·蔷薇玫瑰泪·羽灵·邪儿·凡多姆海威恩·夏影·琉璃舞·雅·蕾玥瑷雅·曦梦月·玥蓝·岚樱·紫蝶·丽馨·蕾琦洛·凤·颜鸢·希洛·玖兮·雨烟·叶洛莉兰·凝羽冰·泪伊如冰落·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·凝羽冰蓝璃·泪伊如冰缈娅泪落冰花紫蝶梦珠·殇心樱语冰凌伊娜·洛丽塔紫心爱·蝶梦如璃紫陌悠千艳·优花梦冰玫瑰灵伤如爱·晶泪墨阳云筱残伤雅·琉璃爱梦莲泪·冰雪殇璃陌梦·爱樱沫渺·落璃琴依语·千梦然丝伤·可薇·茉殇黎·幽幻紫银·泪如韵影倾乐兰慕·冰雪殇璃陌梦·凝羽冰蓝璃·泪伊如琉璃爱梦莲泪·冰雅泪落冰紫蝶梦·殇心樱语冰凌伊蝶梦如·璃紫陌悠千艳优墨阳云筱残·雪莲茉·伊文思·蕊夏清·碎墨音·芊乐梦黛怡·墨丽莎·梦灵苏魅香·紫蓝幽幻倾城萌美迷离·茉莉白嫩爱凤风魑·殇泪花如霜梦兰·萝莉心梦妖丽百千艳·瑰百合香珠合梦喃·泪伤梦雅爱之瑰·墨艳黎幻殇雪倩梦·情娜血清恋沫幽弥千月绯心丝梦灵蓝千月筱雪殇·希羽岚梦心殇雨樱琉璃舞韵倾雅·蕾玥瑷雅芸茜殇樱雪梦·曦魂梦月澪瑷琪欣泪·咝玥蓝·岚樱殇紫乐蝶雨·苏丽落雅馨瑷魅·音蕾琦洛凤之幽·蠫赬飖·风璃殇·颜鸢璃沫血伤·月冰灵希洛梦·玖兮恋琴爱·雨烟雪殇萌呗·血叶洛莉兰·安吉拉·姆斯基·柔月兰·美惠可薇安朵·兰殇月·梦茹妙可铃·云裳月舞纱·莉可朵·塲殇雪颖泪蝶·影梦雅兰·觞蕴燢覮·铧累觷儠·摋孆瞲櫗刿鷡·氩浅趯鸑萦儽·骅璎糜婺嚻觷龠鹦·苏韎凪麴莳·雪乖冰·娥爱寂翼巧·丝哀琪·俏莉娅·梦茹莎·樱冰泪蝶喃凤涅盘·璃殇玖璃梦·沫辰芝兰琴艾柒·安娜·黛丝·艾曼妲·眉纱御寇·安妮·苏丽·莉莉丝·艾米丽·菲奥娜·格格利亚·萨曼塔·温蒂·兰尼·丽塔吉娜·洛丽丝·兰子安克乃·苏眉凪湿掉·力压米兰可压";

    @Test
    public void name() throws Exception {
        Set<String> strings = new HashSet<>();
        for (String s : name.split("·")) {
            strings.add(s);
        }
        List<String> list = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            list.add(next);
        }

        int len = 3;

        for (int y = 0; y < 100; y++) {
            Random random = new Random();

            String[] s = new String[len];
            for (int i = 0; i < len; i++) {
                int i1 = random.nextInt(list.size());
                s[i] = list.get(i1);
            }

            System.out.println(StringUtils.join(s, "·"));

        }
    }
}