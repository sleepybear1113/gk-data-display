const {createApp} = Vue;
let app = createApp({
    data() {
        return {
            gkPersonQuery: new GkPersonQuery(),

        }
    },
    created() {

    },
    methods: {
        query() {
            let url = "/queryGkData";
            axios.post(url, this.gkPersonQuery).then(res => {
                console.log(res.data);
            }).catch(() => {
            });
        },
    },
    watch: {
    }
});
app.mount("#app");