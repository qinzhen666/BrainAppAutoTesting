# BrainAppAutoTesting
## 以PO形式进行封装的App自动化测试-基于appium，java
    1、包含了定位方式的封装-id，xpath（text）
    2、包含了基本操作的封装-点击click，输入sendkeys
    3、对操作系统环境做了区分和预留，可适应Android和iOS环境，无需改动代码逻辑，只需增加元素定位即可
    3、包含了常用操作工具类的封装-滑屏、滚动查找ScrollSelectUtil、双指放大缩小ZoomUtil、图像识别查找JavaCVUtil等
    4、包含了接口操作初始化，利用接口自动化进行数据清理的工作，提高数据清理的效率和成功率
    5、对测试环境做了适配封装，在yaml文件中修改测试环境即可将程序在生产和测试等环境中随意切换，需要改动代码
