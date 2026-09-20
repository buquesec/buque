# 补阙

公开仓：https://gitee.com/sea-vessels/main

**补阙**是漏洞管理平台。完整功能请到本仓库 **发行版** 下载安装包（Docker 起库和应用），不要指望从本仓库 `mvn package`。

本仓库只公开**部分源码**（许可证、说明书、扫描工具 Adapter 接口等）。源码公开、禁止转售，**不是** OSI 开源。见 [LICENSE](./LICENSE)（Apache-2.0 + Commons Clause）。

## 使用完整产品

1. 打开仓库「发行版」，下载 `buque-<版本>.zip` 并解压
2. 安装 [Docker](https://docs.docker.com/get-docker/)（不必装 JDK / Node）
3. 执行 `start.ps1`（Windows）或 `./start.sh`（Linux/macOS）
4. 浏览器打开 http://127.0.0.1:8080

首次会构建应用镜像并启动 PostgreSQL，等健康检查通过后再登录。演示账号见安装包内 `README.txt`。仅供本地试用，生产必须改密。

## 本仓库有什么

- 产品使用说明书、已实现功能清单
- 扫描工具 Adapter 接口（便于理解如何对接）
- 许可与安全披露

不要提交未公开的业务源码。贡献说明见 [CONTRIBUTING.md](./CONTRIBUTING.md)。

安全问题请发邮件至 **buquesec@163.com**，不要开公开 Issue。

## 许可证

- **可以**：下载、修改已公开的源码；用安装包在自有环境管理自身漏洞（含企业内网）
- **不可以**：把本系统（含安装包或改皮后的实质相同产品）拿去卖、收费授权，或作为对外收费 SaaS
- **版权人**：补阙
