# spb-elasticsearch-in-action
知识储备：
一、elasticsearch
1、全文搜索属于最常见的需求，开源的 Elasticsearch （以下简称 Elastic）是目前全文搜索引擎的首选。
2、它可以快速地储存、搜索和分析海量数据
3、全文搜索引擎，提供了 REST API 的操作接口，开箱即用
网络参考url:http://www.ruanyifeng.com/blog/2017/08/elasticsearch.html
4、es有9200和9300两个端口

程序运行：
1、本机mac安装了elasticsearch,修改了配置文件，主要是要修改cluster_name，改成默认值，否则连接报错
2、先运行项目main下的main，启动项目，然后运行test目录下的junit测试文件，灌测试数据到es
3、浏览器访问，url:http://localhost:8080//blogs?title=i&summary=love&content=you
可以看到返回值

