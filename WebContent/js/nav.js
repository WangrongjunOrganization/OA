// 导航栏配置文件
var outlookbar=new outlook();
var t;
t=outlookbar.addtitle('部门管理','组织管理',1)
outlookbar.additem('部门添加',t,'hjc/adddept.jsp')
outlookbar.additem('部门查询',t,'addselec.html')
t=outlookbar.addtitle('岗位管理','组织管理',1)
outlookbar.additem('岗位添加',t,'addjob.html')
outlookbar.additem('岗位查询',t,'wrj/jobselec.html')
t=outlookbar.addtitle('设置关系','组织管理',1)
outlookbar.additem('设置关系',t,'addjobdept_r.html')


t=outlookbar.addtitle('入职管理','人员管理',1)
outlookbar.additem('输入员工',t,'writeinfo.html')
outlookbar.additem('查询人才库',t,'newempinsert.html')





t=outlookbar.addtitle('试用期管理','人员管理',1)
outlookbar.additem('试用期审查',t,'showselect.html')
outlookbar.additem('已转正员工查询',t,'showselectzs.html')

t=outlookbar.addtitle('离职管理','人员管理',1)
outlookbar.additem('员工离职办理',t,'leavingselect.html')
outlookbar.additem('已离职员工查询',t,'leavingse.html')


t=outlookbar.addtitle('调动管理','调动管理',1)
outlookbar.additem('部门岗位调动',t,'movecheck.html')
outlookbar.additem('已调动员工查询',t,'sourchmeth.html')

t=outlookbar.addtitle('员工信息中心','信息管理',1)
outlookbar.additem('人才库查询',t,'DBselect.html')
outlookbar.additem('入职员工查询',t,'EMPDselect.html')



t=outlookbar.addtitle('报表管理','报表管理',1)
outlookbar.additem('新聘员工报表',t,'selnewemp.html')
outlookbar.additem('离职员工报表',t,'selretireemp.html')
outlookbar.additem('部门调动员工报表',t,'selmodeptemp.html')
outlookbar.additem('岗位调动员工报表',t,'selmobmemp.html')
outlookbar.additem('人事月报',t,'selmothlist.html')

t=outlookbar.addtitle('系统管理','系统管理',1)
outlookbar.additem('添加管理员',t,'hjc/addmanager.jsp')
outlookbar.additem('查询管理员',t,'selectmanager.html')

outlookbar.additem('退出登录',t,'out.html')