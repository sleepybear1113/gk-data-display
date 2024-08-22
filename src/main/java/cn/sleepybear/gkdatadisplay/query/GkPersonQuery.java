package cn.sleepybear.gkdatadisplay.query;

import cn.sleepybear.gkdatadisplay.exception.FrontException;
import cn.sleepybear.gkdatadisplay.model.GkPerson;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 22:51
 */
@Data
public class GkPersonQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 8525393088999233883L;

    private static final String LIKE_SYMBOL = "*";
    private static final String LIKE_SYMBOL_SQL = "%";
    private static final char LIKE_SYMBOL_SQL_CHAR = '%';

    private String name;
    private List<String> year;
    private String bmd;
    private String bmdFix;
    private String sfzh;
    private String yxmc;
    private String zymc;
    private List<String> xqh;
    private String ksh;
    private String qtxx;
    private String phone;
    private String cc;

    public LambdaQueryWrapper<GkPerson> toQueryWrapper() {
        LambdaQueryWrapper<GkPerson> queryWrapper = new LambdaQueryWrapper<>();
        if (name != null) {
            // 正则表达式去除空格
            name = name.replaceAll("\\s+", "");
            if (!name.isEmpty()) {
                name = name.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                // 逗号分隔的字符串转为列表
                List<String> nameList = List.of(replaceUtil(name, List.of("，", ";", "；"), ",").split(","));
                if (judgeSameChar(nameList, LIKE_SYMBOL_SQL_CHAR)) {
                    throw new FrontException("查询条件不能全为通配符");
                }
                queryWrapper.nested(qw -> nameList.forEach(s -> qw.or().apply(applyTemplate("xm"), s)));
            }
        }

        if (year != null && !year.isEmpty()) {
            queryWrapper.in(GkPerson::getYear, year);
        }

        if (bmd != null) {
            // 正则表达式去除空格
            bmd = bmd.replaceAll("\\s+", "");
            if (!bmd.isEmpty()) {
                bmd = bmd.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                if (judgeSameChar(bmd, LIKE_SYMBOL_SQL_CHAR)) {
                    throw new FrontException("查询条件不能全为通配符");
                }
                queryWrapper.apply(applyTemplate("bmd"), bmd);
            }
        }

        if (bmdFix != null) {
            // 正则表达式去除空格
            bmdFix = bmdFix.replaceAll("\\s+", "");
            if (!bmdFix.isEmpty()) {
                bmdFix = bmdFix.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                if (judgeSameChar(bmdFix, LIKE_SYMBOL_SQL_CHAR)) {
                    throw new FrontException("查询条件不能全为通配符");
                }
                queryWrapper.apply(applyTemplate("bmd_fix"), bmdFix);
            }
        }

        if (sfzh != null) {
            // 与 name 相同处理逻辑
            sfzh = sfzh.replaceAll("\\s+", "");
            if (!sfzh.isEmpty()) {
                sfzh = sfzh.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                List<String> sfzhList = List.of(replaceUtil(sfzh, List.of("，", ";", "；"), ",").split(","));
                if (judgeSameChar(sfzhList, LIKE_SYMBOL_SQL_CHAR)) {
                    throw new FrontException("查询条件不能全为通配符");
                }
                queryWrapper.nested(qw -> sfzhList.forEach(s -> qw.or().apply(applyTemplate("sfzh"), s)));
            }
        }

        if (yxmc != null) {
            // 与 name 相同处理逻辑
            yxmc = yxmc.replaceAll("\\s+", "");
            if (!yxmc.isEmpty()) {
                yxmc = yxmc.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                List<String> yxmcList = List.of(replaceUtil(yxmc, List.of("，", ";", "；"), ",").split(","));
                queryWrapper.nested(qw -> yxmcList.forEach(s -> qw.or().apply(applyTemplate("yxmc"), s)));
            }
        }

        if (zymc != null) {
            // 与 name 相同处理逻辑
            zymc = zymc.replaceAll("\\s+", "");
            if (!zymc.isEmpty()) {
                zymc = zymc.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                List<String> zymcList = List.of(replaceUtil(zymc, List.of("，", ";", "；"), ",").split(","));
                if (judgeSameChar(zymcList, LIKE_SYMBOL_SQL_CHAR)) {
                    throw new FrontException("查询条件不能全为通配符");
                }
                queryWrapper.nested(qw -> zymcList.forEach(s -> qw.or().apply(applyTemplate("zymc"), s)));
            }
        }

        if (xqh != null && !xqh.isEmpty()) {
            queryWrapper.in(GkPerson::getXqh, xqh);
        }

        if (ksh != null) {
            // 与 name 相同处理逻辑
            ksh = ksh.replaceAll("\\s+", "");
            if (!ksh.isEmpty()) {
                ksh = ksh.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                List<String> kshList = List.of(replaceUtil(ksh, List.of("，", ";", "；"), ",").split(","));
                if (judgeSameChar(kshList, LIKE_SYMBOL_SQL_CHAR)) {
                    throw new FrontException("查询条件不能全为通配符");
                }
                queryWrapper.nested(qw -> kshList.forEach(s -> qw.or().apply(applyTemplate("ksh"), s)));
                queryWrapper.nested(qw -> kshList.forEach(s -> qw.or().apply(applyTemplate("bmxh"), s)));
                queryWrapper.nested(qw -> kshList.forEach(s -> qw.or().apply(applyTemplate("zkzh"), s)));
                queryWrapper.nested(qw -> kshList.forEach(s -> qw.or().apply(applyTemplate("xjfh"), s)));
            }
        }

        if (qtxx != null) {
            // 与 name 相同处理逻辑
            qtxx = qtxx.replaceAll("\\s+", "");
            if (!qtxx.isEmpty()) {
                qtxx = qtxx.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                List<String> qtxxList = List.of(replaceUtil(qtxx, List.of("，", ";", "；"), ",").split(","));
                if (judgeSameChar(qtxxList, LIKE_SYMBOL_SQL_CHAR)) {
                    throw new FrontException("查询条件不能全为通配符");
                }
                queryWrapper.nested(qw -> qtxxList.forEach(s -> qw.or().apply(applyTemplate("qtxx"), s)));
            }
        }

        if (phone != null) {
            // 与 name 相同处理逻辑
            phone = phone.replaceAll("\\s+", "");
            if (!phone.isEmpty()) {
                phone = phone.replace(LIKE_SYMBOL, LIKE_SYMBOL_SQL);
                List<String> phoneList = List.of(replaceUtil(phone, List.of("，", ";", "；"), ",").split(","));
                queryWrapper.nested(qw -> phoneList.forEach(s -> qw.or().eq(GkPerson::getLxdh, s).or().eq(GkPerson::getLxdh2, s).or().eq(GkPerson::getGddh, s)));
            }
        }

        if (cc != null && !cc.isEmpty()) {
            if ("未知".equals(cc)) {
                queryWrapper.nested(qw -> qw.isNull(GkPerson::getCc).or().eq(GkPerson::getCc, "未知"));
            } else if ("专科".equals(cc)) {
                queryWrapper.nested(qw -> qw.eq(GkPerson::getCc, "高职(专科)").or().eq(GkPerson::getCc, "专科"));
            } else {
                queryWrapper.eq(GkPerson::getCc, cc);
            }
        }

        if (queryWrapper.isEmptyOfWhere()) {
            throw new FrontException("查询条件不能为空");
        }
        return queryWrapper;
    }

    private static String replaceUtil(String s, List<String> list, String target) {
        for (String s1 : list) {
            s = s.replace(s1, target);
        }
        return s;
    }

    private static String applyTemplate(String colName) {
        return colName + " like {0}";
    }

    private static boolean judgeSameChar(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    private static boolean judgeSameChar(List<String> s, char c) {
        for (String s1 : s) {
            if (!judgeSameChar(s1, c)) {
                return false;
            }
        }
        return true;
    }
}
