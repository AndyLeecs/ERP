# 详细设计文档  表单  王瑞华 #
## 初稿 ##
###4.1.8 Store模块
####(1)模块描述
storebl模块承担的需求参见需求规格说明文档功能需求及相关非功能需求  
storebl模块的职责及接口参见软件系统体系结构描述文档  
  
根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性和可修改性，我们会添加接口。在展示层和业务逻辑层之间，我们添加StoreBLService接口。业务逻辑层和数据层之间添加StoreDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们添加了StoreBLServiceImpl，这样StoreBLServiceImpl会将对新建的业务逻辑处理委托给store_check,store_inventory,overflow_report_List,loss_report_List,presentList对象。StorePO是作为表单（目录）类信息的持久化对象被添加到设计模型中去的。<br/>

Listbl 模块的详细设计类图如图4.1.8-1所示  
  
![](https://i.imgur.com/qQLCiTU.png)
  
  
表4.1.4(2)  listbl 模块各个类的职责  
  
|模块|职责|
|-------
|StoreblserviceImpl|负责实现Storeblservice接口所需要的库存报损、库存报溢、库存赠送、库存查看、库存盘点功能，并将具体任务分派给模块内其他各类
|overflow_report_List|负责实现库存报溢单的生成、提交等功能
|loss_report_List|负责实现库存报损单的生成、提交等功能
|presentList|负责实现库存赠送单的生成、提交等功能。
|store_check|负责实现库存查看功能，向库存管理人员反应库存情况。
|store_inventory|负责实现库存盘点功能，并支持信息的Excel导出。
|message|负责实现表单审批后的消息发送功能。  
|AlarmList|自动生成库存报警单，并向库存管理人员发送消息
|dataChange|负责处理库存类单据过审、商品和商品分类变动造成的库存数据变化
  
  
####（3）模块内部类的接口规范  
  
表4.1.8（3）-1a   storeblserviceImpl类的供接口  

|服务编号|项目|内容|
|---------
|storeblserviceImpl.openReportList|语法|public List<\ReportListVO> openReportList(ListType lt，StateType st)  
|  |前置条件|用户选择查看报告类单据，包括报损类、报溢类的草稿单、待审批单、通过单、未通过单
|  |后置条件|系统显示该类表单的列表
|storeblserviceImpl.openAlarmList|语法|public List <\AlarmListVO> openAlarmList()
|  |前置条件|用户选择查看报警单列表
|  |后置条件|系统显示该类表单的列表  
|storeblserviceImpl.openPresentList|语法|public List<\PresentListVO> openPresentList(StateType st)
|  |前置条件|用户选择查看赠送单列表，可选择的状态为草稿单、待审批单、通过单、未通过单
|  |后置条件|系统显示该类表单的列表
|storeblserviceImpl.toExcelFile|语法|public String toExcel(	InventoryVO vo)
|  |前置条件|用户选择导出当天的库存盘点，生成Excel文件
|  |后置条件|系统显示导出信息（成功导出的文件地址或导出失败）
|storeblserviceImpl.newList|语法|public String newList(ListType type)
|  |前置条件|用户选择新建单据
|  |后置条件|系统自动计算并返回单据编号
|storeblserviceImpl.saveReportList|语法|public ListRM saveReportList (ListType type , ListVO vo)
|  |前置条件|用户选择保存报损或者报溢出类单据
|  |后置条件|系统将该单据数据保存在草稿箱
|storeblserviceImpl.savePresentList|语法|public ListRM savePresentList ( ListVO vo)
|  |前置条件|用户选择保存赠送类单据
|  |后置条件|系统将该单据数据保存在草稿箱
|storeblserviceImpl.commit|语法|public ListRM commit (ListType type , String ID)
|  |前置条件|用户选择提交某类型的单据
|  |后置条件|系统将该单据提交，并更新单据状态为已经提交，并在表单类的已提交单据信息表中注册该单据的信息。（若该单据尚未保存在数据库，则界面层应先调用保存方法，再提交）
|storeblserviceImpl.check|语法| public storeCheckVO store_check(String begintime,String endTime)
|  |前置条件|用户设置查看时间段，并查看该时段的各类库存信息，具体信息项见用例文档
|  |后置条件|系统返回该时间段内的各类库存信息
|storeblserviceImpl.inventory|语法|public storeInventoryVO store_inventory(String day)
|  |前置条件|用户设置查询日期，对该天进行库存查看
|  |后置条件|系统返回该日的库存盘点结果
  
  
表4.1.8（3）-1b   listblserviceImpl类的需接口   
 
|需要的服务名|需要的服务内容
|-------
|storeDataService.insertItem|插入单项商品的库存信息
|storeDataService.insertList|插入表单信息
|storeDataService.modifyItem|修改单项商品的库存信息
|storeDataService.modifyList|修改单项表单的表单信息
|storeDataService.deleteItem|删除单项商品的库存信息记录
|storeDataService.deleteList|删除单项表单的表单内容记录
|storeDataService.findItem|查找某项库存记录
|storeDataService.findList|查找某项表单
|storeDataService.calcID|计算某类单据新建时的编号

**由于库存单据（报损、报溢、赠送）所有操作均相同，只有VO\PO中的数据项意义略有区别，故而只选择库存报损单来说明供接口和需接口。**  
表4.1.8（3）-2a loss_report_List类的供接口   
 
|服务编号|项目|内容|
|---------
|loss_report_List.new|语法| public String new ()
|  |前置条件|用户选择新建库存报损单
|  |后置条件|系统计算单据编号并返回
|loss_report_List.openList|语法|public List<\ListVO> openList()  
|  |前置条件|用户选择查看库存报损单，入口参数是单据状态，包括草稿单、待审批单、审批通过单、审批未过单
|  |后置条件|系统显示该类表单的列表
|loss_report_List.delete|语法|public ResultMessage delete (String ID)
|  |前置条件|用户选择删除某项记录
|  |后置条件|系统显示删除信息
|loss_report_List.save|语法| public ListRM save （ReportListVO vo）
|  |前置条件|用户选择保存某个单据至数据库
|  |后置条件|系统显示操作是否成功
|loss_report_List.commit|语法|public ListRM commit(String ID)
|  |前置条件|用户选择提交某张单据
|  |后置条件|系统将该单据提交，并更新单据状态为已经提交，并在表单类的已提交单据信息表中注册该单据的信息。


  
表4.1.8（3）-2b accountList类的需接口   
 
|需要的服务名|需要的服务内容
|-------
|storeDataService.insertList|插入表单信息
|storeDataService.modifyList|修改单项表单的表单信息
|storeDataService.deleteList|删除单项表单的表单内容记录
|storeDataService.findList|查找某项表单
|storeDataService.calcID|计算某类单据新建时的编号
|listblservice.addListInfo|添加已提交单的信息
  

  
表4.1.8（3）-3a store_inventory 类的供接口  
  

|服务编号|项目|内容|
|---------
|store_inventory.inventory|语法| public storeInventoryVO store_inventory(String day)
|  |前置条件|用户选择进行库存盘点，并输入了要盘点的日期
|  |后置条件|系统返回该日期库存各项数据的统计，统计的项见用例文档  
|store_inventory.toExcel|语法|public String toExcel(	InventoryVO vo)
|  |前置条件|用户选择导出当天的库存盘点，生成Excel文件
|  |后置条件|系统显示导出信息（成功导出的文件地址或导出失败）
  
表4.1.8（3）-3b store_inventory 类的需接口  

|需要的服务名|需要的服务内容
|-------  
|storeDataService.findItem|查找某项库存记录  
  
表4.1.8（3）-4a store_check 类的供接口  
  

|服务编号|项目|内容|
|---------
|store_check.inventory|语法| public storeCheckVO store_check(String begin ,String end)
|  |前置条件|用户选择进行库存盘点，并输入了要盘点的日期
|  |后置条件|系统返回该日期库存各项数据的统计，统计的项见用例文档 

表4.1.8（3）-4b store_check 类的需接口  

|需要的服务名|需要的服务内容
|-------  
|storeDataService.findItem|查找某项库存记录
  
  
表4.1.8（3）-5a dataChange类的供接口    

|服务编号|项目|内容|
|---------
|dataChange.new|语法| public dataChangeRM newItem (String name,int number)
|  |前置条件|商品类新建了某项商品，并初始化了其库存值
|  |后置条件|调用数据层接口，更新数据库  
|dataChange.delete|语法| public dataChangeRM deleteItem (String name) 
|  |前置条件|商品类删除了某商品，从而清空其库存记录
|  |后置条件|调用数据层接口，删除该库存项的记录
|dataChange.modify|语法|public dataChangeRM modifyItem (String name,int number )
|  |前置条件|某种商品数量因为某种操作被修改
|  |后置条件|系统更新数据库
|dataChange.changeItemName|语法| public dataChangeRM changeItemName（String old,String new）
|  |前置条件|某种商品名称被修改，或更换了分类
|  |后置条件|系统更新数据库中的商品名字
|dataChange.checkAlarm|语法|public dataChangeRM checkAlarm (String name,int number)
|  |前置条件|用户做了某项将要更改库存数量的操作
|  |后置条件|系统自动检查库存是否少于警戒线，若操作后低于警戒线，但库存依然为正，则允许该操作，并调用库存报警单的方法，生成报警单，并向库存管理员发送消息。若操作后库存为负，则直接拒绝该操作。
  
表4.1.8（3）-5b dataChange类的需接口  

|需要的服务名|需要的服务内容
|-------
|storeDataService.insertItem|插入库存记录
|storeDataService.modifyItem|修改单项库存记录
|storeDataService.deleteItem|删除单项库存记录
|storeDataService.findItem|查找单项库存记录  
|AlarmList.alarmCheck|库存报警检验  
  
  
  
####(4)业务逻辑层的动态模型
  
库存包中库存盘点、库存报告表示相关对象协作的顺序图由图4.1.8（4）-1表示：  
    
图4.1.8（4）-1
![](https://i.imgur.com/uxSIvcf.png)  
  
库存包中各个对象的状态图在图4.1.8（4）-2中给出，在图中，对象被初始化后根据得到的信息和命令进入不同的状态，包括增加状态、删除状态、修改状态、查找状态、计算状态，在结束单次操作后对象生命期结束。
  
图4.1.8（4）-2
 
![](https://i.imgur.com/qE4NRcz.png)  
  

####（5）业务逻辑层的设计原理  
  利用委托式控制风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同领域的对象。并通过向外提供接口避免了循环依赖的问题。其他设计原理从略。