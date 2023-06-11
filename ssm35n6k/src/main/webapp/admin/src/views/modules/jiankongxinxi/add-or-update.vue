<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"padding":"30px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"0 auto","borderColor":"rgba(230, 242, 254, 1)","borderRadius":"6px","borderWidth":"30px 0 0 0","width":"90%","borderStyle":"solid"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="140px"
		>
			<template >
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="input" v-if="type!='info'" label="编号" prop="bianhao">
					<el-input v-model="ruleForm.bianhao" placeholder="编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.bianhao" label="编号" prop="bianhao">
					<el-input v-model="ruleForm.bianhao" placeholder="编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="标题" prop="biaoti">
					<el-input v-model="ruleForm.biaoti" placeholder="标题" clearable  :readonly="ro.biaoti"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' v-else class="input" label="标题" prop="biaoti">
					<el-input v-model="ruleForm.biaoti" placeholder="标题" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="select" v-if="type!='info'"  label="区域" prop="quyu">
					<el-select :disabled="ro.quyu" v-model="ruleForm.quyu" placeholder="请选择区域" >
						<el-option
							v-for="(item,index) in quyuOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' v-else class="input" label="区域" prop="quyu">
					<el-input v-model="ruleForm.quyu"
						placeholder="区域" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="date" v-if="type!='info'" label="更新时间" prop="gengxinshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.gengxinshijian" 
						type="datetime"
						:readonly="ro.gengxinshijian"
						placeholder="更新时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.gengxinshijian" label="更新时间" prop="gengxinshijian">
					<el-input v-model="ruleForm.gengxinshijian" placeholder="更新时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="upload" v-if="type!='info' && !ro.jiankonghuamian" label="监控画面" prop="jiankonghuamian">
					<file-upload
						tip="点击上传监控画面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.jiankonghuamian?ruleForm.jiankonghuamian:''"
						@change="jiankonghuamianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="upload" v-else-if="ruleForm.jiankonghuamian" label="监控画面" prop="jiankonghuamian">
					<img v-if="ruleForm.jiankonghuamian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jiankonghuamian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jiankonghuamian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="upload" v-if="type!='info'&& !ro.jiankongshipin" label="监控视频" prop="jiankongshipin">
					<file-upload
						tip="点击上传监控视频"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.jiankongshipin?ruleForm.jiankongshipin:''"
						@change="jiankongshipinUploadChange"
					></file-upload>
				</el-form-item> 
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' v-else-if="ruleForm.jiankongshipin" label="监控视频" prop="jiankongshipin">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(198, 205, 214, 1)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.jiankongshipin)">预览</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' v-else-if="!ruleForm.jiankongshipin" label="监控视频" prop="jiankongshipin">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(198, 205, 214, 1)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' class="select" v-if="type!='info'"  label="工作状态" prop="gongzuozhuangtai">
					<el-select :disabled="ro.gongzuozhuangtai" v-model="ruleForm.gongzuozhuangtai" placeholder="请选择工作状态" >
						<el-option
							v-for="(item,index) in gongzuozhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' v-else class="input" label="工作状态" prop="gongzuozhuangtai">
					<el-input v-model="ruleForm.gongzuozhuangtai"
						placeholder="工作状态" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' v-if="type!='info'"  label="监控详情" prop="jiankongxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.jiankongxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 2% 20px 0","display":"inline-block"}' v-else-if="ruleForm.jiankongxiangqing" label="监控详情" prop="jiankongxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.jiankongxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"4px","background":"rgba(185, 216, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(198, 205, 214, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(198, 205, 214, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				bianhao : false,
				biaoti : false,
				quyu : false,
				gengxinshijian : false,
				jiankonghuamian : false,
				jiankongshipin : false,
				jiankongxiangqing : false,
				gongzuozhuangtai : false,
				clicktime : false,
				browseduration : false,
			},
			
			
			ruleForm: {
				bianhao: this.getUUID(),
				biaoti: '',
				quyu: '',
				gengxinshijian: '',
				jiankonghuamian: '',
				jiankongshipin: '',
				jiankongxiangqing: '',
				gongzuozhuangtai: '已离线',
				clicktime: '',
			},
		
			quyuOptions: [],
			gongzuozhuangtaiOptions: [],
			
			rules: {
				bianhao: [
				],
				biaoti: [
				],
				quyu: [
				],
				gengxinshijian: [
				],
				jiankonghuamian: [
				],
				jiankongshipin: [
				],
				jiankongxiangqing: [
				],
				gongzuozhuangtai: [
				],
				clicktime: [
				],
				browseduration: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
		this.ruleForm.gengxinshijian = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='bianhao'){
							this.ruleForm.bianhao = obj[o];
							this.ro.bianhao = true;
							continue;
						}
						if(o=='biaoti'){
							this.ruleForm.biaoti = obj[o];
							this.ro.biaoti = true;
							continue;
						}
						if(o=='quyu'){
							this.ruleForm.quyu = obj[o];
							this.ro.quyu = true;
							continue;
						}
						if(o=='gengxinshijian'){
							this.ruleForm.gengxinshijian = obj[o];
							this.ro.gengxinshijian = true;
							continue;
						}
						if(o=='jiankonghuamian'){
							this.ruleForm.jiankonghuamian = obj[o];
							this.ro.jiankonghuamian = true;
							continue;
						}
						if(o=='jiankongshipin'){
							this.ruleForm.jiankongshipin = obj[o];
							this.ro.jiankongshipin = true;
							continue;
						}
						if(o=='jiankongxiangqing'){
							this.ruleForm.jiankongxiangqing = obj[o];
							this.ro.jiankongxiangqing = true;
							continue;
						}
						if(o=='gongzuozhuangtai'){
							this.ruleForm.gongzuozhuangtai = obj[o];
							this.ro.gongzuozhuangtai = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='browseduration'){
							this.ruleForm.browseduration = obj[o];
							this.ro.browseduration = true;
							continue;
						}
				}
				








				this.ruleForm.gongzuozhuangtai='已离线'


			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/quyu/quyu`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.quyuOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.gongzuozhuangtaiOptions = "运行中,已离线".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jiankongxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.jiankongxiangqing = this.ruleForm.jiankongxiangqing.replace(reg,'../../../ssm35n6k/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {










	if(this.ruleForm.jiankonghuamian!=null) {
		this.ruleForm.jiankonghuamian = this.ruleForm.jiankonghuamian.replace(new RegExp(this.$base.url,"g"),"");
	}


	if(this.ruleForm.jiankongshipin!=null) {
		this.ruleForm.jiankongshipin = this.ruleForm.jiankongshipin.replace(new RegExp(this.$base.url,"g"),"");
	}









var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "jiankongxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `jiankongxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.jiankongxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `jiankongxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.jiankongxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jiankongxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    jiankonghuamianUploadChange(fileUrls) {
	    this.ruleForm.jiankonghuamian = fileUrls;
    },
    jiankongshipinUploadChange(fileUrls) {
	    this.ruleForm.jiankongshipin = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 20px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border:  2px solid rgba(198, 205, 214, 1);
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 250px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border:  2px solid rgba(198, 205, 214, 1);
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border:  2px solid rgba(198, 205, 214, 1);
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border:  2px dashed rgba(198, 205, 214, 1);
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: rgba(198, 205, 214, 1);
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border:  2px dashed rgba(198, 205, 214, 1);
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: rgba(198, 205, 214, 1);
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border:  2px dashed rgba(198, 205, 214, 1);
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: rgba(198, 205, 214, 1);
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border:  2px dashed rgba(198, 205, 214, 1);
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
