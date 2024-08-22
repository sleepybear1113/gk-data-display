// axios 全局拦截器
axios.interceptors.response.use(
    // 如果返回的状态码为 200，说明接口请求成功，可以正常拿到数据
    (response) => {
        let status = response.status;
        if (status === 200) {
            let res = response.data;
            let code = res.code;
            if (code === 0) {
                return response;
            } else {
                let message = res.message;
                if (code > -10) {
                    alertMsg(null, message, "warning");
                    return Promise.reject(response);
                } else if (code) {
                    alertMsg("系统错误", message, "danger");
                    // 直接拒绝往下面返回结果信息
                    return Promise.reject(response);
                }
                return response;
            }
        }
        return response;
    },
    // 否则的话抛出错误
    (error) => {
        let response = error.response;
        if (response == null) {
            alertMsg(`请求失败，请检查程序是否启动`, "", "danger");
            return Promise.reject(error);
        }
        let status = response.status;
        let request = error.request;
        // 401 到 index.html
        if (status === 401) {
            window.location.href = "/index.html";
            return Promise.reject(error);
        }
        if (status >= 500) {
            alertMsg(`服务器发生错误[${status}]，无法处理！`, `${request.responseURL}`, "danger");
            return Promise.reject(error);
        }

        alertMsg(`请求失败，code = ${status}`, `url：${request.responseURL}`, "danger");
        return Promise.reject(error);
    }
);
axios.interceptors.request.use(
    config => {
        if (config.method === "get") {
            config.params = {
                ...config.params,
                _t: new Date().getTime().toString().substring(6, 13),
            };
        }
        config.headers["Request-From"] = "axios";
        return config
    }, function (error) {
        return Promise.reject(error);
    },
);

function alertMsg(title, message, type, duration = 3000) {
    let t = new Date().getTime();
    let alertInfo = {
        "id": t,
        "title": title,
        "msg": message,
        "type": type,
        "time": new Date().getTime(),
        "duration": duration
    };
    window.app.alertObj[t] = alertInfo;
    let timer = setTimeout(() => {
        delete window.app.alertObj[t];
        clearTimeout(timer);
    }, duration);
    alertInfo.timer = timer;
}

axios.defaults.baseURL = "/api-gk-data-display/";
