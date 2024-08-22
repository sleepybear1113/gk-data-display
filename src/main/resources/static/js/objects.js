class BaseDto {
    constructor(props = {}) {
        this.id = props.id;
        this.createTime = props.createTime;
        this.modifyTime = props.modifyTime;
    }
}

class AppInfoDto {
    constructor(props = {}) {
        this.version = props.version;
        this.sqlLimitSize = props.sqlLimitSize;
    }
}

class GkPersonQuery {
    constructor(props = {}) {
        this.name = props.name;
        this.year = mapToArray(props.year);
        this.bmd = props.bmd;
        this.bmdFix = props.bmdFix;
        this.sfzh = props.sfzh;
        this.yxmc = props.yxmc;
        this.zymc = props.zymc;
        this.xqh = mapToArray(props.xqh);
        this.ksh = props.ksh;
        this.qtxx = props.qtxx;
        this.phone = props.phone;
        this.cc = props.cc;
    }

    defaultItem() {
        this.name = "";
        this.year = [];
        this.bmd = "";
        this.bmdFix = "";
        this.sfzh = "";
        this.yxmc = "";
        this.zymc = "";
        this.xqh = [];
        this.ksh = "";
        this.qtxx = "";
        this.phone = "";
        this.cc = "";
        return this;
    }
}

class GkPersonSimpleDto {
    constructor(props = {}) {
        this.id = props.id;
        this.year = props.year;
        this.xm = props.xm;
        this.sfzh = props.sfzh;
        this.zjhm = props.zjhm;
        this.bj = props.bj;
        this.xqh = props.xqh;
        this.bmd = props.bmd;
        this.bmdmc = props.bmdmc;
        this.bmdFix = props.bmdFix;
        this.yxmc = props.yxmc;
        this.yxdh = props.yxdh;
        this.yxdm = props.yxdm;
        this.zymc = props.zymc;
        this.zydh = props.zydh;
        this.zydm = props.zydm;
        this.lqsj = props.lqsj;
        this.xqh = props.xqh;
        this.ksh = props.ksh;
        this.zkzh = props.zkzh;
        this.bmxh = props.bmxh;
        this.xjfh = props.xjfh;
        this.qtxx = props.qtxx;
        this.lxdh = props.lxdh;
        this.lxdh2 = props.lxdh2;
        this.gddh = props.gddh;
        this.cc = props.cc;
        this.xz = props.xz;
    }
}


function mapToArray(prop, Obj) {
    return prop ? prop.map(item => Obj ? new Obj(item) : item) : [];
}