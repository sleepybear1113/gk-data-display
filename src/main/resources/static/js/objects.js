class BaseDto {
    constructor(props = {}) {
        this.id = props.id;
        this.createTime = props.createTime;
        this.modifyTime = props.modifyTime;
        this.deleted = props.deleted;
    }
}

class GkPersonQuery {
    constructor(props = {}) {
        this.name = props.name;
        this.nameLikeType = props.nameLikeType;
        this.year = mapToArray(props.year);
        this.bmd = props.bmd;
        this.bmdLikeType = props.bmdLikeType;
        this.bmdFix = props.bmdFix;
        this.bmdFixLikeType = props.bmdFixLikeType;
        this.sfzh = props.sfzh;
        this.sfzhLikeType = props.sfzhLikeType;
        this.yxmc = props.yxmc;
        this.yxmcLikeType = props.yxmcLikeType;
        this.zymc = props.zymc;
        this.zymcLikeType = props.zymcLikeType;
        this.xqh = mapToArray(props.xqh);
        this.ksh = mapToArray(props.ksh);
        this.qtxx = props.qtxx;
        this.qtxxLikeType = props.qtxxLikeType;
        this.phone = props.phone;
        this.cc = props.cc;
    }
}


function mapToArray(prop, Obj) {
    return prop ? prop.map(item => Obj ? new Obj(item) : item) : [];
}