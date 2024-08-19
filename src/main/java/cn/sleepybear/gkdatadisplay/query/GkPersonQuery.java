package cn.sleepybear.gkdatadisplay.query;

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

    private String name;
    /**
     * 0 or null: equals, 1: like, 2: all like %n%a%m%e%
     */
    private Integer nameLikeType;

    private List<String> year;

    private String bmd;
    /**
     * 0 or null: equals, 1: like
     */
    private Integer bmdLikeType;

    private String bmdFix;
    /**
     * 0 or null: equals, 1: like
     */
    private Integer bmdFixLikeType;

    private String sfzh;
    /**
     * 0 or null: equals, 1: like
     */
    private Integer sfzhLikeType;

    private String yxmc;
    /**
     * 0 or null: equals, 1: like
     */
    private Integer yxmcLikeType;

    private String zymc;
    /**
     * 0 or null: equals, 1: like
     */
    private Integer zymcLikeType;

    private List<String> xqh;

    private List<String> ksh;

    private String qtxx;
    /**
     * 0 or null: equals, 1: like
     */
    private Integer qtxxLikeType;

    private String phone;

    private String cc;

    public LambdaQueryWrapper<GkPerson> toQueryWrapper() {
        LambdaQueryWrapper<GkPerson> queryWrapper = new LambdaQueryWrapper<>();
        if (name != null) {
            switch (nameLikeType) {
                case 1 -> queryWrapper.like(GkPerson::getXm, name);
                case 2 -> {
                    // 每个字符之间插入 % 来进行 like
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < name.length(); i++) {
                        sb.append(name.charAt(i)).append("%");
                    }
                    queryWrapper.like(GkPerson::getXm, sb.toString());
                }
                case null, default -> queryWrapper.eq(GkPerson::getXm, name);
            }
        }

        if (year != null && !year.isEmpty()) {
            queryWrapper.in(GkPerson::getYear, year);
        }

        if (bmd != null) {
            switch (bmdLikeType) {
                case 1 -> queryWrapper.like(GkPerson::getBmd, bmd);
                case null, default -> queryWrapper.eq(GkPerson::getBmd, bmd);
            }
        }

        if (bmdFix != null) {
            if (bmdFixLikeType == 1) {
                queryWrapper.like(GkPerson::getBmdFix, bmdFix);
            } else {
                queryWrapper.eq(GkPerson::getBmdFix, bmdFix);
            }
        }

        if (sfzh != null) {
            switch (sfzhLikeType) {
                case 1 -> queryWrapper.like(GkPerson::getSfzh, sfzh).or().like(GkPerson::getZjhm, sfzh);
                case null, default -> queryWrapper.eq(GkPerson::getSfzh, sfzh).or().eq(GkPerson::getZjhm, sfzh);
            }
        }

        if (yxmc != null) {
            switch (yxmcLikeType) {
                case 1 -> queryWrapper.like(GkPerson::getYxmc, yxmc);
                case null, default -> queryWrapper.eq(GkPerson::getYxmc, yxmc);
            }
        }

        if (zymc != null) {
            switch (zymcLikeType) {
                case 1 -> queryWrapper.like(GkPerson::getZymc, zymc);
                case null, default -> queryWrapper.eq(GkPerson::getZymc, zymc);
            }
        }

        if (xqh != null && !xqh.isEmpty()) {
            queryWrapper.in(GkPerson::getXqh, xqh);
        }

        if (ksh != null && !ksh.isEmpty()) {
            queryWrapper.in(GkPerson::getKsh, ksh).or().in(GkPerson::getBmxh, ksh).or().in(GkPerson::getZkzh, ksh);
        }

        if (qtxx != null) {
            switch (qtxxLikeType) {
                case 1 -> queryWrapper.like(GkPerson::getQtxx, qtxx);
                case null, default -> queryWrapper.eq(GkPerson::getQtxx, qtxx);
            }
        }

        if (phone != null) {
            queryWrapper.eq(GkPerson::getLxdh, phone).or().eq(GkPerson::getLxdh2, phone).or().eq(GkPerson::getGddh, phone);
        }

        if (cc != null) {
            queryWrapper.eq(GkPerson::getCc, cc);
        }

        return queryWrapper;
    }
}
