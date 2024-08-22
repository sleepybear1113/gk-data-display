const {createApp} = Vue;
let app = createApp({
    data() {
        return {
            gkPersonQuery: new GkPersonQuery().defaultItem(),
            years: [],
            xqList: [[36, '市区'], [38, '嘉善'], [39, '平湖'], [40, '海宁'], [41, '海盐'], [42, '桐乡']],
            gkPersonSimpleDtoList: [],
            appInfo: new AppInfoDto(),
            querying: false,
            alertObj: {},
        }
    },
    created() {
        // years 从 2001 到今年，逆序
        let nowYear = new Date().getFullYear();
        for (let i = nowYear; i >= 2001; i--) {
            this.years.push(i);
        }
        this.years.push("9999");

        this.getAppInfo();
    },
    methods: {
        getAppInfo() {
            let url = "/system/getAppInfo";
            axios.get(url).then(res => {
                let result = res.data.result;
                if (result) {
                    this.appInfo = new AppInfoDto(result);
                }
            });
        },
        query() {
            let url = "/query/gkData";
            this.querying = true;
            axios.post(url, this.gkPersonQuery).then(res => {
                let result = res.data.result;
                if (result) {
                    this.gkPersonSimpleDtoList = [];
                    for (let i = 0; i < result.length; i++) {
                        this.gkPersonSimpleDtoList.push(new GkPersonSimpleDto(result[i]));
                    }
                } else {
                    this.gkPersonSimpleDtoList = null;
                }
                this.querying = false;
            }).catch(() => {
                this.querying = false;
            });
        },
        clearQuery() {
            this.gkPersonQuery = new GkPersonQuery().defaultItem();
        },
        chooseYears(n) {
            // 今年年份
            let nowYear = new Date().getFullYear();
            // 最近 n 年的数组
            this.gkPersonQuery.year = [];
            if (n) {
                for (let i = 0; i < n; i++) {
                    this.gkPersonQuery.year.push(nowYear - i);
                }
            }
        },
    },
    watch: {
    }
}).mount("#app");

window.app = app;