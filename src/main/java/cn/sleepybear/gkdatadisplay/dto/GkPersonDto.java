package cn.sleepybear.gkdatadisplay.dto;

import cn.sleepybear.gkdatadisplay.model.GkPerson;
import cn.sleepybear.gkdatadisplay.util.CommonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2024/08/19 21:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GkPersonDto extends BaseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 241524451418939825L;

    private Integer useType;
    private String description;
    private String year;
    private String type;
    private String bdylfx;
    private String beizhu;
    private String bj;
    private String bkkl;
    private String bklb;
    private String bmd;
    private String bmdFix;
    private String bmdmc;
    private String bmxh;
    private String brjl1;
    private String brjl2;
    private String brtc;
    private String bylb;
    private String bylbdm;
    private String byxx;
    private String byzymc;
    private String bz;
    private String cjgkkm;
    private String cjgspcs;
    private String cjksblsq;
    private String cjtzscs;
    private String confirm;
    private String csny;
    private String dfzxbz;
    private String dqdm;
    private String dsh;
    private String gddh;
    private String gjzxj;
    private String gspcsxmmc;
    private String gxzxbz;
    private String gzjdry;
    private String gzjdrz;
    private String hj;
    private String hjdm;
    private String hjmc;
    private String hjqk;
    private String jnbh;
    private String jndj;
    private String jnmcdj;
    private String jrbz;
    private String kglb;
    private String kldm;
    private String ksh;
    private String kslb;
    private String kslbdm;
    private String kslxdm;
    private String kstz;
    private String llks;
    private String lqlxdm;
    private String lxdh;
    private String lxdh2;
    private String minzu;
    private String ndbxs;
    private String petsflag;
    private String petsksny;
    private String qdzs;
    private String qtlzy;
    private String qttycsxm;
    private String qtxx;
    private String qydm;
    private String ryqk;
    private String rzqk;
    private String sfzh;
    private String shzt;
    private String skkm;
    private String snb;
    private String sqbz;
    private String ssmzszxz;
    private String sxdm;
    private String sxmc;
    private String sxpd;
    private String sycfdm;
    private String tjjldm;
    private String txdz;
    private String tycsxmmc;
    private String tydb;
    private String tydbjg;
    private String tyywb;
    private String tyzycs;
    private String wdwz;
    private String wswgzn;
    private String wyks;
    private String wyyz;
    private String xingbie;
    private String xjfh;
    private String xkkm;
    private String xm;
    private String xqh;
    private String yddh;
    private String ysjzdm;
    private String yslzy;
    private String ystysk;
    private String yybmxh;
    private String yymslb;
    private String yzbm;
    private String yzzt;
    private String zbytks;
    private String zcjfsb;
    private String zjhm;
    private String zjlx;
    private String zjlxdm;
    private String zkzh;
    private String zslbmc;
    private String zsqk;
    private String zylb;
    private String zylbdm;
    private String zzmm;
    private String zzmmmc;
    private String ccdm;
    private String jhsxdm;
    private String jhxzdm;
    private String lqbz;
    private String lqsj;
    private String lqzyxh;
    private String pcdm;
    private String lqpcdm;
    private String xz;
    private String yxdh;
    private String yxdm;
    private String yxmc;
    private String zf;
    private String zgbmdm;
    private String zydm;
    private String zydh;
    private String lqzydm;
    private String zymc;
    private String cc;
    private String jhrs;
    private String jhzxs;

    public static GkPersonDto convert(GkPerson gkPerson) {
        return CommonUtils.copyBean(gkPerson, GkPersonDto.class);
    }

    public static List<GkPersonDto> convert(List<GkPerson> list) {
        return CommonUtils.copyBean(list, GkPersonDto.class);
    }
}
