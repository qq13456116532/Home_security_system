const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm35n6k/",
            name: "ssm35n6k",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm35n6k/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "家用安防系统的设计与实现"
        } 
    }
}
export default base
