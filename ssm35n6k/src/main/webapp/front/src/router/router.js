import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import quyuList from '../pages/quyu/list'
import quyuDetail from '../pages/quyu/detail'
import quyuAdd from '../pages/quyu/add'
import jiankongxinxiList from '../pages/jiankongxinxi/list'
import jiankongxinxiDetail from '../pages/jiankongxinxi/detail'
import jiankongxinxiAdd from '../pages/jiankongxinxi/add'
import xiaoxitixingList from '../pages/xiaoxitixing/list'
import xiaoxitixingDetail from '../pages/xiaoxitixing/detail'
import xiaoxitixingAdd from '../pages/xiaoxitixing/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'quyu',
					component: quyuList
				},
				{
					path: 'quyuDetail',
					component: quyuDetail
				},
				{
					path: 'quyuAdd',
					component: quyuAdd
				},
				{
					path: 'jiankongxinxi',
					component: jiankongxinxiList
				},
				{
					path: 'jiankongxinxiDetail',
					component: jiankongxinxiDetail
				},
				{
					path: 'jiankongxinxiAdd',
					component: jiankongxinxiAdd
				},
				{
					path: 'xiaoxitixing',
					component: xiaoxitixingList
				},
				{
					path: 'xiaoxitixingDetail',
					component: xiaoxitixingDetail
				},
				{
					path: 'xiaoxitixingAdd',
					component: xiaoxitixingAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
