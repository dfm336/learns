tiangong-endine

# td-framework-core
整个编排是： 
1. 一个编排类。 加上 @pipeline（声明 为一个 pipeline 编排）
2. 编排类 中 有 多个 属性， 属性 加上 @Phase 注解。  表面 一个 pipeline 下，要 进行 所有 Phase 的 任务
3. @Phase 中 有 order ， 同一个 pipeline 下的 phase 根据  phase上的 order 来 排序 执行。 越小先执行
4. 一个 具体任务执行 的 类（Component）， 会加上 注解 。 @Step。 
   1. @Step 中 存在 pipline， phase，order 属性。
   2. 通过这三个属性， 来表面 该任务 属于  哪个 pipeline 的 哪个 phase。  
   3. 同一个 pipeline 下的 phase  也还可以 拆分 多个 Step。  也通过 Setp上的  order 属性  排序执行。

基于这个 编排， 就一定要知道：
1. 某个pipeline 下 有多少个 @phase，  
2. 某个 phase 下有 多少个 Setp

这些数据 最终 会放入 pipelineRepository 中。 存放 三个 map

1.engine-xml 配置 二方包 启动引导bean。 bootstrap， xml 配置 属性，packages。配置init method
2. init method 中 初始化 packages （扫描路径） 下 的 各个Class ， 
   并 根据 class 的 注解（ @pipeline， @step 等）获取 不通类型 的 注册器， 通过 注册器 注册 class
3。 注册 时，根据 注解属性， 设置 phase， 是否并行（ 设置线程池） 等。  会将 这个 class 上的 注解， 注册 到 对应的 repositroy
    - repository 中放了 有 各种 map属性（ 存  @pipeline 的 属性）。
